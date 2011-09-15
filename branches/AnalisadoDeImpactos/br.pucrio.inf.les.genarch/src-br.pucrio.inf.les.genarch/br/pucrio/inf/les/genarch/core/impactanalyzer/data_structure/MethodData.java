package br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure;

import java.util.ArrayList;
import java.util.List;

import br.pucrio.inf.les.genarch.core.impactanalyzer.data_structure.assetdata.AbstractData;

public class MethodData extends AbstractData{
	
	private List<FieldData> fieldDependences = new ArrayList<FieldData>();
	private List<MethodData> methodDependences = new ArrayList<MethodData>();
	private List<ClassData> classDependences = new ArrayList<ClassData>();	
	private List<MethodData> methodReverseDependences = new ArrayList<MethodData>();
	private List<ClassData> classReverseDependences = new ArrayList<ClassData>();
	
	
	public void addClassDependences(ClassData clazz){
		classDependences.add(clazz);
	}
	
	public void addClassReverseDependences(ClassData clazz){
		classReverseDependences.add(clazz);
	}
	
	public void addMethodDependences(MethodData method){
		methodDependences.add(method);
	}
	
	public void addMethodReverseDependences(MethodData method){
		methodReverseDependences.add(method);
	}
	
	public void addFieldDependences(FieldData field){
		fieldDependences.add(field);
	}
	
	public MethodData(String name, String path) {
		super(name, path);
	}

	public List<FieldData> getFieldDependences() {
		return fieldDependences;
	}

	public void setFieldDependences(List<FieldData> fieldDependences) {
		this.fieldDependences = fieldDependences;
	}

	public List<MethodData> getMethodDependences() {
		return methodDependences;
	}

	public void setMethodDependences(List<MethodData> methodDependences) {
		this.methodDependences = methodDependences;
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
