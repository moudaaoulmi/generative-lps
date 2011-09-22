package br.pucrio.inf.les.genarch.core.impactanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.designwizard.design.ClassNode;
import org.designwizard.design.FieldNode;
import org.designwizard.design.MethodNode;
import org.designwizard.main.DesignWizard;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sun.media.sound.AlawCodec;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AnalysisAssetData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.ClassData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.FieldData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.MethodData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.AnalysisFeatureData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.FeatureData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata.AnalysisMappingData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata.MappingData;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationField;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;

public class MappingImporter {
	
	
	
	private AnalysisMappingData analysisMappingData = new AnalysisMappingData();
	private MappingRelationships mappingRelationships;
	private AnalysisAssetData analysisAssetData;
	private AnalysisFeatureData analysisFeatureData;

	public MappingImporter(Configuration configuration, AnalysisAssetData analysisAssetData, AnalysisFeatureData analysisFeatureData){
		this.mappingRelationships = configuration.getMappingRelationships();
		this.analysisAssetData = analysisAssetData;
		this.analysisFeatureData = analysisFeatureData;
	}

	public AnalysisMappingData extract() {	
		
		TreeIterator configurationContents = mappingRelationships.eAllContents();
		List<MappingData> mappingData = new ArrayList<MappingData>();
		
		
		while ( configurationContents.hasNext() ) {
			EObject o = (EObject)configurationContents.next();
			MappingData mapping =  new MappingData();
			o.getClass();
			if ( o instanceof ConfigurationField) {				
				ConfigurationField entity = (ConfigurationField)o;
				FieldData field = analysisAssetData.getField(entity.getName(), pathTranslator(entity.getPath()));
				
				List<FeatureData> featureData = new ArrayList<FeatureData>();
				List<String> expressionFeatures = Logic.toFeatures(entity.getFeatureExpression().getExpression());
				for(String featureName : expressionFeatures){
					featureData.add( analysisFeatureData.getFeatureDataById(featureName) );
				}
				mapping = new MappingData(field, featureData);
				
			} else if (o instanceof ConfigurationClass ) {
				
				ConfigurationClass entity = (ConfigurationClass)o;
				ClassData clazz = analysisAssetData.getClass(entity.getName(), classPathTranslator(entity.getPath(), entity.getName()) );
				
				List<FeatureData> featureData = new ArrayList<FeatureData>();
				List<String> expressionFeatures = Logic.toFeatures(entity.getFeatureExpression().getExpression());
				for(String featureName : expressionFeatures){
					featureData.add( analysisFeatureData.getFeatureDataById(featureName) );
				}
				mapping = new MappingData(clazz, featureData);
			} else if (o instanceof ConfigurationMethod) {
				
				ConfigurationMethod entity = (ConfigurationMethod)o;
				MethodData method = analysisAssetData.getMethod(entity.getName(), pathTranslator(entity.getPath()) );
				
				List<FeatureData> featureData = new ArrayList<FeatureData>();
				List<String> expressionFeatures = Logic.toFeatures(entity.getFeatureExpression().getExpression());
				for(String featureName : expressionFeatures){
					featureData.add( analysisFeatureData.getFeatureDataById(featureName) );
				}
				mapping = new MappingData(method, featureData);
			} else {
				continue;
			}
			
			mappingData.add(mapping);
		}
		analysisMappingData.setAllMappings(mappingData);
		return analysisMappingData;
	}
	
	public String classPathTranslator(String path, String name){
		String newPath = "";
		newPath = path.replace("src/", "");
		newPath = newPath.replaceAll("(/)",".");
		newPath = newPath.replace("."+name,"");
		return newPath;
		
	}
	public String pathTranslator(String path){
		String newPath = "";
		newPath = path.replace("src/", "");
		newPath = newPath.replaceAll("(/)",".");
		newPath = newPath.replace(".java","");
		return newPath;
		
	}
	
}
