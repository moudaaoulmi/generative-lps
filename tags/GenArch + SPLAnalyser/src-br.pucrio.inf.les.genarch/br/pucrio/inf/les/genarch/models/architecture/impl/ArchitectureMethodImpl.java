/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;
import br.pucrio.inf.les.genarch.models.architecture.CodePiece;

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
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureMethodImpl#getMethodDeclaration <em>Method Declaration</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureMethodImpl#getCodePieceRef <em>Code Piece Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureMethodImpl extends ArchitectureEntityImpl implements ArchitectureMethod {
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
	 * The cached value of the '{@link #getCodePieceRef() <em>Code Piece Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodePieceRef()
	 * @generated
	 * @ordered
	 */
	protected EList codePieceRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.ARCHITECTURE_METHOD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_METHOD__METHOD_DECLARATION, oldMethodDeclaration, methodDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCodePieceRef() {
		if (codePieceRef == null) {
			codePieceRef = new EObjectContainmentEList(CodePiece.class, this, ArchitecturePackage.ARCHITECTURE_METHOD__CODE_PIECE_REF);
		}
		return codePieceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_METHOD__CODE_PIECE_REF:
				return ((InternalEList)getCodePieceRef()).basicRemove(otherEnd, msgs);
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
			case ArchitecturePackage.ARCHITECTURE_METHOD__METHOD_DECLARATION:
				return getMethodDeclaration();
			case ArchitecturePackage.ARCHITECTURE_METHOD__CODE_PIECE_REF:
				return getCodePieceRef();
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
			case ArchitecturePackage.ARCHITECTURE_METHOD__METHOD_DECLARATION:
				setMethodDeclaration((String)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_METHOD__CODE_PIECE_REF:
				getCodePieceRef().clear();
				getCodePieceRef().addAll((Collection)newValue);
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
			case ArchitecturePackage.ARCHITECTURE_METHOD__METHOD_DECLARATION:
				setMethodDeclaration(METHOD_DECLARATION_EDEFAULT);
				return;
			case ArchitecturePackage.ARCHITECTURE_METHOD__CODE_PIECE_REF:
				getCodePieceRef().clear();
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
			case ArchitecturePackage.ARCHITECTURE_METHOD__METHOD_DECLARATION:
				return METHOD_DECLARATION_EDEFAULT == null ? methodDeclaration != null : !METHOD_DECLARATION_EDEFAULT.equals(methodDeclaration);
			case ArchitecturePackage.ARCHITECTURE_METHOD__CODE_PIECE_REF:
				return codePieceRef != null && !codePieceRef.isEmpty();
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

} //ArchitectureMethodImpl
