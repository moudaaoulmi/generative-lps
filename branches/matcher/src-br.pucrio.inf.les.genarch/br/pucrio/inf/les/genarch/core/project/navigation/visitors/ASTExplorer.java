package br.pucrio.inf.les.genarch.core.project.navigation.visitors;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTCodePiece;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTExplorerVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.visitors.ast.ASTree;



public class ASTExplorer {
	private ASTree tree = null;
	private List<Object> orderedList = new ArrayList<Object>();
	
	
	public ASTExplorer(final String fullPath) throws InterruptedException, InvocationTargetException {
		try {	
			File file = new File(fullPath);
			BufferedReader in = new BufferedReader(new FileReader(file));
			StringBuffer buffer = new StringBuffer(); 
			String line = null;
			while (null != (line = in.readLine())) {
				buffer.append("\t" + line);
				buffer.append("\n");
			}	

			ASTParser parser = ASTParser.newParser(AST.JLS2);
			parser.setKind(ASTParser.K_COMPILATION_UNIT);
			final String text = buffer.toString();
			parser.setSource(text.toCharArray());
			final CompilationUnit node = (CompilationUnit) parser.createAST(null);
			
			
			ASTVisitor visitor = new ASTExplorerVisitor();
			node.accept(visitor);
			
			setOrderedList(order(((ASTExplorerVisitor)visitor).getApplicableNodes()));
			setTree(createTree(getOrderedList(), text));
			tree.setSourceCode(text);
			
		}
		catch (IOException e) {
			throw new InvocationTargetException(e);
		}
	}

	//Ordena lista de ASTNodes+CodePieces conforme o indice de starPosition na string do código fonte. 
	public List<Object> order(List<Object>  list){
		List<Object> result = new ArrayList<Object>();
		
		for(Object node : list){
			
			if(result.isEmpty()){
				result.add(node);
				continue;
			}
			for(Object resultNode : result){
				if(precedence(node, resultNode) <= 1 ){
					if(result.size() == result.indexOf(resultNode) + 1){
						result.add(result.indexOf(resultNode) + 1, node);
						break;
					}else if(precedence(node, result.get(result.indexOf(resultNode) + 1)) == 2 ){
						result.add(result.indexOf(resultNode) + 1, node);
						break;
					}
				}else{
					result.add(result.indexOf(resultNode), node);
					break;
				}
			}
		}		
		return result;
	}
	
	//Cria uma ASTTree passando uma lista de objetos contendo ASTNodes e CodePieces 
	public ASTree createTree(List<Object> list, String code){
		ASTree tree = null;
		
		
		for(Object node : list){
			if(tree == null)tree = new ASTree(node, code);
			else tree.insert(node);
		}
		List<Object> refactoredList = refactorCodePieces(list, tree);
		for(Object node : refactoredList){
			if(tree == null)tree = new ASTree(node, code);
			else tree.insert(node);
		}
		
		return tree;
	}
	
	//Verifica annotações na lista ordenada e as transforma em CodePieces
	public List<Object> refactorCodePieces(List<Object> orderedList, ASTree treeTarget){
		
		List<Javadoc> javadocList = new ArrayList<Javadoc>();
		
		for(Object node : orderedList){
			if(node instanceof Javadoc)
				javadocList.add((Javadoc) node);
		}
		Stack<Javadoc> stack = new Stack<Javadoc>();
		
		Javadoc returnJavadoc = null;  
		for(Javadoc javadoc : javadocList){
			if(javadoc.getComment().toLowerCase().startsWith("/** #Feature".toLowerCase())){
				stack.push(javadoc);
				continue;
			}
			if(javadoc.getComment().toLowerCase().equals("/** #endFeature */".toLowerCase())){
				
				returnJavadoc = stack.pop();
				
				MethodDeclaration method =  (MethodDeclaration)treeTarget.findParent(returnJavadoc);
				String code = treeTarget.getSourceCode().substring(returnJavadoc.getStartPosition() + returnJavadoc.getLength(), javadoc.getStartPosition());
				ASTCodePiece piece =  new ASTCodePiece(code, method, returnJavadoc.getStartPosition() + returnJavadoc.getLength(), javadoc.getStartPosition(), returnJavadoc.getComment());
				int indexAnnotation = orderedList.indexOf(returnJavadoc);
				orderedList.remove(indexAnnotation);
				orderedList.remove(javadoc);
				orderedList.add(indexAnnotation, piece);
			}
		}
		return orderedList;
	}
	
	
	//Retorna 1 se node1 esta a frente na arvore sintática, retorna 2 se node2 esta a frente na árvore sintática
	public int precedence(Object node1 , Object node2){
		int n1Start = 0;
		int n2Start = 0;

		if(node1 instanceof ASTNode && node2 instanceof ASTNode){
			n1Start = ((ASTNode)node1).getStartPosition();
			n2Start = ((ASTNode)node2).getStartPosition();
		} else if(node1 instanceof ASTNode && node2 instanceof ASTCodePiece){
			n1Start = ((ASTNode)node1).getStartPosition();
			n2Start = ((ASTCodePiece)node2).getStart();
		} else if(node1 instanceof ASTCodePiece && node2 instanceof ASTNode){
			n1Start = ((ASTCodePiece)node1).getStart();
			n2Start = ((ASTNode)node2).getStartPosition();
		} else if(node1 instanceof ASTCodePiece && node2 instanceof ASTCodePiece){
			n1Start = ((ASTCodePiece)node1).getStart();
			n2Start = ((ASTCodePiece)node2).getStart();
		}

		if(n1Start > n2Start)
			return 1;
		else if(n1Start < n2Start)
			return 2;
		return 0;
	}

	public void setTree(ASTree tree) {
		this.tree = tree;
	}

	public ASTree getTree() {
		return tree;
	}

	public void setOrderedList(List<Object> orderedList) {
		this.orderedList = orderedList;
	}

	public List<Object> getOrderedList() {
		return orderedList;
	}
	
}