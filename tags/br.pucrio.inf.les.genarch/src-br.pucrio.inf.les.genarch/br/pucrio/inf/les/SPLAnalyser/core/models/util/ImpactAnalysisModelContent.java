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

public class ImpactAnalysisModelContent {

	private ImpactanalysismodelPackage impactanalysismodelPackage;
	private ImpactanalysismodelFactory impactanalysismodelFactory;
	private ImpactAnalysisModel analysisModel;


	public ImpactAnalysisModelContent() {				
		init();			
		this.analysisModel = this.impactanalysismodelFactory.createImpactAnalysisModel();
	}

	public ImpactAnalysisModelContent(ImpactAnalysisModel analysisModel) {
		init();
		this.analysisModel = analysisModel;	
	}

	private void init() {
		ArchitecturePackageImpl.init();
		ImpactanalysismodelPackageImpl.init();
		this.impactanalysismodelPackage = ImpactanalysismodelPackage.eINSTANCE;
		this.impactanalysismodelFactory = this.impactanalysismodelPackage.getImpactanalysismodelFactory();
	}
	
	public ImpactAnalysisModel createImpactAnalysisModel() {				
		init();			
		this.analysisModel = this.impactanalysismodelFactory.createImpactAnalysisModel();
		return analysisModel;
	}
	
	public Feature simpleCopyFeature(Feature feature){
		Feature result = this.impactanalysismodelFactory.createFeature();
		result.setName(feature.getName());
		result.setType(feature.getType());
		return result;
	}
	
	public Feature copyFeature(Feature feature){
		Feature result = this.impactanalysismodelFactory.createFeature();
		result.setName(feature.getName());
		result.setType(feature.getType());
		for(Constraint constraint : feature.getConstraints()){
			result.getConstraints().add(this.copyConstraint(constraint));
		}
		return result;
	}
	
	public Constraint copyConstraint(Constraint constraint){
		Constraint result = this.impactanalysismodelFactory.createConstraint();
		result.setConstraintExpression(constraint.getConstraintExpression());
		result.setFeatureTarget(this.simpleCopyFeature(constraint.getFeatureTarget()));
		result.setConstraintType(constraint.getConstraintType());
		for(Feature feature :  constraint.getAssociatedFeatures()){
			result.getAssociatedFeatures().add(this.simpleCopyFeature(feature));
		}
		return result;
	}
	
	
	//Copia artefatos sem considerar dependencias e artefatos associados.
	public Asset copyAsset(Asset asset){
		Asset result = null;
		if(asset instanceof Class){
			result =  this.impactanalysismodelFactory.createClass();
			for(Asset assetAux : ((Class) asset).getDeclaredFields()){ // copia atributos declarados
				((Class) result).getDeclaredFields().add((Field) simpleCopyAsset(assetAux));
			}
			for(Asset assetAux : ((Class) asset).getDeclaredMethods()){//copia metodos declarados
				((Class) result).getDeclaredMethods().add((Method) simpleCopyAsset(assetAux));
			}
			
		}else if(asset instanceof Method){
			result =  this.impactanalysismodelFactory.createMethod();
		}else if(asset instanceof Field){
			result =  this.impactanalysismodelFactory.createField();
		}
		
		for(Asset assetAux : ((Class) asset).getDependencies()){//copia metodos declarados
			((Class) result).getDependencies().add((Asset) simpleCopyAsset(assetAux));
		}
		
		result.setName(asset.getName());
		result.setPath(asset.getPath());
		return result;
	}
	
	
	//Copia artefatos sem considerar dependencias e artefatos associados.
	public Asset simpleCopyAsset(Asset asset){
		Asset result = null;
		if(asset instanceof Class){
			result =  this.impactanalysismodelFactory.createClass();
			for(Asset assetAux : ((Class) asset).getDeclaredFields()){ // copia atributos declarados
				((Class) result).getDeclaredFields().add((Field) simpleCopyAsset(assetAux));
			}
			for(Asset assetAux : ((Class) asset).getDeclaredMethods()){//copia metodos declarados
				((Class) result).getDeclaredMethods().add((Method) simpleCopyAsset(assetAux));
			}
			
		}else if(asset instanceof Method){
			result =  this.impactanalysismodelFactory.createMethod();
		}else if(asset instanceof Field){
			result =  this.impactanalysismodelFactory.createField();
		}
		result.setName(asset.getName());
		result.setPath(asset.getPath());
		return result;
	}
	
