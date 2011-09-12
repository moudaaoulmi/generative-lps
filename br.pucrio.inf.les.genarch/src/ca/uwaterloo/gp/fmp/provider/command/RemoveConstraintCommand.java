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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import ca.uwaterloo.gp.fmp.Constraint;
import ca.uwaterloo.gp.fmp.FmpPackage;

/**
 * 
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class RemoveConstraintCommand extends CompoundCommand {
	Collection<?> selection;
	EditingDomain domain;
	
	public RemoveConstraintCommand(EditingDomain domain, Collection<?> owner) {
		this.selection = owner;
		this.domain = domain;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		Collection<Constraint> constraints = (Collection<Constraint>) selection; 
		for (Constraint c : constraints) {
			append(new RemoveCommand(domain, c.eContainer(), FmpPackage.eINSTANCE.getFeature_Constraints(), c));
		}
		super.execute();
	}

	@Override
	public boolean canExecute() {
		Iterator<?> iter = selection.iterator();
		while (iter.hasNext()) {
			Object o = iter.next();
			if (!(o instanceof EObject)) {
				return false;
			}
			EObject eobj = (EObject) o;
			if (eobj.eClass().getClassifierID() != FmpPackage.CONSTRAINT) {
				return false;
			}
		}
		return true;
	}
}
