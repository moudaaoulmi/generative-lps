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

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
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

public class AssetImporter {
	
	private DesignWizard instancia;
	private Architecture architecture;
	private List<ArchitectureClass> architectureClass;
	private AnalysisAssetData assetData = new AnalysisAssetData();

	public AssetImporter(String projectLocation, Architecture architecture){
		try {
			instancia =  new DesignWizard(projectLocation);
		} catch (IOException ex) {
			ex.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(ex);
		}		
		this.architecture = architecture;
		architectureClass = new ArrayList<ArchitectureClass>();				
	}

	public AnalysisAssetData extract() {		
		
		iteracaoClasses();
		importDependencies();
		return assetData;
	}
	
	//
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
		
			//explora as classes contidas no componente
			EList classes = component.getClasses();
			for ( int classesCount = 0; classesCount < classes.size(); classesCount++ ) {
				ArchitectureClass classe = (ArchitectureClass)classes.get(classesCount);
				ClassData clazz = new ClassData(classe.getName().replaceAll("(\\(.*\\))", ""), path);
				clazz.addAllFields(exploreFields(classe, path) );
				clazz.addAllMethods(exploreMethods(classe, path) );
				assetData.addClass(clazz);
				architectureClass.add(classe);
			}
			EList subComponents = component.getSubComponents();

			//explora os subcomponentes
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
			MethodData methodData = new MethodData(((ArchitectureMethod)method).getName().replaceAll("(\\(.*\\))",""), path+"."+clazz.getName().replace(".java", ""));
			listMethods.add(methodData);
		}
		return listMethods;
	}
	
	public List<FieldData> exploreFields(ArchitectureClass clazz, String path){
		List<FieldData> listFields = new ArrayList<FieldData>(); 
		
		EList fields = clazz.getAttributeRef();
		
		for(Object field : clazz.getAttributeRef()){	
			FieldData methodData = new FieldData(((ArchitectureAttribute)field).getName().replaceAll("(\\(.*\\))",""), path+"."+clazz.getName().replace(".java", ""));
			listFields.add(methodData);	
		}
		
		return listFields;
	}
	
	public void importDependencies(){
		for(ClassNode classNode : instancia.getAllClasses()){
			if(isInArchitectureModel(classNode)){
				
				//verifica dependencias dos metodos da classe
				for(MethodNode method : classNode.getDeclaredMethods()){									
					MethodData methodData = assetData.getMethod(method.getShortName().replaceAll("(\\(.*\\))", ""),  method.getClassName());
					if(methodData == null) continue;
					
					//métodos que o método alvo depende
					for(MethodNode calleMethod : method.getCalleeMethods()){
						MethodData calleMethodData = assetData.getMethod(calleMethod.getShortName().replaceAll("(\\(.*\\))", ""),  calleMethod.getClassName());
						if(calleMethodData == null) continue;
						methodData.addMethodDependences(calleMethodData);
					}
					//métodos que dependem do metodo alvo
					for(MethodNode callerMethod : method.getCallerMethods()){
						MethodData callerMethodData = assetData.getMethod(callerMethod.getShortName().replaceAll("(\\(.*\\))", ""),  callerMethod.getClassName());
						if(callerMethodData == null) continue;
						methodData.addMethodReverseDependences(callerMethodData);
					}
					//atributos acessado pelo metodo
					for(FieldNode acessedField : method.getAccessedFields()){
						FieldData acessedFieldData = assetData.getField(acessedField.getShortName(),  acessedField.getClassName());
						if(acessedFieldData == null) continue;
						methodData.addFieldDependences(acessedFieldData);
					}
				}
				//verifica dependencias dos atributos da classe
				for(FieldNode field : classNode.getDeclaredFields() ){
					FieldData fieldData = assetData.getField(field.getName(), field.getClassName());
					if(fieldData == null) continue;
					//metodos que acessam o atributo
					for(MethodNode callerMethod : field.getCallerMethods()){
						MethodData callerMethodData = assetData.getMethod(callerMethod.getShortName().replaceAll("(\\(.*\\))", ""),  callerMethod.getClassName());
						if(callerMethodData == null) continue;
						fieldData.addMethodReverseDependences(callerMethodData);
					}
				}
				/**
				//Verificar as dependencias da Classe
				ClassData classData = assetData.getClass(classNode.getName(), classNode.getClassName());
				if(classData == null) continue;
				//metodos que acessam a classe
				for(MethodNode callerMethod : classNode.getCallerMethods()){
					MethodData callerMethodData = assetData.getMethod(callerMethod.getShortName().replaceAll("(\\(.*\\))", ""),  callerMethod.getClassName());
					if(callerMethodData == null) continue;
					classData.addMethodReverseDependences(callerMethodData);
				}
				//Classes que acessam a classe
				for(ClassNode callerClass : classNode.getCallerClasses() ){
					ClassData callerMethodData = assetData.getClass(callerClass.getShortName().replaceAll("(\\(.*\\))", ""),  callerClass.getClassName());
					if(callerMethodData == null) continue;
					classData.addMethodReverseDependences(callerMethodData);
				}
				//Classes que essa classe acessa
				for(MethodNode callerMethod : classNode.getCallerMethods()){
					MethodData callerMethodData = assetData.getMethod(callerMethod.getShortName().replaceAll("(\\(.*\\))", ""),  callerMethod.getClassName());
					if(callerMethodData == null) continue;
					classData.addMethodReverseDependences(callerMethodData);
				}*/
			}
		}
		assetData.print();
	}
	
	public boolean isInArchitectureModel(ClassNode classNode){
		if(classNode == null) return false;
		for(ArchitectureClass classe : architectureClass){
			if(classe.getName().replace(".java", "").equalsIgnoreCase(classNode.getShortName()) ) 
				return true;
		}
		return false;
	}

	public AnalysisAssetData getAssetData() {
		return assetData;
	}

	public void setAssetData(AnalysisAssetData assetData) {
		this.assetData = assetData;
	}
	
	
	
}
