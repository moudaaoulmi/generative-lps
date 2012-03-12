/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelFactory
 * @model kind="package"
 * @generated
 */
public interface DeltamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "deltamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://deltamodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "deltamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeltamodelPackage eINSTANCE = br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl <em>Added Entities</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getAddedEntities()
	 * @generated
	 */
	int ADDED_ENTITIES = 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_ENTITIES__FEATURES = 0;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_ENTITIES__ASSETS = 1;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_ENTITIES__USE_CASES = 2;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_ENTITIES__MAPPINGS = 3;

	/**
	 * The feature id for the '<em><b>Asset Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_ENTITIES__ASSET_DEPENDENCIES = 4;

	/**
	 * The feature id for the '<em><b>Feature Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_ENTITIES__FEATURE_CONSTRAINTS = 5;

	/**
	 * The number of structural features of the '<em>Added Entities</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDED_ENTITIES_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.RemovedEntitiesImpl <em>Removed Entities</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.RemovedEntitiesImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getRemovedEntities()
	 * @generated
	 */
	int REMOVED_ENTITIES = 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_ENTITIES__FEATURES = 0;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_ENTITIES__ASSETS = 1;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_ENTITIES__USE_CASES = 2;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_ENTITIES__MAPPINGS = 3;

	/**
	 * The feature id for the '<em><b>Asset Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_ENTITIES__ASSET_DEPENDENCIES = 4;

	/**
	 * The feature id for the '<em><b>Feature Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_ENTITIES__FEATURE_CONSTRAINTS = 5;

	/**
	 * The number of structural features of the '<em>Removed Entities</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVED_ENTITIES_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.ChangedEntitiesImpl <em>Changed Entities</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.ChangedEntitiesImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getChangedEntities()
	 * @generated
	 */
	int CHANGED_ENTITIES = 2;

	/**
	 * The feature id for the '<em><b>Feature Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGED_ENTITIES__FEATURE_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Changed Entities</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGED_ENTITIES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DependencieImpl <em>Dependencie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DependencieImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getDependencie()
	 * @generated
	 */
	int DEPENDENCIE = 3;

	/**
	 * The feature id for the '<em><b>Caller</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCIE__CALLER = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCIE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Dependencie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCIE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.FeatureChangeImpl <em>Feature Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.FeatureChangeImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getFeatureChange()
	 * @generated
	 */
	int FEATURE_CHANGE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CHANGE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Previous Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CHANGE__PREVIOUS_VALUE = 1;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CHANGE__NEW_VALUE = 2;

	/**
	 * The number of structural features of the '<em>Feature Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CHANGE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities <em>Added Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Added Entities</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities
	 * @generated
	 */
	EClass getAddedEntities();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getFeatures()
	 * @see #getAddedEntities()
	 * @generated
	 */
	EReference getAddedEntities_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getAssets <em>Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assets</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getAssets()
	 * @see #getAddedEntities()
	 * @generated
	 */
	EReference getAddedEntities_Assets();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Cases</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getUseCases()
	 * @see #getAddedEntities()
	 * @generated
	 */
	EReference getAddedEntities_UseCases();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getMappings()
	 * @see #getAddedEntities()
	 * @generated
	 */
	EReference getAddedEntities_Mappings();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getAssetDependencies <em>Asset Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Asset Dependencies</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getAssetDependencies()
	 * @see #getAddedEntities()
	 * @generated
	 */
	EReference getAddedEntities_AssetDependencies();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getFeatureConstraints <em>Feature Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Constraints</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities#getFeatureConstraints()
	 * @see #getAddedEntities()
	 * @generated
	 */
	EReference getAddedEntities_FeatureConstraints();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities <em>Removed Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Removed Entities</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities
	 * @generated
	 */
	EClass getRemovedEntities();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getFeatures()
	 * @see #getRemovedEntities()
	 * @generated
	 */
	EReference getRemovedEntities_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getAssets <em>Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assets</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getAssets()
	 * @see #getRemovedEntities()
	 * @generated
	 */
	EReference getRemovedEntities_Assets();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Cases</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getUseCases()
	 * @see #getRemovedEntities()
	 * @generated
	 */
	EReference getRemovedEntities_UseCases();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getMappings()
	 * @see #getRemovedEntities()
	 * @generated
	 */
	EReference getRemovedEntities_Mappings();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getAssetDependencies <em>Asset Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Asset Dependencies</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getAssetDependencies()
	 * @see #getRemovedEntities()
	 * @generated
	 */
	EReference getRemovedEntities_AssetDependencies();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getFeatureConstraints <em>Feature Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Constraints</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities#getFeatureConstraints()
	 * @see #getRemovedEntities()
	 * @generated
	 */
	EReference getRemovedEntities_FeatureConstraints();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.ChangedEntities <em>Changed Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Changed Entities</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.ChangedEntities
	 * @generated
	 */
	EClass getChangedEntities();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.ChangedEntities#getFeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Type</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.ChangedEntities#getFeatureType()
	 * @see #getChangedEntities()
	 * @generated
	 */
	EReference getChangedEntities_FeatureType();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie <em>Dependencie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependencie</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie
	 * @generated
	 */
	EClass getDependencie();

	/**
	 * Returns the meta object for the reference '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie#getCaller <em>Caller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Caller</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie#getCaller()
	 * @see #getDependencie()
	 * @generated
	 */
	EReference getDependencie_Caller();

	/**
	 * Returns the meta object for the reference '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie#getTarget()
	 * @see #getDependencie()
	 * @generated
	 */
	EReference getDependencie_Target();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange <em>Feature Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Change</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange
	 * @generated
	 */
	EClass getFeatureChange();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getName()
	 * @see #getFeatureChange()
	 * @generated
	 */
	EAttribute getFeatureChange_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getPreviousValue <em>Previous Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Previous Value</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getPreviousValue()
	 * @see #getFeatureChange()
	 * @generated
	 */
	EAttribute getFeatureChange_PreviousValue();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange#getNewValue()
	 * @see #getFeatureChange()
	 * @generated
	 */
	EAttribute getFeatureChange_NewValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeltamodelFactory getDeltamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl <em>Added Entities</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getAddedEntities()
		 * @generated
		 */
		EClass ADDED_ENTITIES = eINSTANCE.getAddedEntities();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDED_ENTITIES__FEATURES = eINSTANCE.getAddedEntities_Features();

		/**
		 * The meta object literal for the '<em><b>Assets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDED_ENTITIES__ASSETS = eINSTANCE.getAddedEntities_Assets();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDED_ENTITIES__USE_CASES = eINSTANCE.getAddedEntities_UseCases();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDED_ENTITIES__MAPPINGS = eINSTANCE.getAddedEntities_Mappings();

		/**
		 * The meta object literal for the '<em><b>Asset Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDED_ENTITIES__ASSET_DEPENDENCIES = eINSTANCE.getAddedEntities_AssetDependencies();

		/**
		 * The meta object literal for the '<em><b>Feature Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDED_ENTITIES__FEATURE_CONSTRAINTS = eINSTANCE.getAddedEntities_FeatureConstraints();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.RemovedEntitiesImpl <em>Removed Entities</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.RemovedEntitiesImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getRemovedEntities()
		 * @generated
		 */
		EClass REMOVED_ENTITIES = eINSTANCE.getRemovedEntities();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVED_ENTITIES__FEATURES = eINSTANCE.getRemovedEntities_Features();

		/**
		 * The meta object literal for the '<em><b>Assets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVED_ENTITIES__ASSETS = eINSTANCE.getRemovedEntities_Assets();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVED_ENTITIES__USE_CASES = eINSTANCE.getRemovedEntities_UseCases();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVED_ENTITIES__MAPPINGS = eINSTANCE.getRemovedEntities_Mappings();

		/**
		 * The meta object literal for the '<em><b>Asset Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVED_ENTITIES__ASSET_DEPENDENCIES = eINSTANCE.getRemovedEntities_AssetDependencies();

		/**
		 * The meta object literal for the '<em><b>Feature Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVED_ENTITIES__FEATURE_CONSTRAINTS = eINSTANCE.getRemovedEntities_FeatureConstraints();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.ChangedEntitiesImpl <em>Changed Entities</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.ChangedEntitiesImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getChangedEntities()
		 * @generated
		 */
		EClass CHANGED_ENTITIES = eINSTANCE.getChangedEntities();

		/**
		 * The meta object literal for the '<em><b>Feature Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGED_ENTITIES__FEATURE_TYPE = eINSTANCE.getChangedEntities_FeatureType();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DependencieImpl <em>Dependencie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DependencieImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getDependencie()
		 * @generated
		 */
		EClass DEPENDENCIE = eINSTANCE.getDependencie();

		/**
		 * The meta object literal for the '<em><b>Caller</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCIE__CALLER = eINSTANCE.getDependencie_Caller();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCIE__TARGET = eINSTANCE.getDependencie_Target();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.FeatureChangeImpl <em>Feature Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.FeatureChangeImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelPackageImpl#getFeatureChange()
		 * @generated
		 */
		EClass FEATURE_CHANGE = eINSTANCE.getFeatureChange();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CHANGE__NAME = eINSTANCE.getFeatureChange_Name();

		/**
		 * The meta object literal for the '<em><b>Previous Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CHANGE__PREVIOUS_VALUE = eINSTANCE.getFeatureChange_PreviousValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CHANGE__NEW_VALUE = eINSTANCE.getFeatureChange_NewValue();

	}

} //DeltamodelPackage
