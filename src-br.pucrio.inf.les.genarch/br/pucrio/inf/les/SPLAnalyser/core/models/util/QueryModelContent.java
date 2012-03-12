package br.pucrio.inf.les.SPLAnalyser.core.models.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelFactory;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl;
import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.impl.ArchitecturePackageImpl;

public class QueryModelContent {

	private ImpactanalysismodelPackage impactanalysismodelPackage;
	private ImpactanalysismodelFactory impactanalysismodelFactory;
	private ImpactAnalysisModel queryModel;


	public QueryModelContent() {				
		init();			
		this.queryModel = this.impactanalysismodelFactory.createImpactAnalysisModel();
	}

	public QueryModelContent(ImpactAnalysisModel queryModel) {
		init();
		this.queryModel = queryModel;	
	}

	private void init() {
		ArchitecturePackageImpl.init();
		ImpactanalysismodelPackageImpl.init();
		this.impactanalysismodelPackage = ImpactanalysismodelPackage.eINSTANCE;
		this.impactanalysismodelFactory = this.impactanalysismodelPackage.getImpactanalysismodelFactory();
	}
	
	public ImpactAnalysisModel createImpactAnalysisModel() {				
		init();			
		this.queryModel = this.impactanalysismodelFactory.createImpactAnalysisModel();
		return queryModel;
	}
	
	public void addAsset(Asset asset) {
		this.queryModel.getAssetsReference().add(asset);
	}
	public void addFeature(Feature feature) {
		this.queryModel.getFeaturesReference().add(feature);
	}
	public void addUseCase(UseCase useCase) {
		this.queryModel.getUseCasesReference().add(useCase);
	}
	
	public void addAsset(List<Asset> asset) {
		this.queryModel.getAssetsReference().addAll(asset);
	}
	public void addFeature(List<Feature> feature) {
		this.queryModel.getFeaturesReference().addAll(feature);
	}
	public void addUseCase(List<UseCase> useCase) {
		this.queryModel.getUseCasesReference().addAll(useCase);
	}
	
	public ImpactAnalysisModel getAnalysisModel() {
		return queryModel;
	}
	
	public void addClass(List<Class> clazz) {
		this.queryModel.getAssetsReference().addAll(clazz);
	}
	
	public void addField(List<Field> field) {
		this.queryModel.getAssetsReference().addAll(field);
	}
	
	public void addMethod(List<Method> method) {
		this.queryModel.getAssetsReference().addAll(method);
	}
	

	public void setAnalysisModel(ImpactAnalysisModel analysisModel) {
		this.queryModel = analysisModel;
	}

	public void saveModel(String path){
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");		
		
		URI modelFileURI = URI.createPlatformResourceURI(path, false);	
		
		ResourceSet analysisModelResourceSet = new ResourceSetImpl();
		Resource impactAnalysisResource = analysisModelResourceSet.createResource(modelFileURI);
		
		impactAnalysisResource.getContents().add(this.getAnalysisModel());

		try {
			impactAnalysisResource.save(options);
		} catch (IOException e) {						
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}	
	}
}
