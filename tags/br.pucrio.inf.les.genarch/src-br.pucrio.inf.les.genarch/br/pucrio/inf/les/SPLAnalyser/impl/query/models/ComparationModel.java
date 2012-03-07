package br.pucrio.inf.les.SPLAnalyser.impl.query.models;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;

public class ComparationModel {

	private List<Asset> removedAsset =  new ArrayList<Asset>();
	private List<Asset> addedAsset =  new ArrayList<Asset>();
	
	private List<Asset[]> addedAssetDependencies =  new ArrayList<Asset[]>();
	private List<Asset[]> removedAssetDependencies =  new ArrayList<Asset[]>();
	
	
	private List<Feature> removedFeature =  new ArrayList<Feature>();
	private List<Feature> addedFeature =  new ArrayList<Feature>();
	
	private List<Mapping> removedMapping =  new ArrayList<Mapping>();
	private List<Mapping> addedMapping =  new ArrayList<Mapping>();
	
	private List<Feature[]> removedFeatureConstraint =  new ArrayList<Feature[]>();
	private List<Feature[]> FeatureConstraint =  new ArrayList<Feature[]>();
	
	void ComparationModel(){
		
	}
}
