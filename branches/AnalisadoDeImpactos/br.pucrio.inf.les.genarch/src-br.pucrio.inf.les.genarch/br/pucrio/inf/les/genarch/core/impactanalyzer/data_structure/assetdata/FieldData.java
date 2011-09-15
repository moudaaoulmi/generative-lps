package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata;

import java.util.ArrayList;
import java.util.List;

public class FieldData extends AbstractData{
	
	
	private List<MethodData> methodReverseDependences = new ArrayList<MethodData>();
	
	public FieldData(String name, String shortName) {
		super(name, shortName);
	}
	
	
	public void addMethodReverseDependences(MethodData method){
		methodReverseDependences.add(method);
	}
	
	public List<MethodData> getMethodReverseDependences() {
		return methodReverseDependences;
	}
	public void setMethodReverseDependences(List<MethodData> methodReverseDependences) {
		this.methodReverseDependences = methodReverseDependences;
	}
	
	
}
