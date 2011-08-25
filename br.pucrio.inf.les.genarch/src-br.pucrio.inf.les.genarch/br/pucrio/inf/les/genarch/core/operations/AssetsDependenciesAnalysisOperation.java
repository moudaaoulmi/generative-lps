package br.pucrio.inf.les.genarch.core.operations;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.designwizard.design.MethodNode;
import org.designwizard.main.DesignWizard;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jface.operation.IRunnableWithProgress;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.impactanalyzer.AnalizerResourceVisitor;
import br.pucrio.inf.les.genarch.core.impactanalyzer.StaticAnalyzer;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.project.navigation.ProjectNavigator;



public class AssetsDependenciesAnalysisOperation implements IRunnableWithProgress {
	
	private IProject project;
	DesignWizard instancia;
	StaticAnalyzer analyzerInstance;

	public AssetsDependenciesAnalysisOperation(IProject project) {
		this.project = project;
		try {
			analyzerInstance = new StaticAnalyzer(project);
		} catch (IOException ex) {
			ex.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(ex);
		}						
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
//		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
//
//		List<String> containers = new ArrayList<String>();
//		containers.addAll(genarchProjectConfigurationFile.getSourceContainers());
//		containers.addAll(genarchProjectConfigurationFile.getResourceContainers());
//		ProjectNavigator navigator = new ProjectNavigator(this.project,containers);
//		
//		AnalizerResourceVisitor visitor = new AnalizerResourceVisitor();
//		
//		navigator.addResourceVisitors(visitor);
//		navigator.navigate();
	}
	
	
	private List<org.eclipse.jdt.core.dom.MethodDeclaration> getMethods(IFile file) {	
		ICompilationUnit iCompilationUnit = JavaCore.createCompilationUnitFrom(file);
		
		ASTParser parser = ASTParser.newParser(AST.JLS3); 
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(iCompilationUnit); 
		parser.setResolveBindings(true);

		CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
		
		List types = compilationUnit.types(); 
		TypeDeclaration typeDec = (TypeDeclaration) types.get(0); 

		return Arrays.asList(typeDec.getMethods()); 
	}
}
