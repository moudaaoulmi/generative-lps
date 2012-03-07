package br.pucrio.inf.les.SPLAnalyser.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class AnalyzerFacade {
	Extractor extractor;
	
	
	ImpactAnalysisModel analysisModel;
	Object sourceTarget;
	Object queryModel;
	SourceCodeAnalyser sourceCodeAnalyser;
	String analysisModelPath;
	String queryModelPath;
	
	
	public AnalyzerFacade(Object sourceTarget, Extractor extractorImpl, SourceCodeAnalyser sourceCodeAnalyser){
		this.sourceTarget = sourceTarget;
		this.extractor = extractorImpl;
		this.sourceCodeAnalyser = sourceCodeAnalyser;
	}
	
	public void run(){
		analysisModel = extractor.extract(sourceTarget);
		analysisModel = sourceCodeAnalyser.analyse(sourceTarget, analysisModel);
		saveModel(analysisModel, extractor.getPath());
	}
	
	public void executeQuery(Query query, Visualize visualize){
		queryModel = query.runQuery( loadAnalysisModel() );
		visualize.run(queryModel, query.getName());
	}
	
	private void saveModel(ImpactAnalysisModel model,String path){
		Map options = new HashMap();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");		
		
		URI modelFileURI = URI.createPlatformResourceURI(path, false);	
		
		ResourceSet analysisModelResourceSet = new ResourceSetImpl();
		Resource impactAnalysisResource = analysisModelResourceSet.createResource(modelFileURI);
		
		impactAnalysisResource.getContents().add(model);

		try {
			impactAnalysisResource.save(options);
		} catch (IOException e) {						
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}	
	}
	
	public ImpactAnalysisModel getAnalysisModel(){
		return analysisModel;
	}
	
	private ImpactAnalysisModel loadAnalysisModel(){
		URI analysisModelFileURI = URI.createPlatformResourceURI(extractor.getPath());
		ResourceSet analysisModelResourceSet = new ResourceSetImpl();
		Resource analysisModelResource = analysisModelResourceSet.getResource(analysisModelFileURI,true);
		ImpactAnalysisModel model = (ImpactAnalysisModel)analysisModelResource.getContents().get(0);
		return model;
	}
	
}
