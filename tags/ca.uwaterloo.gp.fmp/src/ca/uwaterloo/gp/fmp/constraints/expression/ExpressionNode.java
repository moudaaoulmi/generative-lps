/**************************************************************************************
 * Copyright (c) 2005-2008 Generative Software Development Lab, University of Waterloo
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   1. Generative Software Development Lab, University of Waterloo,
 *      http://gp.uwaterloo.ca  - initial API and implementation
 **************************************************************************************/
package ca.uwaterloo.gp.fmp.constraints.expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import net.sf.javabdd.BDD;

import ca.uwaterloo.gp.fmp.constraints.expression.Symbols.Token;
import ca.uwaterloo.gp.fmp.provider.fmpEditPlugin;

/**
 * Represents an Expression.
 * 
 * @author Steven She <shshe@uwaterloo.ca>
 */
@SuppressWarnings("unchecked")
public class ExpressionNode implements Cloneable {
	private Token symbol;
	private List<ExpressionNode> children = Collections.EMPTY_LIST;
	
	@Override
	protected Object clone() {
		ExpressionNode result = new ExpressionNode(this.getSymbol());
		for (ExpressionNode c : getChildren()) {
			result.getChildren().add((ExpressionNode)c.clone());
		}
		return result;
	}
	
	public ExpressionNode(Token symbol) {
		this.symbol = symbol;
	}
	
	public ExpressionNode(Token symbol, List<ExpressionNode> children) {
		this.symbol = symbol;
		this.children = children;
	}

	public Token getSymbol() {
		return symbol;
	}
	
	public List<ExpressionNode> getChildren() {
		return children;
	}
	
	
	
	public  ExpressionNode and(ExpressionNode y) {
		List<ExpressionNode> children = new ArrayList<ExpressionNode>(2);
		children.add(this);
		children.add(y);
		return new ExpressionNode(Symbols.AND_T, children);
	}
	public ExpressionNode or(ExpressionNode y) {
		List<ExpressionNode> children = new ArrayList<ExpressionNode>(2);
		children.add(this);
		children.add(y);

		return new ExpressionNode(Symbols.OR_T, children);
	}
	public ExpressionNode xor(ExpressionNode y) {
		List<ExpressionNode> children = new ArrayList<ExpressionNode>(2);
		children.add(this);
		children.add(y);

		return new ExpressionNode(Symbols.XOR_T, children);
	}
	public ExpressionNode imp(ExpressionNode y) {
		List<ExpressionNode> children = new ArrayList<ExpressionNode>(2);
		children.add(this);
		children.add(y);
		return new ExpressionNode(Symbols.IMPL_T, children);
	}
	
	public ExpressionNode not() {
		List<ExpressionNode> children = new ArrayList<ExpressionNode>(1);
		children.add(this);
		return new ExpressionNode(Symbols.NOT_T, children); 
	}
	
	/**
	 * Simplify the expression with some heuristics.
	 * Expression with true AND x, x AND true, will return x.
	 * Expression with false OR y, y OR false, will return y.
	 * Expression with false AND x will return false.
	 * Expression with true OR y will return true.
	 * @return reduced ExpressionNode.
	 */
	public ExpressionNode reduce() {
		if (this.getSymbol() == Symbols.AND_T) {
			if (getChildren().get(0).getSymbol().getId() == Symbols.TokenType.TRUE
					&& getChildren().get(1).getSymbol().getId() == Symbols.TokenType.FALSE) {
				return new ExpressionNode(Symbols.FALSE_T);
			}
			if (getChildren().get(0).getSymbol().getId() == Symbols.TokenType.TRUE) {
				return getChildren().get(1).reduce();
			}
			else if (getChildren().get(1).getSymbol().getId() == Symbols.TokenType.TRUE) {
				return getChildren().get(0).reduce();
			}
			else if (getChildren().get(0).getSymbol().getId() == Symbols.TokenType.FALSE
					|| getChildren().get(1).getSymbol().getId() == Symbols.TokenType.FALSE) {
				return new ExpressionNode(Symbols.FALSE_T).reduce();
			}
		}
		else if (this.getSymbol() == Symbols.OR_T) {
			if (getChildren().get(0).getSymbol().getId() == Symbols.TokenType.FALSE) {
				return getChildren().get(1).reduce();
			}
			else if (getChildren().get(1).getSymbol().getId() == Symbols.TokenType.FALSE) {
				return getChildren().get(0).reduce();
			}
			else if (getChildren().get(0).getSymbol().getId() == Symbols.TokenType.TRUE
					|| getChildren().get(1).getSymbol().getId() == Symbols.TokenType.TRUE) {
				return new ExpressionNode(Symbols.TRUE_T).reduce();
			}
		}
		
		ListIterator<ExpressionNode> iter = getChildren().listIterator();
		while (iter.hasNext()) {
			ExpressionNode c = iter.next();
			ExpressionNode newC = c.reduce();
			iter.set(newC);
		}
			
		return this;
	}
	
