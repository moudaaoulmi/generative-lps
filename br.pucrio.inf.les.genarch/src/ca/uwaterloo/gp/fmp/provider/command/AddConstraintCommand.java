/**************************************************************************************
 * Copyright (c) 2005, 2006 Generative Software Development Lab, University of Waterloo
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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import ca.uwaterloo.gp.fmp.Constraint;
import ca.uwaterloo.gp.fmp.FmpFactory;
import ca.uwaterloo.gp.fmp.FmpPackage;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.constraints.expression.ui.ExpressionValidator;
import ca.uwaterloo.gp.fmp.impl.NodeImpl;
import ca.uwaterloo.gp.fmp.system.IdTable;


/**
 * Adds a constraint to the feature model.
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class AddConstraintCommand extends CompoundCommand {
	
	/** The root feature in the model. */
	EObject modelRoot;
	
	/** The editing domain. */
	EditingDomain domain;
	
	/**
	 * Instantiates a new command which adds a constraint to the given feature 
	 * root.
	 * 
	 * @param domain the domain
	 * @param owner the feature root
	 */
	public AddConstraintCommand(EditingDomain domain, EObject owner) {
		this.modelRoot = owner;
		this.domain = domain;
	}
	
	@Override
	public void execute() {
		assert(modelRoot instanceof Node);
		
		IdTable idtable = ((NodeImpl)modelRoot).getIdTable();
		
		InputDialog d = new InputDialog(Display.getDefault().getActiveShell(),
                "Add Constraint",
                "Please input constraint",
                "",
                new ExpressionValidator(idtable));
		int retcode = d.open();
		
		if (retcode == Window.OK) {
			Constraint c = FmpFactory.eINSTANCE.createConstraint();
			c.setText(d.getValue());
			
			appendAndExecute(new AddCommand(domain , modelRoot,FmpPackage.eINSTANCE.getFeature_Constraints(), c));
		}
	}
	
	@Override
	public boolean canExecute() {
		if (modelRoot.eClass().getClassifierID() == FmpPackage.FEATURE)
			return true;
		return false;
	}
}
