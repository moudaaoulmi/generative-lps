package br.pucrio.inf.les.genarch.core.project.navigation.visitors;

import java.util.Arrays;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.dom.Modifier;
import org.aspectj.org.eclipse.jdt.core.search.LocalVariableDeclarationMatch;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.models.ArchitectureModelContent;
import br.pucrio.inf.les.genarch.core.models.FeatureModelContent;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.NavigationUtil;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;

public class ArchitectureModelResourceVisitor implements ResourceClient {

	private ArchitectureModelContent architectureContent;
	private ArchitectureMethod method;
	private ArchitectureMethod attri;

	public ArchitectureModelResourceVisitor() {
		this.architectureContent = new ArchitectureModelContent();
	}

	public void visit(IResource resource) {
		String resourceName = resource.getName();
		resource.getProjectRelativePath().toOSString();
		resource.getProjectRelativePath().removeFileExtension().toString().replace("/", ".");
		String resourcePhysicalPath = resource.getProjectRelativePath().toString();
		

		if ( resource.getProjectRelativePath().segmentCount() == 1 ) {	    
			if ( JavaCore.create(resource) instanceof IPackageFragmentRoot ) {
				this.architectureContent.addContainer(resource.getName());
			} else if ( resource instanceof IFolder ) {
				this.architectureContent.addResourceContainer(resource.getName());
			}
		} else if ( resource.getType() == IResource.FOLDER ) {
			IFolder component = (IFolder)resource;
			String parentPath = NavigationUtil.getParentByPath(component.getProjectRelativePath().toString());
			EObject parent = this.architectureContent.getElementByPath(parentPath);

			if ( parent instanceof ArchitectureContainer ) {		
				this.architectureContent.addComponent(resource.getName(),(ArchitectureContainer)parent,resourcePhysicalPath);	    	
			} else if ( parent instanceof ArchitectureComponent ){
				this.architectureContent.addSubComponent(resourceName,resourcePhysicalPath,(ArchitectureComponent)parent);
			} else if ( parent instanceof ArchitectureResourcesContainer ) {
				this.architectureContent.addFolder(resourceName,resourcePhysicalPath,(ArchitectureResourcesContainer)parent);
			} else if ( parent instanceof ArchitectureFolder ) {
				this.architectureContent.addSubFolder(resourceName,resourcePhysicalPath,(ArchitectureFolder)parent);
			}
		} else if ( resource.getType() == IResource.FILE ) {
			IFile file = (IFile)resource;
			String componentParentPath = NavigationUtil.getParentByPath(file.getProjectRelativePath().toString());
			EObject parent = architectureContent.getElementByPath(componentParentPath);

			if ( file.getFileExtension().equals("java") ) {
				
				this.architectureContent.addClass(resourceName,resourcePhysicalPath,(ArchitectureComponent)parent);
				//Colocar para varrer o arquivo e encontrar metodos e atributos anotados.
				ArchitectureClass parentClass = (ArchitectureClass)architectureContent.getElementByPath(resourcePhysicalPath);
				
				
				for(FieldDeclaration field : getFields(file)){
					this.architectureContent.addAttribute(getFieldName(field) ,getFieldDeclarationString(field), resourcePhysicalPath, parentClass);
				}
				
				for(org.eclipse.jdt.core.dom.MethodDeclaration method : getMethods(file)){
					this.architectureContent.addMethod(method.getName().toString() , getMethodDeclarationString(method), resourcePhysicalPath, parentClass);					
				}
				
//				for(NormalAnnotation normalAnnotation : getNormalAnnotations(file)){
//					FeatureItem featureItem = getFeatureItens(normalAnnotation);
//					
//					if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.FieldDeclaration.class)) {
//						this.architectureContent.addAttribute(featureItem.getName(), resourcePhysicalPath, parentClass);
//					}else if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.MethodDeclaration.class)) {
//						this.architectureContent.addMethod(featureItem.getName(), resourcePhysicalPath, parentClass);
//					}
//				}
				

			} else if ( file.getFileExtension().equals("aj") ) {
				this.architectureContent.addAspect(resourceName,resourcePhysicalPath,(ArchitectureComponent)parent);
			} else if ( resource.getFileExtension().equals("xpt") ) {
				String genPath = resource.getProjectRelativePath().removeLastSegments(1).toString();
				if ( parent instanceof ArchitectureComponent ) {
					this.architectureContent.addTemplate(resourceName,resourcePhysicalPath,genPath,(ArchitectureComponent)parent);
				} else if ( parent instanceof ArchitectureFolder ) {
					this.architectureContent.addTemplate(resourceName,resourcePhysicalPath,genPath,(ArchitectureFolder)parent);
				}			
			} else if ( resource.getFileExtension().equals("mvel") ) {
				String toPath = resource.getProjectRelativePath().removeLastSegments(1).toString();
				this.architectureContent.addTemplate(resourceName,resourcePhysicalPath,toPath,(ArchitectureComponent)parent);
			} else {
				if ( parent instanceof ArchitectureResourcesContainer ) {
					this.architectureContent.addFile(resourceName,resourcePhysicalPath,(ArchitectureResourcesContainer)parent);
				} else if ( parent instanceof ArchitectureComponent ) {
					this.architectureContent.addFile(resourceName,resourcePhysicalPath,(ArchitectureComponent)parent);
				} else if ( parent instanceof ArchitectureFolder ) {
					this.architectureContent.addFile(resourceName,resourcePhysicalPath,(ArchitectureFolder)parent);
				}

			}
		}
	}

