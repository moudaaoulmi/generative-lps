package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AbstractData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.ClassData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.FieldData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.MethodData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.FeatureData;


public class AnalysisMappingData {
	private List<MappingData> allMappings = new ArrayList<MappingData>();

	
	
	//testar
	public List<MappingData> getAllMappingsOf(FeatureData featureData){
		List<MappingData> result = new ArrayList<MappingData>();
		for(MappingData mapping : allMappings){
			for(FeatureData feature : mapping.getFeatures()){
				if(feature.equals(featureData)){
					result.add(mapping);
					break;
				}
			}			
		}
		return result;
		
	}
	//testar
	public List<MappingData> getAllMappingsOf(AbstractData abstractData){
		List<MappingData> result = new ArrayList<MappingData>();
		for(MappingData mapping : allMappings){
			AbstractData data = mapping.getAsset();
			if(data.equals(abstractData)){
				result.add(mapping);
			}
			
		}
		return result;
		
	}
	
	public MappingData getMappingByFeature(String featureId){
		
		return null;		
	}
	
	public List<MappingData> getMappingByAsset(String assetId){
		
		return null;		
	}
	
	public AnalysisMappingData(){
		allMappings = new ArrayList<MappingData>();
	}
	
	public void addMapping(List<MappingData> mapping) {
		this.allMappings.addAll(mapping);
	}
	
	public void addMapping(MappingData mapping) {
		this.allMappings.add(mapping);
	}
	
	public List<MappingData> getAllMappings() {
		return allMappings;
	}

	public void setAllMappings(List<MappingData> allMappings) {
		this.allMappings = allMappings;
	}
	
	
	
	
}
