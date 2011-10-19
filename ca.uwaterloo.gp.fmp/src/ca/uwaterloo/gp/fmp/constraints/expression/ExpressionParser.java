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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import ca.uwaterloo.gp.fmp.constraints.expression.Symbols.Token;
import ca.uwaterloo.gp.fmp.constraints.expression.Symbols.TokenType;

/**
 * This is a hand-coded parser for the expressions. we could use a parser-generator
 * framework to construct this, however, the expression language is not too
 * complex at the moment, and things are better kept simple. 
 * @author Steven She <shshe@uwaterloo.ca>
 *
 */
public class ExpressionParser {
	
	public static class ExpressionParseException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 570243054390678048L;
		String symbol;
		public ExpressionParseException(String symbol) {
			this.symbol = symbol;
		}
		
		public String getSymbol() {
			return symbol;
		}
	}
	
	/**
	 * This variable contains all the parsing information required to construct
	 * the LR parsing tables used to parse the expression grammar. This is a
	 * direct copy-and-paste of the slr.tbl tables.
	 */
	public static final String SLR_TABLE = "17 13 22\n" +
		"1 X\n" +
		"0 bof\n" +
		"1 S\n" +
		"0 eof\n" +
		"0 and\n" +
		"1 T\n" +
		"0 or\n" +
		"0 xor\n" +
		"0 impl\n" +
		"1 F\n" +
		"0 (\n" +
		"0 )\n" +
		"1 N\n" +
		"0 !\n" +
		"0 ID\n" +
		"0 true\n" +
		"0 false\n" +
		"0 3 1 2 3\n" +
		"2 3 2 4 5\n" +
		"2 3 2 6 5\n" +
		"2 3 2 7 5\n" +
		"2 1 5\n" +
		"5 3 5 8 9\n" +
		"5 1 9\n" +
		"9 3 10 2 11\n" +
		"9 1 12\n" +
		"12 2 13 12\n" +
		"12 1 14\n" +
		"12 1 15\n" +
		"12 1 16\n" +
		"9 2 S9 5 S8 9 S7 10 S6 12 S5 13 S4 14 S3 15 S2 16 S1\n" +
		"6 3 R12 4 R12 6 R12 7 R12 8 R12 11 R12\n" +
		"6 3 R11 4 R11 6 R11 7 R11 8 R11 11 R11\n" +
		"6 3 R10 4 R10 6 R10 7 R10 8 R10 11 R10\n" +
		"5 12 S10 13 S4 14 S3 15 S2 16 S1\n" +
		"6 3 R8 4 R8 6 R8 7 R8 8 R8 11 R8\n" +
		"9 2 S11 5 S8 9 S7 10 S6 12 S5 13 S4 14 S3 15 S2 16 S1\n" +
		"6 3 R6 4 R6 6 R6 7 R6 8 R6 11 R6\n" +
		"6 3 R4 4 R4 6 R4 7 R4 8 S12 11 R4\n" +
		"4 3 S16 4 S15 6 S14 7 S13\n" +
		"6 3 R9 4 R9 6 R9 7 R9 8 R9 11 R9\n" +
		"4 4 S15 6 S14 7 S13 11 S17\n" +
		"7 9 S18 10 S6 12 S5 13 S4 14 S3 15 S2 16 S1\n" +
		"8 5 S19 9 S7 10 S6 12 S5 13 S4 14 S3 15 S2 16 S1\n" +
		"8 5 S20 9 S7 10 S6 12 S5 13 S4 14 S3 15 S2 16 S1\n" +
		"8 5 S21 9 S7 10 S6 12 S5 13 S4 14 S3 15 S2 16 S1\n" +
		"0\n" +
		"6 3 R7 4 R7 6 R7 7 R7 8 R7 11 R7\n" +
		"6 3 R5 4 R5 6 R5 7 R5 8 R5 11 R5\n" +
		"6 3 R3 4 R3 6 R3 7 R3 8 S12 11 R3\n" +
		"6 3 R2 4 R2 6 R2 7 R2 8 S12 11 R2\n" +
		"6 3 R1 4 R1 6 R1 7 R1 8 S12 11 R1\n";
	
	public static Map<TokenType, Integer> TOKENID_SYMBOL_MAP = new HashMap<TokenType, Integer>();
	
	/**
	 * Table used when shifting or moving to another state (transitions).
	 * First dimension is the state. Second dimension is the symbol.
	 */
	public static int[][] TRANS;
	
	/**
	 * Table used when reducing by a rule.
	 * First dimension is the state. Second dimension is the symbol.
	 */
	public static int[][] REDUCE;
	
	/**
	 * Array of the sizes of the RHS of the rules .Indexed by rule number.
	 */
	public static int[] RHS_SIZE;
	
	/**
	 * Array of symbols of the LHS of the rules. Indexed by rule number.
	 */
	public static int[] LHS;
	
	/**
	 * Used to initialize the static tables required for LR parsing. This 
	 * interprets the string in SLR_TABLE, and fills in the correct tables.
	 * SLR_TABLE is an copy-and-paste of the tables from slr.c by G. Cormack.
	 */
	private static void buildTables() {
		Scanner scanner = new Scanner(SLR_TABLE);
		int numOfSymbols = scanner.nextInt();
		int numOfRules = scanner.nextInt();
		int numOfStates = scanner.nextInt();
		
		TRANS = new int[numOfStates][numOfSymbols];
		REDUCE = new int[numOfStates][numOfSymbols];
		
		for (int i=0; i<numOfStates; i++) {
			for (int j=0;j<numOfSymbols;j++) {
				TRANS[i][j] = -1;
				REDUCE[i][j] = -1;
			}
		}
		RHS_SIZE = new int[numOfRules];
		LHS = new int[numOfRules];

		int prefixCount = 0;
		for (int i=0; i<numOfSymbols;i++) {
			int isNonTerminal = scanner.nextInt();
			String symbol = scanner.next();
			if (isNonTerminal == 1) {
					//Infix rule, do nothing
			}
			else {
				TokenType tokenid = Symbols.LEXEME_TOKEN_MAP.get(symbol);
//				System.out.println("putting tokenid:" + tokenid + " i:" + i + " " + symbol);
				TOKENID_SYMBOL_MAP.put(tokenid, i);
			}
		}
		
		String clear = scanner.nextLine(); //Clear line
		assert(clear.equals(""));
		
		for (int i=0;i<numOfRules;i++) {
			int lhs = scanner.nextInt();
			LHS[i] = lhs;
			int rhs_length = scanner.nextInt();
			RHS_SIZE[i] = rhs_length;
			for (int j=0; j<rhs_length; j++) {
				scanner.nextInt(); //Do nothing
			}
		}
		
		clear = scanner.nextLine();
		assert(clear.equals(""));
		
		for (int i=0;i<numOfStates;i++) {
			int numOfActions = scanner.nextInt();
			for (int j=0;j<numOfActions;j++) {
				int symbol = scanner.nextInt();
				String action = scanner.next();
				if (action.charAt(0) == 'S') {
					//Shift
					TRANS[i][symbol] = Integer.parseInt(action.substring(1));
//					System.out.println(i + ":symbol " + symbol + " shift, move to " + action);
				}
				else {
					//Reduce
					REDUCE[i][symbol] = Integer.parseInt(action.substring(1));
//					System.out.println(i + ":symbol " + symbol+ " reduce by rule " + action);
				}
			}
		}
	}
	
	static {
		buildTables();
	}
	
	
	public ExpressionNode createExpression(ExpressionScanner scanner) throws ExpressionParseException {
		ExpressionNode result = parse(scanner);
		return removeRules(result);
	}
	
	protected ExpressionNode removeRules(ExpressionNode node) {
		if (node.getSymbol().getId() == TokenType.RULE) {

			if (node.getChildren().get(0).getSymbol().getId() == TokenType.NOT) {
				//Prefix rules go here
				List<ExpressionNode> newChildren = new ArrayList<ExpressionNode>(1);
				newChildren.add(removeRules(node.getChildren().get(1)));
				return new ExpressionNode(node.getChildren().get(0).getSymbol(), newChildren);
			}
			else if (node.getChildren().get(0).getSymbol().getId() == TokenType.LPAREN) {
				//Parenthesis
				ExpressionNode child = removeRules(node.getChildren().get(1));
				return child;
			}
			else if (node.getChildren().size() == 1){
				//Single rule with no terminals
				ExpressionNode child = removeRules(node.getChildren().get(0));
				return child;
			}
			else {
				List<ExpressionNode> newChildren = new ArrayList<ExpressionNode>(2);
				newChildren.add(removeRules(node.getChildren().get(0)));
				newChildren.add(removeRules(node.getChildren().get(2)));
				return new ExpressionNode(node.getChildren().get(1).getSymbol(), newChildren);
			}
		}

		
//		ListIterator<ExpressionNode> iter = node.getChildren().listIterator();
//		while (iter.hasNext()) {
//			ExpressionNode c = iter.next();
//			iter.set(removeRules(c));
//		}
//		
		return node;
	}
	
	/**
	 * Reference linear time LR parser implementation. There should be no reason
	 * to modify this method, other than to change the way the parse tree is
	 * generated.
	 * There is a customization to the algorithm which determines whether a rule
	 * is a PREFIX rule or an INFIX rule based on the PREFIX_NONTERMINAL_IDS array.
	 * @author Steven She <shshe@uwaterloo.ca>
	 * @param scanner Lexer to use
	 * @return
	 */
	public ExpressionNode parse(ExpressionScanner scanner) throws ExpressionParseException {
		Stack<Integer> stateStack = new Stack<Integer>();
		Stack<ExpressionNode> nodeStack = new Stack<ExpressionNode>();
		
		nodeStack.push(new ExpressionNode(Symbols.BOF_T)); //Completeness sake
		stateStack.push(0);
		while (true) {
//			System.out.println("Current state: " + stateStack.peek());
			if (scanner.eof())
				break;
			
			Token t = scanner.nextToken();
			if (t.getId() == Symbols.TokenType.ERROR) {
				System.err.println("Lexer error");
				break;
			}
			
			int s = TOKENID_SYMBOL_MAP.get(t.getId());
			
			while (REDUCE[stateStack.peek()][s] >=0) {
				int rule = REDUCE[stateStack.peek()][s];
				
				List<ExpressionNode> children = new ArrayList<ExpressionNode>();
				for (int i=0; i<RHS_SIZE[rule];i++) {
					stateStack.pop();
					children.add(nodeStack.pop());
				}
				Collections.reverse(children); //Reverse instead of popping right side first

				nodeStack.add(new ExpressionNode(Symbols.RULE_T, children));
				stateStack.push(TRANS[stateStack.peek()][LHS[rule]]);
				
//				System.out.println("reducing by rule " + rule + " LHS: " + LHS[rule] 
//                   + " new state: " + stateStack.peek());
			}
			nodeStack.add(new ExpressionNode(t));
			
			if (TRANS[stateStack.peek()][s] >= 0) {
				int nextState = TRANS[stateStack.peek()][s];
//				System.out.println("shifting to state " + nextState);
				stateStack.push(nextState);
			}
			else {
				throw new ExpressionParseException(t.getLexeme());
			}
		}
		
//		System.out.println("Node stack size: " + nodeStack.size());
		if (nodeStack.size() != 3) {
			throw new ExpressionParseException("Extreneous symbols");
		}
		//TODO fix BOF S EOF
		ExpressionNode eof = nodeStack.pop(); //Should be EOF
		if (eof.getSymbol() != Symbols.EOF_T) {
			throw new ExpressionParseException("Missing EOF");
		}
		
		return nodeStack.pop();
	}
	
	public static void main(String[] args) throws Exception {
//		ExpressionScanner s = new ExpressionScanner("!!c+d+e");
//		ExpressionParser p = new ExpressionParser();
//		ExpressionNode n = p.createExpression(s);
	}

}
