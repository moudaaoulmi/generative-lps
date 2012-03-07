package br.pucrio.inf.les.SPLAnalyser.core;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;

public interface Extractor {

	ImpactAnalysisModel extract(Object sourceTarget);
	public String getPath();
}
