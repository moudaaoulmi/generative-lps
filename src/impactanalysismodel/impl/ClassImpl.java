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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link impactanalysismodel.impl.ClassImpl#getDeclaredMethods <em>Declared Methods</em>}</li>
 *   <li>{@link impactanalysismodel.impl.ClassImpl#getDeclaredFields <em>Declared Fields</em>}</li>
 *   <li>{@link impactanalysismodel.impl.ClassImpl#getClassDependencies <em>Class Dependencies</em>}</li>
 *   <li>{@link impactanalysismodel.impl.ClassImpl#getFieldDependencies <em>Field Dependencies</em>}</li>
 *   <li>{@link impactanalysismodel.impl.ClassImpl#getMethodDependencies <em>Method Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends AssetImpl implements impactanalysismodel.Class {
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
	 * The cached value of the '{@link #getClassDependencies() <em>Class Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<impactanalysismodel.Class> classDependencies;

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
	 * The cached value of the '{@link #getMethodDependencies() <em>Method Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methodDependencies;

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
	public EList<impactanalysismodel.Class> getClassDependencies() {
		if (classDependencies == null) {
			classDependencies = new EObjectResolvingEList<impactanalysismodel.Class>(impactanalysismodel.Class.class, this, ImpactanalysismodelPackage.CLASS__CLASS_DEPENDENCIES);
		}
		return classDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getFieldDependencies() {
		if (fieldDependencies == null) {
			fieldDependencies = new EObjectResolvingEList<Field>(Field.class, this, ImpactanalysismodelPackage.CLASS__FIELD_DEPENDENCIES);
		}
		return fieldDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethodDependencies() {
		if (methodDependencies == null) {
			methodDependencies = new EObjectResolvingEList<Method>(Method.class, this, ImpactanalysismodelPackage.CLASS__METHOD_DEPENDENCIES);
		}
		return methodDependencies;
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
			case ImpactanalysismodelPackage.CLASS__CLASS_DEPENDENCIES:
				return getClassDependencies();
			case ImpactanalysismodelPackage.CLASS__FIELD_DEPENDENCIES:
				return getFieldDependencies();
			case ImpactanalysismodelPackage.CLASS__METHOD_DEPENDENCIES:
				return getMethodDependencies();
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
			case ImpactanalysismodelPackage.CLASS__CLASS_DEPENDENCIES:
				getClassDependencies().clear();
				getClassDependencies().addAll((Collection<? extends impactanalysismodel.Class>)newValue);
				return;
			case ImpactanalysismodelPackage.CLASS__FIELD_DEPENDENCIES:
				getFieldDependencies().clear();
				getFieldDependencies().addAll((Collection<? extends Field>)newValue);
				return;
			case ImpactanalysismodelPackage.CLASS__METHOD_DEPENDENCIES:
				getMethodDependencies().clear();
				getMethodDependencies().addAll((Collection<? extends Method>)newValue);
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
			case ImpactanalysismodelPackage.CLASS__CLASS_DEPENDENCIES:
				getClassDependencies().clear();
				return;
			case ImpactanalysismodelPackage.CLASS__FIELD_DEPENDENCIES:
				getFieldDependencies().clear();
				return;
			case ImpactanalysismodelPackage.CLASS__METHOD_DEPENDENCIES:
				getMethodDependencies().clear();
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
			case ImpactanalysismodelPackage.CLASS__CLASS_DEPENDENCIES:
				return classDependencies != null && !classDependencies.isEmpty();
			case ImpactanalysismodelPackage.CLASS__FIELD_DEPENDENCIES:
				return fieldDependencies != null && !fieldDependencies.isEmpty();
			case ImpactanalysismodelPackage.CLASS__METHOD_DEPENDENCIES:
				return methodDependencies != null && !methodDependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassImpl
