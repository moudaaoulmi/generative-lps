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
package ca.uwaterloo.gp.fmp.provider.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.sf.javabdd.BDD;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.internal.resolver.ComputeNodeOrder;
import org.eclipse.swt.widgets.Display;

import ca.uwaterloo.gp.fmp.Clonable;
import ca.uwaterloo.gp.fmp.ConfigState;
import ca.uwaterloo.gp.fmp.Constraint;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FmpPackage;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.constraints.Configurator;
import ca.uwaterloo.gp.fmp.constraints.ConfiguratorDictionary;
import ca.uwaterloo.gp.fmp.constraints.expression.BDDBuilder;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionBuilder;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionNode;
import ca.uwaterloo.gp.fmp.impl.ConstraintImpl;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;

/**
 * Resolves a constraint by selecting the first satisfying variable assignment.
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class ResolveConstraintCommand extends CompoundCommand {
	protected Constraint toSatisfy;
	protected Feature model;
	protected Feature config;
	protected EditingDomain domain;
	protected BDDBuilder builder;

	public ResolveConstraintCommand(EditingDomain domain,
			BDDBuilder builder,
			Feature configRoot,
			Feature modelRoot,
			Constraint selection) {
		this.builder = builder;
		this.domain = domain;
		this.toSatisfy = selection;
		this.model = modelRoot;
		this.config = configRoot;
	}

	/**
	 * TODO If there is a conflict, show exactly which constraint is conflicting when resolving.
	 * TODO Present user with a choice if there are multiple satisfying assignments
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		BDD value = ((ConstraintImpl)toSatisfy).getExpression().bdd(builder);
		BDD configExpr = ExpressionBuilder.getConfigExpression(config).bdd(builder);
		configExpr = configExpr.exist(value); //Remove existence of valuation

		//FIXME Using only the first satisfying assignment. Ideally, if there
		//are multiple assignments, we can present the user with a choice
		if (configExpr.and(value).satCount() > 0) {
			BDD sat = configExpr.and(value).satOne();
			byte[] varAssignments = (byte[])sat.allsat().get(0);
			
			for (int i=0; i<Math.min(builder.numOfIdentifiers(),varAssignments.length);i++) {
				Node node = getConfigNode(config, builder.getIdentifier(i));
				if (node != null && node.eClass().getClassifierID() == FmpPackage.FEATURE) {
					Feature f = (Feature)node;
					switch(varAssignments[i]) {
					case 0: //false
						System.out.println("Assign false to " + i + ": " + builder.getIdentifier(i));
						assignFalse(f);
						break;
					case 1: //true
						System.out.println("Assign true to " + i + ": " + builder.getIdentifier(i));
						assignTrue(f);
						break;
					}
				}
			}
		}
		else {
			MessageDialog.openError(Display.getDefault().getActiveShell(), 
					"Resolution failed",
					"The constraint '" + ((ConstraintImpl)toSatisfy).getExpression() 
					+ "' cannot be satisfied in the selected configuration.");
		}
		System.out.println("Execute " + commandList.size());

		
		super.execute();
	}
	
	protected void assignTrue(Feature f) {
		while (f != null && f.isOptional() && (f.getState() == ConfigState.MACHINE_ELIMINATED_LITERAL
				|| f.getState() == ConfigState.USER_ELIMINATED_LITERAL
				|| f.getState() == ConfigState.UNDECIDED_LITERAL)) {
			//FIXME Update configurator, Remove this when removing configurator
			Configurator conf = ConfiguratorDictionary.INSTANCE.get(ModelNavigation.INSTANCE.navigateToRootFeature(f));
			conf.assignValue(f.getId(),1, false);
			
			append(new SetCommand(domain, f, FmpPackage.eINSTANCE.getClonable_State(), ConfigState.MACHINE_SELECTED_LITERAL));
			f = (Feature)f.eContainer();
		}
	}
	
	protected void assignFalse(Feature f) {
		while (f != null && f.isOptional() && (f.getState() == ConfigState.MACHINE_SELECTED_LITERAL
				|| f.getState() == ConfigState.USER_SELECTED_LITERAL)) {
			//FIXME Update configurator, Remove this when removing configurator
			Configurator conf = ConfiguratorDictionary.INSTANCE.get(ModelNavigation.INSTANCE.navigateToRootFeature(f));
			conf.assignValue(f.getId(),0, false);
			
			append(new SetCommand(domain, f, FmpPackage.eINSTANCE.getClonable_State(), ConfigState.MACHINE_ELIMINATED_LITERAL));
			f = (Feature)f.eContainer();
		}
	}
	
	
	/**
	 * Gets the config node by id.
	 * 
	 * @param root the root configuration node
	 * @param identifier the id of the node in which we which to find
	 * 
	 * @return the configuration node with the correct id, null if a node
	 * could not be found in the current configuration tree.
	 */
	public Node getConfigNode(Node root, String identifier) {
		if (root.getId().equals(identifier)) {
			return root;
		}
		for (Node n : (List<Node>)root.getChildren()) {
			Node ret = getConfigNode(n, identifier);
			if (ret != null)
				return ret;
		}
		return null;
	}
	
	
	private void makeAncestorList(Node root, List<Node> ancestors) {
		ancestors.addAll(root.getChildren());
		for (Node n : (List<Node>)root.getChildren()) {
			makeAncestorList(n, ancestors);
		}
	}
	
	@Override
	public boolean canExecute() {
		return true;
	}
}
