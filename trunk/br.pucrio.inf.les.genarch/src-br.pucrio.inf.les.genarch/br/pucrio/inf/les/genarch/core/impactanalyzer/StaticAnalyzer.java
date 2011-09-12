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

import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.AnalysisData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.ClassData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.FieldData;
import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.MethodData;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;

public class StaticAnalyzer {
	private IProject project;
	DesignWizard instancia;
	Architecture architecture;
	List<ClassNode> allClass;
	List<MethodNode> allMethods;
	List<ArchitectureClass> architectureClass;
	AnalysisData data = new AnalysisData();

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
			EList classes = component.getClasses();
			for ( int classesCount = 0; classesCount < classes.size(); classesCount++ ) {
				ArchitectureClass classe = (ArchitectureClass)classes.get(classesCount);
				System.out.println(" - CLASSE:   "+ classe.getName().replace(".java", "") +"" );
				
				ClassData clazz = new ClassData(classe.getName().replaceAll("(\\(.*\\))", ""), path);
				clazz.addAllFields(exploreFields(classe, path) );
				clazz.addAllMethods(exploreMethods(classe, path) );
				data.addClass(clazz);
				architectureClass.add(classe);
			}
			EList subComponents = component.getSubComponents();

			for ( int subComponentCount = 0; subComponentCount < subComponents.size(); subComponentCount++ ) {
				ArchitectureComponent subComponent = (ArchitectureComponent)subComponents.get(subComponentCount);
//				path += "." + subComponent.getName();
				exploreComponents(subComponent, path+ "." + subComponent.getName());
				}
	}
	
	public List<MethodData> exploreMethods(ArchitectureClass clazz, String path){
		List<MethodData> listMethods = new ArrayList<MethodData>(); 
		
		EList methods = clazz.getMethodRef();
		for(Object method : clazz.getMethodRef()){
			System.out.println("    - Method:   "+ ((ArchitectureMethod)method).getName().replace(".java", "") +"" );			
			MethodData methodData = new MethodData(((ArchitectureMethod)method).getName().replaceAll("(\\(.*\\))",""), path+"."+clazz.getName().replace(".java", ""));
			listMethods.add(methodData);
		}
		return listMethods;
	}
	
	public List<FieldData> exploreFields(ArchitectureClass clazz, String path){
		List<FieldData> listFields = new ArrayList<FieldData>(); 
		
		EList fields = clazz.getAttributeRef();
		
		for(Object field : clazz.getAttributeRef()){
			System.out.println("    - Field:   "+ ((ArchitectureAttribute)field).getName().replace(".java", "") +"" );			
			FieldData methodData = new FieldData(((ArchitectureAttribute)field).getName().replaceAll("(\\(.*\\))",""), path+"."+clazz.getName().replace(".java", ""));
			listFields.add(methodData);	
		}
		
		return listFields;
	}
	
	public void print(){
		for(ClassNode classNode : instancia.getAllClasses()){
			if(isInArchitectureModel(classNode)){
				System.out.println(" - CLASSE:  "+ classNode.getName()+"" );
				classNode.getDeclaredMethods();
				classNode.getAllMethods();
				for(MethodNode method : classNode.getDeclaredMethods()){
									
					MethodData methodData = data.getMethod(method.getShortName().replaceAll("(\\(.*\\))", ""),  method.getClassName());
					if(methodData == null) continue;
					System.out.println("   -    METODO:  "+ method.getName()+"" );
					
					for(MethodNode calleMethod : method.getCalleeMethods()){
						MethodData calleMethodData = data.getMethod(calleMethod.getShortName().replaceAll("(\\(.*\\))", ""),  calleMethod.getClassName());
						if(calleMethodData == null) continue;
						methodData.addMethodDependences(calleMethodData);
						System.out.println("          -  "+ calleMethod.getName()+"" );
					}
					for(MethodNode callerMethod : method.getCallerMethods()){
						MethodData callerMethodData = data.getMethod(callerMethod.getShortName().replaceAll("(\\(.*\\))", ""),  callerMethod.getClassName());
						if(callerMethodData == null) continue;
						methodData.addMethodReverseDependences(callerMethodData);
						System.out.println("          +  "+ callerMethod.getName()+"" );
					}
					
					for(FieldNode acessedField : method.getAccessedFields()){
						FieldData acessedFieldData = data.getField(acessedField.getShortName(),  acessedField.getClassName());
						if(acessedFieldData == null) continue;
						methodData.addFieldDependences(acessedFieldData);
						System.out.println("          f  "+ acessedField.getName()+"" );
					}
					
				}
			}
			
		}
		data.print();
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
