/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod#getMethodDeclaration <em>Method Declaration</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod#getCodePieces <em>Code Pieces</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationMethod()
 * @model
 * @generated
 */
public interface ConfigurationMethod extends MappingEntity {
	/**
	 * Returns the value of the '<em><b>Method Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Declaration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Declaration</em>' attribute.
	 * @see #setMethodDeclaration(String)
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationMethod_MethodDeclaration()
	 * @model
	 * @generated
	 */
	String getMethodDeclaration();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod#getMethodDeclaration <em>Method Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Declaration</em>' attribute.
	 * @see #getMethodDeclaration()
	 * @generated
	 */
	void setMethodDeclaration(String value);

	/**
	 * Returns the value of the '<em><b>Code Pieces</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationCodePiece}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code Pieces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code Pieces</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationMethod_CodePieces()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationCodePiece" containment="true"
	 * @generated
	 */
	EList getCodePieces();

} // ConfigurationMethod
