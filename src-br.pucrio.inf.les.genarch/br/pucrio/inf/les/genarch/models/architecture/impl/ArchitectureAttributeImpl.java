/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureAttributeImpl#getAttributDeclaration <em>Attribut Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureAttributeImpl extends ArchitectureEntityImpl implements ArchitectureAttribute {
	/**
	 * The default value of the '{@link #getAttributDeclaration() <em>Attribut Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributDeclaration()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUT_DECLARATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributDeclaration() <em>Attribut Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributDeclaration()
	 * @generated
	 * @ordered
	 */
	protected String attributDeclaration = ATTRIBUT_DECLARATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.ARCHITECTURE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributDeclaration() {
		return attributDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributDeclaration(String newAttributDeclaration) {
		String oldAttributDeclaration = attributDeclaration;
		attributDeclaration = newAttributDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_ATTRIBUTE__ATTRIBUT_DECLARATION, oldAttributDeclaration, attributDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_ATTRIBUTE__ATTRIBUT_DECLARATION:
				return getAttributDeclaration();
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
			case ArchitecturePackage.ARCHITECTURE_ATTRIBUTE__ATTRIBUT_DECLARATION:
				setAttributDeclaration((String)newValue);
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
			case ArchitecturePackage.ARCHITECTURE_ATTRIBUTE__ATTRIBUT_DECLARATION:
				setAttributDeclaration(ATTRIBUT_DECLARATION_EDEFAULT);
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
			case ArchitecturePackage.ARCHITECTURE_ATTRIBUTE__ATTRIBUT_DECLARATION:
				return ATTRIBUT_DECLARATION_EDEFAULT == null ? attributDeclaration != null : !ATTRIBUT_DECLARATION_EDEFAULT.equals(attributDeclaration);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (AttributDeclaration: ");
		result.append(attributDeclaration);
		result.append(')');
		return result.toString();
	}

} //ArchitectureAttributeImpl
