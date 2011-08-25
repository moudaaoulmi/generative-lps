package br.pucrio.inf.les.genarch.core.impactanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.designwizard.design.ClassNode;
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

import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;

public class StaticAnalyzer {
	private IProject project;
	DesignWizard instancia;
	Architecture architecture;
	List<ClassNode> allClass;
	List<MethodNode> allMethods;
	List<ArchitectureClass> architectureClass;

	public StaticAnalyzer(IProject project) throws IOException{
		this.project = project;
		architectureClass = new ArrayList<ArchitectureClass>();
		mount(this.project.getFullPath());
		iteracaoClasses();
		print();
				
	}

	private void mount(IPath iPath) throws IOException  {		
		instancia =  new DesignWizard(project.getLocation().toOSString());
		
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);
		String architectureModelFileName = genarchProjectConfigurationFile.getArchitectureModelPath();
		IFile architectureModelFile = project.getFile(architectureModelFileName);
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString());
		ResourceSet architectureResourceSet = new ResourceSetImpl();
		Resource architectureResource = architectureResourceSet.getResource(architectureFileURI,true);
		
		
		//Extrai informações e do modelo de arquitetura
		architecture = (Architecture)architectureResource.getContents().get(0);
	}
	
	public void iteracaoClasses(){
		EList containers = architecture.getContainers(); //Pega todas as pastas da raiz

		for ( int y = 0; y < containers.size(); y++ ) {
			ArchitectureContainer container = (ArchitectureContainer)containers.get(y); //Passa por todos os containers
			EList components = container.getComponents(); //Pega os elementos do container
			for (int x = 0; x < components.size(); x++) { //Varre todos os componentes;
				ArchitectureComponent component = (ArchitectureComponent)components.get(x);
				exploreComponents(component);
			}
		}
	}
	
	public void exploreComponents(ArchitectureComponent component){
		
			
			EList classes = component.getClasses();
			for ( int classesCount = 0; classesCount < classes.size(); classesCount++ ) {
				ArchitectureClass classe = (ArchitectureClass)classes.get(classesCount);
				System.out.println(" - CLASSE:   "+ classe.getName().replace(".java", "") +"" );
				architectureClass.add(classe);
			}
			EList subComponents = component.getSubComponents();

			for ( int subComponentCount = 0; subComponentCount < subComponents.size(); subComponentCount++ ) {
				ArchitectureComponent subComponent = (ArchitectureComponent)subComponents.get(subComponentCount);
				exploreComponents(subComponent);
				}
	}
	
	public void print(){
		for(ClassNode classNode : instancia.getAllClasses()){
			if(isInArchitectureModel(classNode)){
				System.out.println(" - CLASSE:  "+ classNode.getName()+"" );
				classNode.getDeclaredMethods();
				classNode.getAllMethods();
				for(MethodNode method : classNode.getDeclaredMethods()){
					if(!isInArchitectureModel(method.getClassNode())) continue;
					if(method.getShortName().startsWith("<init>")) continue;
					System.out.println("   -    METODO:  "+ method.getName()+"" );
					method.getImpactOfAChange();
					for(MethodNode calleMethod : method.getCalleeMethods()){
						calleMethod.getDeclaringClass();
						if(!isInArchitectureModel(calleMethod.getClassNode())) continue;
						if(calleMethod.getShortName().startsWith("<init>")) continue;
						System.out.println("          -  "+ calleMethod.getName()+"" );
					}
					for(MethodNode callerMethod : method.getCallerMethods()){
						callerMethod.getDeclaringClass();
						if(!isInArchitectureModel(callerMethod.getClassNode())) continue;
						if(callerMethod.getShortName().startsWith("<init>")) continue;
						System.out.println("          +  "+ callerMethod.getName()+"" );
					}
				}
			}
			
		}
	}
	
	public boolean isInArchitectureModel(ClassNode classNode){
		if(classNode == null) return false;
		for(ArchitectureClass classe : architectureClass){
			if(classe.getName().replace(".java", "").equalsIgnoreCase(classNode.getShortName()) ) 
				return true;
		}
		return false;
	}
}
