/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package impactanalysismodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link impactanalysismodel.Constraint#getConstraintExpression <em>Constraint Expression</em>}</li>
 *   <li>{@link impactanalysismodel.Constraint#getAssociatedFeatures <em>Associated Features</em>}</li>
 *   <li>{@link impactanalysismodel.Constraint#getConstraintType <em>Constraint Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see impactanalysismodel.ImpactanalysismodelPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraint Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Expression</em>' attribute.
	 * @see #setConstraintExpression(String)
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getConstraint_ConstraintExpression()
	 * @model
	 * @generated
	 */
	String getConstraintExpression();

	/**
	 * Sets the value of the '{@link impactanalysismodel.Constraint#getConstraintExpression <em>Constraint Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Expression</em>' attribute.
	 * @see #getConstraintExpression()
	 * @generated
	 */
	void setConstraintExpression(String value);

	/**
	 * Returns the value of the '<em><b>Associated Features</b></em>' reference list.
	 * The list contents are of type {@link impactanalysismodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Features</em>' reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getConstraint_AssociatedFeatures()
	 * @model
	 * @generated
	 */
	EList<Feature> getAssociatedFeatures();

	/**
	 * Returns the value of the '<em><b>Constraint Type</b></em>' attribute.
	 * The literals are from the enumeration {@link impactanalysismodel.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Type</em>' attribute.
	 * @see impactanalysismodel.Type
	 * @see #setConstraintType(Type)
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getConstraint_ConstraintType()
	 * @model
	 * @generated
	 */
	Type getConstraintType();

	/**
	 * Sets the value of the '{@link impactanalysismodel.Constraint#getConstraintType <em>Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Type</em>' attribute.
	 * @see impactanalysismodel.Type
	 * @see #getConstraintType()
	 * @generated
	 */
	void setConstraintType(Type value);

} // Constraint
