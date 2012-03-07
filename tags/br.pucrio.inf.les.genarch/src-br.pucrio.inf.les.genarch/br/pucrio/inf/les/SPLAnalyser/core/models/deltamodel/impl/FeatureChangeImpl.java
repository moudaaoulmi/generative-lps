/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.FeatureChangeImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.FeatureChangeImpl#getPreviousValue <em>Previous Value</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.FeatureChangeImpl#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureChangeImpl extends EObjectImpl implements FeatureChange {
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
	 * The default value of the '{@link #getPreviousValue() <em>Previous Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousValue()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureType PREVIOUS_VALUE_EDEFAULT = FeatureType.OPTIONAL;

	/**
	 * The cached value of the '{@link #getPreviousValue() <em>Previous Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousValue()
	 * @generated
	 * @ordered
	 */
	protected FeatureType previousValue = PREVIOUS_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureType NEW_VALUE_EDEFAULT = FeatureType.OPTIONAL;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected FeatureType newValue = NEW_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltamodelPackage.Literals.FEATURE_CHANGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DeltamodelPackage.FEATURE_CHANGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType getPreviousValue() {
		return previousValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousValue(FeatureType newPreviousValue) {
		FeatureType oldPreviousValue = previousValue;
		previousValue = newPreviousValue == null ? PREVIOUS_VALUE_EDEFAULT : newPreviousValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltamodelPackage.FEATURE_CHANGE__PREVIOUS_VALUE, oldPreviousValue, previousValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType getNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(FeatureType newNewValue) {
		FeatureType oldNewValue = newValue;
		newValue = newNewValue == null ? NEW_VALUE_EDEFAULT : newNewValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeltamodelPackage.FEATURE_CHANGE__NEW_VALUE, oldNewValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeltamodelPackage.FEATURE_CHANGE__NAME:
				return getName();
			case DeltamodelPackage.FEATURE_CHANGE__PREVIOUS_VALUE:
				return getPreviousValue();
			case DeltamodelPackage.FEATURE_CHANGE__NEW_VALUE:
				return getNewValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DeltamodelPackage.FEATURE_CHANGE__NAME:
				setName((String)newValue);
				return;
			case DeltamodelPackage.FEATURE_CHANGE__PREVIOUS_VALUE:
				setPreviousValue((FeatureType)newValue);
				return;
			case DeltamodelPackage.FEATURE_CHANGE__NEW_VALUE:
				setNewValue((FeatureType)newValue);
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
			case DeltamodelPackage.FEATURE_CHANGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DeltamodelPackage.FEATURE_CHANGE__PREVIOUS_VALUE:
				setPreviousValue(PREVIOUS_VALUE_EDEFAULT);
				return;
			case DeltamodelPackage.FEATURE_CHANGE__NEW_VALUE:
				setNewValue(NEW_VALUE_EDEFAULT);
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
			case DeltamodelPackage.FEATURE_CHANGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DeltamodelPackage.FEATURE_CHANGE__PREVIOUS_VALUE:
				return previousValue != PREVIOUS_VALUE_EDEFAULT;
			case DeltamodelPackage.FEATURE_CHANGE__NEW_VALUE:
				return newValue != NEW_VALUE_EDEFAULT;
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
		result.append(", PreviousValue: ");
		result.append(previousValue);
		result.append(", NewValue: ");
		result.append(newValue);
		result.append(')');
		return result.toString();
	}

} //FeatureChangeImpl
