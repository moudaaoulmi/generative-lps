package br.pucrio.inf.les.SPLAnalyser.impl.query;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.SPLAnalyser.core.Query;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.QueryModelContent;
import br.pucrio.inf.les.SPLAnalyser.impl.query.models.OptionalArtefactBindingsModel;

//Apresenta artefatos que depende de features opcionais, 
//onde não há restrições que obriguem a entrada do artefato opcional
public class OptionalArtefactBindings implements Query {

	private ImpactAnalysisModelContent analysisModelContent;
	
	private OptionalArtefactBindingsModel queryModel;
	
	
	public OptionalArtefactBindings(){
		
	}
	
	public OptionalArtefactBindingsModel runQuery(ImpactAnalysisModel analysisModel) {
		analysisModelContent = new ImpactAnalysisModelContent(analysisModel);
		queryModel = new OptionalArtefactBindingsModel();
		query();
		return queryModel;
	}

	private void query() {
		List<Feature> features = new ArrayList<Feature>();
		List<Mapping> mappings;
		Mapping mapping = null;
		boolean isIncluding = false;
		boolean allOptional = true;
		for(Feature feature : analysisModelContent.getAllFeatures()){
			mappings = analysisModelContent.findMappingOf(feature);
			for(Mapping map : mappings){
				for(Asset asset : map.getAssets().getDependencies()){
					isIncluding = false;
					allOptional = true;
					features = new ArrayList<Feature>();
					mapping = null;
					if(mappingContains(mappings, asset)) continue;
					mapping = analysisModelContent.findMappingOf(asset);
					if(mapping == null) continue; //quando o artefato não esta anotado ele faz parte do CORE
					features = mapping.getFeatures();
					for(Feature featureAux : features){
						if(analysisModelContent.featureDependsOf(featureAux, feature))
							isIncluding = true;
					}
					if(isIncluding) continue;
					for(Feature featureAux : features){
						if(featureAux.getType() == FeatureType.MANDATORY)
							allOptional = false;
					}
					if(allOptional){
						queryModel.addRelation(feature, map.getAssets(), asset);
					}
				}			
			}
		}
	}
	
	//retorna true se existe um mapeamento para AssetTarget
	private boolean mappingContains(List<Mapping> mappings,Asset assetTarget){
		Asset asset = null;
		for(Mapping map : mappings){
			asset = map.getAssets();
			if(asset == null) continue;
			if(analysisModelContent.isEqual(asset, assetTarget))
				return true;
		}
		return false;
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

}
