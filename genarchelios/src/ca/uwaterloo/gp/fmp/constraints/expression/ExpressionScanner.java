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

import java.util.regex.Pattern;
import ca.uwaterloo.gp.fmp.constraints.expression.Symbols.Token;
/**
 * Lexer / scanner for boolean expressions. This class represents a simple DFA
 * which tokenizes the input.
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class ExpressionScanner {
	public static final int IDENTIFIER_START_STATE = 1;
	public static final int IDENTIFIER_STATE = 2;
	public static final int EOF_STATE = 100;
	
	protected int state = 0;
	protected StringBuilder buffer = new StringBuilder();
	
	protected CharSequence sequence;
	int pos = 0;
	
	public ExpressionScanner(CharSequence sequence) {
		this.sequence = sequence;
	}
	
	protected boolean done() {
		return pos >= sequence.length();
	}
	protected char next() {
		return sequence.charAt(pos++);
	}
	protected void back() {
		pos--;
	}
	
	public boolean eof() {
		return state == EOF_STATE;
	}
	
	public Token nextToken() {
		while (true) {
			if (state == 0) {
				if (done()) {
					state = EOF_STATE;
					return Symbols.EOF_T;
				}
				char c = next();
				buffer = new StringBuilder();
				switch (c) {
				case '!':
					state = 0;
					return Symbols.NOT_T;
				case '&':
					//and
					state = 0;
					return Symbols.AND_T;
				case '|':
					//or
					state = 0;
					return Symbols.OR_T;
				case '+':
					//xor
					state = 0;
					return Symbols.XOR_T;
				case '-':
					//impl
					if (done()) return Symbols.ERROR_T;
					c = next();
					if (c == '>') {
						state = 0;
						return Symbols.IMPL_T;
					}
					return Symbols.ERROR_T;
				case '(':
					//left parenthesis
					state = 0;
					return Symbols.LPAREN_T;
				case ')':
					//right parenthesis
					state = 0;
					return Symbols.RPAREN_T;
				default:
					back(); //return character
					state = IDENTIFIER_START_STATE;
					//don't break
				}
			}
			else if (state == IDENTIFIER_START_STATE) {
				if (done()) return Symbols.ERROR_T;
				char c = next();
				if (Pattern.matches("\\p{Alpha}", ""+c)) {
					state = IDENTIFIER_STATE;
					buffer.append(c);
					//don't break
				}
			}
			else if (state == IDENTIFIER_STATE) {
				if (done()) {
					state = 0;
					if (buffer.toString().equals("true")) {
						return Symbols.TRUE_T;
					}
					else if (buffer.toString().equals("false")) {
						return Symbols.FALSE_T;
					}
					else {
						return new Token(Symbols.TokenType.IDENTIFIER,buffer.toString());
					}
				}
				char c = next();
				if (Pattern.matches("\\p{Alnum}", ""+c)) {
					state = IDENTIFIER_STATE;
					buffer.append(c);
					//don't break
				}
				else {
					back(); //return character
					state = 0;
					if (buffer.toString().equals("true")) {
						return Symbols.TRUE_T;
					}
					else if (buffer.toString().equals("false")) {
						return Symbols.FALSE_T;
					}
					else {
						return new Token(Symbols.TokenType.IDENTIFIER,buffer.toString());
					}
				}
			}
			else if (state == EOF_STATE) {
				state = EOF_STATE;
				return Symbols.ERROR_T;
			}
		}
	}
	
	public static void main(String[] args) {
		String test = "a|b+c|d->e!!!!!f";
		ExpressionScanner scan = new ExpressionScanner(test);
		
		while (true) {
			Token t = scan.nextToken();
			if (t.getId() == Symbols.TokenType.EOF) {
				System.out.println("Success");
				break;
			}
			else if (t.getId() == Symbols.TokenType.ERROR) {
				System.err.println("Error");
				break;
			}
			else {
				System.out.print(t.getLexeme());
			}
		}
		
	}
}
