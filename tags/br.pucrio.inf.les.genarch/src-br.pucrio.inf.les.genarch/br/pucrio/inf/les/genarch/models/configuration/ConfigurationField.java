/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationField#getFieldDeclaration <em>Field Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationField()
 * @model
 * @generated
 */
public interface ConfigurationField extends MappingEntity {
	/**
	 * Returns the value of the '<em><b>Field Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Declaration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Declaration</em>' attribute.
	 * @see #setFieldDeclaration(String)
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationField_FieldDeclaration()
	 * @model
	 * @generated
	 */
	String getFieldDeclaration();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationField#getFieldDeclaration <em>Field Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Declaration</em>' attribute.
	 * @see #getFieldDeclaration()
	 * @generated
	 */
	void setFieldDeclaration(String value);

} // ConfigurationField
