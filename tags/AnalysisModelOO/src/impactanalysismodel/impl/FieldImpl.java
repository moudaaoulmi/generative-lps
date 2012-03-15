/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package impactanalysismodel.impl;

import impactanalysismodel.Field;
import impactanalysismodel.ImpactanalysismodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link impactanalysismodel.impl.FieldImpl#getClassDependencies <em>Class Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldImpl extends AssetImpl implements Field {
	/**
	 * The cached value of the '{@link #getClassDependencies() <em>Class Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<impactanalysismodel.Class> classDependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactanalysismodelPackage.Literals.FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<impactanalysismodel.Class> getClassDependencies() {
		if (classDependencies == null) {
			classDependencies = new EObjectResolvingEList<impactanalysismodel.Class>(impactanalysismodel.Class.class, this, ImpactanalysismodelPackage.FIELD__CLASS_DEPENDENCIES);
		}
		return classDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpactanalysismodelPackage.FIELD__CLASS_DEPENDENCIES:
				return getClassDependencies();
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
			case ImpactanalysismodelPackage.FIELD__CLASS_DEPENDENCIES:
				getClassDependencies().clear();
				getClassDependencies().addAll((Collection<? extends impactanalysismodel.Class>)newValue);
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
			case ImpactanalysismodelPackage.FIELD__CLASS_DEPENDENCIES:
				getClassDependencies().clear();
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
			case ImpactanalysismodelPackage.FIELD__CLASS_DEPENDENCIES:
				return classDependencies != null && !classDependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FieldImpl
