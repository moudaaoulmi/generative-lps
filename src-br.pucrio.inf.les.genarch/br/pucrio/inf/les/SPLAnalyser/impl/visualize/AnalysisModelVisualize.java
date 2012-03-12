package br.pucrio.inf.les.SPLAnalyser.impl.visualize;

import br.pucrio.inf.les.SPLAnalyser.core.Visualize;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.QueryModelContent;

public class AnalysisModelVisualize implements Visualize {

	
	public void run(Object queryModel, String queryName){
		QueryModelContent queryModelContent = new QueryModelContent((ImpactAnalysisModel) queryModel);
		String queryModelPath = "/MB/ImpactAnalysis/querys/"+queryName+".impactanalysismodel";
		queryModelContent.saveModel(queryModelPath);
	}
}
