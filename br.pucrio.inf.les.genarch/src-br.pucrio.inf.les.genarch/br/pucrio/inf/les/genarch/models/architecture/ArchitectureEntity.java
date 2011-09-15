/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getPath <em>Path</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getDependences <em>Dependences</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getReverseDependences <em>Reverse Dependences</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureEntity()
 * @model
 * @generated
 */
public interface ArchitectureEntity extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureEntity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureEntity_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Dependences</b></em>' reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependences</em>' reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureEntity_Dependences()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity"
	 * @generated
	 */
	EList getDependences();

	/**
	 * Returns the value of the '<em><b>Reverse Dependences</b></em>' reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse Dependences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse Dependences</em>' reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureEntity_ReverseDependences()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity"
	 * @generated
	 */
	EList getReverseDependences();

} // ArchitectureEntity
