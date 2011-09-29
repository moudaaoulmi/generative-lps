package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AbstractData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.FeatureData;

public class MappingData {
	private AbstractData asset;
	private List<FeatureData> features = new ArrayList<FeatureData>();
	public MappingData (AbstractData asset, List<FeatureData> features){
		this.asset = asset;
		this.features = features;
	}
	
	public MappingData (){
		super();
	}	
	public AbstractData getAsset() {
		return asset;
	}
	public void setAsset(AbstractData asset) {
		this.asset = asset;
	}
	public List<FeatureData> getFeatures() {
		return features;
	}
	public void setFeatures(List<FeatureData> features) {
		this.features = features;
	}	
}
