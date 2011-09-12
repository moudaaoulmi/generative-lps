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
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass#getMethods <em>Methods</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationClass()
 * @model
 * @generated
 */
public interface ConfigurationClass extends MappingEntity {
	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationClass_Methods()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationMethod" containment="true"
	 * @generated
	 */
	EList getMethods();

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationClass_Fields()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationField" containment="true"
	 * @generated
	 */
	EList getFields();

} // ConfigurationClass
