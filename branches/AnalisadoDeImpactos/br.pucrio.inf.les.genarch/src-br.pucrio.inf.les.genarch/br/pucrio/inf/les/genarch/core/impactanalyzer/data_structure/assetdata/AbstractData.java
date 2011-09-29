package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata;

import java.util.ArrayList;
import java.util.List;

public class AbstractData {
	String name;
	String path;
	List<AbstractData> dependences = new ArrayList<AbstractData>();
	List<AbstractData> reverseDependences = new ArrayList<AbstractData>();
	
	
	public AbstractData(String name, String path) {
		this.name = name;
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean equals(AbstractData data){
		
		if(this instanceof ClassData){
			if(data instanceof ClassData
					&& data.getName().equals(name)
					&& data.getPath().equals(path)){
				return true;
			}else return false;
		}else if(this instanceof MethodData){
			if(data instanceof MethodData
					&& data.getName().equals(name)
					&& data.getPath().equals(path)){
				return true;
			}else return false;
		}else if(this instanceof FieldData){
			if(data instanceof FieldData
					&& data.getName().equals(name)
					&& data.getPath().equals(path)){
				return true;
			}else return false;
		}
		
		return false;
	}
	
	public void addDependence(AbstractData abstractData){
		this.dependences.add(abstractData);
	}
	public void addReverseDependence(AbstractData abstractData){
		this.reverseDependences.add(abstractData);
	}
	
	public void addDependence(List<AbstractData> abstractDatas){
		this.dependences.addAll(abstractDatas);
	}
	public void addReverseDependence(List<AbstractData> abstractDatas){
		this.reverseDependences.addAll(abstractDatas);
	}
	
	public List<AbstractData> getDependences() {
		return dependences;
	}
	public void setDependences(List<AbstractData> dependences) {
		this.dependences = dependences;
	}
	public List<AbstractData> getReverseDependences() {
		return reverseDependences;
	}
	public void setReverseDependences(List<AbstractData> reverseDependences) {
		this.reverseDependences = reverseDependences;
	}
	
	

}
