package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata;

import java.util.ArrayList;
import java.util.List;


public class AnalysisFeatureData {
	private List<FeatureData> allFeatures = new ArrayList<FeatureData>();

	
	public void addFeature(List<FeatureData> feature) {
		this.allFeatures.addAll(feature);
	}
	
	public List<FeatureData> getAllFeatures() {
		return allFeatures;
	}

	public void setAllFeatures(List<FeatureData> allFeatures) {
		this.allFeatures = allFeatures;
	}
	
	
}
