/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getName <em>Name</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getPreviousValue <em>Previous Value</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getFeatureChange()
 * @model
 * @generated
 */
public interface FeatureChange extends EObject {
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
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getFeatureChange_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Previous Value</b></em>' attribute.
	 * The literals are from the enumeration {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Value</em>' attribute.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType
	 * @see #setPreviousValue(FeatureType)
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getFeatureChange_PreviousValue()
	 * @model
	 * @generated
	 */
	FeatureType getPreviousValue();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getPreviousValue <em>Previous Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Value</em>' attribute.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType
	 * @see #getPreviousValue()
	 * @generated
	 */
	void setPreviousValue(FeatureType value);

	/**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute.
	 * The literals are from the enumeration {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType
	 * @see #setNewValue(FeatureType)
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getFeatureChange_NewValue()
	 * @model
	 * @generated
	 */
	FeatureType getNewValue();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getNewValue <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' attribute.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(FeatureType value);

} // FeatureChange