	public BDD bdd(BDDBuilder builder) {
		if (this.getSymbol() == Symbols.AND_T) {
			return getChildren().get(0).bdd(builder).andWith(getChildren().get(1).bdd(builder));
		}
		else if (this.getSymbol() == Symbols.OR_T) {
			return getChildren().get(0).bdd(builder).orWith(getChildren().get(1).bdd(builder));
		}
		else if (this.getSymbol() == Symbols.XOR_T) {
			return getChildren().get(0).bdd(builder).xorWith(getChildren().get(1).bdd(builder));
		}
		else if (this.getSymbol() == Symbols.IMPL_T) {
			return getChildren().get(0).bdd(builder).impWith(getChildren().get(1).bdd(builder));
		}
		else if (this.getSymbol() == Symbols.NOT_T) {
			return getChildren().get(0).bdd(builder).not();
		}
		else if (this.getSymbol() == Symbols.TRUE_T) {
			return builder.one();
		}
		else if (this.getSymbol() == Symbols.FALSE_T) {
			return builder.zero();
		}
		else if(this.getSymbol().getId() == Symbols.TokenType.IDENTIFIER) {
			return builder.getIdentifierBDD(this.getSymbol().getLexeme());
		}
		else {
			fmpEditPlugin.getPlugin().getLog().log(new Status(IStatus.ERROR,
					fmpEditPlugin.PLUGIN_ID, 
					"Constructing BDD, but don't know how to handle " + this.getSymbol()));
			return builder.one();
		}
	}
	
	@Override
	public String toString() {
		if (this.getSymbol() == Symbols.AND_T) {
			return "(" + getChildren().get(0) + " and " + getChildren().get(1) + ")";
		}
		else if (this.getSymbol() == Symbols.OR_T) {
			return "(" + getChildren().get(0) + " or " + getChildren().get(1) + ")";
		}
		else if (this.getSymbol() == Symbols.XOR_T) {
			return "(" + getChildren().get(0) + " xor " + getChildren().get(1) +")";
		}
		else if (this.getSymbol() == Symbols.IMPL_T) {
			return "(" + getChildren().get(0) + "->" + getChildren().get(1) + ")";
		}
		else if (this.getSymbol() == Symbols.NOT_T) {
			return "!" + getChildren().get(0);
		}
		else if (this.getSymbol().getId() == Symbols.TokenType.TRUE) {
			return Symbols.TRUE_T.getLexeme();
		}
		else if (this.getSymbol().getId() == Symbols.TokenType.FALSE) {
			return Symbols.FALSE_T.getLexeme();
		}
		else if(this.getSymbol().getId() == Symbols.TokenType.IDENTIFIER) {
			return this.getSymbol().getLexeme();
		}
		else {
			return "?" + this.getSymbol() + "?";
		}
	}
	
	public static void printTree(ExpressionNode n, int level) {
		for (int i=0;i<level; i++) {
			System.out.print("-");
		}
		System.out.println(n);
		
		for (ExpressionNode e : n.getChildren()) {
			printTree(e, level+1);
		}
	}
}