	public Mapping simpleCopyMapping(Mapping mapping){
		Mapping result = this.impactanalysismodelFactory.createMapping();
		result.setAssets(this.simpleCopyAsset(mapping.getAssets()));
		for(Feature feature : mapping.getFeatures()){
			result.getFeatures().add(this.copyFeature(feature));
		}
		for(UseCase useCase : mapping.getUseCases()){
			result.getUseCases().add(this.copyUseCase(useCase));
		}
		return result;
	}
	
	public UseCase copyUseCase(UseCase useCase){
		UseCase result = this.impactanalysismodelFactory.createUseCase();
		result.setName(useCase.getName());		
		return result;
	}
	
	public Feature addFeature(String name, FeatureType featureType, Boolean isAlternative) {
		
		//Se a feature já existir, não cria a feature.
		if(findFeature(this.analysisModel.getFeaturesReference(),name) != null) 
			return findFeature(this.analysisModel.getFeaturesReference(),name);
		
		Feature feature = this.impactanalysismodelFactory.createFeature();
		feature.setName(name);
		feature.setType(featureType);
		feature.setIsAlternative(isAlternative);
		this.analysisModel.getFeaturesReference().add(feature);
		return feature;
	}
	
	public Feature setAlternative(Feature feature, Boolean isAlternative) {
		feature.setIsAlternative(isAlternative);
		return feature;
	}
	
	public Feature addFeatureChild(Feature feature, Feature child) {
		feature.getFeatureChild().add(child);
		return feature;
	}
	
	
	public Feature findFeature( EList<Feature> list, String name) {
		for(Feature feature : list){
			if(feature.getName().equalsIgnoreCase(name)){
				return feature;
			}else{
				Feature result = findFeature(feature.getFeatureChild(), name);
				if(result != null) return result;
			}
				
		}
		return null;
	}
	
	
	public Feature findFeature(  String name) {
		return findFeature(this.analysisModel.getFeaturesReference() , name);
	}
	
	
	public Constraint addConstraint(Type constraintType, String constraintExp, String featureTarget, String associatedFeature) {
		Constraint constraint = this.impactanalysismodelFactory.createConstraint();
		constraint.setConstraintExpression(constraintExp);
		constraint.setConstraintType(constraintType);
		constraint.getAssociatedFeatures().add(findFeature(this.analysisModel.getFeaturesReference() , associatedFeature));
		this.analysisModel.getConstraintsReference().add(constraint);
		Feature target = findFeature(this.analysisModel.getFeaturesReference(), featureTarget);
		constraint.setFeatureTarget(target);
		target.getConstraints().add(constraint);	
		return constraint;
	}
	
	public UseCase addUseCase(String name) {
		UseCase useCase = this.impactanalysismodelFactory.createUseCase();
		useCase.setName(name);
		this.analysisModel.getUseCasesReference().add(useCase);
		return useCase;
	}
	
	public Method addMethod(Class clazz, String name, String path) {
		Method method = this.impactanalysismodelFactory.createMethod();
		method.setName(name);
		method.setPath(path);
		this.analysisModel.getAssetsReference().add(method);
		clazz.getDeclaredMethods().add(method);
		return method;
	}
	
	
	public Asset addDependencies(Asset asset, Asset dependencie) {
		asset.getDependencies().add(dependencie);
		return asset;
	}
	
	public Class addClass(String name, String path) {
		Class clazz = this.impactanalysismodelFactory.createClass();
		clazz.setName(name);
		clazz.setPath(path);
		this.analysisModel.getAssetsReference().add(clazz);
		
		return clazz;
	}
	
	
	
	public Field addField(Class clazz, String name, String path) {
		Field field = this.impactanalysismodelFactory.createField();
		field.setName(name);
		field.setPath(path);
		this.analysisModel.getAssetsReference().add(field);
		clazz.getDeclaredFields().add(field);
		return field;
	}
	
