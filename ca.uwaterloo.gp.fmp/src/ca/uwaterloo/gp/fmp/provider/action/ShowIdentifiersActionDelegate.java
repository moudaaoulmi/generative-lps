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

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.part.EditorActionBarContributor;

import ca.uwaterloo.gp.fmp.presentation.FmpEditor;

public class ShowIdentifiersActionDelegate extends ActionDelegate implements IEditorActionDelegate {

	/**
	 * Sets the Show Identifier button according to the boolean variable in
	 * FmpEditor.
	 * @param action The action to modify.
	 */
	@Override
	public void init(IAction action) {
		action.setChecked(FmpEditor.SHOW_IDENTIFIER_DEFAULT);
	}
	
	/**
	 * @see ActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		assert(editor instanceof FmpEditor);
		FmpEditor fmpEditor = (FmpEditor) editor;
		
		if (action.isChecked()) {
			fmpEditor.setShowIdentifiers(true);
		}
		else {
			fmpEditor.setShowIdentifiers(false);
		}
	}

	/**
	 * Updates the action accordingly if there is another FmpEditor in the
	 * Workbench.
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if (targetEditor instanceof FmpEditor) {
			FmpEditor fmpEditor = (FmpEditor) targetEditor;
			action.setChecked(fmpEditor.getShowIdentifiers());
		}
	}
	


}
