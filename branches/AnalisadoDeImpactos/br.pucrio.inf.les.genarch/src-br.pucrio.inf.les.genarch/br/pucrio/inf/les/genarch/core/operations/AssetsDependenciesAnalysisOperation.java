package br.pucrio.inf.les.genarch.core.operations;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


import org.designwizard.design.MethodNode;
import org.designwizard.main.DesignWizard;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jface.operation.IRunnableWithProgress;

import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.system.ModelManipulation;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.impactanalyzer.AnalizerResourceVisitor;
import br.pucrio.inf.les.genarch.core.impactanalyzer.FeatureImporter;
import br.pucrio.inf.les.genarch.core.impactanalyzer.StaticAnalyzer;
import br.pucrio.inf.les.genarch.core.models.FeatureModelContent;
import br.pucrio.inf.les.genarch.core.models.dsl.FMPModelUitl;
import br.pucrio.inf.les.genarch.core.models.dsl.fmp.FeatureModelHandle;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.project.navigation.ProjectNavigator;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.FeatureModelResourceVistor;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;
import br.pucrio.inf.les.genarch.models.feature.impl.FeatureImpl;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance;
import br.pucrio.inf.les.genarch.models.instance.FeatureInstance;
import br.pucrio.inf.les.genarch.models.instance.Instance;
import br.pucrio.inf.les.genarch.models.instance.InstanceFactory;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;
import br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl;



public class AssetsDependenciesAnalysisOperation implements IRunnableWithProgress {
	
	private IProject project;
	DesignWizard instancia;
	StaticAnalyzer analyzerInstance;
	FeatureImporter featureImporter;
	private InstanceFactory instanceFactory = InstancePackage.eINSTANCE.getInstanceFactory();
	

	public AssetsDependenciesAnalysisOperation(IProject project) {
		this.project = project;
		try {
//			analyzerInstance = new StaticAnalyzer(project);
			featureImporter = new FeatureImporter(project);
		} catch (IOException ex) {
			ex.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(ex);
		}						
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		List<String> containers = new ArrayList<String>();
		containers.addAll(genarchProjectConfigurationFile.getSourceContainers());
		containers.addAll(genarchProjectConfigurationFile.getResourceContainers());
		
		FeatureModelResourceVistor featureClient = new FeatureModelResourceVistor();
		ProjectNavigator navigator = new ProjectNavigator(this.project,containers);
		navigator.addResourceVisitors(featureClient);
		navigator.navigate();
		
		
		FeatureModelContent featuresContent = featureClient.getFeaturesContent();
		String featureFileName = "FeatureModel.fmp";
		IPath folderPath = new Path("models");
		FMPModelUitl fmpModel = new FMPModelUitl(this.project,folderPath.append(featureFileName));
		fmpModel.create(featuresContent,project.getName());
		fmpModel.saveModel();
		System.out.println("s");
		
		ModelNavigation modelNavigation;
		modelNavigation = ModelNavigation.INSTANCE;
		Node model = fmpModel.getFmpProject().getModel();
		
		modelNavigation.getAllFeatures(model);
		for (Iterator i = modelNavigation.getAllFeatures(model).iterator(); i.hasNext(); ) {
			Feature aux = (Feature) i.next();
			System.out.println("s ");
		}
		
		
		
//		extract();
		
		FeatureModelHandle meu = FeatureModelHandle.open(project);
		
		
		IFile fmpModelFile = project.getFile("models/FeatureModel.fmp");
		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(fmpModelFile);
		EList resourceList = externalLoader.getResources();
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		fmpResource.getContents();
		
		
		
		
		
		
		
		
		
		
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
	
	public void extract() {
		//Abre o arquivo de configuração do GenArch
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		//Do arquivo de configuração pega o caminho para os 3 modelos.
		String architectureModelFileName = genarchProjectConfigurationFile.getArchitectureModelPath();
		String configurationModelFileName = genarchProjectConfigurationFile.getConfigurationModelPath();
		String featureModelFileName = genarchProjectConfigurationFile.getFeatureModelPath();

		
		IFile architectureModelFile = project.getFile(architectureModelFileName);
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString());

		ResourceSet architectureResourceSet = new ResourceSetImpl();
		Resource architectureResource = architectureResourceSet.getResource(architectureFileURI,true);

		

		IFile fmpModelFile = project.getFile(featureModelFileName);

		//Extrai informações e da configuração do modelo de Features
		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(fmpModelFile);					
		EList resourceList = externalLoader.getResources();					
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		Project fmpProject = (Project)fmpResource.getAllContents().next();

		InstancePackageImpl.init();
		
		Instance instance = instanceFactory.createInstance();
		//Instancia da configuração do modelo de features.
		FeatureInstance featureConfiguration = readFeatureModelConfiguration(fmpProject); 
		
				
	}
	
	/**
	 * Método retorna a configuração do modelo de features para o produto alvo
	 * @param fmpProject
	 * @return
	 */
	private FeatureInstance readFeatureModelConfiguration(Project fmpProject) {
		Feature model = fmpProject.getModel();
		EList modelChildren = model.getChildren();
		Feature modelChild = (Feature)modelChildren.get(0);
		EList modelChildConfs = modelChild.getConfs();
		fmpProject.eAllContents();
//		fmpProject.getMetaModel().
//		Feature childConf = (Feature)modelChildConfs.get(featureModelInstance);

		FeatureInstance featureInstance = instanceFactory.createFeatureInstance();	
//		featureInstance.setName(childConf.getName());
//
//		if ( childConf.getTypedValue() != null ) {
//			featureInstance.setAttribute(childConf.getTypedValue().getStringValue());
//		}
//
//		br.pucrio.inf.les.genarch.models.instance.Feature rootFeature = toFeature((Feature)childConf);		
//		featureInstance.setRoot(rootFeature);
		
		return featureInstance;
	}
	
	
	
	
}
