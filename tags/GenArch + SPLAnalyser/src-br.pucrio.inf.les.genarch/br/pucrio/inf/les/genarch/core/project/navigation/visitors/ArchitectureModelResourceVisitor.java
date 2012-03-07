package br.pucrio.inf.les.genarch.core.project.navigation.visitors;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Tree;

import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.models.ArchitectureModelContent;
import br.pucrio.inf.les.genarch.core.models.FeatureModelContent;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.NavigationUtil;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;
import br.pucrio.inf.les.genarch.core.project.navigation.itens.FeatureItem;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTCodePiece;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTree;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTreeNode;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.CodePiece;

public class ArchitectureModelResourceVisitor implements ResourceClient {

	private ArchitectureModelContent architectureContent;
	
	private Tree treeControl;
	

	public ArchitectureModelResourceVisitor() {
		this.architectureContent = new ArchitectureModelContent();
	}

	public void visit(IResource resource) {
		String resourceName = resource.getName();
		resource.getProjectRelativePath().toOSString();
		resource.getProjectRelativePath().removeFileExtension().toString().replace("/", ".");
		String resourcePhysicalPath = resource.getProjectRelativePath().toString();
		resource.getFullPath();
		resource.getLocationURI().getPath();
		
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
				//Colocar para varrer o arquivo e encontrar metodos e atributos
				ArchitectureClass parentClass = (ArchitectureClass)architectureContent.getElementByPath(resourcePhysicalPath);
				
				//adiciona atributos
				for(FieldDeclaration field : getFields(file)){
					this.architectureContent.addAttribute(getFieldName(field) ,getFieldDeclarationString(field), resourcePhysicalPath, parentClass);
				}
				
				ASTree tree = getASTTree(resource);
				tree.getOrdered(tree.getRoot());
				
				//adiciona métodos
				for(org.eclipse.jdt.core.dom.MethodDeclaration method : getMethods(file)){
					ArchitectureMethod include = this.architectureContent.addMethod(method.getName().toString() , getMethodDeclarationString(method), resourcePhysicalPath, parentClass);
					
					MethodDeclaration methodClone = tree.findCloneMethod(method);
					
					//adiciona trechos de códido do método
					ASTree subTree = tree.getSubTree(methodClone);
					for(ASTreeNode child: subTree.getRoot().getChildren()){
						if(child.getNode() instanceof ASTCodePiece){
							buildCodePieceTree( child, include);
						}
					}
				}	
				

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

	/**
	 * O método recursivo transforma uma ramificação de CodePieces da ASTTree em uma ramificação 
	 * de codePieces do ArchitectureModel
	 * @param target Code Piece a ser inserido
	 * @param parent Entidade pai ao qual o code piece estará relacionado no ArchitectureModel
	 */
	private void buildCodePieceTree(ASTreeNode target, ArchitectureEntity parent){
		ASTCodePiece piece = (ASTCodePiece)target.getNode();
		CodePiece result = this.architectureContent.addCodePiece(piece.getStart(), piece.getEnd(),
				parent.getPath() + ".{" +piece.getStart() + " , "  + piece.getEnd()+  "}"  
				, piece.getSourceCode(), parent);
		
		for(ASTreeNode child : target.getChildren()){
			if(child.getNode() instanceof ASTCodePiece){
				buildCodePieceTree( child, result);				
			}
		}
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
