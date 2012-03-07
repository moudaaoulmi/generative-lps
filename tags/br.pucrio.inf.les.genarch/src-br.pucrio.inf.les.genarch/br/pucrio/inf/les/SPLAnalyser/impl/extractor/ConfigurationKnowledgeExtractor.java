package br.pucrio.inf.les.SPLAnalyser.impl.extractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import sun.security.krb5.internal.MethodData;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationField;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod;

public class ConfigurationKnowledgeExtractor {

	private ImpactAnalysisModelContent analysisModelContent;
	private Configuration configuration;
	public ConfigurationKnowledgeExtractor(Configuration configuration,
			ImpactAnalysisModel analysisModel) {
		this.configuration = configuration;
		analysisModelContent = new ImpactAnalysisModelContent(analysisModel);
		
	}

	public ImpactAnalysisModel extract() {
		TreeIterator configurationContents = configuration.getMappingRelationships().eAllContents();
		
		while ( configurationContents.hasNext() ) {
			EObject o = (EObject)configurationContents.next();
			
			Mapping mapping;
			o.getClass();
			if ( o instanceof ConfigurationField) {				
				ConfigurationField entity = (ConfigurationField)o;
				
				Field field = analysisModelContent.findField(entity.getName(), pathTranslator(entity.getPath()));
				List<Feature> features = new ArrayList<Feature>();
				List<String> expressionFeatures = expressionToFeature(entity.getFeatureExpression().getExpression());
				for(String featureName : expressionFeatures){
					Feature feature = analysisModelContent.findFeature(analysisModelContent.getAnalysisModel().getFeaturesReference()
							, featureName);
					analysisModelContent.addMapping(feature, field, null);
				}
				
			} else if (o instanceof ConfigurationClass ) {
				
				ConfigurationClass entity = (ConfigurationClass)o;
				Class clazz = analysisModelContent.findClass(entity.getName(), classPathTranslator(entity.getPath(), entity.getName()));
				List<String> expressionFeatures = expressionToFeature(entity.getFeatureExpression().getExpression());
				for(String featureName : expressionFeatures){
					Feature feature = analysisModelContent.findFeature(analysisModelContent.getAnalysisModel().getFeaturesReference()
							, featureName);
					analysisModelContent.addMapping(feature, clazz, null);
				}
				
			} else if (o instanceof ConfigurationMethod) {
				
				ConfigurationMethod entity = (ConfigurationMethod)o;
				Method method = analysisModelContent.findMethod(entity.getName(), pathTranslator(entity.getPath()) );
				
				List<String> expressionFeatures = expressionToFeature(entity.getFeatureExpression().getExpression());
				for(String featureName : expressionFeatures){
					Feature feature = analysisModelContent.findFeature(analysisModelContent.getAnalysisModel().getFeaturesReference()
							, featureName);
					analysisModelContent.addMapping(feature, method, null);
				}
			} else {
				continue;
			}
		}
		return analysisModelContent.getAnalysisModel();
	}
	
	public List<String> expressionToFeature(String expression){
		List<String> result = new ArrayList<String>();
		
//		StringTokenizer tokenize = new StringTokenizer(expression, "and");
		
	     Scanner s = new Scanner(expression).useDelimiter("\\s* and \\s*");
	    
	     while (s.hasNext()) {
				result.add(s.next());
			}
//		while (tokenize.hasMoreTokens()) {
//			result.add(tokenize.nextToken());
//		}
		return result;
	}
	
	public String classPathTranslator(String path, String name){
		String newPath = "";
		newPath = path.replace("src/", "");
		newPath = newPath.replaceAll("(/)",".");
		newPath = newPath.replace("."+name,"");
		return newPath;
		
	}
	public String pathTranslator(String path){
		String newPath = "";
		newPath = path.replace("src/", "");
		newPath = newPath.replaceAll("(/)",".");
		newPath = newPath.replace(".java","");
		return newPath;
		
	}

}
