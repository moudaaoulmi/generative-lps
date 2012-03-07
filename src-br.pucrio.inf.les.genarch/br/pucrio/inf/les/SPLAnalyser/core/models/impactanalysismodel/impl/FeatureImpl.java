/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl#getType <em>Type</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl#getFeatureChild <em>Feature Child</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl#isIsAlternative <em>Is Alternative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureType TYPE_EDEFAULT = FeatureType.OPTIONAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected FeatureType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatureChild() <em>Feature Child</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureChild()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> featureChild;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * The default value of the '{@link #isIsAlternative() <em>Is Alternative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAlternative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ALTERNATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAlternative() <em>Is Alternative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAlternative()
	 * @generated
	 * @ordered
	 */
	protected boolean isAlternative = IS_ALTERNATIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactanalysismodelPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactanalysismodelPackage.FEATURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(FeatureType newType) {
		FeatureType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactanalysismodelPackage.FEATURE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatureChild() {
		if (featureChild == null) {
			featureChild = new EObjectContainmentEList<Feature>(Feature.class, this, ImpactanalysismodelPackage.FEATURE__FEATURE_CHILD);
		}
		return featureChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectResolvingEList<Constraint>(Constraint.class, this, ImpactanalysismodelPackage.FEATURE__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAlternative() {
		return isAlternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAlternative(boolean newIsAlternative) {
		boolean oldIsAlternative = isAlternative;
		isAlternative = newIsAlternative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactanalysismodelPackage.FEATURE__IS_ALTERNATIVE, oldIsAlternative, isAlternative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImpactanalysismodelPackage.FEATURE__FEATURE_CHILD:
				return ((InternalEList<?>)getFeatureChild()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpactanalysismodelPackage.FEATURE__NAME:
				return getName();
			case ImpactanalysismodelPackage.FEATURE__TYPE:
				return getType();
			case ImpactanalysismodelPackage.FEATURE__FEATURE_CHILD:
				return getFeatureChild();
			case ImpactanalysismodelPackage.FEATURE__CONSTRAINTS:
				return getConstraints();
			case ImpactanalysismodelPackage.FEATURE__IS_ALTERNATIVE:
				return isIsAlternative();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpactanalysismodelPackage.FEATURE__NAME:
				setName((String)newValue);
				return;
			case ImpactanalysismodelPackage.FEATURE__TYPE:
				setType((FeatureType)newValue);
				return;
			case ImpactanalysismodelPackage.FEATURE__FEATURE_CHILD:
				getFeatureChild().clear();
				getFeatureChild().addAll((Collection<? extends Feature>)newValue);
				return;
			case ImpactanalysismodelPackage.FEATURE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case ImpactanalysismodelPackage.FEATURE__IS_ALTERNATIVE:
				setIsAlternative((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpactanalysismodelPackage.FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ImpactanalysismodelPackage.FEATURE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ImpactanalysismodelPackage.FEATURE__FEATURE_CHILD:
				getFeatureChild().clear();
				return;
			case ImpactanalysismodelPackage.FEATURE__CONSTRAINTS:
				getConstraints().clear();
				return;
			case ImpactanalysismodelPackage.FEATURE__IS_ALTERNATIVE:
				setIsAlternative(IS_ALTERNATIVE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpactanalysismodelPackage.FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ImpactanalysismodelPackage.FEATURE__TYPE:
				return type != TYPE_EDEFAULT;
			case ImpactanalysismodelPackage.FEATURE__FEATURE_CHILD:
				return featureChild != null && !featureChild.isEmpty();
			case ImpactanalysismodelPackage.FEATURE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case ImpactanalysismodelPackage.FEATURE__IS_ALTERNATIVE:
				return isAlternative != IS_ALTERNATIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Name: ");
		result.append(name);
		result.append(", Type: ");
		result.append(type);
		result.append(", isAlternative: ");
		result.append(isAlternative);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl
