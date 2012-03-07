package br.pucrio.inf.les.SPLAnalyser.core;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;

public interface SourceCodeAnalyser {

	public ImpactAnalysisModel  analyse(Object sourceCode, ImpactAnalysisModel analysisModel);

}
