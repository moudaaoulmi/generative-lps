/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.ChangedEntities;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelFactory;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.FeatureChange;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeltamodelPackageImpl extends EPackageImpl implements DeltamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addedEntitiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removedEntitiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changedEntitiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureChangeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DeltamodelPackageImpl() {
		super(eNS_URI, DeltamodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DeltamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DeltamodelPackage init() {
		if (isInited) return (DeltamodelPackage)EPackage.Registry.INSTANCE.getEPackage(DeltamodelPackage.eNS_URI);

		// Obtain or create and register package
		DeltamodelPackageImpl theDeltamodelPackage = (DeltamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DeltamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DeltamodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ImpactanalysismodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDeltamodelPackage.createPackageContents();

		// Initialize created meta-data
		theDeltamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDeltamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DeltamodelPackage.eNS_URI, theDeltamodelPackage);
		return theDeltamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddedEntities() {
		return addedEntitiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddedEntities_Features() {
		return (EReference)addedEntitiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddedEntities_Assets() {
		return (EReference)addedEntitiesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddedEntities_UseCases() {
		return (EReference)addedEntitiesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddedEntities_Mappings() {
		return (EReference)addedEntitiesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddedEntities_AssetDependencies() {
		return (EReference)addedEntitiesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddedEntities_FeatureConstraints() {
		return (EReference)addedEntitiesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemovedEntities() {
		return removedEntitiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemovedEntities_Features() {
		return (EReference)removedEntitiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemovedEntities_Assets() {
		return (EReference)removedEntitiesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemovedEntities_UseCases() {
		return (EReference)removedEntitiesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemovedEntities_Mappings() {
		return (EReference)removedEntitiesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemovedEntities_AssetDependencies() {
		return (EReference)removedEntitiesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemovedEntities_FeatureConstraints() {
		return (EReference)removedEntitiesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangedEntities() {
		return changedEntitiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangedEntities_FeatureType() {
		return (EReference)changedEntitiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencie() {
		return dependencieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencie_Caller() {
		return (EReference)dependencieEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencie_Target() {
		return (EReference)dependencieEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureChange() {
		return featureChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureChange_Name() {
		return (EAttribute)featureChangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureChange_PreviousValue() {
		return (EAttribute)featureChangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureChange_NewValue() {
		return (EAttribute)featureChangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltamodelFactory getDeltamodelFactory() {
		return (DeltamodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		addedEntitiesEClass = createEClass(ADDED_ENTITIES);
		createEReference(addedEntitiesEClass, ADDED_ENTITIES__FEATURES);
		createEReference(addedEntitiesEClass, ADDED_ENTITIES__ASSETS);
		createEReference(addedEntitiesEClass, ADDED_ENTITIES__USE_CASES);
		createEReference(addedEntitiesEClass, ADDED_ENTITIES__MAPPINGS);
		createEReference(addedEntitiesEClass, ADDED_ENTITIES__ASSET_DEPENDENCIES);
		createEReference(addedEntitiesEClass, ADDED_ENTITIES__FEATURE_CONSTRAINTS);

		removedEntitiesEClass = createEClass(REMOVED_ENTITIES);
		createEReference(removedEntitiesEClass, REMOVED_ENTITIES__FEATURES);
		createEReference(removedEntitiesEClass, REMOVED_ENTITIES__ASSETS);
		createEReference(removedEntitiesEClass, REMOVED_ENTITIES__USE_CASES);
		createEReference(removedEntitiesEClass, REMOVED_ENTITIES__MAPPINGS);
		createEReference(removedEntitiesEClass, REMOVED_ENTITIES__ASSET_DEPENDENCIES);
		createEReference(removedEntitiesEClass, REMOVED_ENTITIES__FEATURE_CONSTRAINTS);

		changedEntitiesEClass = createEClass(CHANGED_ENTITIES);
		createEReference(changedEntitiesEClass, CHANGED_ENTITIES__FEATURE_TYPE);

		dependencieEClass = createEClass(DEPENDENCIE);
		createEReference(dependencieEClass, DEPENDENCIE__CALLER);
		createEReference(dependencieEClass, DEPENDENCIE__TARGET);

		featureChangeEClass = createEClass(FEATURE_CHANGE);
		createEAttribute(featureChangeEClass, FEATURE_CHANGE__NAME);
		createEAttribute(featureChangeEClass, FEATURE_CHANGE__PREVIOUS_VALUE);
		createEAttribute(featureChangeEClass, FEATURE_CHANGE__NEW_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ImpactanalysismodelPackage theImpactanalysismodelPackage = (ImpactanalysismodelPackage)EPackage.Registry.INSTANCE.getEPackage(ImpactanalysismodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(addedEntitiesEClass, AddedEntities.class, "AddedEntities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddedEntities_Features(), theImpactanalysismodelPackage.getFeature(), null, "Features", null, 0, -1, AddedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddedEntities_Assets(), theImpactanalysismodelPackage.getAsset(), null, "Assets", null, 0, -1, AddedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddedEntities_UseCases(), theImpactanalysismodelPackage.getUseCase(), null, "UseCases", null, 0, -1, AddedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddedEntities_Mappings(), theImpactanalysismodelPackage.getMapping(), null, "Mappings", null, 0, -1, AddedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddedEntities_AssetDependencies(), this.getDependencie(), null, "AssetDependencies", null, 0, -1, AddedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddedEntities_FeatureConstraints(), theImpactanalysismodelPackage.getConstraint(), null, "FeatureConstraints", null, 0, -1, AddedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removedEntitiesEClass, RemovedEntities.class, "RemovedEntities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemovedEntities_Features(), theImpactanalysismodelPackage.getFeature(), null, "Features", null, 0, -1, RemovedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemovedEntities_Assets(), theImpactanalysismodelPackage.getAsset(), null, "Assets", null, 0, -1, RemovedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemovedEntities_UseCases(), theImpactanalysismodelPackage.getUseCase(), null, "UseCases", null, 0, -1, RemovedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemovedEntities_Mappings(), theImpactanalysismodelPackage.getMapping(), null, "Mappings", null, 0, -1, RemovedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemovedEntities_AssetDependencies(), this.getDependencie(), null, "AssetDependencies", null, 0, -1, RemovedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemovedEntities_FeatureConstraints(), theImpactanalysismodelPackage.getConstraint(), null, "FeatureConstraints", null, 0, -1, RemovedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changedEntitiesEClass, ChangedEntities.class, "ChangedEntities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChangedEntities_FeatureType(), this.getFeatureChange(), null, "FeatureType", null, 0, -1, ChangedEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencieEClass, Dependencie.class, "Dependencie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencie_Caller(), theImpactanalysismodelPackage.getAsset(), null, "Caller", null, 1, 1, Dependencie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencie_Target(), theImpactanalysismodelPackage.getAsset(), null, "Target", null, 1, 1, Dependencie.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureChangeEClass, FeatureChange.class, "FeatureChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureChange_Name(), ecorePackage.getEString(), "Name", null, 0, 1, FeatureChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureChange_PreviousValue(), theImpactanalysismodelPackage.getFeatureType(), "PreviousValue", null, 0, 1, FeatureChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureChange_NewValue(), theImpactanalysismodelPackage.getFeatureType(), "NewValue", null, 0, 1, FeatureChange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DeltamodelPackageImpl
