/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package impactanalysismodel.impl;

import impactanalysismodel.Field;
import impactanalysismodel.ImpactanalysismodelPackage;
import impactanalysismodel.Method;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link impactanalysismodel.impl.MethodImpl#getMethodDependencies <em>Method Dependencies</em>}</li>
 *   <li>{@link impactanalysismodel.impl.MethodImpl#getFieldDependencies <em>Field Dependencies</em>}</li>
 *   <li>{@link impactanalysismodel.impl.MethodImpl#getClassDependencies <em>Class Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodImpl extends AssetImpl implements Method {
	/**
	 * The cached value of the '{@link #getMethodDependencies() <em>Method Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methodDependencies;

	/**
	 * The cached value of the '{@link #getFieldDependencies() <em>Field Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Field> fieldDependencies;

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
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactanalysismodelPackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethodDependencies() {
		if (methodDependencies == null) {
			methodDependencies = new EObjectResolvingEList<Method>(Method.class, this, ImpactanalysismodelPackage.METHOD__METHOD_DEPENDENCIES);
		}
		return methodDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getFieldDependencies() {
		if (fieldDependencies == null) {
			fieldDependencies = new EObjectResolvingEList<Field>(Field.class, this, ImpactanalysismodelPackage.METHOD__FIELD_DEPENDENCIES);
		}
		return fieldDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<impactanalysismodel.Class> getClassDependencies() {
		if (classDependencies == null) {
			classDependencies = new EObjectResolvingEList<impactanalysismodel.Class>(impactanalysismodel.Class.class, this, ImpactanalysismodelPackage.METHOD__CLASS_DEPENDENCIES);
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
			case ImpactanalysismodelPackage.METHOD__METHOD_DEPENDENCIES:
				return getMethodDependencies();
			case ImpactanalysismodelPackage.METHOD__FIELD_DEPENDENCIES:
				return getFieldDependencies();
			case ImpactanalysismodelPackage.METHOD__CLASS_DEPENDENCIES:
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
			case ImpactanalysismodelPackage.METHOD__METHOD_DEPENDENCIES:
				getMethodDependencies().clear();
				getMethodDependencies().addAll((Collection<? extends Method>)newValue);
				return;
			case ImpactanalysismodelPackage.METHOD__FIELD_DEPENDENCIES:
				getFieldDependencies().clear();
				getFieldDependencies().addAll((Collection<? extends Field>)newValue);
				return;
			case ImpactanalysismodelPackage.METHOD__CLASS_DEPENDENCIES:
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
			case ImpactanalysismodelPackage.METHOD__METHOD_DEPENDENCIES:
				getMethodDependencies().clear();
				return;
			case ImpactanalysismodelPackage.METHOD__FIELD_DEPENDENCIES:
				getFieldDependencies().clear();
				return;
			case ImpactanalysismodelPackage.METHOD__CLASS_DEPENDENCIES:
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
			case ImpactanalysismodelPackage.METHOD__METHOD_DEPENDENCIES:
				return methodDependencies != null && !methodDependencies.isEmpty();
			case ImpactanalysismodelPackage.METHOD__FIELD_DEPENDENCIES:
				return fieldDependencies != null && !fieldDependencies.isEmpty();
			case ImpactanalysismodelPackage.METHOD__CLASS_DEPENDENCIES:
				return classDependencies != null && !classDependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MethodImpl
