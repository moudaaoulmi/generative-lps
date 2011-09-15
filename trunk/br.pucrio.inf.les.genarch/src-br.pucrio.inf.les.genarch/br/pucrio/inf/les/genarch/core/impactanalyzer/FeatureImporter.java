package br.pucrio.inf.les.genarch.core.impactanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.designwizard.design.ClassNode;
import org.designwizard.design.FieldNode;
import org.designwizard.design.MethodNode;
import org.designwizard.main.DesignWizard;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AnalysisAssetData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.ClassData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.FieldData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.MethodData;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;
import br.pucrio.inf.les.genarch.models.feature.Feature;

public class FeatureImporter {
	private IProject project;
	
	
	private Feature feature;

	public FeatureImporter(IProject project) throws IOException{
		this.project = project;
		
		mount();
		extractFeature();
	}

	private void mount() throws IOException  {			
		
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		String featureModelFileName = genarchProjectConfigurationFile.getFeatureModelPath();
		IFile featureModelFile = project.getFile(featureModelFileName);
		URI featureFileURI = URI.createPlatformResourceURI(featureModelFile.getFullPath().toString());
		ResourceSet featureResourceSet = new ResourceSetImpl();
		Resource featureResource = featureResourceSet.getResource(featureFileURI,true);
		
		
		//Extrai informações e do modelo de arquitetura
//		feature = (Feature)featureResource.getContents().get(0);
		
	}
	
	private void extractFeature(){			
//		feature.getAttribute();
//		feature.getClass();
//		feature.getMax();
//		feature.getMin();
//		feature.getName();
//		feature.getPath();
//		feature.getType();
	}
	
}
