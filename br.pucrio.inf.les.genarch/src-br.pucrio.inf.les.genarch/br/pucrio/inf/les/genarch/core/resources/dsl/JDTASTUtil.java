package br.pucrio.inf.les.genarch.core.resources.dsl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.org.eclipse.jdt.core.IField;
import org.aspectj.org.eclipse.jdt.core.IJavaElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
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

	public static void removeContent(IFile file, String elementName) {
		//[Demóstenes] Find and Removee IField or IMethod in ICompilationUnit (IFile resource).
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);
		ASTNode astNode = JDTASTUtil.astNode(file, compilationUnit);
		CompilationUnit unit = (CompilationUnit)astNode;
		BodyDeclaration bodyDeclaration = JDTASTUtil.bodyDeclaration(unit);
		IDocument document = JDTASTUtil.createDocument(compilationUnit);		    
		unit.recordModifications();

		//[Demóstenes] - Remove content of elementName of unit. (begin)
		ASTNode member = unit.findDeclaringNode(elementName);	
		
		if (member != null) {
			member.delete();			
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

}
