package br.pucrio.inf.les.genarch.core.project.navigation.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.models.ConfigurationModelContent;
import br.pucrio.inf.les.genarch.core.models.FeatureModelContent;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItem;
import br.pucrio.inf.les.genarch.core.resources.dsl.AspectAnnotationUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JavaAnnotationUtil;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;

public class ConfigurationModelResourceVisitor implements ResourceClient {

	private ConfigurationModelContent configurationContent;

	public ConfigurationModelResourceVisitor() {
		this.configurationContent = new ConfigurationModelContent();		
	}

	public void visit(IResource resource) {
		List<FeatureItem> featuresItem = new ArrayList<FeatureItem>();
		List<String> featuresNames = new ArrayList<String>();
		VariabilityItem variabiliyItem;
		String componentPath = resource.getProjectRelativePath().removeLastSegments(1).toString();
		String resourceName = resource.getName();
		String resourcePhysicalPath = resource.getProjectRelativePath().toString();

		if ( resource.getProjectRelativePath().segmentCount() == 1 ) {	    
			if ( JavaCore.create(resource) instanceof IPackageFragmentRoot ) {
				this.configurationContent.addSourceContainer(resource.getName());
			} else if ( resource instanceof IFolder ) {
				this.configurationContent.addResourcesContainer(resource.getName());
			}
		} else if ( resource.getType() == IResource.FILE ) {

			if ( resource.getFileExtension().equals("java") ) {		
				//Pega anotações de Classes
				featuresItem = JavaAnnotationUtil.featureSpecificsAnnotations((IFile)resource, org.eclipse.jdt.core.dom.TypeDeclaration.class);		

				for ( FeatureItem featureItem: featuresItem ) {					
					featuresNames.add(featureItem.getName());
				}

				if ( featuresNames.size() > 0 ) {
					String expression = Logic.makeExpression(featuresNames);
					//Adiciona Classe ao modelo de configuração
					if(this.configurationContent.addClass(resourceName,resourcePhysicalPath,expression,componentPath)){//Se a classe foi adicionada, verifica atributos e metodos
						
						ConfigurationClass parentClass = (ConfigurationClass)this.configurationContent.getElementByPath(resourcePhysicalPath);
						
										
						for(NormalAnnotation normalAnnotation : getNormalAnnotations((IFile)resource)){
							expression = "";
							featuresNames = new ArrayList<String>();
							featuresItem = getFeatureItens(normalAnnotation);
							for ( FeatureItem featureItem: featuresItem ) {					
								featuresNames.add(featureItem.getName());
							}
							if ( featuresNames.size() > 0 )
								expression = Logic.makeExpression(featuresNames);
							
							//Adiciona atributos anotados
							if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.FieldDeclaration.class)) {
								FieldDeclaration field = (FieldDeclaration) normalAnnotation.getParent();
								
								List<VariableDeclarationFragment> fragments = field.fragments();
								
						        if (fragments.size() == 1) {
						            VariableDeclarationFragment frag = fragments.get(0);
						            this.configurationContent.addField(frag.getName().getFullyQualifiedName(),getFieldDeclarationString(field) ,resourcePhysicalPath, parentClass, expression);
						        }
								
						      //Adiciona metodos anotados
							}else if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.MethodDeclaration.class)) {
								MethodDeclaration method = (MethodDeclaration) normalAnnotation.getParent();
								this.configurationContent.addMethod(method.getName().toString(), getMethodDeclarationString(method), resourcePhysicalPath, parentClass, expression);
							}
						}
					}
				}
				variabiliyItem = JavaAnnotationUtil.variabilityAnnotation((IFile)resource);

				if ( variabiliyItem != null ) {
					String templateName =  (new Path(resourceName)).removeFileExtension().toString() + "Template.xpt";
					String templatePath = new Path(componentPath).append(templateName).toString();
					this.configurationContent.addTemplate(templateName,templatePath,variabiliyItem.getFeature(),componentPath);
				}

			} else if ( resource.getFileExtension().equals("aj") ) {
				featuresItem = AspectAnnotationUtil.featuresAnnotations((IFile)resource);

				for ( FeatureItem featureItem: featuresItem ) {					
					featuresNames.add(featureItem.getName());
				}

				if ( featuresNames.size() > 0 ) {
					String expression = Logic.makeExpression(featuresNames);
					this.configurationContent.addAspect(resourceName,resourcePhysicalPath,expression,componentPath);
				}

				variabiliyItem = AspectAnnotationUtil.variabilityAnnotation((IFile)resource);

				if ( variabiliyItem != null ) {
					String templateName =  (new Path(resourceName)).removeFileExtension().toString() + "Template.xpt";
					String templatePath = new Path(componentPath).append(templateName).toString();
					this.configurationContent.addTemplate(templateName,templatePath,variabiliyItem.getFeature(),componentPath);
				}
			} 
		}	
	}

	public ConfigurationModelContent getConfigurationContent() {
		return this.configurationContent;
	}	
	
	private List<NormalAnnotation> getNormalAnnotations(IFile file) {	
		
		FeatureModelContent featuresContent = new FeatureModelContent();
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);

		ASTParser astParser = ASTParser.newParser(AST.JLS3);
		astParser.setSource(compilationUnit);
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);			
		astParser.setResolveBindings(true);
		ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

		AnnotationClassVisitor visitor = new AnnotationClassVisitor();
		rootNode.accept(visitor);
		visitor.getSingleMemberAnnotations();
		visitor.getAnnotationsTypeDeclaration();
		visitor.getAnnotationsTypeMemberDeclaration();
		visitor.getMarkerAnnotations();		
		return visitor.getNormalAnnotations();
	}
	
	private List<FeatureItem> getFeatureItens(NormalAnnotation annotation) {	
		
		List<FeatureItem> featuresItem = new ArrayList<FeatureItem>();
		IAnnotationBinding binding = annotation.resolveAnnotationBinding();

		if(annotation.isAnnotation()){
			if ( binding == null ) {
				return null;
			}
			
			
			if ( binding.getName().equals("Feature") ) {
				IMemberValuePairBinding[] membersValuePairBinding = binding.getDeclaredMemberValuePairs();
				FeatureItem featureItem = new FeatureItem();
				for ( IMemberValuePairBinding memberValuePairBinding : membersValuePairBinding ) {								
					String name = memberValuePairBinding.getName();
					Object value = memberValuePairBinding.getValue();
					if ( "name".equals(name) ) {
						featureItem.setName((String)value);
					} else if ( "type".equals(name) ) {
						IBinding variableBinding = (IBinding)value;									
						FeatureType featureType = FeatureType.valueOf(new String(variableBinding.getName()));
						featureItem.setType(featureType);
					} else if ( "parent".equals(name) ) {
						featureItem.setParent((String)value);
					}															
				}
				featuresItem.add(featureItem);
			}
			else {
				return null;
			}
		}
	
		return featuresItem;
	}
	
	
	private String getMethodDeclarationString(org.eclipse.jdt.core.dom.MethodDeclaration method) {		
		String methodNameString = "";
		
		IMethodBinding meu = method.resolveBinding();

		if(method.getReturnType2() != null)
			methodNameString += method.getReturnType2() + " ";
		
		methodNameString += method.getName() + "( ";
		for(Object parameter :  method.parameters()){
			methodNameString += parameter.toString() + " ";
		}
		methodNameString += ")";
		return methodNameString; 		
	}
	
	private String getFieldDeclarationString(FieldDeclaration field) {		
		String fieldNameString = "";
		fieldNameString += field.getType() + " ";
        List<VariableDeclarationFragment> fragments = field.fragments();
        if (fragments.size() == 1) {
            VariableDeclarationFragment frag = fragments.get(0);
            fieldNameString += frag.getName().getFullyQualifiedName();
        }
		return fieldNameString; 		
	}
	
}
