/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod#getMethodDeclaration <em>Method Declaration</em>}</li>
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

} // ConfigurationMethod
