/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureClassImpl#getMethodRef <em>Method Ref</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureClassImpl#getAttributeRef <em>Attribute Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureClassImpl extends ArchitectureEntityImpl implements ArchitectureClass {
	/**
	 * The cached value of the '{@link #getMethodRef() <em>Method Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodRef()
	 * @generated
	 * @ordered
	 */
	protected EList methodRef;

	/**
	 * The cached value of the '{@link #getAttributeRef() <em>Attribute Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeRef()
	 * @generated
	 * @ordered
	 */
	protected EList attributeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.ARCHITECTURE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMethodRef() {
		if (methodRef == null) {
			methodRef = new EObjectContainmentEList(ArchitectureMethod.class, this, ArchitecturePackage.ARCHITECTURE_CLASS__METHOD_REF);
		}
		return methodRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAttributeRef() {
		if (attributeRef == null) {
			attributeRef = new EObjectContainmentEList(ArchitectureAttribute.class, this, ArchitecturePackage.ARCHITECTURE_CLASS__ATTRIBUTE_REF);
		}
		return attributeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_CLASS__METHOD_REF:
				return ((InternalEList)getMethodRef()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.ARCHITECTURE_CLASS__ATTRIBUTE_REF:
				return ((InternalEList)getAttributeRef()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_CLASS__METHOD_REF:
				return getMethodRef();
			case ArchitecturePackage.ARCHITECTURE_CLASS__ATTRIBUTE_REF:
				return getAttributeRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_CLASS__METHOD_REF:
				getMethodRef().clear();
				getMethodRef().addAll((Collection)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_CLASS__ATTRIBUTE_REF:
				getAttributeRef().clear();
				getAttributeRef().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_CLASS__METHOD_REF:
				getMethodRef().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_CLASS__ATTRIBUTE_REF:
				getAttributeRef().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_CLASS__METHOD_REF:
				return methodRef != null && !methodRef.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_CLASS__ATTRIBUTE_REF:
				return attributeRef != null && !attributeRef.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitectureClassImpl
