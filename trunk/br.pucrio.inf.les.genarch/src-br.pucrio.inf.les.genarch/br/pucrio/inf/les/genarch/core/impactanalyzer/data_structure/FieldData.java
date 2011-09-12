package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure;

import java.util.ArrayList;
import java.util.List;

public class FieldData extends AbstractData{
	
	private List<FieldData> field = new ArrayList<FieldData>();
	private List<FieldData> methodReverseDependences = new ArrayList<FieldData>();
	
	public FieldData(String name, String shortName) {
		super(name, shortName);
	}

	public List<FieldData> getField() {
		return field;
	}
	public void setField(List<FieldData> field) {
		this.field = field;
	}
	public List<FieldData> getMethodReverseDependences() {
		return methodReverseDependences;
	}
	public void setMethodReverseDependences(List<FieldData> methodReverseDependences) {
		this.methodReverseDependences = methodReverseDependences;
	}
	
	
}
