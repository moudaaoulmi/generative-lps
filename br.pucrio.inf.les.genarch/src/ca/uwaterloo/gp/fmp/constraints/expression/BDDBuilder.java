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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;

import ca.uwaterloo.gp.fmp.system.IdTable;

/**
 * 
 * @author Steven She <shshe@uwaterloo.ca>
 *
 */
public class BDDBuilder {
	
	public static class UnknownIdentifierException extends Exception {
		private static final long serialVersionUID = 7945149049122579606L;
		public UnknownIdentifierException(String identifier) {
			super("Unknown identifier: " + identifier);
		}
	}
	
	protected BDDFactory factory = null;
	
	/**
	 * The list of identifiers encountered so far. The BDD var is equal to
	 * the identifiers location in the array. Thus, this list serves as a mapping
	 * from BDD var to identifier.
	 */
	protected List<String> identifiers = new ArrayList<String>();
	
	/**
	 * The reverse mapping from identifier to BDD var.
	 */
	protected Map<String, Integer> identifierVar = new HashMap<String, Integer>();
	protected int numOfVars = 40;
	protected IdTable idTable;
	
	public BDDBuilder(IdTable idTable) {
		factory = BDDFactory.init("j", 150000, 30000);
		factory.setVarNum (numOfVars);
		this.idTable = idTable;
	}
	
	public int addIdentifier(String id) {
		int var = identifiers.size();
		identifiers.add(id);
		if (numOfVars == identifiers.size()) {
			numOfVars = numOfVars * 2;
			factory.setVarNum(numOfVars);
		}
		identifierVar.put(id, var);
		return var;
	}
	
	/**
	 * FIXME currently doesn't remove old identifiers... varnum will
	 * continue to grow in size
	 */
	public void removeIdentifier(String id) {
		identifierVar.remove(id);
	}

	public boolean containsIdentifier(String id) {
		return identifierVar.containsKey(id);
	}
	
	public BDD getIdentifierBDD(String id) {
		assert(identifierVar.containsKey(id)); //Steven DEBUG
		return factory.ithVar(identifierVar.get(id));
	}
	
	public String getIdentifier(int var) {
		return identifiers.get(var);
	}
	
	public IdTable getIdTable() {
		return idTable;
	}
	
	/**
	 * TODO This really belongs in ExpressionBuilder
	 * This method is called by the constraints view in order to check whether
	 * a configuration node satisfies an expression in the model.
	 * @param e Model Expression.
	 * @param node Configuration Expression.
	 * @return true if the configuration expression satisfies the model expression, false otherwise
	 */
	public boolean validate(ExpressionNode e, ExpressionNode config) {
//		return config.bdd(this).imp(e.bdd(this)).isOne();
		if (e == null || config == null) return false;
		return !e.bdd(this).restrict(config.bdd(this)).isZero();
	}
	
	/**
	 * TODO This really belongs in ExpressionBuilder
	 */
	public boolean conflicts(ExpressionNode constraint, ExpressionNode valuation) {
		BDD nbdd = valuation.bdd(this);
		BDD ebdd = constraint.bdd(this).restrict(nbdd);
		if (ebdd.satCount() == 0) {
			return true;
		}
		return false;
	}
	
	public int numOfIdentifiers() {
		return identifiers.size();
	}
	
	public BDD var(int v) {
		return factory.ithVar(v);
	}

	/**
	 * @return BDD representing true
	 */
	public BDD one() {
		return factory.one();
	}
	
	/**
	 * @return BDD representing false
	 */
	public BDD zero() {
		return factory.zero();
	}
	
}
