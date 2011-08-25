package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure;

import java.util.ArrayList;
import java.util.List;

public class FieldData {
	private List<MethodData> methods = new ArrayList<MethodData>(); 
	private List<FieldData> field = new ArrayList<FieldData>();
	
	
	
	
	
	
	
	void setMethods(List<MethodData> methods) {
		this.methods = methods;
	}
	List<MethodData> getMethods() {
		return methods;
	} 

}