	public Mapping addMapping(Feature feature, Asset asset, UseCase useCase) {
		
		Mapping mapping;
		mapping = findMappingOf(asset);
		if(mapping == null){
			mapping = this.impactanalysismodelFactory.createMapping();
			mapping.setAssets(asset);
		}
		if(feature != null){
			mapping.getFeatures().add(feature);
		}
		if(useCase != null){
			mapping.getUseCases().add(useCase);
		}
		this.analysisModel.getMappingsReference().add(mapping);
		return mapping;
	}
	
	
	public Mapping findMappingOf(Asset assetTarget){
		
		for(Mapping mapping :  this.analysisModel.getMappingsReference()){
			if(mapping.getAssets() == null) return null;
			if(mapping.getAssets().getName().equals(assetTarget.getName())
				&& mapping.getAssets().getPath().equals(assetTarget.getPath())
				&& mapping.getAssets().getClass().equals(assetTarget.getClass())){
				return mapping;
			}
		}
		
		return null;		
	}
	
public List<Mapping> findMappingOf(Feature feature){
		List<Mapping> mappings = new ArrayList<Mapping>();
		for(Mapping mapping :  this.analysisModel.getMappingsReference()){
			for(Feature feat : mapping.getFeatures()){
				if(feat.getName().equals(feature.getName())){
					mappings.add(mapping);
					break;
				}	
			}	
		}
		return mappings;		
	}
	
	public List<Class> getAllClass(){
		List<Class> classList = new ArrayList<Class>();
		for(Asset asset :  this.analysisModel.getAssetsReference()){
			if(asset instanceof Class){
				classList.add((Class) asset);
			}
		}
		return classList;
	}
	
	public List<Method> getAllMethods(){
		List<Method> methodList = new ArrayList<Method>();
		for(Asset asset :  this.analysisModel.getAssetsReference()){
			if(asset instanceof Class){
				methodList.addAll(((Class) asset).getDeclaredMethods());
			}
		}
		return methodList;
	}
	
	public List<Field> getAllFields(){
		List<Field> fieldList = new ArrayList<Field>();
		for(Asset asset :  this.analysisModel.getAssetsReference()){
			if(asset instanceof Class){
				fieldList.addAll(((Class) asset).getDeclaredFields());
			}
		}
		return fieldList;
	}
	
	public List<Feature> getAllFeatures(){
		return featureTreeInteractor(this.analysisModel.getFeaturesReference());
	}
	
	public List<Feature> featureTreeInteractor(List<Feature> features){
		List<Feature> result = new ArrayList<Feature>(features);
		for(Feature feature : features){
			result.addAll(featureTreeInteractor(feature.getFeatureChild()));
		}
		return result;
	}
	
	public List<Mapping> getAllMappigns(){
		List<Mapping> resulto = new ArrayList<Mapping>();		
		return this.analysisModel.getMappingsReference();
	}
	
	public List<Asset> getAllAssets(){
		List<Asset> assets = new ArrayList<Asset>();
		assets.addAll(getAllClass());
		assets.addAll(getAllFields());
		assets.addAll(getAllMethods());
		return assets;
	}
	
	public Class findClass(String name, String path){
		List<Class> classList = new ArrayList<Class>();
		for(Asset asset :  this.analysisModel.getAssetsReference()){
			if(asset instanceof Class){
				classList.add((Class) asset);
			}
		}
		for(Class aClass : classList){
			if(aClass.getName().equals(name) &&
					aClass.getPath().equals(path)) {
				return aClass;
			}
		}
		return null;		
	}
	
		
	public Field findField(String name, String path){
		List<Field> fieldList = new ArrayList<Field>();
		for(Asset asset :  this.analysisModel.getAssetsReference()){
			if(asset instanceof Class){
				fieldList.addAll(((Class) asset).getDeclaredFields());
			}
		}
		for(Field aField : fieldList){
			if(aField.getName().equals(name) &&
					aField.getPath().equals(path)) {
				return aField;
			}
		}
		return null;		
	}
	
	public Method findMethod(String name, String path){
		List<Method> methodList = new ArrayList<Method>();
		for(Asset asset :  this.analysisModel.getAssetsReference()){
			if(asset instanceof Class){
				methodList.addAll(((Class) asset).getDeclaredMethods());
			}
		}
		for(Method aMethod : methodList){
			if(aMethod.getName().equals(name) &&
					aMethod.getPath().equals(path)) {
				return aMethod;
			}
		}
		return null;		
	}
	
