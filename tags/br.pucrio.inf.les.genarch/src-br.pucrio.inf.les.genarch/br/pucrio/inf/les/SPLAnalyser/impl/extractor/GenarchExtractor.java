package br.pucrio.inf.les.SPLAnalyser.impl.extractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

import br.pucrio.inf.les.SPLAnalyser.core.Extractor;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.project.navigation.ProjectNavigator;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.configuration.Configuration;



public class GenarchExtractor implements Extractor {
	private IProject project;
	private ImpactAnalysisModel analysisModel;
	private final String impactAnalysisModelPath = "/MB/ImpactAnalysis/ImpactAnalysisModel.impactanalysismodel";
	
	
	public ImpactAnalysisModel extract(Object sourceTarget) {
		ImpactAnalysisModelContent analysisModelContent = new ImpactAnalysisModelContent();
		analysisModel = analysisModelContent.getAnalysisModel();
		project = (IProject)sourceTarget;
		extractAssets();
		extractFeatures();
		extractConfigurationKnowledge();
		extractUseCases();
		return analysisModel;
	}
	
	private void extractAssets(){
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		String architectureModelFileName = genarchProjectConfigurationFile.getArchitectureModelPath();
		IFile architectureModelFile = project.getFile(architectureModelFileName);
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString());
		ResourceSet architectureResourceSet = new ResourceSetImpl();
		Resource architectureResource = architectureResourceSet.getResource(architectureFileURI,true);
		Architecture architecture = (Architecture)architectureResource.getContents().get(0);
		
		//Extrai local do projeto
		String projectLocation = project.getLocation().toOSString();
		
		ArchitectureExtractor architectureExtractor = 
			new ArchitectureExtractor(architecture, analysisModel);
		analysisModel = architectureExtractor.extract();
		
		
	}
	
	private void extractFeatures(){
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		String featureModelFileName = genarchProjectConfigurationFile.getFeatureModelPath();
		
		IFile fmpModelFile = project.getFile(featureModelFileName);
		
		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(fmpModelFile);
		
		EList resourceList = externalLoader.getResources();					
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		Project fmpProject = (Project)fmpResource.getAllContents().next();
		fmpProject.getModel();
		
		FeatureExtractor featureExtractor = new FeatureExtractor(fmpProject.getModel(), analysisModel);
		analysisModel = featureExtractor.extract();
		
	}
	
	private void extractConfigurationKnowledge(){
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		String configurationModelFileName = genarchProjectConfigurationFile.getConfigurationModelPath();
		IFile configurationModelFile = project.getFile(configurationModelFileName);
		URI configurationFileURI = URI.createPlatformResourceURI(configurationModelFile.getFullPath().toString());
		ResourceSet configurationResourceSet = new ResourceSetImpl();
		Resource configurationResource = configurationResourceSet.getResource(configurationFileURI,true);
		Configuration configuration = (Configuration)configurationResource.getContents().get(0);
		
		//Extrai local do projeto
		String projectLocation = project.getLocation().toOSString();
		
		ConfigurationKnowledgeExtractor configurationExtractor = 
			new ConfigurationKnowledgeExtractor(configuration, analysisModel);
		analysisModel = configurationExtractor.extract();
		
		
	}
	
	public void extractUseCases(){
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		List<String> containers = new ArrayList<String>();
		containers.addAll(genarchProjectConfigurationFile.getSourceContainers());
		containers.addAll(genarchProjectConfigurationFile.getResourceContainers());

		IPath folderPath = new Path("models");

		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		

		UseCaseResourceVisitor useCaseClient = new UseCaseResourceVisitor(analysisModel);

		ProjectNavigator navigator = new ProjectNavigator(this.project,containers);
		navigator.addResourceVisitors(useCaseClient);
		navigator.navigate();
		analysisModel = useCaseClient.getAnalysisModel();
	}
	
	
	

	public String getPath() {
		return impactAnalysisModelPath;
	}
	

}
