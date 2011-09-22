package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata;

import java.util.ArrayList;
import java.util.List;

public class ConstraintData {
	public static final Integer DEPENDENCE = 1;
	public static final Integer EXCLUSION = 2;
	
	private Integer type;
	private String primaryTarget;
	private String secondaryTarget;
	
	
	public ConstraintData(Integer type, String primaryTargetId, String secondaryTargetId){
		this.primaryTarget = primaryTargetId;
		this.secondaryTarget = secondaryTargetId;
		this.type = type;
	}


	public Integer getType() {
		return type;
	}


	public String getPrimaryTarget() {
		return primaryTarget;
	}


	public String getSecondaryTarget() {
		return secondaryTarget;
	}
	
	
}
