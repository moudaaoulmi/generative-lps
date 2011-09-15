/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass#getMethodRef <em>Method Ref</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass#getAttributeRef <em>Attribute Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureClass()
 * @model
 * @generated
 */
public interface ArchitectureClass extends ArchitectureEntity {
	/**
	 * Returns the value of the '<em><b>Method Ref</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Ref</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Ref</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureClass_MethodRef()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureMethod" containment="true"
	 * @generated
	 */
	EList getMethodRef();

	/**
	 * Returns the value of the '<em><b>Attribute Ref</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Ref</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Ref</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureClass_AttributeRef()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute" containment="true"
	 * @generated
	 */
	EList getAttributeRef();

} // ArchitectureClass
