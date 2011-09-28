package br.pucrio.inf.les.genarch.core.resources.dsl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.aspectj.org.eclipse.jdt.core.IField;
import org.aspectj.org.eclipse.jdt.core.IJavaElement;

import org.eclipse.core.internal.resources.InternalTeamHook;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class JDTASTUtil {

	public static ASTNode astNode(IFile resource,ICompilationUnit compilationUnit) {
		try {
			InputStream fileContents = resource.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileContents));
			StringBuffer sb = new StringBuffer();

			while ( reader.ready() ) {
				sb.append(reader.readLine());
			}

			ASTParser astParser = ASTParser.newParser(AST.JLS3);
			astParser.setSource(compilationUnit);
			astParser.setKind(ASTParser.K_COMPILATION_UNIT);
			astParser.setResolveBindings(true);
			ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

			return rootNode;	     
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (IOException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
		return null;
	}

	public static IDocument createDocument(ICompilationUnit compilationUnit) {
		String source;
		try {
			source = compilationUnit.getBuffer().getContents();
			return new Document(source);
		} catch (JavaModelException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}
		return null;	
	}

	public static BodyDeclaration bodyDeclaration(CompilationUnit unit) {
		BodyDeclaration typeDeclaration = (BodyDeclaration)unit.types().get(0);
		return typeDeclaration;
	}
	
	public static TypeDeclaration typeDeclaration(CompilationUnit unit) {
		TypeDeclaration typeDeclaration = (TypeDeclaration)unit.types().get(0);
		return typeDeclaration;
	}

	//[Demóstenes] Find and Remove FieldDeclaration in ICompilationUnit (IFile resource).
	public static void removeContentField(IFile file, String elementName) {
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);
		ASTNode astNode = JDTASTUtil.astNode(file, compilationUnit);
		CompilationUnit unit = (CompilationUnit)astNode;
		TypeDeclaration typeDeclaration = JDTASTUtil.typeDeclaration(unit);
		IDocument document = JDTASTUtil.createDocument(compilationUnit);		    
		unit.recordModifications();

		FieldDeclaration[] fields = typeDeclaration.getFields();
		
		for(int i=0; i<fields.length;i++){
			FieldDeclaration field = fields[i];
			VariableDeclarationFragment variableDeclarationFragment = (VariableDeclarationFragment) field.fragments().get(0);			
			
			if(variableDeclarationFragment.toString().equals(elementName)){			
				ASTNode member = (ASTNode) field;
				member.delete();
				break;
			}
		}
		
		TextEdit textEdit = unit.rewrite(document, compilationUnit.getJavaProject().getOptions(true));

		try {
			textEdit.apply(document);
		} catch (MalformedTreeException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (BadLocationException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		String newSource = document.get();

		try {
			compilationUnit.getBuffer().setContents(newSource); 
			compilationUnit.save(new NullProgressMonitor(),true);
		} catch (JavaModelException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}				
	}

	//[Demóstenes] Find and Remove MethodDeclaration in ICompilationUnit (IFile resource).
	// TODO [Demóstenes] - This implementation not resolve method overloading. 
	public static void removeContentMethod(IFile file, String methodDeclaration) {
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);
		ASTNode astNode = JDTASTUtil.astNode(file, compilationUnit);
		CompilationUnit unit = (CompilationUnit)astNode;
		TypeDeclaration typeDeclaration = JDTASTUtil.typeDeclaration(unit);
		IDocument document = JDTASTUtil.createDocument(compilationUnit);    
		unit.recordModifications();

		MethodDeclaration[] methods = typeDeclaration.getMethods();
				
		for(int i=0; i<methods.length;i++){
			MethodDeclaration currentMethod = methods[i];
			MethodDeclaration expectedMethod = produceMethodDeclaration(methodDeclaration);						
			
			if(compareMethodDeclaration(currentMethod,expectedMethod)){
				ASTNode member = (ASTNode) currentMethod;
				member.delete();
				break;
			}
		}
		
		TextEdit textEdit = unit.rewrite(document, compilationUnit.getJavaProject().getOptions(true));

		try {
			textEdit.apply(document);
		} catch (MalformedTreeException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (BadLocationException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		String newSource = document.get();

		try {
			compilationUnit.getBuffer().setContents(newSource); 
			compilationUnit.save(new NullProgressMonitor(),true);
		} catch (JavaModelException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}				
	}

	// TODO [Demóstenes] Compara dois MethodDeclarations.
	// TODO [Demóstenes] Outra opção é a utilização de SubtreeMatch.
	private static boolean compareMethodDeclaration(
			MethodDeclaration method_one, MethodDeclaration method_two) {		
		
		SimpleName name_one = method_one.getName();
		Type type_one = method_one.getReturnType2();
		List params_one = method_one.parameters(); //list of FormalParameters
		
		SimpleName name_two = method_two.getName();
		Type type_two = method_two.getReturnType2();
		List params_two = method_two.parameters(); //list of FormalParameters
					
		if(name_one.toString().equals(name_two.toString())){
			if(type_one.toString().equals(type_two.toString())){
				if(params_one.size() == params_two.size()){				
					Iterator it_one = params_one.iterator();
					Iterator it_two = params_two.iterator();
					
					while(it_one.hasNext()){
						SingleVariableDeclaration variableDecl_one = (SingleVariableDeclaration) it_one.next();
						SingleVariableDeclaration variableDecl_two = (SingleVariableDeclaration) it_two.next();
						
						if(!(variableDecl_one.getType().toString().equals(variableDecl_two.getType().toString()))){
							return false;
						}												
					}
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	// TODO [Demóstenes] Produz um MethodDeclaration com o perfil do método em String.
	private static MethodDeclaration produceMethodDeclaration(
			String methodDeclaration) {
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		
		//[Demóstenes] Adicionando um body vazio para adequar ao padrão mínimo de methodDeclaration.
		methodDeclaration = methodDeclaration.concat("{ }");
		
		parser.setSource(methodDeclaration.toCharArray());
		
		Map options = JavaCore.getOptions();
		JavaCore.setComplianceOptions(JavaCore.VERSION_1_5, options);
		parser.setKind(ASTParser.K_CLASS_BODY_DECLARATIONS);
		parser.setCompilerOptions(options);
				
		TypeDeclaration typeDecl = (TypeDeclaration) parser.createAST(null);		
		
		return (MethodDeclaration) typeDecl.bodyDeclarations().get(0);
	}	

}