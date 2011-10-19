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

import java.util.HashMap;
import java.util.Map;

public class Symbols {
	public static Map<String, TokenType> LEXEME_TOKEN_MAP = new HashMap<String, TokenType>();
	
	public static class Token {
		private TokenType id;
		private String lexeme;
		public Token(TokenType id, String lexeme) {
			this.id = id;
			this.lexeme = lexeme;
			
			LEXEME_TOKEN_MAP.put(lexeme, id); //Add to Lexeme Token Map
		}
		public TokenType getId() {
			return this.id;
		}
		public String getLexeme() {
			return lexeme;
		}
		public String toString() {
			return this.id + ":" + lexeme;
		}
	}
	
	public static enum TokenType { NOT, AND, OR, XOR, IMPL, LPAREN, RPAREN, 
		IDENTIFIER, TRUE, FALSE, BOF, EOF, ERROR, RULE };
	
	/*
	 * Mapping between SLR grammar and Tokens
	 */
	public static final Token NOT_T = new Token(TokenType.NOT,"!");
	public static final Token AND_T = new Token(TokenType.AND,"and");
	public static final Token OR_T = new Token(TokenType.OR,"or");
	public static final Token XOR_T = new Token(TokenType.XOR,"xor");
	public static final Token IMPL_T = new Token(TokenType.IMPL,"impl");
	public static final Token LPAREN_T = new Token(TokenType.LPAREN,"(");
	public static final Token RPAREN_T = new Token(TokenType.RPAREN,")");
	public static final Token ERROR_T = new Token(TokenType.ERROR,"err");
	public static final Token BOF_T = new Token(TokenType.BOF,"bof");
	public static final Token EOF_T = new Token(TokenType.EOF,"eof");
	public static final Token IDENTIFIER_T = new Token(TokenType.IDENTIFIER,"ID");
	public static final Token TRUE_T = new Token(TokenType.TRUE,"true");
	public static final Token FALSE_T = new Token(TokenType.FALSE,"false");
	public static final Token RULE_T = new Token(TokenType.RULE,"rule");
	
}
