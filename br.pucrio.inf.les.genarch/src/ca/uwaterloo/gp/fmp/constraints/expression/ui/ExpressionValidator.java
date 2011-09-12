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
package ca.uwaterloo.gp.fmp.constraints.expression.ui;

import org.eclipse.jface.dialogs.IInputValidator;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionNode;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionParser;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionScanner;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionParser.ExpressionParseException;
import ca.uwaterloo.gp.fmp.constraints.expression.Symbols.Token;
import ca.uwaterloo.gp.fmp.constraints.expression.Symbols;
import ca.uwaterloo.gp.fmp.system.IdTable;

/**
 * An input validator for InputDialog that uses the ExpressionScanner and 
 * ExpressionParser to construct a parse tree.
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class ExpressionValidator implements IInputValidator {
	protected IdTable idTable;
	public ExpressionValidator(IdTable table) {
		this.idTable = table;
	}
	
	public String isValid(String input) {
		if (input == null)
			return "Constraint is empty.";
		
		ExpressionScanner scanner = new ExpressionScanner(input);
		ExpressionParser parser = new ExpressionParser();
		try {
			ExpressionNode root = parser.createExpression(scanner);
			String idCheck = traverse(root);
			if (idCheck != null)
				return "Identifier not found: " + idCheck;
		} catch (ExpressionParseException e) {
			return "Unexpected Symbol: " + e.getSymbol();
		}
		
		return null;
	}
	
	/**
	 * @param n
	 * @return name of the identifier that doesn't exist, null if the expression
	 * tree is correct
	 */
	protected String traverse(ExpressionNode n) {
		Token t = n.getSymbol();
		
		if (t.getId() == Symbols.TokenType.IDENTIFIER) {
			if (!idTable.containsKey(t.getLexeme())) return t.getLexeme();
		}
		
		for (ExpressionNode child : n.getChildren()) {
			String result = traverse(child);
			if (result != null) return result;
		}
		return null;
	}
}
