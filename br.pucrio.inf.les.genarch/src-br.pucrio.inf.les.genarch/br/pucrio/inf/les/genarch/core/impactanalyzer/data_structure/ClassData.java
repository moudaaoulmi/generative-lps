package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure;

import java.util.ArrayList;
import java.util.List;

public class ClassData {
	private List<MethodData> methods = new ArrayList<MethodData>(); 
	private List<FieldData> field = new ArrayList<FieldData>();
		
	public void setMethods(List<MethodData> methods) {
		this.methods = methods;
	}
	public List<MethodData> getMethods() {
		return methods;
	}
	public void setField(List<FieldData> field) {
		this.field = field;
	}
	public List<FieldData> getField() {
		return field;
	} 

}
