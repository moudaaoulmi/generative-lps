/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel;

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
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getConstraintExpression <em>Constraint Expression</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getAssociatedFeatures <em>Associated Features</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getConstraintType <em>Constraint Type</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getFeatureTarget <em>Feature Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getConstraint()
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
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getConstraint_ConstraintExpression()
	 * @model
	 * @generated
	 */
	String getConstraintExpression();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getConstraintExpression <em>Constraint Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Expression</em>' attribute.
	 * @see #getConstraintExpression()
	 * @generated
	 */
	void setConstraintExpression(String value);

	/**
	 * Returns the value of the '<em><b>Associated Features</b></em>' reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Features</em>' reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getConstraint_AssociatedFeatures()
	 * @model
	 * @generated
	 */
	EList<Feature> getAssociatedFeatures();

	/**
	 * Returns the value of the '<em><b>Constraint Type</b></em>' attribute.
	 * The literals are from the enumeration {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Type</em>' attribute.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type
	 * @see #setConstraintType(Type)
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getConstraint_ConstraintType()
	 * @model
	 * @generated
	 */
	Type getConstraintType();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getConstraintType <em>Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Type</em>' attribute.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type
	 * @see #getConstraintType()
	 * @generated
	 */
	void setConstraintType(Type value);

	/**
	 * Returns the value of the '<em><b>Feature Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Target</em>' reference.
	 * @see #setFeatureTarget(Feature)
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getConstraint_FeatureTarget()
	 * @model required="true"
	 * @generated
	 */
	Feature getFeatureTarget();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getFeatureTarget <em>Feature Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Target</em>' reference.
	 * @see #getFeatureTarget()
	 * @generated
	 */
	void setFeatureTarget(Feature value);

} // Constraint
