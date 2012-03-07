package br.pucrio.inf.les.SPLAnalyser.impl.extractor;

import org.eclipse.emf.common.util.EList;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;

public class ArchitectureExtractor {

	private ImpactAnalysisModel analysisModel;
	private ImpactAnalysisModelContent analysisModelContent;
	private Architecture architecture;
	
	ArchitectureExtractor(Architecture architecture, 
			ImpactAnalysisModel analysisModel){
		this.architecture = architecture;
		this.analysisModel = analysisModel;
		analysisModelContent = new ImpactAnalysisModelContent(analysisModel);
		
	}
	
	public ImpactAnalysisModel extract(){
		exploreArchitecture();
		return analysisModel;		
	}
	
	public void exploreArchitecture(){
		EList containers = architecture.getContainers(); //Pega todas as pastas da raiz
		String path = "";
		for ( int y = 0; y < containers.size(); y++ ) {
			ArchitectureContainer container = (ArchitectureContainer)containers.get(y); //Passa por todos os containers
			EList components = container.getComponents(); //Pega os elementos do container
			for (int x = 0; x < components.size(); x++) { //Varre todos os componentes;
				ArchitectureComponent component = (ArchitectureComponent)components.get(x);
				path += component.getName();
				exploreComponents(component, path);
			}
		}
	}
	
	public void exploreComponents(ArchitectureComponent component, String path){
			//explora as classes contidas no componente
			EList classes = component.getClasses();
			for ( int classesCount = 0; classesCount < classes.size(); classesCount++ ) {
				ArchitectureClass archClass = (ArchitectureClass)classes.get(classesCount);
				Class modelClass = analysisModelContent.addClass(archClass.getName().replaceAll("(\\(.*\\))", ""), path);
				
				exploreMethods(archClass, path, modelClass);
				exploreFields(archClass, path, modelClass);
			}
			EList subComponents = component.getSubComponents();

			//explora os subcomponentes
			for ( int subComponentCount = 0; subComponentCount < subComponents.size(); subComponentCount++ ) {
				ArchitectureComponent subComponent = (ArchitectureComponent)subComponents.get(subComponentCount);
//				path += "." + subComponent.getName();
				exploreComponents(subComponent, path+ "." + subComponent.getName());
				}
	}
	
	public Class exploreMethods(ArchitectureClass archClass, String path, Class modelClass){
		
		for(Object method : archClass.getMethodRef()){		
			analysisModelContent.addMethod(modelClass, 
					((ArchitectureMethod)method).getName().replaceAll("(\\(.*\\))",""), 
					path+"."+archClass.getName().replace(".java", ""));
		}
		return modelClass;
	}
	
	public Class exploreFields(ArchitectureClass archClass, String path, Class modelClass){		
		
		for(Object field : archClass.getAttributeRef()){
			analysisModelContent.addField(modelClass,
					((ArchitectureAttribute)field).getName().replaceAll("(\\(.*\\))",""), 
					path+"."+archClass.getName().replace(".java", ""));
		}
		return modelClass;
	}
	
}
