package br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.MethodDeclaration;


/**
 * Estrutura de dados em árvore, armazena em hierarquia 
 * elementos da AST java ASTNode e também ASTCodePieces. 
 * @author Alexandre Strapação (strapacao@gmail.com)
 *
 */
public class ASTree {

	private ASTreeNode root;
	private String sourceCode = "";
	
	public ASTree(Object node, String sourceCode){
		if(node instanceof ASTNode){
			ASTNode astNode = (ASTNode) node;
			setRoot(new ASTreeNode(astNode, astNode.getStartPosition(), astNode.getStartPosition() + astNode.getLength()));
		}
		this.sourceCode = sourceCode;
	}
	
	public ASTree(ASTreeNode root){
		this.root = root;
	}
	
	public void insert(Object node){
		ASTreeNode newNode = null;
		if(node instanceof ASTNode){
			ASTNode astNode = (ASTNode) node;
			newNode = new ASTreeNode(astNode, astNode.getStartPosition(), astNode.getStartPosition() + astNode.getLength());
		}else if(node instanceof ASTCodePiece){
			ASTCodePiece codePiece = (ASTCodePiece) node;
			newNode = new ASTreeNode(codePiece, codePiece.getStart(), codePiece.getEnd());
		}
		if(getRoot().getStart() > newNode.getStart() && getRoot().getStart() < newNode.getEnd()){
			newNode.insertChild(getRoot());
			setRoot(newNode);
			return;
		}
		getRoot().insertChild(newNode);
		
	}
	
	public Object findParent(Object target){
		if(target.equals(root.getNode())) return null;
		for(ASTreeNode node : root.getChildren()){
			
			if(node.getNode().equals(target)){
				return root.getNode();
			}
		}
		for(ASTreeNode node : root.getChildren()){			
			Object result = navigateForParent(target, node);
			if(result != null) return result;
		}
		return null;
	}
	
	public Object navigateForParent(Object target, ASTreeNode subTree ){
		for(ASTreeNode node : subTree.getChildren()){
			
			if(node.getNode().equals(target)){
				return subTree.getNode();
			}
		}
		for(ASTreeNode node : subTree.getChildren()){
			Object result = navigateForParent(target, node);
			if(result != null) return result;
		}
		return null;
	}
	
	public ASTree getSubTree(ASTNode target){		
		ASTreeNode node = findNode(target, root);		
		ASTree tree = new ASTree(node);
		tree.setSourceCode(this.sourceCode);
		
		return tree;
		
	}
	
	public ASTreeNode findNode(ASTNode target, ASTreeNode subTree){
		if(subTree.getNode().equals(target))
			return subTree;
		for(ASTreeNode node : subTree.getChildren()){
			ASTreeNode result = findNode(target, node);
			if(result != null) return result;
		}
		return null;	
	}
	
	public MethodDeclaration findCloneMethod(MethodDeclaration target){
		for(Object node : getOrdered(root)){
			if(node instanceof MethodDeclaration
			   && ((MethodDeclaration) node).getName().toString().equals(target.getName().toString())
			   &&  target.getStartPosition() + 1 ==  ((MethodDeclaration) node).getStartPosition())
				return (MethodDeclaration) node;
		}
		
		return null;
	}
	
	
	public List<Object> getOrdered(ASTreeNode target){
		
		List<Object> result = new ArrayList<Object>();
		
		result.add(target.getNode());
		for(ASTreeNode node : target.getChildren()){
			result.addAll(getOrdered(node));
		}
		
		return result;
	}

	public void setRoot(ASTreeNode root) {
		this.root = root;
	}

	public ASTreeNode getRoot() {
		return root;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceCode() {
		return sourceCode;
	}
	
	
}
