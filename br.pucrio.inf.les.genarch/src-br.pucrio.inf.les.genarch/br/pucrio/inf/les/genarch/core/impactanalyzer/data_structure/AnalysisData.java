package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure;

import java.util.ArrayList;
import java.util.List;

public class AnalysisData {
	private List<ClassData> allClass = new ArrayList<ClassData>();
	
	
	
	
	public List<ClassData> getAllClass() {
		return allClass;
	}
	public void setAllClass(List<ClassData> allClass) {
		this.allClass = allClass;
	}
	
	
}
