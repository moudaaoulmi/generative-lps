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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AbstractData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AnalysisAssetData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.ClassData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.FieldData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.MethodData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.AnalysisFeatureData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.FeatureData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata.AnalysisMappingData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata.MappingData;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;

public class ImpactAnalyzer {
	AnalysisAssetData analysisAssetData;
	AnalysisFeatureData analysisFeatureData;
	AnalysisMappingData analysisMappingData;

	public ImpactAnalyzer(AnalysisAssetData analysisAssetData, AnalysisFeatureData analysisFeatureData, AnalysisMappingData analysisMappingData) {
		this.analysisAssetData = analysisAssetData;
		this.analysisFeatureData = analysisFeatureData;
		this.analysisMappingData = analysisMappingData;		
	}
	/**
	 * Retorna as features impactadas diretamente por um artefato
	 * @param abstractData
	 * @return
	 */
	public List<FeatureData> getImpactAsset2Features(AbstractData abstractData){
		List<FeatureData> featureDatas = new ArrayList<FeatureData>();
		List<FeatureData> result = new ArrayList<FeatureData>();
		
		for(MappingData mapping : analysisMappingData.getAllMappingsOf(abstractData)){
			featureDatas.addAll( mapping.getFeatures() );
		}
		
		for(FeatureData feature : featureDatas){
			boolean test = true;
			for(FeatureData f : result){
				if(feature.equals(f)) test = false;
			}
			if(test) result.add(feature);
		}
		
		if(result.size() > 0)
			System.out.println("");
		return result;
	}
	
	/**
	 * Retorna as artefato impactados diretamente por uma feature.
	 * @param abstractData
	 * @return 
	 */
	public List<AbstractData> getImpactFeature2Assets(FeatureData featureData){
		List<AbstractData> assetDatas = new ArrayList<AbstractData>();
		List<AbstractData> result = new ArrayList<AbstractData>();
		
		for(MappingData mapping : analysisMappingData.getAllMappingsOf(featureData)){
			assetDatas.add( mapping.getAsset() );
		}
		
		for(AbstractData data : assetDatas){
			boolean test = true;
			for(AbstractData d : result){
				if(data.equals(d)) test = false;
			}
			if(test) result.add(data);
		}
		
		if(result.size() > 0)
			System.out.println("");
		return result;
	}

	
}
