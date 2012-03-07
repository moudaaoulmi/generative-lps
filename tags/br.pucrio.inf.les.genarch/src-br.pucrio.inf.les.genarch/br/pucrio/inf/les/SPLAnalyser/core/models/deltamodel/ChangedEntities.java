/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Changed Entities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.ChangedEntities#getFeatureType <em>Feature Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getChangedEntities()
 * @model
 * @generated
 */
public interface ChangedEntities extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature Type</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Type</em>' containment reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getChangedEntities_FeatureType()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureChange> getFeatureType();

} // ChangedEntities
