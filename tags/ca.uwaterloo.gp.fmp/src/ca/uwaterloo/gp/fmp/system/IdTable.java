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
package ca.uwaterloo.gp.fmp.system;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import ca.uwaterloo.gp.fmp.FmpPackage;
import ca.uwaterloo.gp.fmp.Node;
import ca.uwaterloo.gp.fmp.constraints.expression.BDDBuilder;
import ca.uwaterloo.gp.fmp.impl.NodeImpl;
import ca.uwaterloo.gp.fmp.provider.fmpEditPlugin;

/**
 * Replacement for NodeIdDictionary. Uses an EContentAdapter that monitors the
 * feature model for changes, and adds Ids accordingly.
 * 
 * @author Steven She <shshe@uwaterloo.ca>
 */
public class IdTable extends HashMap<String, Node> {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 5768407090649657755L;

	/**
	 * Reverse mapping from Node to Id. This makes IdTable a bi-directional
	 * mapping.
	 */
	protected HashMap<Node, String> nodeIds = new HashMap<Node, String>();

	/** The Constant digitPattern. */
	protected static final Pattern digitPattern = Pattern.compile("\\d+");

	/** The associated builder. */
	protected BDDBuilder builder = new BDDBuilder(this);

	/**
	 * Listener for a Feature, which listens for changes to the Id attribute,
	 * and updates a given IdTable automatically.
	 * 
	 * @author Steven She <shshe@uwaterloo.ca>
	 */
	public static class IdSetListener extends EContentAdapter {
		private IdTable idtable;

		public IdSetListener(IdTable table) {
			this.idtable = table;
		}

		@Override
		public void notifyChanged(Notification n) {
			super.notifyChanged(n);
			if (n.getFeatureID(FmpPackage.class) == FmpPackage.NODE__ID) {
				switch (n.getEventType()) {
				case Notification.SET:
					Node node = (Node) n.getNotifier();
					int location = RoleQuery.INSTANCE.getLocationType(node);
					// Ignore configurations
					if (location == RoleQuery.MODEL
							|| location == RoleQuery.MODEL_PROPERTIES) {
						idtable.put(node.getId(), node);
					}
					break;
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Node put(String key, Node value) {
		if (containsValue(value)) {
			String oldKey = nodeIds.get(value);
			remove(oldKey);
			// fmpEditPlugin.getPlugin().getLog().log(new Status(IStatus.ERROR,
			// FmpEditor.EDITOR_ID, "Duplicate IDs detected for feature " +
			// value.getId()));
			// return null;
		}
		nodeIds.put(value, key);
		builder.addIdentifier(key);
		return super.put(key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.HashMap#remove(java.lang.Object)
	 */
	@Override
	public Node remove(Object key) {
		// System.out.println("Removing: " + key);
		nodeIds.remove(get(key));
		builder.removeIdentifier((String) key);
		return super.remove(key);
	}

	/**
	 * Creates an id for a configuration. TODO use Feature / Node as a
	 * parameter?
	 * 
	 * @param name
	 * @return
	 */
	public String createConfigIdentifier(String name) {
		return createIdentifier("config_" + name);
	}

	/**
	 * Returns an id generated from a name - removes illegal characters. Added
	 * duplicate detection.
	 * 
	 * @return valid id
	 */
	public String createIdentifier(String name) {
		String id = "";
		if (name != null) {
			id = name.trim();
		}
		id = name.replace(' ', '_');
		id = id.replaceAll("\\W", ""); // remove non-word characters

		// If there is
		if (id.length() == 0) {
			id = "feature";
		}
		// Check if first character is a number (not really necessary)
		if (Character.isDigit(id.charAt(0))) {
			id = "_" + id;
		}

		// check the IdTable to see if there are d
		while (containsKey(id)) {
			Matcher digits = digitPattern.matcher(id);

			if (digits.find()) {
				// Digits exist, increment last set of digits
				String lastDigits = digits.group(digits.groupCount());
				int newDigits = Integer.parseInt(lastDigits) + 1;
				id = id.substring(0, id.lastIndexOf(lastDigits)) + newDigits;
			} else {
				// No digits were found
				id += "1";
			}
		}

		return id;
	}

	/**
	 * Called on creation of FmpEditor in order to add Ids present in the model
	 * at the start.
	 * 
	 * @param f
	 */
	@SuppressWarnings("unchecked")
	public void initialize(Node f) {
		// if (f.eClass().getClassifierID() == FmpPackage.FEATURE &&
		if (f.getId() != null) {
			put(f.getId(), f);
			NodeImpl impl = (NodeImpl) f;
			impl.setIdTable(this);
		}

		else if (f.getId() == null) {
			fmpEditPlugin.getPlugin().getLog().log(
					new Status(IStatus.ERROR, fmpEditPlugin.PLUGIN_ID,
							"Feature has null id"));
		}
		for (Node c : (List<Node>) f.getChildren()) {
			initialize(c);
		}
		for (Node c : (List<Node>) f.getConfs()) {
			initialize(c);
		}
	}

	public BDDBuilder getBDDBuilder() {
		return builder;
	}
}
