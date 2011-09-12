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
package ca.uwaterloo.gp.fmp.provider.action;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;

import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.provider.command.AddConstraintCommand;


/**
 * The Class AddConstraintAction.
 * 
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class AddConstraintAction extends CommandActionHandler {
	
	/** The model root feature. */
	Feature modelRoot = null;
	
	public AddConstraintAction(EditingDomain domain, Feature modelRoot) {
		super(domain, "Add Constraint");
		this.modelRoot = modelRoot;
	}
	
	public AddConstraintAction(EditingDomain domain) {
		super(domain, "Add Constraint");
	}
	public AddConstraintAction() {
		super(null, "Add Constraint");
	}
	
	@Override
	public Command createCommand(Collection<?> selection) {
		if (modelRoot != null) {
			return new AddConstraintCommand(domain, modelRoot);
		}
		else if (selection.size() == 1) {
			EObject obj = (EObject) selection.iterator().next();
			return new AddConstraintCommand(domain, obj);
		}
		return UnexecutableCommand.INSTANCE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.ui.action.CommandActionHandler#run()
	 */
	@Override
	public void run() {
		super.run();
	}
	
	@Override
	public boolean isEnabled() {
		return command.canExecute();
	}

}
