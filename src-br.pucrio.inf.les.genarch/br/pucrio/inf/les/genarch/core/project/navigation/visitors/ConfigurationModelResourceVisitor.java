package br.pucrio.inf.les.genarch.core.project.navigation.visitors;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.models.ConfigurationModelContent;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.VariabilityItem;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTree;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTCodePiece;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTreeNode;
import br.pucrio.inf.les.genarch.core.resources.dsl.AspectAnnotationUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JavaAnnotationUtil;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationCodePiece;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;

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
						
						List<FieldDeclaration> annotedFields = new ArrayList<FieldDeclaration>();
						List<MethodDeclaration> annotedMethods = new ArrayList<MethodDeclaration>();
						AnnotationClassVisitor classVisitor = getASTVisitor((IFile)resource);
						
						ASTree tree = getASTTree(resource);
						
						for(NormalAnnotation normalAnnotation : classVisitor.getNormalAnnotations()){
							if ( normalAnnotation.getTypeName().getFullyQualifiedName().equals("Feature") ) {
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
							        	annotedFields.add(field);
							            VariableDeclarationFragment frag = fragments.get(0);
							            this.configurationContent.addField(frag.getName().getFullyQualifiedName(),getFieldDeclarationString(field) ,resourcePhysicalPath, parentClass, expression);
							        }
									
							      //Adiciona metodos anotados
								}else if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.MethodDeclaration.class)) {
									MethodDeclaration method = (MethodDeclaration) normalAnnotation.getParent();
									annotedMethods.add(method);
									ConfigurationMethod include = this.configurationContent.addMethod(method.getName().toString(), getMethodDeclarationString(method), resourcePhysicalPath, parentClass, expression);

									//adiciona trechos de códido do método
									
									MethodDeclaration methodClone = tree.findCloneMethod(method);
									ASTree subTree = tree.getSubTree(methodClone);
									for(ASTreeNode child: subTree.getRoot().getChildren()){
										if(child.getNode() instanceof ASTCodePiece){
											buildCodePieceTree( child, include);
										}
									}
									
									
									
								}else if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.ArrayInitializer.class)){
									ArrayInitializer featureArray = (ArrayInitializer) normalAnnotation.getParent();
									featureArray.getParent().getParent().getClass();
									
									if(featureArray.getParent().getParent().getClass().equals(org.eclipse.jdt.core.dom.FieldDeclaration.class)) {
										//Adiciona metodos anotados
										FieldDeclaration field = (FieldDeclaration) featureArray.getParent().getParent();
										List<VariableDeclarationFragment> fragments = field.fragments();
										
								        if (fragments.size() == 1) {
								        	annotedFields.add(field);
								            VariableDeclarationFragment frag = fragments.get(0);
								            this.configurationContent.addField(frag.getName().getFullyQualifiedName(),getFieldDeclarationString(field) ,resourcePhysicalPath, parentClass, expression);
								        }
										
								      //Adiciona metodos anotados
									}else if(featureArray.getParent().getParent().getClass().equals(org.eclipse.jdt.core.dom.MethodDeclaration.class)) {
										MethodDeclaration method = (MethodDeclaration) featureArray.getParent().getParent();
										annotedMethods.add(method);
										this.configurationContent.addMethod(method.getName().toString(), getMethodDeclarationString(method), resourcePhysicalPath, parentClass, expression);
								}
								
							}
						}
					}
					List<FieldDeclaration> unannotatedFields = new ArrayList<FieldDeclaration>(classVisitor.getFields());
					unannotatedFields.removeAll(annotedFields);
					String coreExpression = "core";
					for(FieldDeclaration field : unannotatedFields){
						List<VariableDeclarationFragment> fragments = field.fragments();
				        if (fragments.size() == 1) {
				        	
				            VariableDeclarationFragment frag = fragments.get(0);
				            this.configurationContent.addField(frag.getName().getFullyQualifiedName(),getFieldDeclarationString(field) ,resourcePhysicalPath, parentClass, coreExpression);
				        }
					}
					List<MethodDeclaration> unannotatedMethods = new ArrayList<MethodDeclaration>(classVisitor.getMethods()); 
					unannotatedMethods.removeAll(annotedMethods);
					for(MethodDeclaration method : unannotatedMethods){
						annotedMethods.add(method);
						ConfigurationMethod include = this.configurationContent.addMethod(method.getName().toString(), getMethodDeclarationString(method), resourcePhysicalPath, parentClass, coreExpression);
						
						MethodDeclaration methodClone = tree.findCloneMethod(method);
						ASTree subTree = tree.getSubTree(methodClone);
						for(ASTreeNode child: subTree.getRoot().getChildren()){
							if(child.getNode() instanceof ASTCodePiece){
								buildCodePieceTree( child, include);
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
	}

	public ConfigurationModelContent getConfigurationContent() {
		return this.configurationContent;
	}	
	
	private AnnotationClassVisitor getASTVisitor(IFile file) {	
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);

		ASTParser astParser = ASTParser.newParser(AST.JLS3);
		astParser.setSource(compilationUnit);
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);			
		astParser.setResolveBindings(true);
		ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

		AnnotationClassVisitor visitor = new AnnotationClassVisitor();
		rootNode.accept(visitor);		
		
		return visitor;
	}
	
	private List<FeatureItem> parserAnnotations(String source) {
		List<FeatureItem> result = new ArrayList<FeatureItem>();
		
		String re1="(#)(Feature)(\\()(name)(=)(\")";	
	    String re2="((?:[a-z][a-z0-9_]*))";	
	    String re3="(\")(,).*?(parent)(=)(\")";	
	    String re4="((?:[a-z][a-z0-9_]*))";
	    String re5="(\")(,).*?(type)(=)(FeatureType)(\\.)";	
	    String re6="((?:[a-z][a-z0-9_]*))";
	    String re7="(\\))";	

	    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	   
	    Matcher m = p.matcher(source);
	    
	    while(m.find()){
	    	 FeatureItem feature = new FeatureItem();
	    	 
	 		 feature.setName(m.group(7));
	 		 feature.setParent(m.group(13));
	 		 if(m.group(20).equals("mandatory"))feature.setType(FeatureType.mandatory);
	 		 else if(m.group(20).equals("alternative"))feature.setType(FeatureType.alternative);
	 		 else if(m.group(20).equals("optional"))feature.setType(FeatureType.optional);
	 		 result.add(feature);
	    }
		return result;
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
	
	private ASTree getASTTree(IResource resource) {
		ASTExplorer astExplorer = null;
		try {
			astExplorer = new ASTExplorer(resource.getLocationURI().getPath());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		ASTree tree = astExplorer.getTree();
		
		return tree;
	}
	
	private void buildCodePieceTree(ASTreeNode target, MappingEntity parent){
		List<String> featuresNames = new ArrayList<String>();
		ASTCodePiece piece = (ASTCodePiece)target.getNode();

		List<FeatureItem> featuresItem = parserAnnotations(piece.getFeatureAnnotation());
		for ( FeatureItem featureItem: featuresItem ) {					
			featuresNames.add(featureItem.getName());
		}
		String expression = Logic.makeExpression(featuresNames);
		
		ConfigurationCodePiece result = this.configurationContent.addCodePiece(piece.getStart(), piece.getEnd(),
				parent.getPath() + ".{" +piece.getStart() + " , "  + piece.getEnd()+  "}"  
				, parent, expression);
		
		for(ASTreeNode child : target.getChildren()){
			if(child.getNode() instanceof ASTCodePiece){
				buildCodePieceTree( child, result);				
			}
		}
	}
	
}
