package br.pucrio.inf.les.genarch.core.operations;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.designwizard.main.DesignWizard;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.operation.IRunnableWithProgress;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.impactanalyzer.AssetImporter;
import br.pucrio.inf.les.genarch.core.impactanalyzer.FeatureImporter;
import br.pucrio.inf.les.genarch.core.impactanalyzer.MappingImporter;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AnalysisAssetData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.AnalysisFeatureData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata.AnalysisMappingData;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.instance.InstanceFactory;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;



public class AssetsDependenciesAnalysisOperation implements IRunnableWithProgress {
	
	private IProject project;
	private AssetImporter assetImporter;
	private FeatureImporter featureImporter;
	private MappingImporter mappingImporter;
	
	

	public AssetsDependenciesAnalysisOperation(IProject project) {
		this.project = project;			
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		String featureModelFileName = genarchProjectConfigurationFile.getFeatureModelPath();
		
		IFile fmpModelFile = project.getFile(featureModelFileName);
		
		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(fmpModelFile);
		
		EList resourceList = externalLoader.getResources();					
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		Project fmpProject = (Project)fmpResource.getAllContents().next();
		fmpProject.getModel();
		
		try {
			featureImporter = new FeatureImporter(fmpProject.getModel());
		} catch (IOException ex) {
			ex.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(ex);
		} 
		
		//Extrai informações do modelo de Features do FMP para o modelo de Feaures de analise
		AnalysisFeatureData analysisFeatureData = featureImporter.extract();		
		
		//Extrai modelo de arquitetura
		String architectureModelFileName = genarchProjectConfigurationFile.getArchitectureModelPath();
		IFile architectureModelFile = project.getFile(architectureModelFileName);
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString());
		ResourceSet architectureResourceSet = new ResourceSetImpl();
		Resource architectureResource = architectureResourceSet.getResource(architectureFileURI,true);
		Architecture architecture = (Architecture)architectureResource.getContents().get(0);
		
		//Extrai local do projeto
		String projectLocation = project.getLocation().toOSString();
		
		assetImporter = new AssetImporter(projectLocation, architecture);
		
		AnalysisAssetData analysisAssetData = assetImporter.extract();
		
		
		String configurationModelFileName = genarchProjectConfigurationFile.getConfigurationModelPath();
		
		IFile configurationModelFile = project.getFile(configurationModelFileName);
		URI configurationFileURI = URI.createPlatformResourceURI(configurationModelFile.getFullPath().toString());

		//Extrai informações e do modelo de configuração
		ResourceSet configurationResourceSet = new ResourceSetImpl();
		Resource configurationResource = configurationResourceSet.getResource(configurationFileURI, true);

		Configuration configuration = (Configuration)configurationResource.getContents().get(0);
		System.out.println("");
		mappingImporter = new MappingImporter(configuration,analysisAssetData,analysisFeatureData);
		AnalysisMappingData analysisMappingData = mappingImporter.extract();
	}
}
