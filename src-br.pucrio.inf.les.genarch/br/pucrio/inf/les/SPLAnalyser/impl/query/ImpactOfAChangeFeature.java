package br.pucrio.inf.les.SPLAnalyser.impl.query;

import java.util.List;

import br.pucrio.inf.les.SPLAnalyser.core.Query;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.QueryModelContent;

//Retorna todas as entidades que dependem diretamente da feature.
public class ImpactOfAChangeFeature implements Query {

	private ImpactAnalysisModelContent analysisModelContent;
	private QueryModelContent queryModelContent;
	private ImpactAnalysisModel queryModel;
	private String featureName;
	
	
	public ImpactOfAChangeFeature(String featureName){
		this.featureName = featureName;
	}
	
	public ImpactAnalysisModel runQuery(ImpactAnalysisModel analysisModel) {
		analysisModelContent = new ImpactAnalysisModelContent(analysisModel);
		queryModelContent = new QueryModelContent();
		query();
		queryModel = queryModelContent.getAnalysisModel();
		return queryModel;
	}

	private void query() {
		Feature feature = null;
		feature = analysisModelContent.findFeature(featureName);
		
		List<Mapping> mappings = analysisModelContent.findMappingOf(feature);
		for(Mapping map : mappings){
			queryModelContent.addAsset(map.getAssets());
			queryModelContent.addUseCase(map.getUseCases());
		}
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}
}