	public boolean isEqual(Asset asset1, Asset asset2){
		if(asset1 instanceof Class){
			if(!(asset2 instanceof Class)) return false;
			if(asset1.getName().equals(asset2.getName())
				&& asset1.getPath().equals(asset2.getPath())) return true;
		}else if(asset1 instanceof Field){
			if(!(asset2 instanceof Field)) return false;
			if(asset1.getName().equals(asset2.getName())
					&& asset1.getPath().equals(asset2.getPath())) return true;
		}else if(asset1 instanceof Method){
			if(!(asset2 instanceof Method)) return false;
			if(asset1.getName().equals(asset2.getName())
					&& asset1.getPath().equals(asset2.getPath())) return true;
		}
		return false;
	}
	
	public List<Asset> getAssetsDependenciasOf(Asset assetTarget){
		List<Asset> result = new ArrayList<Asset>();
		
		for(Asset asset : getAllAssets()){
			if(assetDependsOf(asset, assetTarget))
				result.add(asset);
		}
		return result;
	}
	
	
	//verifica se asset1 depende de asset2
	public boolean assetDependsOf(Asset asset1, Asset asset2 ){
		
		for(Asset asset : asset1.getDependencies()){
			if(isEqual(asset, asset2))
				return true;
		}
		return false;
	}
	
	//verifica se asset1 depende de asset2
	public boolean featureDependsOf(Feature feature1, Feature feature2 ){
		if(isFeatureChildFrom(feature1, feature2)
			|| isFeatureIncluding(feature1, feature2))
		return true;
		
		return false;
	}
	
	//verifica se a feature1 possui um relacionamento de inclusão com a feature2
	public boolean isFeatureIncluding(Feature feature1, Feature feature2 ){
		for(Constraint constraint : feature1.getConstraints()){
			if( constraint.getConstraintType() != Type.INCLUSION) continue;
			for(Feature feature : constraint.getAssociatedFeatures()){
				if(feature.getName().equals(feature2.getName())) return true;
			}
		}
		return false;
	}
	
	//verifica se a feature1 é filha da feature2
	public boolean isFeatureChildFrom(Feature feature1, Feature feature2 ){
		List<String> parents = new ArrayList<String>();
		for(Feature feature : this.analysisModel.getFeaturesReference()){
			parents.clear();
			parents.addAll(featureParentsInteractor(feature1, feature, parents));
			
			for(String parent : parents){
				if(parent.equals(feature2.getName())){
					return true;
				}
			}
		}
		return false;
	}
	
	public List<String> featureParentsInteractor(Feature featureTarget, Feature feature ,  List<String> parents){
		List<String> result = new ArrayList<String>(parents);
		result.add(feature.getName());
		if(feature.getName().equals(featureTarget.getName())){
			return result;
		}
		for(Feature child : feature.getFeatureChild()){
			List<String> result2 = featureParentsInteractor(featureTarget, child, result);
			if(result2.isEmpty()) continue;
			return result2;
			
		}		
		return new ArrayList<String>();
	}
	
	
//public List<String> featureParentsInteractor(Feature featureTarget, Feature feature ,  List<String> parents){
//		
//		if(feature.getFeatureChild().isEmpty()) return new ArrayList<String>();
//		for(Feature child : feature.getFeatureChild()){
//			if(child.getName().equals(featureTarget.getName())){
//				parents.add(child.getName());
//				return parents;
//			}
//			parents.add(child.getName());
//			List<String> result = featureParentsInteractor(featureTarget,child, parents); 
//			if(result.isEmpty()){
//				return new ArrayList<String>();
//			}
//			if((result.size() > 0) && (result.get(result.size() - 1) != null)){
//				return result;
//			}
//			
//			
//		}
//		return parents;
//	}
	
	
	public ImpactAnalysisModel getAnalysisModel() {
		return analysisModel;
	}

	public void setAnalysisModel(ImpactAnalysisModel analysisModel) {
		this.analysisModel = analysisModel;
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
