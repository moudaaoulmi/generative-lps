/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

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
 * An implementation of the model object '<em><b>Code Piece</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.CodePieceImpl#getStart <em>Start</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.CodePieceImpl#getEnd <em>End</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.CodePieceImpl#getCode <em>Code</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.CodePieceImpl#getCodePieceRef <em>Code Piece Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodePieceImpl extends ArchitectureEntityImpl implements CodePiece {
	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final int START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected int start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected static final int END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected int end = END_EDEFAULT;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected String code = CODE_EDEFAULT;

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
	protected CodePieceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.CODE_PIECE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(int newStart) {
		int oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.CODE_PIECE__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(int newEnd) {
		int oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.CODE_PIECE__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(String newCode) {
		String oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.CODE_PIECE__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCodePieceRef() {
		if (codePieceRef == null) {
			codePieceRef = new EObjectContainmentEList(CodePiece.class, this, ArchitecturePackage.CODE_PIECE__CODE_PIECE_REF);
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
			case ArchitecturePackage.CODE_PIECE__CODE_PIECE_REF:
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
			case ArchitecturePackage.CODE_PIECE__START:
				return new Integer(getStart());
			case ArchitecturePackage.CODE_PIECE__END:
				return new Integer(getEnd());
			case ArchitecturePackage.CODE_PIECE__CODE:
				return getCode();
			case ArchitecturePackage.CODE_PIECE__CODE_PIECE_REF:
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
			case ArchitecturePackage.CODE_PIECE__START:
				setStart(((Integer)newValue).intValue());
				return;
			case ArchitecturePackage.CODE_PIECE__END:
				setEnd(((Integer)newValue).intValue());
				return;
			case ArchitecturePackage.CODE_PIECE__CODE:
				setCode((String)newValue);
				return;
			case ArchitecturePackage.CODE_PIECE__CODE_PIECE_REF:
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
			case ArchitecturePackage.CODE_PIECE__START:
				setStart(START_EDEFAULT);
				return;
			case ArchitecturePackage.CODE_PIECE__END:
				setEnd(END_EDEFAULT);
				return;
			case ArchitecturePackage.CODE_PIECE__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case ArchitecturePackage.CODE_PIECE__CODE_PIECE_REF:
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
			case ArchitecturePackage.CODE_PIECE__START:
				return start != START_EDEFAULT;
			case ArchitecturePackage.CODE_PIECE__END:
				return end != END_EDEFAULT;
			case ArchitecturePackage.CODE_PIECE__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case ArchitecturePackage.CODE_PIECE__CODE_PIECE_REF:
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
		result.append(" (Start: ");
		result.append(start);
		result.append(", End: ");
		result.append(end);
		result.append(", Code: ");
		result.append(code);
		result.append(')');
		return result.toString();
	}

} //CodePieceImpl
