package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure;

import java.util.ArrayList;
import java.util.List;

public class ClassData extends AbstractData{
	
	
	private List<MethodData> methods = new ArrayList<MethodData>(); 
	private List<FieldData> fields = new ArrayList<FieldData>();
	
	
	public ClassData(String name, String shortName) {
		super(name, shortName);
	}
	
	public void setMethods(List<MethodData> methods) {
		this.methods = methods;
	}
	public List<MethodData> getMethods() {
		return methods;
	}
	public void setFields(List<FieldData> fields) {
		this.fields = fields;
	}
	public List<FieldData> getFields() {
		return fields;
	}
	
	public void addAllMethods(List<MethodData> methods) {
		this.methods.addAll(methods);
	}
	
	public void addAllFields(List<FieldData> fields) {
		this.fields.addAll(fields);
	}

}
