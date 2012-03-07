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
 * A representation of the model object '<em><b>Code Piece</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.CodePiece#getStart <em>Start</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.CodePiece#getEnd <em>End</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.CodePiece#getCode <em>Code</em>}</li>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.CodePiece#getCodePieceRef <em>Code Piece Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getCodePiece()
 * @model
 * @generated
 */
public interface CodePiece extends ArchitectureEntity {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(int)
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getCodePiece_Start()
	 * @model
	 * @generated
	 */
	int getStart();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.architecture.CodePiece#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(int value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(int)
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getCodePiece_End()
	 * @model
	 * @generated
	 */
	int getEnd();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.architecture.CodePiece#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(int value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getCodePiece_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.architecture.CodePiece#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * Returns the value of the '<em><b>Code Piece Ref</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.genarch.models.architecture.CodePiece}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code Piece Ref</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code Piece Ref</em>' containment reference list.
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getCodePiece_CodePieceRef()
	 * @model type="br.pucrio.inf.les.genarch.models.architecture.CodePiece" containment="true"
	 * @generated
	 */
	EList getCodePieceRef();

} // CodePiece
