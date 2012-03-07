package br.pucrio.inf.les.SPLAnalyser.operations;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import br.pucrio.inf.les.SPLAnalyser.core.AnalyzerFacade;
import br.pucrio.inf.les.SPLAnalyser.impl.extractor.GenarchExtractor;
import br.pucrio.inf.les.SPLAnalyser.impl.query.AssetFeatureBinding;
import br.pucrio.inf.les.SPLAnalyser.impl.query.AssetIndirectDependencies;
import br.pucrio.inf.les.SPLAnalyser.impl.query.DependenciesOfAsset;
import br.pucrio.inf.les.SPLAnalyser.impl.query.FeatureIndirectDependencies;
import br.pucrio.inf.les.SPLAnalyser.impl.query.ImpactOfAChangeAsset;
import br.pucrio.inf.les.SPLAnalyser.impl.query.ImpactOfAChangeFeature;
import br.pucrio.inf.les.SPLAnalyser.impl.query.OptionalArtefactBindings;
import br.pucrio.inf.les.SPLAnalyser.impl.query.models.OptionalArtefactBindingsModel;
import br.pucrio.inf.les.SPLAnalyser.impl.sourcecodeanalyser.JavaSourceCodeAnalyser;
import br.pucrio.inf.les.SPLAnalyser.impl.visualize.AnalysisModelVisualize;
import br.pucrio.inf.les.SPLAnalyser.impl.visualize.OptionalArtefactBindingsVisualize;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;



public class ChangeImpactAnalysisOperation implements IRunnableWithProgress {
	
	private IProject project;
	

	public ChangeImpactAnalysisOperation(IProject project) {
		this.project = project;			
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		GenarchExtractor genarchExtractor = new GenarchExtractor();
		DependenciesOfAsset dependenciesOfAsset = new DependenciesOfAsset("OperacaoSubtracaoTeste.java","br.pucrio.inf.les.genarch.exemplos.teste",DependenciesOfAsset.CLAZZ);
		ImpactOfAChangeAsset impactOfAChangeAsset = new ImpactOfAChangeAsset("OperacaoSubtracaoTeste.java","br.pucrio.inf.les.genarch.exemplos.teste",DependenciesOfAsset.CLAZZ);
		ImpactOfAChangeFeature impactOfAChangeFeature = new ImpactOfAChangeFeature("Subtracao");
		FeatureIndirectDependencies featureIndirectDependencies = new FeatureIndirectDependencies("Teste", 3);
		OptionalArtefactBindings optionalArtefactBindings = new OptionalArtefactBindings();
		AssetIndirectDependencies assetIndirectDependencies = new AssetIndirectDependencies("OperacaoSubtracaoTeste.java","br.pucrio.inf.les.genarch.exemplos.teste",DependenciesOfAsset.CLAZZ, 3);
		AssetFeatureBinding featureIndirectBindingsByAsset = new AssetFeatureBinding("OperacaoSubtracaoTeste.java","br.pucrio.inf.les.genarch.exemplos.teste",DependenciesOfAsset.CLAZZ, 3);
		
		AnalysisModelVisualize analysisModelVisualize = new AnalysisModelVisualize();
		OptionalArtefactBindingsVisualize optionalArtefactBindingsVisualize = new OptionalArtefactBindingsVisualize();
		
		
		
		JavaSourceCodeAnalyser javaAnalyser = new JavaSourceCodeAnalyser();
		AnalyzerFacade analyzer = new AnalyzerFacade(project, genarchExtractor,javaAnalyser);
		analyzer.run();
		analyzer.executeQuery(dependenciesOfAsset, analysisModelVisualize);
		analyzer.executeQuery(impactOfAChangeAsset, analysisModelVisualize);
		analyzer.executeQuery(impactOfAChangeFeature, analysisModelVisualize);
		analyzer.executeQuery(featureIndirectDependencies, analysisModelVisualize);
		analyzer.executeQuery(assetIndirectDependencies, analysisModelVisualize);
		analyzer.executeQuery(featureIndirectBindingsByAsset, analysisModelVisualize);
		analyzer.executeQuery(optionalArtefactBindings, optionalArtefactBindingsVisualize);
	}
}

