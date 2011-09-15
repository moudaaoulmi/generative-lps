package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata;

import java.util.ArrayList;
import java.util.List;

public class AnalysisAssetData {
	private List<ClassData> allClass = new ArrayList<ClassData>();
	
	
	
	public boolean isMethodInArchitecture(String name, String path){
		for(MethodData method : getAllMethods()){
//			System.out.println("name: "+name+"  -  "+method.getName());
//			System.out.println("path: "+path+"  -  "+method.getPath());
			if(method.getName().equals(name) && method.getPath().equals(path))
				return true;
		}
		return false;
	}
	
	public boolean isClassInArchitecture(String name, String path){
		for(ClassData clazz : getAllClass()){
			if(clazz.getName().equals(name) && clazz.getPath().equals(path))
				return true;
		}
		return false;
	}
	
	public boolean isFieldInArchitecture(String name, String path){
		for(FieldData field : getAllFields()){
			if(field.getName().equals(name) && field.getPath().equals(path))
				return true;
		}
		return false;
	}
	
	public void addClass(ClassData classNode){
		allClass.add(classNode);
	}
	
	public List<MethodData> getAllMethods(){
		List<MethodData> allMethods = new ArrayList<MethodData>();
		for(ClassData classNode : getAllClass()){
			allMethods.addAll(classNode.getMethods());
		}
		return allMethods;		
	}
	
	public List<FieldData> getAllFields(){
		List<FieldData> allFields = new ArrayList<FieldData>();
		for(ClassData classNode : getAllClass()){
			allFields.addAll(classNode.getFields());
		}
		return allFields;		
	}
	
	public List<ClassData> getAllClass() {
		return allClass;
	}
	
	public void setAllClass(List<ClassData> allClass) {
		this.allClass = allClass;
	}
	
	public FieldData getField(String name, String path){
		List<FieldData> list = new ArrayList<FieldData>();
		list.addAll(getAllFields());
		for(FieldData data : list){
			if(data.name.equals(name) && data.path.equals(path))
				return data;			
		}		
		return null;
	}
	public ClassData getClass(String name, String path){
		List<ClassData> list = new ArrayList<ClassData>();
		list.addAll(getAllClass());
		for(ClassData data : list){
			if(data.name.equals(name) && data.path.equals(path))
				return data;			
		}		
		return null;
	}
	public MethodData getMethod(String name, String path){
		List<MethodData> list = new ArrayList<MethodData>();
		list.addAll( getAllMethods());
		for(MethodData data : list){
			if(data.name.equals(name) && data.path.equals(path))
				return data;			
		}		
		return null;
	}
	
	public void print(){
		for(ClassData clazz : getAllClass()){
			System.out.println("\nCLASSE : " + clazz.getPath() + "." + clazz.getName());
			System.out.println("  FIELDS : ");
			for(FieldData field : clazz.getFields()){
				System.out.println("          " + field.getPath() + "." + field.getName());
			}
			System.out.println("  METHODS : ");
			for(MethodData method : clazz.getMethods()){
				System.out.println("\n          " + method.getPath() + "." + method.getName());
				
				System.out.println("            FIELD DEPENDENCES : ");
				for(FieldData acessedField : method.getFieldDependences()){
					System.out.println("               " + acessedField.getPath() + "." + acessedField.getName());
				}
				
				System.out.println("            METHODS DEPENDENCES: ");
				for(MethodData methodDepen :  method.getMethodDependences()){
					System.out.println("               " + methodDepen.getPath() + "." + methodDepen.getName());
				}
				
				System.out.println("            REVERSE METHODS DEPENDENCES: ");
				for(MethodData methodReverseDepen :  method.getMethodReverseDependences()){
					System.out.println("               " + methodReverseDepen.getPath() + "." + methodReverseDepen.getName());
				}
			}
		}
	}
	
}
