package br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast;

import org.eclipse.jdt.core.dom.MethodDeclaration;

public class ASTCodePiece {
	private String sourceCode = "";
	private MethodDeclaration methodParent = null;
	private int start;
	private int end;
	private String featureAnnotation = "";
	
	public ASTCodePiece(String code , MethodDeclaration method, int start, int end, String featureAnnotation){
		this.sourceCode = code;
		this.methodParent = method;		
		this.setStart(start);
		this.setEnd(end);
		this.setFeatureAnnotation(featureAnnotation);
	}
	
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public MethodDeclaration getMethodParent() {
		return methodParent;
	}
	public void setMethodParent(MethodDeclaration method) {
		this.methodParent = method;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getStart() {
		return start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getEnd() {
		return end;
	}

	public void setFeatureAnnotation(String featureAnnotation) {
		this.featureAnnotation = featureAnnotation;
	}

	public String getFeatureAnnotation() {
		return featureAnnotation;
	}
	
	
	
}
