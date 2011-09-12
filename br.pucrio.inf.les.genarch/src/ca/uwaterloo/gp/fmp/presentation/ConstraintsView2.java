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
package ca.uwaterloo.gp.fmp.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import ca.uwaterloo.gp.fmp.Constraint;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FmpPackage;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.constraints.expression.BDDBuilder;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionBuilder;
import ca.uwaterloo.gp.fmp.constraints.expression.ExpressionNode;
import ca.uwaterloo.gp.fmp.constraints.expression.ui.ExpressionValidator;
import ca.uwaterloo.gp.fmp.impl.ConstraintImpl;
import ca.uwaterloo.gp.fmp.impl.NodeImpl;
import ca.uwaterloo.gp.fmp.provider.fmpEditPlugin;
import ca.uwaterloo.gp.fmp.provider.action.AddConstraintAction;
import ca.uwaterloo.gp.fmp.provider.action.RemoveConstraintAction;
import ca.uwaterloo.gp.fmp.provider.action.ResolveConstraintAction;
import ca.uwaterloo.gp.fmp.system.ModelNavigation;
import ca.uwaterloo.gp.fmp.system.RoleQuery;

/**
 * A view which displays: (1) the feature hierarchy and its implied constraints,
 * (2) the additional constraints. This view allows the user to add new constraints,
 * remove existing constraints, and resolve constraints. 
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class ConstraintsView2 extends ViewPart {

	/** The Constant VIEW_ID. */
	public static final String VIEW_ID = "ca.uwaterloo.gp.fmp.ConstraintsView";

	private class InputContainer {
		String label;
		Object[] objects;
		Image image;

		public InputContainer(String type, Object[] objects) {
			this.label = type;
			this.objects = objects;
		}

		public Object[] getObjects() {
			return objects;
		}

		public String getLabel() {
			return label;
		}

		public Image getImage() {
			return ExtendedImageRegistry.getInstance().getImage(
					fmpEditPlugin.getPlugin().getImage(
							"full/obj16/hierarchical"));
		}
	}

	/**
	 * @author Steven She <shshe@uwaterloo.ca>
	 */
	private class ConstraintsLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
		 */
		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof InputContainer) {
				if (columnIndex == 0)
						return ((InputContainer) element).getImage();
				return null;
			} else if (element instanceof Node || element instanceof Constraint) {
				switch(columnIndex) {
				case 0:
					if (element instanceof Node)
						return ExtendedImageRegistry.getInstance().getImage(
								fmpEditPlugin.getPlugin().getImage(
										"full/obj16/bullet_blue"));
					else
						return ExtendedImageRegistry.getInstance().getImage(
								fmpEditPlugin.getPlugin().getImage(
										"full/obj16/bullet_black"));
				case 1:
					Node root = ModelNavigation.INSTANCE
							.navigateToRootFeature(selection);
					int location = RoleQuery.INSTANCE.getLocationType(root);

					ExpressionNode expr = null;
					if (element instanceof Node) {
						Node n = (Node) element;
						expr = ExpressionBuilder.getNodeExpression(n,
								(Node) n.eContainer()).reduce();
					} else {
						// Constraint
						Constraint c = (Constraint) element;
						expr = ((ConstraintImpl) c).getExpression();
					}

					if (location == RoleQuery.CONFIGURATION
							|| location == RoleQuery.CONFIGURATION_PROPERTIES) {
						// Show a check mark and an exclamation mark if we
						// selected a configuration
						BDDBuilder builder = ((NodeImpl) root).getIdTable()
							.getBDDBuilder();
						if (builder.validate(expr, selConfigExpr)) {
							return ExtendedImageRegistry.getInstance()
									.getImage(
											fmpEditPlugin.getPlugin().getImage(
													"full/obj16/tick"));
						} else {
							return ExtendedImageRegistry.getInstance()
									.getImage(
											fmpEditPlugin.getPlugin().getImage(
													"full/obj16/exclamation"));
						}
					} else {
						// Show bullets otherwise
						if (element instanceof Node)
							return ExtendedImageRegistry.getInstance()
									.getImage(
											fmpEditPlugin.getPlugin().getImage(
													"full/obj16/bullet_blue"));
						else
							return ExtendedImageRegistry.getInstance()
									.getImage(
											fmpEditPlugin.getPlugin().getImage(
													"full/obj16/bullet_black"));
					}
				}
			}

			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
		 */
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof String) {
				if (columnIndex == 0)
					return element.toString();
				return null;
			} else if (element instanceof InputContainer) {
				if (columnIndex == 0)
					return ((InputContainer) element).getLabel();
				return null;
			}

			// This could be the model root, or a configuration root
			Node root = ModelNavigation.INSTANCE
					.navigateToRootFeature(selection);
			int location = RoleQuery.INSTANCE.getLocationType(root);
			BDDBuilder builder = ((NodeImpl) root).getIdTable().getBDDBuilder();

			if (element instanceof Node) {
				Node n = (Node) element;
				ExpressionNode expr = ExpressionBuilder.getNodeExpression(n,
						(Node) n.eContainer()).reduce();

				switch (columnIndex) {
				case 0:
					String label = "[" + n.getId() + "]";
					if (n.eClass().getClassifierID() == FmpPackage.FEATURE) {
						Feature f = (Feature) n;
						label += " " + f.getName();
					}
					return label;
				case 1:
					return ExpressionBuilder.getNodeExpression(n,
							(Node) n.eContainer()).reduce().toString();
				case 2:
					if (location == RoleQuery.CONFIGURATION
							|| location == RoleQuery.CONFIGURATION_PROPERTIES) {
						return Boolean.toString(builder.validate(expr,
								selConfigExpr));
					} else {
						return "Select Configuration";
					}
				}
				return "";
			} else if (element instanceof Constraint) {
				Constraint c = (Constraint) element;
				switch (columnIndex) {
				case 0:
					return c.getText();
				case 1:
					ExpressionValidator validator = new ExpressionValidator(
							((NodeImpl) root).getIdTable());
					String validation = validator.isValid(c.getText());
					if (validation == null) {
						// Constraint is valid. Convert constraint to Expression
						ExpressionNode expr = ((ConstraintImpl) c)
								.getExpression();
						return expr.reduce().toString();
					} else {
						return validation;
					}
				case 2:
					if (location == RoleQuery.CONFIGURATION
							|| location == RoleQuery.CONFIGURATION_PROPERTIES) {
						ExpressionNode expr = ((ConstraintImpl) c)
								.getExpression();
						return Boolean.toString(builder.validate(expr,
								selConfigExpr));
					} else {
						return "Select Configuration";
					}
				}
				return "";
			}

			return "Unknown";
		}
	}

	private class ConstraintsContentProvider implements ITreeContentProvider {
		public void dispose() {
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(Object parent) {
			if (parent instanceof InputContainer) {
				return ((InputContainer) parent).getObjects();
			} else if (parent instanceof Node) {
				Node n = (Node) parent;
				return n.getChildren().toArray();
			}
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(Object element) {
			if (element instanceof Node) {
				Node n = (Node) element;
				return n.getChildren().size() > 0;
			} else if (element instanceof InputContainer) {
				return true;
			}
			return false;
		}

		/**
		 * A list of ConstraintViewInputs should be passed in as elements.
		 */
		public Object[] getElements(Object element) {
			if (element instanceof Object[]) {
				return (Object[]) element;
			} else {
				System.err
						.println("ERROR: Unknown element passed into content provider");
				return new Object[0];
			}
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * This listener updates the ConstraintsView input with the list of
	 * constraints from the currently selected root node from FmpEditor.
	 * 
	 * @author Steven She <shshe@uwaterloo.ca>
	 * 
	 */
	private class NodeSelectionListener implements ISelectionListener,
			IPartListener2 {

		/** The model listener. */
		ModelConstraintsListener modelListener = new ModelConstraintsListener();
		
		/**
		 * Required overridden method. Updates when the user clicks on a new
		 * feature in the FmpEditor.
		 */
		public void selectionChanged(IWorkbenchPart part, ISelection newSel) {
			// TODO link button
			if (!(part instanceof FmpEditor))
				return;
			if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
				if (newSel instanceof IStructuredSelection
						&& ((IStructuredSelection) newSel).size() == 1
						&& newSel != selection) {
					updateInput(newSel);
				}
			}
		}

		public void partActivated(IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if (part instanceof FmpEditor) {
				editor = (FmpEditor) part;
				// updateInput(editor.getSelection());
				if (!editor.getModel().eAdapters().contains(modelListener))
					editor.getModel().eAdapters().add(modelListener);
			}
		}

		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		public void partClosed(IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if (part instanceof FmpEditor) {
				editor = null;
				clearTable();
			}
		}

		public void partDeactivated(IWorkbenchPartReference partRef) {
		}

		public void partHidden(IWorkbenchPartReference partRef) {
		}

		public void partInputChanged(IWorkbenchPartReference partRef) {
		}

		public void partOpened(IWorkbenchPartReference partRef) {
			IWorkbenchPart part = partRef.getPart(false);
			if (part.getSite().getWorkbenchWindow().getActivePage() != null) {
			IEditorPart editor = part.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
			if (editor instanceof FmpEditor) {
				FmpEditor fmp = (FmpEditor)editor;
				updateInput(fmp.getSelection());
				if (!fmp.getModel().eAdapters().contains(modelListener))
					fmp.getModel().eAdapters().add(modelListener);

			}
			}
		}

		public void partVisible(IWorkbenchPartReference partRef) {
		}
	}

	/**
	 * Monitors for changes to the constraints property in a feature model.
	 * Should be attached to the Model feature, by a PartListener such as
	 * NodeSelectionListener. Connector between Model and View.
	 * 
	 * @author Steven She <shshe@uwaterloo.ca>
	 * 
	 */
	private class ModelConstraintsListener extends EContentAdapter {
		@Override
		public void notifyChanged(Notification n) {
			System.out.println("notify");
			if (!n.isTouch()
				&& (n.getFeatureID(FmpPackage.class) == FmpPackage.CONSTRAINT
						|| n.getFeatureID(FmpPackage.class) == FmpPackage.FEATURE__CONSTRAINTS
						|| n.getFeatureID(FmpPackage.class) == FmpPackage.CLONABLE__STATE)) {
				updateInput();
			}
		}
		
	}

	protected TreeViewer treeViewer;
	protected FmpEditor editor = null;

	/**
	 * Watches for changes in the editor selection.
	 */
	protected NodeSelectionListener selectionListener = new NodeSelectionListener();

	/**
	 * The Model root of the currently selected node. The model root is the top
	 * most root element in the feature model.
	 */
	protected Feature selModelRoot = null;
	
	/**
	 * The currently selected configuration root.
	 */
	protected Feature selConfig = null;

	/**
	 * The expression representing the currently selected node if it is a
	 * configuration. If the current node is not a configuration, then this
	 * variable will be null.
	 */
	protected ExpressionNode selConfigExpr = null;

	/**
	 * Represents the currently selected Node in the model.
	 */
	protected Node selection = null;

	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent);
		treeViewer.getTree().setHeaderVisible(true);

		Tree tree = treeViewer.getTree();

		TreeColumn column = new TreeColumn(tree, SWT.LEFT);
		column.setText("Node");
		column.setWidth(250);
		column = new TreeColumn(tree, SWT.LEFT);
		column.setText("Constraint");
		column.setWidth(300);
		column = new TreeColumn(tree, SWT.LEFT);
		column.setText("Satisfied");
		column.setWidth(100);

		treeViewer.setContentProvider(new ConstraintsContentProvider());
		treeViewer.setLabelProvider(new ConstraintsLabelProvider());

		getSite().getPage().addSelectionListener(selectionListener);
		getSite().getWorkbenchWindow().getPartService().addPartListener(
				selectionListener);
		
		createContextMenu();
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}
	
	private void createContextMenu() {
		// Create menu manager.
		MenuManager menuMgr = new MenuManager(VIEW_ID);
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				EditingDomain editingDomain = null;
				if (editor instanceof FmpEditor) {
					FmpEditor fmpEditor = (FmpEditor) editor;
					editingDomain = fmpEditor.getEditingDomain();
				}
				RemoveConstraintAction remove = new RemoveConstraintAction(editingDomain);
				remove.updateSelection((IStructuredSelection)treeViewer.getSelection());
				
				BDDBuilder builder = ((NodeImpl)selModelRoot).getIdTable().getBDDBuilder();
				ResolveConstraintAction resolve = new ResolveConstraintAction(editingDomain, builder, selConfig, selModelRoot);
				resolve.updateSelection((IStructuredSelection)treeViewer.getSelection());
			
				AddConstraintAction add = new AddConstraintAction(editingDomain, selModelRoot);
				add.updateSelection(TreeSelection.EMPTY);
				
				mgr.add(remove);
				mgr.add(resolve);
				mgr.add(add);
				
				mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			}

		});

		// Create menu.
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);

		// Register menu for extension.
		getSite().registerContextMenu(menuMgr, treeViewer);
	}
	

	/**
	 * Updates the currRootFeature attribute. 
	 * mode with configuration
	 * 
	 * @param selection
	 */
	public void updateInput(ISelection selection) {
		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			Object input = ((IStructuredSelection) selection).getFirstElement();

			if (input instanceof Node) {
				this.selection = (Node) input;
				selModelRoot = ModelNavigation.INSTANCE.navigateToModelRoot((Node) input);

				updateInput();
			}
		}
	}

	protected void updateInput() {
		if (treeViewer.getContentProvider() == null) // Part not yet
														// initialized
			return;

		if (selModelRoot != null) {
			InputContainer nodes = new InputContainer("Feature Hierarchy",
					new Object[] { selModelRoot });
			InputContainer constraints = new InputContainer(
					"Additional Constraints", selModelRoot.getConstraints()
							.toArray());

				int selRole = RoleQuery.INSTANCE.getNodeType(selection);
				Feature configRoot = 
						(selRole == RoleQuery.ROOT_FEATURE) ? (Feature)selection :
						ModelNavigation.INSTANCE.navigateToRootFeature(selection);
						
				int location = RoleQuery.INSTANCE.getLocationType(configRoot);
				if (location == RoleQuery.CONFIGURATION
						|| location == RoleQuery.CONFIGURATION_PROPERTIES) {
					selConfig = configRoot;
					selConfigExpr = ExpressionBuilder
							.getConfigExpression(configRoot);
				} else {
					selConfigExpr = null;
					selConfig = null;
				}
			
			
			treeViewer.setInput(new Object[] { nodes, constraints });
			treeViewer.expandAll();
			treeViewer.refresh();
		} else {
			clearTable();
		}

	}

	protected void clearTable() {
		if (treeViewer.getContentProvider() == null) // Part not yet
														// initialized
			return;
		treeViewer.setInput("Select root feature to view constraints.");
		treeViewer.refresh();
	}

}
