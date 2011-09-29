package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata;

import java.util.ArrayList;
import java.util.List;

public class ClassData extends AbstractData{

	private List<MethodData> methods = new ArrayList<MethodData>(); 
	private List<FieldData> fields = new ArrayList<FieldData>();
	private List<ClassData> classDependences = new ArrayList<ClassData>();	
	private List<MethodData> methodReverseDependences = new ArrayList<MethodData>();
	private List<ClassData> classReverseDependences = new ArrayList<ClassData>();
	
	
	public ClassData(String name, String shortName) {
		super(name, shortName);
	}
	
	public void setMethods(List<MethodData> methods) {
		this.methods = methods;
	}
	public List<MethodData> getMethods() {
		return methods;
	}
	public void setFields(List<FieldData> fields) {
		this.fields = fields;
	}
	public List<FieldData> getFields() {
		return fields;
	}
	
	public void addAllMethods(List<MethodData> methods) {
		this.methods.addAll(methods);
	}
	
	public void addAllFields(List<FieldData> fields) {
		this.fields.addAll(fields);
	}
	
	public void addClassDependences(ClassData clazz){
		classDependences.add(clazz);
	}
	
	public void addClassReverseDependences(ClassData clazz){
		classReverseDependences.add(clazz);
	}
			
	public void addMethodReverseDependences(MethodData method){
		methodReverseDependences.add(method);
	}

	public List<ClassData> getClassDependences() {
		return classDependences;
	}

	public void setClassDependences(List<ClassData> classDependences) {
		this.classDependences = classDependences;
	}

	public List<MethodData> getMethodReverseDependences() {
		return methodReverseDependences;
	}

	public void setMethodReverseDependences(
			List<MethodData> methodReverseDependences) {
		this.methodReverseDependences = methodReverseDependences;
	}

	public List<ClassData> getClassReverseDependences() {
		return classReverseDependences;
	}

	public void setClassReverseDependences(List<ClassData> classReverseDependences) {
		this.classReverseDependences = classReverseDependences;
	}

}
