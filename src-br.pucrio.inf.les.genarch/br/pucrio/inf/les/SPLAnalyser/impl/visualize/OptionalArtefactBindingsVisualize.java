package br.pucrio.inf.les.SPLAnalyser.impl.visualize;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import br.pucrio.inf.les.SPLAnalyser.core.Visualize;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.impl.query.models.OptionalArtefactBindingsModel;

public class OptionalArtefactBindingsVisualize implements Visualize{

	OptionalArtefactBindingsModel model;
	String queryName;
	public void run(Object queryModel, String name) {
		model = (OptionalArtefactBindingsModel) queryModel;
		queryName = name;
		Writer writer = null;

		try {
			File file = new File("C:\\eclipses\\workspaces\\runtime-EclipseApplication\\MB\\ImpactAnalysis\\querys\\"+queryName+".txt");
			writer = new BufferedWriter(new FileWriter(file));
			printFile(writer);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void printFile(Writer writer){
		try {
			
			writer.write("Análise apresenta ligações com artefatos relacionados apenas com features opcionais,\n" +
					" das quais não existe restrições para a inclusão de alguma das features\n");
			Feature feature = null;
			Asset asset1 = null;
			Asset asset2 = null;
			for(Object[] relation : model.getRelations()){
				feature = (Feature) relation[0];
				asset1 = (Asset) relation[1];
				asset2 = (Asset) relation[2];
				writer.write("\n\n"+feature.getName()+ " -> \n" 
						+ asset1.getPath() + " - " + asset1.getName() + " -> \n"  
						+ asset2.getPath() + " - " + asset2.getName());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
