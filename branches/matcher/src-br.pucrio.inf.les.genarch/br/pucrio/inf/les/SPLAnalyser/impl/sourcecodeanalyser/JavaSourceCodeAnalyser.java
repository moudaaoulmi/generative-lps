package br.pucrio.inf.les.SPLAnalyser.impl.sourcecodeanalyser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.designwizard.design.ClassNode;
import org.designwizard.design.FieldNode;
import org.designwizard.design.MethodNode;
import org.designwizard.design.Modifier;
import org.designwizard.main.DesignWizard;
import org.eclipse.core.resources.IProject;

import br.pucrio.inf.les.SPLAnalyser.core.SourceCodeAnalyser;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class JavaSourceCodeAnalyser implements SourceCodeAnalyser {

	private DesignWizard instancia;
	private IProject project;
	private ImpactAnalysisModel analysisModel;
	private ImpactAnalysisModelContent analysisModelContent;
	
	public ImpactAnalysisModel analyse(Object sourceCode,
			ImpactAnalysisModel analysisModel) {
		this.analysisModel = analysisModel;
		analysisModelContent = new ImpactAnalysisModelContent(this.analysisModel);		
		project = (IProject)sourceCode;
		
		
		try {
			instancia =  new DesignWizard(project.getLocation().toOSString());
		} catch (IOException ex) {
			ex.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(ex);
		}
		importDependencies();
		return analysisModelContent.getAnalysisModel();
		
	}
	
	public void importDependencies(){
		String methodName = "";
		for(ClassNode classNode : instancia.getAllClasses()){
			Class clazz =  analysisModelContent.findClass(classNode.getShortName()+".java",  classNode.getPackage().getName());
			if(clazz != null){
				List<MethodNode> declaredMethods = new ArrayList<MethodNode>(classNode.getDeclaredMethods());
//				declaredMethods.addAll(new ArrayList<MethodNode>(classNode.getConstructors()));			
				
				
				for(Modifier modifier : classNode.getModifiers()){
					clazz.setModifiers(clazz.getModifiers() + modifier.name() + " ");
				}
				
				//Adiciona como dependencias as interfaces implementadas
				for(ClassNode interfaceClass : classNode.getImplementedInterfaces()){
					if(!isInImpactModel(interfaceClass)) continue;
					Class classAcessed =  analysisModelContent.findClass(interfaceClass.getShortName()+".java",  interfaceClass.getPackage().getName());
					if(classAcessed == null) continue;
					if(classNode.getName().equals(interfaceClass.getName())) continue;
					else analysisModelContent.addDependencies(clazz, classAcessed);
				}
				//Adiciona super class
				{
					ClassNode superClass = classNode.getSuperClass();
					if(isInImpactModel(superClass)){
						Class classAcessed =  analysisModelContent.findClass(superClass.getShortName()+".java",  superClass.getPackage().getName());
						if(classAcessed != null && !classNode.getName().equals(superClass.getName())){
							analysisModelContent.addDependencies(clazz, classAcessed);
						}
					}
				}
				
				clazz.setSignature(clazz.getPath() + " " + clazz.getName());
				
				//Verifica as dependências dos métodos da classe
				for(MethodNode method : declaredMethods){
					methodName = adaptName(method);
					
					Method methodTarget = analysisModelContent.findMethod(methodName, method.getClassName());
					
					if(methodTarget == null) continue;
					
					//Retorno
					methodTarget.setReturnType( method.getReturnType().getName() );
					
					//Modificadores
					for(Modifier modifier : method.getModifiers()){
						methodTarget.setModifiers(methodTarget.getModifiers() + modifier.name() + " ");
					}
					
					//Argumentos
					methodTarget.setArguments("");
					for(ClassNode parameter : method.getParameters()){
						methodTarget.setArguments(methodTarget.getArguments() + parameter.getName() + " ");
					}
					
					
					
					//Métodos que o método alvo depende
					for(MethodNode calleMethod : method.getCalleeMethods()){
						methodName = adaptName(calleMethod);
						Method calleMethodData = analysisModelContent.findMethod(methodName, calleMethod.getClassName());
						if(calleMethodData == null) continue;
						else analysisModelContent.addDependencies(methodTarget, calleMethodData);
					}
										
					//Atributos acessados pelo método					
					for(FieldNode acessedField : method.getAccessedFields()){
						Field field =  analysisModelContent.findField(acessedField.getShortName(),  acessedField.getClassName());
						if(field == null) continue;
						else analysisModelContent.addDependencies(methodTarget, field);
					}
					
					//Atributos acessados pelo método					
					for(ClassNode calleeClass : method.getCalleeClasses()){				
						if(!isInImpactModel(calleeClass)) continue;
						Class acessedClass =  analysisModelContent.findClass(calleeClass.getShortName()+".java",  calleeClass.getPackage().getName());
						if(acessedClass == null) continue;
						else analysisModelContent.addDependencies(methodTarget, acessedClass);
					}
					
					//Adiciona o tipo de  retorno como dependencia
					{
						ClassNode returnClass = method.getReturnType();
						if(isInImpactModel(returnClass)){
							Class acessedClass =  analysisModelContent.findClass(returnClass.getShortName()+".java",  returnClass.getPackage().getName());
							if(acessedClass != null) 
								analysisModelContent.addDependencies(methodTarget, acessedClass);
						}
					}
					
					//Adiciona os tipos de parametros como dependencia
					for(ClassNode parameterClass : method.getParameters()){
						if(!isInImpactModel(parameterClass))
							continue;
						Class acessedClass =  analysisModelContent.findClass(parameterClass.getShortName()+".java",  parameterClass.getPackage().getName());
						if(acessedClass == null) continue;
						else analysisModelContent.addDependencies(methodTarget, acessedClass);
					}
					
					methodTarget.setSignature(methodTarget.getPath() + " " + methodTarget.getName() + " " + methodTarget.getArguments());
				}
				
				//Verifica as dependências dos atributos da classe
				for(FieldNode field : classNode.getDeclaredFields()){
					field.getModifiers();
					Field fieldTarget = analysisModelContent.findField(field.getShortName(), field.getClassName());
					if(fieldTarget == null) continue;
					
					for(Modifier modifier : field.getModifiers()){
						fieldTarget.setModifiers(fieldTarget.getModifiers() + modifier.name() + " ");
					}
					
					
					//Adiciona a classe em que foi declarado como dependencia					
					{
						Class declaringClass =  analysisModelContent.findClass(field.getDeclaringClass().getShortName()+".java",  field.getDeclaringClass().getPackage().getName());
						if(declaringClass != null){
							analysisModelContent.addDependencies(fieldTarget, declaringClass);
						}
					}
					//Adiciona tipo de classe declarada como dependente
					if(isInImpactModel(field.getType())){
						Class typeClass =  analysisModelContent.findClass(field.getType().getShortName()+".java",  field.getType().getPackage().getName());
						if(typeClass != null){
							analysisModelContent.addDependencies(fieldTarget, typeClass);
						}
					}
					//Métodos que o atributo alvo depende
					for(MethodNode calleMethod : field.getCalleeMethods()){
						methodName = adaptName(calleMethod);
						Method method = analysisModelContent.findMethod(methodName, calleMethod.getClassName());
						if(method == null) continue;
						else analysisModelContent.addDependencies(fieldTarget,method);
					}

					//Atributos acessados pelo método					
					for(ClassNode calleeClass : field.getCalleeClasses()){
						Class acessedClass =  analysisModelContent.findClass(calleeClass.getShortName()+".java",  calleeClass.getPackage().getName());
						if(acessedClass == null) continue;
						else analysisModelContent.addDependencies(fieldTarget, acessedClass);
					}
					
					fieldTarget.setSignature(fieldTarget.getPath() + " " + fieldTarget.getName());
				}
			}
		}
		
		
	}

	public boolean isInImpactModel(ClassNode classNode){
		String classFullName = "";
		if(classNode == null) return false;
		if(classNode.isPrimitive()) return false;
		if(classNode.getName().equalsIgnoreCase("void")) return false;
		for(Class clazz : analysisModelContent.getAllClass()){
			classFullName = "";
			classFullName = clazz.getPath() + "." + clazz.getName().replace(".java", "");			
			if(classFullName.equalsIgnoreCase(classNode.getClassName()) ) 
				return true;
		}
		return false;
	}
		
	//Adptação do nome dos contrutores da Design Wizard para o padrão do modelo de análise!
	public String adaptName(MethodNode method){
		String methodName = "";
		if(method.isConstructor() && method.getClassNode() != null){
			methodName = method.getShortName().replaceAll("(\\(.*\\))", "").replace("<init>", method.getClassNode().getShortName());
		}else{
			methodName = method.getShortName().replaceAll("(\\(.*\\))", "");
		}
		return methodName;
	}
	
	
}
