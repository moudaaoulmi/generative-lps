/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ClassImpl#getDeclaredMethods <em>Declared Methods</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ClassImpl#getDeclaredFields <em>Declared Fields</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ClassImpl#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends AssetImpl implements br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class {
	/**
	 * The cached value of the '{@link #getDeclaredMethods() <em>Declared Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> declaredMethods;

	/**
	 * The cached value of the '{@link #getDeclaredFields() <em>Declared Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredFields()
	 * @generated
	 * @ordered
	 */
	protected EList<Field> declaredFields;

	/**
	 * The default value of the '{@link #getModifiers() <em>Modifiers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected static final String MODIFIERS_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected String modifiers = MODIFIERS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactanalysismodelPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getDeclaredMethods() {
		if (declaredMethods == null) {
			declaredMethods = new EObjectContainmentEList<Method>(Method.class, this, ImpactanalysismodelPackage.CLASS__DECLARED_METHODS);
		}
		return declaredMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getDeclaredFields() {
		if (declaredFields == null) {
			declaredFields = new EObjectContainmentEList<Field>(Field.class, this, ImpactanalysismodelPackage.CLASS__DECLARED_FIELDS);
		}
		return declaredFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModifiers() {
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiers(String newModifiers) {
		String oldModifiers = modifiers;
		modifiers = newModifiers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactanalysismodelPackage.CLASS__MODIFIERS, oldModifiers, modifiers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImpactanalysismodelPackage.CLASS__DECLARED_METHODS:
				return ((InternalEList<?>)getDeclaredMethods()).basicRemove(otherEnd, msgs);
			case ImpactanalysismodelPackage.CLASS__DECLARED_FIELDS:
				return ((InternalEList<?>)getDeclaredFields()).basicRemove(otherEnd, msgs);
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
			case ImpactanalysismodelPackage.CLASS__DECLARED_METHODS:
				return getDeclaredMethods();
			case ImpactanalysismodelPackage.CLASS__DECLARED_FIELDS:
				return getDeclaredFields();
			case ImpactanalysismodelPackage.CLASS__MODIFIERS:
				return getModifiers();
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
			case ImpactanalysismodelPackage.CLASS__DECLARED_METHODS:
				getDeclaredMethods().clear();
				getDeclaredMethods().addAll((Collection<? extends Method>)newValue);
				return;
			case ImpactanalysismodelPackage.CLASS__DECLARED_FIELDS:
				getDeclaredFields().clear();
				getDeclaredFields().addAll((Collection<? extends Field>)newValue);
				return;
			case ImpactanalysismodelPackage.CLASS__MODIFIERS:
				setModifiers((String)newValue);
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
			case ImpactanalysismodelPackage.CLASS__DECLARED_METHODS:
				getDeclaredMethods().clear();
				return;
			case ImpactanalysismodelPackage.CLASS__DECLARED_FIELDS:
				getDeclaredFields().clear();
				return;
			case ImpactanalysismodelPackage.CLASS__MODIFIERS:
				setModifiers(MODIFIERS_EDEFAULT);
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
			case ImpactanalysismodelPackage.CLASS__DECLARED_METHODS:
				return declaredMethods != null && !declaredMethods.isEmpty();
			case ImpactanalysismodelPackage.CLASS__DECLARED_FIELDS:
				return declaredFields != null && !declaredFields.isEmpty();
			case ImpactanalysismodelPackage.CLASS__MODIFIERS:
				return MODIFIERS_EDEFAULT == null ? modifiers != null : !MODIFIERS_EDEFAULT.equals(modifiers);
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
		result.append(" (Modifiers: ");
		result.append(modifiers);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
