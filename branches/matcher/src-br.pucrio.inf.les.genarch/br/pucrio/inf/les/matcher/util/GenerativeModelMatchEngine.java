package br.pucrio.inf.les.matcher.util;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class GenerativeModelMatchEngine extends GenericMatchEngine {
	@Override
	protected AbstractSimilarityChecker prepareChecker(){		
		return new AbstractSimilarityChecker(filter) {
			
			@Override
			public boolean isSimilar(EObject arg0, EObject arg1)
					throws FactoryException {
				
				if(arg0.eClass().getClassifierID() == arg1.eClass().getClassifierID())
					return true;
				
				return false;
			}
			
			@Override
			public void init(Resource arg0, Resource arg1) throws FactoryException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void init(EObject arg0, EObject arg1) throws FactoryException {
				// TODO Auto-generated method stub
				
			}
			
			//TODO [Demóstenes] This is a simple absoluteMetric. It is necessary to evolve.
			@Override
			public double absoluteMetric(EObject arg0, EObject arg1)
					throws FactoryException {
								
				/*if(arg0.eClass().getClassifierID() == arg1.eClass().getClassifierID()) {
					if (arg0.eClass().getClassifierID() == GenerativemodelPackage.ABSTRACT_DATA){
						AbstractData abstractData0 = (AbstractData) arg0;
						AbstractData abstractData1 = (AbstractData) arg1; 
						
						double metric = 0.0;
												
						if(abstractData0.getName().equals(abstractData1.getName())) metric += 0.25;
						if(abstractData0.getPath().equals(abstractData1.getPath())) metric += 0.25;
						
						if(abstractData0.getDependences().size() == abstractData1.getDependences().size()) metric += 0.25;
						if(abstractData0.getReverseDependences() == abstractData1.getReverseDependences()) metric += 0.25;
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.ASSET_DATA){
						AssetData assetdata0 = (AssetData) arg0;
						AssetData assetdata1 = (AssetData) arg1;
						double metric = 0.0;
						
						if(assetdata0.getAssetsData().size() == assetdata1.getAssetsData().size()) metric += 1.0;
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.CLASS){						
						Class class0 = (Class) arg0;
						Class class1 = (Class) arg1;
						double metric = 0.0;
						
						if(class0.getDependences().size() == class1.getDependences().size()) metric += 0.143;
						if(class0.getFields().size() == class1.getFields().size()) metric += 0.143;
						if(class0.getMethodReverseDependences().size() == class1.getMethodReverseDependences().size()) metric += 0.143;
						if(class0.getMethods().size() == class1.getMethods().size()) metric += 0.143;
						if(class0.getName().equals(class1.getName())) metric += 0.143;
						if(class0.getPath().equals(class1.getPath())) metric += 0.143;
						if(class0.getReverseDependences().size() == class1.getReverseDependences().size()) metric += 0.143;
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.FEATURE){
						Feature feature0 = (Feature) arg0;
						Feature feature1 = (Feature) arg1;
						double metric = 0.0;
						
						if(feature0.getChildren().size() == feature1.getChildren().size()) metric += 0.143;
						if(feature0.getMax().intValue() == feature1.getMax().intValue()) metric += 0.143;
						if(feature0.getMin().intValue() == feature1.getMin().intValue()) metric += 0.143;
						if(feature0.getDependences().size() == feature1.getDependences().size()) metric += 0.143;
						if(feature0.getExclusion().size() == feature1.getExclusion().size()) metric += 0.143;
						if(feature0.getId().equals(feature1.getId())) metric += 0.143;
						if(feature0.getName().equals(feature1.getName())) metric += 0.143;												
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.FEATURE_DATA){
						FeatureData featuredata0 = (FeatureData) arg0;
						FeatureData featuredata1 = (FeatureData) arg1;
						double metric = 0.0;
						
						if(featuredata0.getFeaturesData().size() == featuredata1.getFeaturesData().size()) metric += 1.0;
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.FIELD){
						Field field0 = (Field) arg0;
						Field field1 = (Field) arg1;
						double metric = 0.0;
						
						if(field0.getDependences().size() == field1.getDependences().size()) metric += 0.25;
						if(field0.getMethodReverseDependences().size() == field1.getMethodReverseDependences().size()) metric += 0.25;
						if(field0.getReverseDependences().size() == field1.getReverseDependences().size()) metric += 0.25;
						if(field0.getName().equals(field1.getName())) metric += 0.25;
						if(field0.getPath().equals(field1.getPath())) metric += 0.25;
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.GENERATIVE_MODEL){
						GenerativeModel generativemodel0 = (GenerativeModel) arg0;
						GenerativeModel generativemodel1 = (GenerativeModel) arg1;
						double metric = 0.0;
						
						if(generativemodel0.getAssetData().equals(generativemodel1.getAssetData())) metric += 0.33;
						if(generativemodel0.getFeatureData().equals(generativemodel1.getFeatureData())) metric += 0.33;
						if(generativemodel0.getMappingData().equals(generativemodel1.getMappingData())) metric += 0.33;
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.MAPPING){
						Mapping mapping0 = (Mapping) arg0;
						Mapping mapping1 = (Mapping) arg1;
						double metric = 0.0;
						
						if(mapping0.getAsset().equals(mapping1.getAsset())) metric += 0.25;
						if(mapping0.getAsset().equals(mapping1.getAsset())) metric += 0.25;
						if(mapping0.getId().equals(mapping1.getId())) metric += 0.25;
						if(mapping0.getFeatures().size() == mapping1.getFeatures().size()) metric += 025;
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.MAPPING_DATA){
						MappingData mappingdata0 = (MappingData) arg0;
						MappingData mappingdata1 = (MappingData) arg1;
						double metric = 0.0;
						
						if(mappingdata0.getMappingsData().size() == mappingdata1.getMappingsData().size()) metric += 1.0;
						
						return metric;
						
					} else if (arg0.eClass().getClassifierID() == GenerativemodelPackage.METHOD){
						Method method0 = (Method) arg0;
						Method method1 = (Method) arg1;
						double metric = 0.0;
						
						if(method0.getClassDependences().size() == method1.getClassDependences().size()) metric += 0.143;
						if(method0.getClassReverseDependences().size() == method1.getClassReverseDependences().size()) metric += 0.143;
						if(method0.getDependences().size() == method1.getDependences().size()) metric += 0.143;
						if(method0.getFieldDependences().size() == method1.getFieldDependences().size()) metric += 0.143;
						if(method0.getReverseDependences().size() == method1.getReverseDependences().size()) metric += 0.143;
						if(method0.getName().equals(method1.getName())) metric += 0.143;
						if(method0.getPath().equals(method1.getPath())) metric += 0.143;
						
						return metric;
												
					}
				}*/
								
				return 0;
			}
		};
	}
}

