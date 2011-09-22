package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata;

import java.util.ArrayList;
import java.util.List;


public class AnalysisFeatureData {
	private List<FeatureData> allFeatures = new ArrayList<FeatureData>();
	private List<ConstraintData> allConstraints = new ArrayList<ConstraintData>();

	
	
	public FeatureData getFeatureDataById(String featureId){
		for(FeatureData feature : allFeatures){
			if(feature.getId().toLowerCase().equals(featureId.toLowerCase()))
				return feature;
		}
		return null;		
	}
	
	public AnalysisFeatureData(){
		allFeatures = new ArrayList<FeatureData>();
	}
	
	public void addFeature(List<FeatureData> feature) {
		this.allFeatures.addAll(feature);
	}
	
	public void addFeature(FeatureData feature) {
		this.allFeatures.add(feature);
	}
	
	public List<FeatureData> getAllFeatures() {
		return allFeatures;
	}

	public void setAllFeatures(List<FeatureData> allFeatures) {
		this.allFeatures = allFeatures;
	}
	
	public void addConstraint(List<ConstraintData> constraint) {
		this.allConstraints.addAll(constraint);
	}
	
	public void addConstraint(ConstraintData constraint) {
		this.allConstraints.add(constraint);
	}
	
	public List<ConstraintData> getAllConstraint() {
		return allConstraints;
	}

	public void setAllConstraint(List<ConstraintData> allConstraints) {
		this.allConstraints = allConstraints;
	}
	
	
}
