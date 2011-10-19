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
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.ui.IEditorPart;

import ca.uwaterloo.gp.fmp.Constraint;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.constraints.expression.BDDBuilder;
import ca.uwaterloo.gp.fmp.presentation.FmpEditor;
import ca.uwaterloo.gp.fmp.provider.command.AddConstraintCommand;
import ca.uwaterloo.gp.fmp.provider.command.ResolveConstraintCommand;

public class ResolveConstraintAction extends CommandActionHandler {
	AdapterFactory adapterFactory;
	BDDBuilder builder;
	Feature config, model;
	
	public ResolveConstraintAction(EditingDomain domain, BDDBuilder builder, Feature config, Feature model) {
		super(domain, "Resolve Constraint");
		this.builder = builder;
		this.config = config;
		this.model = model;
	}
	
	@Override
	public void run() {
		super.run();
	}
	
	@Override
	public Command createCommand(Collection<?> selection) {
		if (selection.size() == 1 && selection.iterator().next() instanceof Constraint) {
			Constraint c = (Constraint) selection.iterator().next();
			return new ResolveConstraintCommand(domain, builder, config, model, c);
		}
		return UnexecutableCommand.INSTANCE;
	}
	
	@Override
	public boolean isEnabled() {
		return command.canExecute();
	}
}