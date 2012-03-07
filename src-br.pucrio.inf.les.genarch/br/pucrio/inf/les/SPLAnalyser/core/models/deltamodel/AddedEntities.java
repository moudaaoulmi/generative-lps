/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Added Entities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getFeatures <em>Features</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getAssets <em>Assets</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getMappings <em>Mappings</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getAssetDependencies <em>Asset Dependencies</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getFeatureConstraints <em>Feature Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getAddedEntities()
 * @model
 * @generated
 */
public interface AddedEntities extends EObject {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getAddedEntities_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Assets</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assets</em>' containment reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getAddedEntities_Assets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Asset> getAssets();

	/**
	 * Returns the value of the '<em><b>Use Cases</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Cases</em>' containment reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getAddedEntities_UseCases()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCase> getUseCases();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getAddedEntities_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Asset Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asset Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asset Dependencies</em>' containment reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getAddedEntities_AssetDependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dependencie> getAssetDependencies();

	/**
	 * Returns the value of the '<em><b>Feature Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Constraints</em>' containment reference list.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#getAddedEntities_FeatureConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getFeatureConstraints();

} // AddedEntities
