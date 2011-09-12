/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute#getAttributDeclaration <em>Attribut Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureAttribute()
 * @model
 * @generated
 */
public interface ArchitectureAttribute extends ArchitectureEntity {
	/**
	 * Returns the value of the '<em><b>Attribut Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribut Declaration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribut Declaration</em>' attribute.
	 * @see #setAttributDeclaration(String)
	 * @see br.pucrio.inf.les.genarch.models.architecture.ArchitecturePackage#getArchitectureAttribute_AttributDeclaration()
	 * @model
	 * @generated
	 */
	String getAttributDeclaration();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.genarch.models.architecture.ArchitectureAttribute#getAttributDeclaration <em>Attribut Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribut Declaration</em>' attribute.
	 * @see #getAttributDeclaration()
	 * @generated
	 */
	void setAttributDeclaration(String value);

} // ArchitectureAttribute
