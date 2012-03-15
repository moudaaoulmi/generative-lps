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
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link impactanalysismodel.Feature#getName <em>Name</em>}</li>
 *   <li>{@link impactanalysismodel.Feature#getType <em>Type</em>}</li>
 *   <li>{@link impactanalysismodel.Feature#getFeatureChild <em>Feature Child</em>}</li>
 *   <li>{@link impactanalysismodel.Feature#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see impactanalysismodel.ImpactanalysismodelPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getFeature_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link impactanalysismodel.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link impactanalysismodel.FeatureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see impactanalysismodel.FeatureType
	 * @see #setType(FeatureType)
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getFeature_Type()
	 * @model
	 * @generated
	 */
	FeatureType getType();

	/**
	 * Sets the value of the '{@link impactanalysismodel.Feature#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see impactanalysismodel.FeatureType
	 * @see #getType()
	 * @generated
	 */
	void setType(FeatureType value);

	/**
	 * Returns the value of the '<em><b>Feature Child</b></em>' containment reference list.
	 * The list contents are of type {@link impactanalysismodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Child</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Child</em>' containment reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getFeature_FeatureChild()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getFeatureChild();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link impactanalysismodel.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getFeature_Constraints()
	 * @model
	 * @generated
	 */
	EList<Constraint> getConstraints();

} // Feature
