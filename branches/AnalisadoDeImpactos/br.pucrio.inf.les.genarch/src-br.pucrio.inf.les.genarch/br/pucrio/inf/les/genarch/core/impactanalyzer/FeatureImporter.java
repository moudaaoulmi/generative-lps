package br.pucrio.inf.les.genarch.core.impactanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.AnalysisFeatureData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.ConstraintData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.featuredata.FeatureData;
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

public class FeatureImporter {
	
	private Node model;
	private ModelNavigation modelNavigation;
	private AnalysisFeatureData featureDataModel;
	private List<Constraint> constraints = new ArrayList<Constraint>();
	private Pattern pattern;
	
	

	public FeatureImporter(Node model) throws IOException{
		this.model = model;
		modelNavigation = ModelNavigation.INSTANCE;
		featureDataModel = new AnalysisFeatureData();
		
		mountRegularExpresssion();
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

	//Cada Feature do FMP é transformada para o modelo FeatureData
	public AnalysisFeatureData extract(){			
		modelNavigation.getAllFeatures(model);
 
		for (Iterator i = modelNavigation.getAllFeatures(model).iterator(); i.hasNext(); ) {
			Feature feature = (Feature) i.next();
			FeatureData featureData = fmp2FeatureData(feature);
			featureDataModel.addFeature(featureData);
		}
		featureDataModel.addConstraint(extractConstraint());
		fillDependences();
		return featureDataModel;
	}
	
	//Preenche os relações de dependencia/exclusão no modelo com base nas constaints extraidas do FMP 
	private void fillDependences() {
		for(ConstraintData constraint : featureDataModel.getAllConstraint()){
			FeatureData primaryTarget = featureDataModel.getFeatureDataById(constraint.getPrimaryTarget());
			if(constraint.getType() == ConstraintData.DEPENDENCE)
				primaryTarget.addDependence(constraint.getSecondaryTarget());
			else if(constraint.getType() == ConstraintData.EXCLUSION)
				primaryTarget.addExclusion(constraint.getSecondaryTarget());
		}
	}


	//transforma uma feature do FMP em uma FeatureData, as constraints são colocadas em uma lista de constraints
	private FeatureData fmp2FeatureData(Feature feature){
		
		FeatureData featureData = new FeatureData();
		featureData.setName(feature.getName());
		featureData.setId(feature.getId());
		featureData.setMin(feature.getMin());
		featureData.setMax(feature.getMax());
		List<String> children = new ArrayList<String>();
		
		for(Object child : feature.getChildren()  ){
			//Atualmente não trata FeatureGroup como Child apenas Features normais
			if(child.getClass().equals(ca.uwaterloo.gp.fmp.Feature.class))
				children.add(((Feature)child).getId());
		}
		featureData.setChildren(children);
		
		//As constraints são colocadas em uma lista para interpretar posteriormente
		for(Object cons : feature.getConstraints()  ){
			constraints.add((Constraint)cons);
		}
		
		return featureData;
		
	}
	
	//Interpreta as constraints no modelo ConstrainData
	private List<ConstraintData> extractConstraint(){
		List<ConstraintData> constraintData = new ArrayList<ConstraintData>();
		ExpressionNode expr = null;
		ExpressionScanner scanner;
		ExpressionParser parser = new ExpressionParser();
		
		for(Constraint cons : constraints){
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
		        ConstraintData constraint = new ConstraintData(c4 == null ? ConstraintData.DEPENDENCE : ConstraintData.EXCLUSION, alphanum1 , alphanum2);		        
		        constraintData.add(constraint);
		    }
		}
		return constraintData;
		
	}
	
}
