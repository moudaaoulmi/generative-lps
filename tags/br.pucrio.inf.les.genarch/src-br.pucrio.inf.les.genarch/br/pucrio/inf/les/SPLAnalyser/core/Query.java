package br.pucrio.inf.les.SPLAnalyser.core;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;

public interface Query {
	public Object runQuery(ImpactAnalysisModel analysisModel);

	public String getName();
	
}
