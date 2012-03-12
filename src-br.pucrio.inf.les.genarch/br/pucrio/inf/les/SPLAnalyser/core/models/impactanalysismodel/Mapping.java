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
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getFeatures <em>Features</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getAssets <em>Assets</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getUseCases <em>Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getMapping_Features()
	 * @model
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Assets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assets</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assets</em>' reference.
	 * @see #setAssets(Asset)
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getMapping_Assets()
	 * @model required="true"
	 * @generated
	 */
	Asset getAssets();

	/**
	 * Sets the value of the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getAssets <em>Assets</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assets</em>' reference.
	 * @see #getAssets()
	 * @generated
	 */
	void setAssets(Asset value);

	/**
	 * Returns the value of the '<em><b>Use Cases</b></em>' reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Cases</em>' reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage#getMapping_UseCases()
	 * @model
	 * @generated
	 */
	EList<UseCase> getUseCases();

} // Mapping
