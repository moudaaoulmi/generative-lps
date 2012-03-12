/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.ChangedEntities;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Changed Entities</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.ChangedEntitiesImpl#getFeatureType <em>Feature Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangedEntitiesImpl extends EObjectImpl implements ChangedEntities {
	/**
	 * The cached value of the '{@link #getFeatureType() <em>Feature Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureType()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureChange> featureType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangedEntitiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltamodelPackage.Literals.CHANGED_ENTITIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureChange> getFeatureType() {
		if (featureType == null) {
			featureType = new EObjectContainmentEList<FeatureChange>(FeatureChange.class, this, DeltamodelPackage.CHANGED_ENTITIES__FEATURE_TYPE);
		}
		return featureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltamodelPackage.CHANGED_ENTITIES__FEATURE_TYPE:
				return ((InternalEList<?>)getFeatureType()).basicRemove(otherEnd, msgs);
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
			case DeltamodelPackage.CHANGED_ENTITIES__FEATURE_TYPE:
				return getFeatureType();
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
			case DeltamodelPackage.CHANGED_ENTITIES__FEATURE_TYPE:
				getFeatureType().clear();
				getFeatureType().addAll((Collection<? extends FeatureChange>)newValue);
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
			case DeltamodelPackage.CHANGED_ENTITIES__FEATURE_TYPE:
				getFeatureType().clear();
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
			case DeltamodelPackage.CHANGED_ENTITIES__FEATURE_TYPE:
				return featureType != null && !featureType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ChangedEntitiesImpl
