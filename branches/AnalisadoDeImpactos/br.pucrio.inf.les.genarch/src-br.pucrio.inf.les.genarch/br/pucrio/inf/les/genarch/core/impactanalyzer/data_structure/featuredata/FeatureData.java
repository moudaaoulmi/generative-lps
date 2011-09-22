package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata;

import java.util.ArrayList;
import java.util.List;

public class FeatureData {
	private String name;
	private String id;
	private List<String> exclusion = new ArrayList<String>();
	private List<String> dependence = new ArrayList<String>();
	private List<String> children = new ArrayList<String>();
	private Integer min;
	private Integer max;
	
	
	public void addDependence(String featureId){
		dependence.add(featureId);
	}
	
	public void addExclusion(String featureId){
		exclusion.add(featureId);
	}
	
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
	public List<String> getExclusion() {
		return exclusion;
	}
	public void setExclusion(List<String> exclusion) {
		this.exclusion = exclusion;
	}
	public List<String> getDependency() {
		return dependence;
	}
	public void setDependency(List<String> dependency) {
		this.dependence = dependency;
	}
	
	public void addChild(List<String> childIdList) {
		this.children.addAll(childIdList);
	}
	
	public void addChild(String childId) {
		this.children.add(childId);
	}		
	public List<String> getChildren() {
		return children;
	}
	public void setChildren(List<String> childIdList) {
		this.children = childIdList;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	
	
}
