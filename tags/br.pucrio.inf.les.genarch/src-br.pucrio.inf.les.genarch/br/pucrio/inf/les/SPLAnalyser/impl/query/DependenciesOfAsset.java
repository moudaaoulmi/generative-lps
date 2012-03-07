package br.pucrio.inf.les.SPLAnalyser.impl.query;

import br.pucrio.inf.les.SPLAnalyser.core.Query;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.QueryModelContent;

//Retorna todas as dependecias diretas de um artefato.
public class DependenciesOfAsset implements Query {

	public static final java.lang.Class CLAZZ = br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class.class;
	public static final java.lang.Class FIELD = br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field.class;
	public static final java.lang.Class METHOD = br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method.class;
	private ImpactAnalysisModelContent analysisModelContent;
	private QueryModelContent queryModelContent;
	private ImpactAnalysisModel queryModel;
	private java.lang.Class  classType;
	private String name;
	private String path;
	
	public DependenciesOfAsset(String name, String path, java.lang.Class clazz){
		this.name = name;
		this.path = path;
		this.classType = clazz;
	}
	
	public ImpactAnalysisModel runQuery(ImpactAnalysisModel analysisModel) {
		analysisModelContent = new ImpactAnalysisModelContent(analysisModel);
		queryModelContent = new QueryModelContent();
		queryModel = queryModelContent.getAnalysisModel();
		query();
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
		Mapping mapping = analysisModelContent.findMappingOf(asset);
		
		queryModelContent.addFeature(mapping.getFeatures());
		queryModelContent.addUseCase(mapping.getUseCases());
		queryModelContent.addAsset(asset.getDependencies());
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

	

}
