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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import ca.uwaterloo.gp.fmp.provider.command.RemoveConstraintCommand;

/**
 * Action to remove Constraints from the feature model.
 * @author Steven She <shshe@uwaterloo.ca>
 *
 */
public class RemoveConstraintAction extends CommandActionHandler {
	
	public RemoveConstraintAction(EditingDomain domain) {
		super(domain, "Remove Constraint(s)");
	}
	
	@Override
	public void run() {
		super.run();
	}
	
	@Override
	public Command createCommand(Collection<?> selection) {
		return new RemoveConstraintCommand(domain, selection);
	}
	
	@Override
	public boolean isEnabled() {
		return command.canExecute();
	}
}
	