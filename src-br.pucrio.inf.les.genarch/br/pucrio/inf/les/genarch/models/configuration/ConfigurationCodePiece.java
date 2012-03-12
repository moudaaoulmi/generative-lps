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
 * A representation of the model object '<em><b>Code Piece</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.configuration.ConfigurationCodePiece#getCodePieces <em>Code Pieces</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationCodePiece()
 * @model
 * @generated
 */
public interface ConfigurationCodePiece extends MappingEntity {
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
	 * @see br.pucrio.inf.les.genarch.models.configuration.ConfigurationPackage#getConfigurationCodePiece_CodePieces()
	 * @model type="br.pucrio.inf.les.genarch.models.configuration.ConfigurationCodePiece" containment="true"
	 * @generated
	 */
	EList getCodePieces();

} // ConfigurationCodePiece
