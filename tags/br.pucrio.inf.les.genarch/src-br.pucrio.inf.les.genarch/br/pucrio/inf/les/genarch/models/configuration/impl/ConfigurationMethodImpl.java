/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration.impl;

import br.pucrio.inf.les.genarch.models.configuration.ConfigurationCodePiece;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage;

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
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationMethodImpl#getMethodDeclaration <em>Method Declaration</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.impl.ConfigurationMethodImpl#getCodePieces <em>Code Pieces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationMethodImpl extends MappingEntityImpl implements ConfigurationMethod {
	/**
	 * The default value of the '{@link #getMethodDeclaration() <em>Method Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodDeclaration()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_DECLARATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethodDeclaration() <em>Method Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodDeclaration()
	 * @generated
	 * @ordered
	 */
	protected String methodDeclaration = METHOD_DECLARATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCodePieces() <em>Code Pieces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodePieces()
	 * @generated
	 * @ordered
	 */
	protected EList codePieces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.CONFIGURATION_METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodDeclaration() {
		return methodDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodDeclaration(String newMethodDeclaration) {
		String oldMethodDeclaration = methodDeclaration;
		methodDeclaration = newMethodDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.CONFIGURATION_METHOD__METHOD_DECLARATION, oldMethodDeclaration, methodDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCodePieces() {
		if (codePieces == null) {
			codePieces = new EObjectContainmentEList(ConfigurationCodePiece.class, this, ConfigurationPackage.CONFIGURATION_METHOD__CODE_PIECES);
		}
		return codePieces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.CONFIGURATION_METHOD__CODE_PIECES:
				return ((InternalEList)getCodePieces()).basicRemove(otherEnd, msgs);
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
			case ConfigurationPackage.CONFIGURATION_METHOD__METHOD_DECLARATION:
				return getMethodDeclaration();
			case ConfigurationPackage.CONFIGURATION_METHOD__CODE_PIECES:
				return getCodePieces();
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
			case ConfigurationPackage.CONFIGURATION_METHOD__METHOD_DECLARATION:
				setMethodDeclaration((String)newValue);
				return;
			case ConfigurationPackage.CONFIGURATION_METHOD__CODE_PIECES:
				getCodePieces().clear();
				getCodePieces().addAll((Collection)newValue);
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
			case ConfigurationPackage.CONFIGURATION_METHOD__METHOD_DECLARATION:
				setMethodDeclaration(METHOD_DECLARATION_EDEFAULT);
				return;
			case ConfigurationPackage.CONFIGURATION_METHOD__CODE_PIECES:
				getCodePieces().clear();
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
			case ConfigurationPackage.CONFIGURATION_METHOD__METHOD_DECLARATION:
				return METHOD_DECLARATION_EDEFAULT == null ? methodDeclaration != null : !METHOD_DECLARATION_EDEFAULT.equals(methodDeclaration);
			case ConfigurationPackage.CONFIGURATION_METHOD__CODE_PIECES:
				return codePieces != null && !codePieces.isEmpty();
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
		result.append(" (MethodDeclaration: ");
		result.append(methodDeclaration);
		result.append(')');
		return result.toString();
	}

} //ConfigurationMethodImpl
