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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import ca.uwaterloo.gp.fmp.ConfigState;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.FmpPackage;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.constraints.expression.Symbols.TokenType;
import ca.uwaterloo.gp.fmp.provider.fmpEditPlugin;
import ca.uwaterloo.gp.fmp.system.RoleQuery;

/**
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class ExpressionBuilder {
	
	public static ExpressionNode id(String name) {
		return new ExpressionNode(new Symbols.Token(TokenType.IDENTIFIER, name));
	}
	
	public static final ExpressionNode ONE = new ExpressionNode(Symbols.TRUE_T);
	public static ExpressionNode one() {
		return (ExpressionNode)ONE.clone();
	}
	public static final ExpressionNode ZERO = new ExpressionNode(Symbols.FALSE_T);
	public static ExpressionNode zero() {
		return (ExpressionNode)ZERO.clone();
	}
	
	public static ExpressionNode getFeatureModelExpression(Feature root) {
		return getTreeExpression(root, null);
	}
	
	public static ExpressionNode getNodeExpression(Node child) {
		return getNodeExpression(child,(Node) child.eContainer());
	}
	
	@SuppressWarnings("unchecked")
	public static ExpressionNode getNodeExpression(Node child, Node parent) {
		ExpressionNode result = one();
		
		int role = RoleQuery.INSTANCE.getNodeType(child);
		Feature f = null;
		
//		System.out.println("ROLE: " + role);
		switch (role) {
		case RoleQuery.ROOT_FEATURE:
			//FEATURE_ROOT
			ExpressionNode rootExpr = id(child.getId());
			result = result.and(rootExpr);
			break;
		case RoleQuery.SOLITARY_FEATURE:
			f = (Feature) child;
			//Add child->parent implication
			ExpressionNode childParentExpr = id(child.getId()).imp(id(parent.getId()));
			result = result.and(childParentExpr);
			
			if (!f.isOptional()) {
				//Add parent->child implication
				ExpressionNode parentChildExpr = id(parent.getId()).imp(id(child.getId()));
				result = result.and(parentChildExpr);
			}
			break;
		case RoleQuery.FEATURE_GROUP:
			FeatureGroup g = (FeatureGroup) child;
			if (g.getMin() == 1 && g.getMax() == 1) {
				//XOR Group
				ExpressionNode subfeatureExpr = zero();
				for (Node subfeature : (List<Node>)g.getChildren()) {
					subfeatureExpr = subfeatureExpr.xor(id(subfeature.getId()));
				}
				subfeatureExpr = id(g.getId()).imp(subfeatureExpr);
				result = result.and(subfeatureExpr);
			}
			else if (g.getMin() == 1) {
				//OR Group
				ExpressionNode subfeatureExpr = zero();
				for (Node subfeature : (List<Node>)g.getChildren()) {
					subfeatureExpr = subfeatureExpr.or(id(subfeature.getId()));
				}
				subfeatureExpr = id(g.getId()).imp(subfeatureExpr);
				result = result.and(subfeatureExpr);				
			}
			else {
				//TODO
				fmpEditPlugin.getPlugin().getLog().log(new Status(IStatus.WARNING,
						fmpEditPlugin.PLUGIN_ID, 
						"Cardinalities on feature group '" 
						+ g.getId() 
						+ "' not supported for configuration"));
			}
			break;
		case RoleQuery.GROUPED_FEATURE:
			f = (Feature) child;
			if (f.getMin() == 1 && f.getMax() == 1) {
				result = result.and(id(f.getId()).imp(id(parent.getId())));
				result = result.and(id(parent.getId()).imp(id(f.getId())));
			}
			else if (f.getMin() == 0 && f.getMax() == 1) {
				result = result.and(id(f.getId()).imp(id(parent.getId())));
			}
			else {
				//TODO
				fmpEditPlugin.getPlugin().getLog().log(new Status(IStatus.WARNING,
						fmpEditPlugin.PLUGIN_ID, 
						"Cardinalities on grouped feature '" 
						+ f.getId() 
						+ "' not supported for configuration"));
			}
			break;
		}
		return result;
	}
	
	public static ExpressionNode getTreeExpression(Node root) {
		assert(RoleQuery.INSTANCE.getNodeType(root) == RoleQuery.ROOT_FEATURE);
		return getTreeExpression(root, null);
	}
	
	@SuppressWarnings("unchecked")
	public static ExpressionNode getTreeExpression(Node child, Node parent) {
		ExpressionNode result = getNodeExpression(child, parent);
		
		for (Node n : (List<Node>)child.getChildren()) {
			result = result.and(getTreeExpression(n, child));
		}
		return result.reduce(); //FIXME, reducing is not necessary really..
	}

	
	enum SelectState { SELECTED, ELIMINATED };
	
	/**
	 * This constructs a valuation of the configuration. Selected features are
	 * true, and unselected or eliminated features are false. This method depends
	 * on the Id of the configuration features matching an identifier in the model
	 * root, if it does not, this method will return an ExpressionNode representing
	 * false.
	 * @param node
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ExpressionNode getConfigExpression(Node node) {
		ExpressionNode result = one();

		SelectState selected = null;
		if (RoleQuery.INSTANCE.getNodeType(node) == RoleQuery.ROOT_FEATURE) {
			//FIXME Root feature is in configstate UNDECIDED, even though it
			//is always selected
			selected = SelectState.SELECTED;
		}
		else if (node.eClass().getClassifierID() == FmpPackage.FEATURE) {
			Feature f = (Feature) node;
			ConfigState state = f.getState();

			//If there is an Id that does not exist in the model
//			if(!((NodeImpl)node).getIdTable().containsKey(node.getId())) {
//				return new ExpressionNode(Symbols.TRUE_T);
//			}
			
			if (!f.isOptional()) { //If the feature is mandatory
				selected = SelectState.SELECTED;
			}
			else {
				switch (state.getValue()) {
				case ConfigState.MACHINE_SELECTED:
				case ConfigState.USER_SELECTED:
					selected = SelectState.SELECTED;
					break;
				case ConfigState.MACHINE_ELIMINATED:
				case ConfigState.USER_ELIMINATED:
				case ConfigState.UNDECIDED:
					selected = SelectState.ELIMINATED;
					break;
				}
			}
		}
		else if (node.eClass().getClassifierID() == FmpPackage.FEATURE_GROUP) {
			//FIXME Steven Feature groups don't have ConfigState, but I don't see why not
			//especially once we add soft constraints
			if (node.getMin() == 0) {
				selected = SelectState.SELECTED;
			}
			else if (node.getMin() == 1) {
				for (Node n : (List<Node>)node.getChildren()) {
					ExpressionNode childexpr = getConfigExpression(n);
					if (childexpr.getSymbol().getId() == TokenType.AND) {
						selected = SelectState.SELECTED;
						break;
					}
				}
			}
			else {
				//Error handling
				fmpEditPlugin.getPlugin().getLog().log(new Status(IStatus.WARNING,
						fmpEditPlugin.PLUGIN_ID, "Constraints on feature groups" +
								"with cardinality > 1 not supported"));
			}
		}
		
		if (selected == SelectState.SELECTED) {
			result = result.and(id(node.getId()));
			
			//The current feature is selected, so we need to process its children
			for (Node n : (List<Node>)node.getChildren()) {
				ExpressionNode childexpr = getConfigExpression(n);
				result = result.and(childexpr);
			}

		}
		else if (selected == SelectState.ELIMINATED) {
			result = result.and(id(node.getId()).not());
			
			//The current feature is deselected, so we need to eliminate its subfeatures
			for (Node n : (List<Node>)node.getChildren()) {
				result = result.and(getSubFeatures(n).not());
			}
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected static ExpressionNode getSubFeatures(Node root) {
		ExpressionNode result = one();
		result = result.and(id(root.getId()));
		for (Node n : (List<Node>)root.getChildren()) {
			result = getSubFeatures(n);
		}
		return result;
	}
}
