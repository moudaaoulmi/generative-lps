/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.impl;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity;
import br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureEntityImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureEntityImpl#getPath <em>Path</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureEntityImpl#getDependences <em>Dependences</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.impl.ArchitectureEntityImpl#getReverseDependences <em>Reverse Dependences</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitectureEntityImpl extends EObjectImpl implements ArchitectureEntity {
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
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependences() <em>Dependences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependences()
	 * @generated
	 * @ordered
	 */
	protected EList dependences;

	/**
	 * The cached value of the '{@link #getReverseDependences() <em>Reverse Dependences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverseDependences()
	 * @generated
	 * @ordered
	 */
	protected EList reverseDependences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitectureEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.ARCHITECTURE_ENTITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_ENTITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.ARCHITECTURE_ENTITY__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDependences() {
		if (dependences == null) {
			dependences = new EObjectResolvingEList(ArchitectureEntity.class, this, ArchitecturePackage.ARCHITECTURE_ENTITY__DEPENDENCES);
		}
		return dependences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getReverseDependences() {
		if (reverseDependences == null) {
			reverseDependences = new EObjectResolvingEList(ArchitectureEntity.class, this, ArchitecturePackage.ARCHITECTURE_ENTITY__REVERSE_DEPENDENCES);
		}
		return reverseDependences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.ARCHITECTURE_ENTITY__NAME:
				return getName();
			case ArchitecturePackage.ARCHITECTURE_ENTITY__PATH:
				return getPath();
			case ArchitecturePackage.ARCHITECTURE_ENTITY__DEPENDENCES:
				return getDependences();
			case ArchitecturePackage.ARCHITECTURE_ENTITY__REVERSE_DEPENDENCES:
				return getReverseDependences();
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
			case ArchitecturePackage.ARCHITECTURE_ENTITY__NAME:
				setName((String)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_ENTITY__PATH:
				setPath((String)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_ENTITY__DEPENDENCES:
				getDependences().clear();
				getDependences().addAll((Collection)newValue);
				return;
			case ArchitecturePackage.ARCHITECTURE_ENTITY__REVERSE_DEPENDENCES:
				getReverseDependences().clear();
				getReverseDependences().addAll((Collection)newValue);
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
			case ArchitecturePackage.ARCHITECTURE_ENTITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArchitecturePackage.ARCHITECTURE_ENTITY__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case ArchitecturePackage.ARCHITECTURE_ENTITY__DEPENDENCES:
				getDependences().clear();
				return;
			case ArchitecturePackage.ARCHITECTURE_ENTITY__REVERSE_DEPENDENCES:
				getReverseDependences().clear();
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
			case ArchitecturePackage.ARCHITECTURE_ENTITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArchitecturePackage.ARCHITECTURE_ENTITY__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case ArchitecturePackage.ARCHITECTURE_ENTITY__DEPENDENCES:
				return dependences != null && !dependences.isEmpty();
			case ArchitecturePackage.ARCHITECTURE_ENTITY__REVERSE_DEPENDENCES:
				return reverseDependences != null && !reverseDependences.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //ArchitectureEntityImpl