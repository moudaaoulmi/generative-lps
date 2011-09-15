package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.mappingdata;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AbstractData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.FeatureData;

public class MappingData {
	private List<AbstractData> assets = new ArrayList<AbstractData>();
	private List<AbstractData> features = new ArrayList<AbstractData>();
	public List<AbstractData> getAssets() {
		return assets;
	}
	public void setAssets(List<AbstractData> assets) {
		this.assets = assets;
	}
	public List<AbstractData> getFeatures() {
		return features;
	}
	public void setFeatures(List<AbstractData> features) {
		this.features = features;
	}
	
	
}
