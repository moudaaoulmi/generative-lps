package br.pucrio.inf.les.SPLAnalyser.impl.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import br.pucrio.inf.les.SPLAnalyser.core.Query;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.QueryModelContent;

//
public class AssetFeatureBinding implements Query {

	public static final java.lang.Class CLAZZ = br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class.class;
	public static final java.lang.Class FIELD = br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field.class;
	public static final java.lang.Class METHOD = br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method.class;
	private ImpactAnalysisModelContent analysisModelContent;
	private QueryModelContent queryModelContent;
	private ImpactAnalysisModel queryModel;
	private int level;
	private String name;
	private String path;
	private java.lang.Class classType;
	
	//Busca todos os features que podem estar associados a um determinado artefato por dependencias com outros artefatos
	public AssetFeatureBinding(String name, String path, java.lang.Class clazz, int level){
		this.name = name;
		this.path = path;
		this.classType = clazz;
		this.level = level;
	}
	
	public ImpactAnalysisModel runQuery(ImpactAnalysisModel analysisModel) {
		analysisModelContent = new ImpactAnalysisModelContent(analysisModel);
		queryModelContent = new QueryModelContent();
		query();
		queryModel = queryModelContent.getAnalysisModel();
		return queryModel;
	}

	private void query() {
		Asset asset = null;
		if(classType.equals(this.CLAZZ)){
			asset = analysisModelContent.findClass(name, path);
		}else if(classType.equals(this.FIELD)){
			asset = analysisModelContent.findField(name, path);
		}else if(classType.equals(this.METHOD)){
			asset = analysisModelContent.findMethod(name, path);
		}
		
		List<Feature> features = new ArrayList<Feature>();
		List<Asset> assets = new ArrayList<Asset>();
		assets.add(asset);
		
		assets.add(asset);
		assets.addAll(assetInteraction(assets, level));
		features.addAll(getFeatureBinding(assets));
		queryModelContent.addFeature(features);
	}
	
	private List<Asset> assetInteraction(List<Asset> assets, int deep) {
		List<Asset> dependencies = new ArrayList<Asset>();
		if (deep == 0) return assets;
		for(Asset asset : assets){
			dependencies = addAllDifferent(dependencies, analysisModelContent.getAssetsDependenciasOf(asset));
		}
		dependencies = removeDuplicates(assets, dependencies);
		assets.addAll(removeDuplicates(assets,assetInteraction(dependencies, deep - 1)));
		return assets;
	}
	
	//remove elementos de assets2 que ja existam em assets1
	private List<Asset> removeDuplicates(List<Asset> assets1, List<Asset> assets2){
		List<Asset> result = new ArrayList<Asset>(assets2);
		for(Asset asset1 : assets1){
			for(Asset asset2 : assets2){
				if(analysisModelContent.isEqual(asset1, asset2))
					result.remove(asset2);
			}
		}
		return result;
	}
	
	
	private List<Asset> addAllDifferent(List<Asset> assets1, List<Asset> assets2){
		List<Asset> result = new ArrayList<Asset>(assets1);
		for(Asset asset2 : assets2){
			Asset target = asset2;
			for(Asset asset1 : assets1){
				if(analysisModelContent.isEqual(asset1, asset2)){
					target = null;
					break;
				}
			}
			if(target != null) result.add(target);
		}
		return result;
	}
	
	//remove elementos de assets2 que ja existam em assets1
	private List<Feature> getFeatureBinding(List<Asset> assets){
		List<Feature> result = new ArrayList<Feature>();
		Mapping mapping = null;
		for(Asset asset : assets){
			mapping = analysisModelContent.findMappingOf(asset);
			if(mapping != null)
				result.addAll(analysisModelContent.findMappingOf(asset).getFeatures());
		}
		return result;
	}
	public String getName() {
		return this.getClass().getSimpleName();
	}

}
