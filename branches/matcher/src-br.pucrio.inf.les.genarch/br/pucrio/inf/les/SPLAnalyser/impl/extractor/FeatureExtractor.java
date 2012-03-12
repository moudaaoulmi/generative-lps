package br.pucrio.inf.les.SPLAnalyser.impl.extractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;


import ca.uwaterloo.gp.fmp.Constraint;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionNode;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionParser;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionScanner;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionParser.ExpressionParseException;
import ca.uwaterloo.gp.fmp.constraints.expression.Symbols.Token;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;

public class FeatureExtractor {
	
	private Node model;
	private ModelNavigation modelNavigation;
	private List<Constraint> constraints = new ArrayList<Constraint>();
	private Pattern pattern;
	
	private ImpactAnalysisModel analysisModel;
	private ImpactAnalysisModelContent analysisModelContent;
	
	

	public FeatureExtractor(Node model, ImpactAnalysisModel analysisModel){
		this.model = model;
		modelNavigation = ModelNavigation.INSTANCE;
		
		this.analysisModel = analysisModel;
		analysisModelContent = new ImpactAnalysisModelContent(analysisModel);
		mountRegularExpresssion();
	}
	
	public ImpactAnalysisModel extract(){
		modelNavigation.getAllFeatures(model);
		for (Iterator i = modelNavigation.getAllFeatures(model).iterator(); i.hasNext(); ) {
			Feature feature = (Feature) i.next();
			fmp2FeatureAnalysisModel(feature);
		}
		extractConstraints();
		return analysisModel;		
	}

	

	
	//Preenche os relações de dependencia/exclusão no modelo com base nas constaints extraidas do FMP 
//	private void fillConstraints() {
//		for(ConstraintData constraint : featureDataModel.getAllConstraint()){
//			FeatureData primaryTarget = featureDataModel.getFeatureDataById(constraint.getPrimaryTarget());
//			if(constraint.getType() == ConstraintData.DEPENDENCE)
//				primaryTarget.addDependence(constraint.getSecondaryTarget());
//			else if(constraint.getType() == ConstraintData.EXCLUSION)
//				primaryTarget.addExclusion(constraint.getSecondaryTarget());
//		}
//	}
	
	// Transforma uma feature do FMP em uma Feature do modelo da Análise,
	// as constraints são colocadas em uma lista de constraints.
	
	
	private br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature 
				fmp2FeatureAnalysisModel(ca.uwaterloo.gp.fmp.Feature feature){
		
		
		br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature featureAM = analysisModelContent.addFeature(feature.getName(),
		feature.isOptional() ? FeatureType.OPTIONAL : FeatureType.MANDATORY, false	);
		
		for(Object child : feature.getChildren()){
			//Atualmente não trata FeatureGroup como Child apenas Features normais
			ca.uwaterloo.gp.fmp.Feature childAux;
			ca.uwaterloo.gp.fmp.FeatureGroup childGroup;
			if(child.getClass().equals(ca.uwaterloo.gp.fmp.impl.FeatureImpl.class)){
				childAux = (ca.uwaterloo.gp.fmp.Feature)child;
				br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature featureChild 
				= analysisModelContent.addFeature(childAux.getName(), feature.isOptional() ? FeatureType.OPTIONAL : FeatureType.MANDATORY, false);
				featureAM = analysisModelContent.addFeatureChild(featureAM,featureChild );
				childAux.getConstraints();
			}else if(child.getClass().equals(ca.uwaterloo.gp.fmp.impl.FeatureGroupImpl.class)){
				childGroup = (FeatureGroup)child;
				for(Object childAlternative : childGroup.getChildren()){
					childAux = (ca.uwaterloo.gp.fmp.Feature)childAlternative;
					br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature featureChild 
					= analysisModelContent.addFeature(childAux.getName(), feature.isOptional() ? FeatureType.OPTIONAL : FeatureType.MANDATORY, false);
					featureAM = analysisModelContent.addFeatureChild(featureAM,featureChild );
					analysisModelContent.setAlternative(featureAM, true);
					childAux.getConstraints();
				}				
			}			
		}
		//As constraints são colocadas em uma lista para interpretar posteriormente
		for(Object cons : feature.getConstraints()  ){
			constraints.add((Constraint)cons);
		}
		return featureAM;		
	}
	
	
	//Interpreta as constraints no modelo ConstrainData
	private void extractConstraints(){
		
		ExpressionNode expr = null;
		ExpressionScanner scanner;
		ExpressionParser parser = new ExpressionParser();
		
		for(Object obj : constraints){
			Constraint cons = (Constraint)obj;
			expr = null;
			scanner = new ExpressionScanner(((Constraint)cons).getText());
			try {
				expr = parser.createExpression(scanner);
			} 
			catch (ExpressionParseException e) {
				expr = null;
			}
			Matcher m = pattern.matcher(expr.toString());
			if (m.find())
		    {
		        String c1=m.group(1);
		        String alphanum1=m.group(2);
		        String c2=m.group(3);
		        String c3=m.group(4);
		        String c4=m.group(5);
		        String alphanum2=m.group(6);
		        String c5=m.group(7);
		        analysisModelContent.addConstraint(c4 == null ? Type.INCLUSION : Type.EXCLUSION, expr.toString(), alphanum1, alphanum2);
		    }
		}
		
	}

	
	//Padrão de expressão regular para interpretar as expressões de constraints do FMP
	private void mountRegularExpresssion() {
	    String re1="(\\()";	
	    String re2="((?:[a-z][a-z0-9_]*))";	
	    String re3="(-)";
	    String re4="(>)";	
	    String re5="(!)?";
	    String re6="((?:[a-z][a-z0-9_]*))";	
	    String re7="(\\))";
	    
	    pattern = Pattern.compile(re1+re2+re3+re4+re5+re6+re7,Pattern.CASE_INSENSITIVE | Pattern.DOTALL); 
	}

}