	private FeatureItem getFeatureItens(NormalAnnotation annotation) {	
		
		FeatureItem featuresItem = new FeatureItem();
		IAnnotationBinding binding = annotation.resolveAnnotationBinding();

		if(annotation.isAnnotation()){
			if ( binding == null ) {
				return null;
			}

			if ( binding.getName().equals("Feature") ) {
				IMemberValuePairBinding[] membersValuePairBinding = binding.getDeclaredMemberValuePairs();
				
				for ( IMemberValuePairBinding memberValuePairBinding : membersValuePairBinding ) {								
					String name = memberValuePairBinding.getName();
					Object value = memberValuePairBinding.getValue();
					if ( "name".equals(name) ) {
						featuresItem.setName((String)value);
					} else if ( "type".equals(name) ) {
						IBinding variableBinding = (IBinding)value;									
						FeatureType featureType = FeatureType.valueOf(new String(variableBinding.getName()));
						featuresItem.setType(featureType);
					} else if ( "parent".equals(name) ) {
						featuresItem.setParent((String)value);
					}															
				}
				
			}else {
				return null;
			}
		}
	
		return featuresItem;
	}
	
	private List<NormalAnnotation> getNormalAnnotations(IFile file) {	
		//this.featuresContent.getFeatureItens().addAll(JavaAnnotationUtil.featureAnnotations(file));
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
	
	private List<org.eclipse.jdt.core.dom.MethodDeclaration> getMethods(IFile file) {	
		ICompilationUnit iCompilationUnit = JavaCore.createCompilationUnitFrom(file);
		
		ASTParser parser = ASTParser.newParser(AST.JLS3); 
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(iCompilationUnit); 
		parser.setResolveBindings(true);

		CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
		
		List types = compilationUnit.types(); 
		file.getFullPath();
		
		file.getName();
		TypeDeclaration typeDec = (TypeDeclaration) types.get(0); 

		return Arrays.asList(typeDec.getMethods()); 
	}
	
	
	private List<FieldDeclaration> getFields(IFile file) {		
		ICompilationUnit iCompilationUnit = JavaCore.createCompilationUnitFrom(file);
		
		ASTParser parser = ASTParser.newParser(AST.JLS3); 
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(iCompilationUnit); 
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);

		CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
		
		List types = compilationUnit.types(); 
		
		TypeDeclaration typeDec = (TypeDeclaration) types.get(0); 
		return Arrays.asList(typeDec.getFields()); 		
	}
	
	private String getMethodDeclarationString(org.eclipse.jdt.core.dom.MethodDeclaration method) {		
		String methodNameString = "";
		
		IMethodBinding meu = method.resolveBinding();
		
		
		
//		for(Object modifier :  method.modifiers()){
//			methodNameString += modifier.toString() + " ";
//		}
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
	
	private String getFieldName(FieldDeclaration field) {		
		String fieldNameString = "";
        List<VariableDeclarationFragment> fragments = field.fragments();
        if (fragments.size() == 1) {
            VariableDeclarationFragment frag = fragments.get(0);
            fieldNameString += frag.getName().getFullyQualifiedName();
        }
		return fieldNameString; 		
	}

	public ArchitectureModelContent getArchitectureContent() {
		return this.architectureContent;
	}	
}
