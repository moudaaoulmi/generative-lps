package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata;

import java.util.ArrayList;
import java.util.List;


public class AnalysisMappingData {
	private List<MappingData> allMappings = new ArrayList<MappingData>();

	
	
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
