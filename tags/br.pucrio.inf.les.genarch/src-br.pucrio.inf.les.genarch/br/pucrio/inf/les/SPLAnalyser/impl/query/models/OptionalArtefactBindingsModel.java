package br.pucrio.inf.les.SPLAnalyser.impl.query.models;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;

public class OptionalArtefactBindingsModel {

	private List<Object[]> relations;

	public OptionalArtefactBindingsModel() {
		relations = new ArrayList<Object[]>();
	}
	
	public void addRelation(Feature feature, Asset asset1, Asset asset2){
		Object[] relation = {feature,asset1,asset2};
		relations.add(relation);
	}
	
	public List<Object[]> getRelations(){
		return relations;
	}
	
}
