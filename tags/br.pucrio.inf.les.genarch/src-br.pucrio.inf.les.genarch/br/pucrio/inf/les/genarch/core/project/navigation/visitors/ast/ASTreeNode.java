package br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;

/**
 * Nó utilizado na árvore ASTree, cada nó armazena ASTNodes ou ASTCodePiece
 * @author Alexandre
 *
 */
public class ASTreeNode {
	
	private Object node;
	private int start;
	private int end;
	public List<ASTreeNode> children = new ArrayList<ASTreeNode>();
	
	public ASTreeNode(Object node, int start, int end){
		this.setNode(node);
		this.end =end;
		this.start = start;		
	}
	
	public void insertChild(ASTreeNode treeNode){
		if(children.isEmpty()){
			children.add(treeNode);
			return;
		}
		List<ASTreeNode> targetChildren = new ArrayList<ASTreeNode>();
		//se os filhes pertencerem ao nó a ser inserido
		for(ASTreeNode child : children){			
			if(child.getStart() > treeNode.getStart() && child.getStart() < treeNode.getEnd()){
				treeNode.insertChild(child);
				targetChildren.add(child);
			}
		}
		
		children.removeAll(targetChildren);
		
		List<ASTreeNode> childrenAux = children;
		for(ASTreeNode child : children){
			if(treeNode.getStart() > child.getStart() && treeNode.getStart() < child.getEnd()){
				child.insertChild(treeNode);
				break;
			}else if(children.indexOf(child) + 1 == children.size() &&  treeNode.getStart() > child.getEnd()){
				childrenAux.add(treeNode);
				break;
			}			
			else if(treeNode.getStart() > child.getEnd() && treeNode.getStart() <  children.get(children.indexOf(child) + 1).getStart()){
				childrenAux.add(children.indexOf(child) + 1,treeNode);
				break;
			}
			children = childrenAux;
		}		
	}
	
	public List<ASTCodePiece> getCodePieces(){
		List<ASTCodePiece> result =  new ArrayList<ASTCodePiece>();
		for(Object child : this.children){
			if(child instanceof ASTCodePiece)
				result.add((ASTCodePiece) child);
		}
		return result;
	}
	
	public List<ASTreeNode> getNodeCodePieces(){
		List<ASTreeNode> result =  new ArrayList<ASTreeNode>();
		
		for(ASTreeNode child : this.children){
			if(child.getNode() instanceof ASTCodePiece)
				result.add(child);
		}
		return result;
	}

	

	public void setChildren(List<ASTreeNode> children) {
		this.children = children;
	}

	public List<ASTreeNode> getChildren() {
		return children;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getEnd() {
		return end;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getStart() {
		return start;
	}

	public void setNode(Object node) {
		this.node = node;
	}

	public Object getNode() {
		return node;
	}

}
