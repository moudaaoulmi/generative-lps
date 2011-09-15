package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata;

import java.util.ArrayList;
import java.util.List;

public class FeatureData {
	private String name;
	private String id;
	private String description;
	private List<FeatureData> exclusion = new ArrayList<FeatureData>();
	private List<FeatureData> dependency = new ArrayList<FeatureData>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<FeatureData> getExclusion() {
		return exclusion;
	}
	public void setExclusion(List<FeatureData> exclusion) {
		this.exclusion = exclusion;
	}
	public List<FeatureData> getDependency() {
		return dependency;
	}
	public void setDependency(List<FeatureData> dependency) {
		this.dependency = dependency;
	}
	
	
}
