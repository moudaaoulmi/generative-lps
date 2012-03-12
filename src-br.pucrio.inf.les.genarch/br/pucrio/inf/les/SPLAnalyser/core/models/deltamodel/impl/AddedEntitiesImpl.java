/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.AddedEntities;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.Dependencie;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase;


import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Added Entities</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl#getAssets <em>Assets</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl#getUseCases <em>Use Cases</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl#getAssetDependencies <em>Asset Dependencies</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.AddedEntitiesImpl#getFeatureConstraints <em>Feature Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddedEntitiesImpl extends EObjectImpl implements AddedEntities {
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * The cached value of the '{@link #getAssets() <em>Assets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssets()
	 * @generated
	 * @ordered
	 */
	protected EList<Asset> assets;

	/**
	 * The cached value of the '{@link #getUseCases() <em>Use Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCases;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> mappings;

	/**
	 * The cached value of the '{@link #getAssetDependencies() <em>Asset Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssetDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependencie> assetDependencies;

	/**
	 * The cached value of the '{@link #getFeatureConstraints() <em>Feature Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> featureConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddedEntitiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeltamodelPackage.Literals.ADDED_ENTITIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Feature>(Feature.class, this, DeltamodelPackage.ADDED_ENTITIES__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Asset> getAssets() {
		if (assets == null) {
			assets = new EObjectContainmentEList<Asset>(Asset.class, this, DeltamodelPackage.ADDED_ENTITIES__ASSETS);
		}
		return assets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCases() {
		if (useCases == null) {
			useCases = new EObjectContainmentEList<UseCase>(UseCase.class, this, DeltamodelPackage.ADDED_ENTITIES__USE_CASES);
		}
		return useCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectContainmentEList<Mapping>(Mapping.class, this, DeltamodelPackage.ADDED_ENTITIES__MAPPINGS);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependencie> getAssetDependencies() {
		if (assetDependencies == null) {
			assetDependencies = new EObjectContainmentEList<Dependencie>(Dependencie.class, this, DeltamodelPackage.ADDED_ENTITIES__ASSET_DEPENDENCIES);
		}
		return assetDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getFeatureConstraints() {
		if (featureConstraints == null) {
			featureConstraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, DeltamodelPackage.ADDED_ENTITIES__FEATURE_CONSTRAINTS);
		}
		return featureConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeltamodelPackage.ADDED_ENTITIES__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case DeltamodelPackage.ADDED_ENTITIES__ASSETS:
				return ((InternalEList<?>)getAssets()).basicRemove(otherEnd, msgs);
			case DeltamodelPackage.ADDED_ENTITIES__USE_CASES:
				return ((InternalEList<?>)getUseCases()).basicRemove(otherEnd, msgs);
			case DeltamodelPackage.ADDED_ENTITIES__MAPPINGS:
				return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
			case DeltamodelPackage.ADDED_ENTITIES__ASSET_DEPENDENCIES:
				return ((InternalEList<?>)getAssetDependencies()).basicRemove(otherEnd, msgs);
			case DeltamodelPackage.ADDED_ENTITIES__FEATURE_CONSTRAINTS:
				return ((InternalEList<?>)getFeatureConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeltamodelPackage.ADDED_ENTITIES__FEATURES:
				return getFeatures();
			case DeltamodelPackage.ADDED_ENTITIES__ASSETS:
				return getAssets();
			case DeltamodelPackage.ADDED_ENTITIES__USE_CASES:
				return getUseCases();
			case DeltamodelPackage.ADDED_ENTITIES__MAPPINGS:
				return getMappings();
			case DeltamodelPackage.ADDED_ENTITIES__ASSET_DEPENDENCIES:
				return getAssetDependencies();
			case DeltamodelPackage.ADDED_ENTITIES__FEATURE_CONSTRAINTS:
				return getFeatureConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DeltamodelPackage.ADDED_ENTITIES__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case DeltamodelPackage.ADDED_ENTITIES__ASSETS:
				getAssets().clear();
				getAssets().addAll((Collection<? extends Asset>)newValue);
				return;
			case DeltamodelPackage.ADDED_ENTITIES__USE_CASES:
				getUseCases().clear();
				getUseCases().addAll((Collection<? extends UseCase>)newValue);
				return;
			case DeltamodelPackage.ADDED_ENTITIES__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends Mapping>)newValue);
				return;
			case DeltamodelPackage.ADDED_ENTITIES__ASSET_DEPENDENCIES:
				getAssetDependencies().clear();
				getAssetDependencies().addAll((Collection<? extends Dependencie>)newValue);
				return;
			case DeltamodelPackage.ADDED_ENTITIES__FEATURE_CONSTRAINTS:
				getFeatureConstraints().clear();
				getFeatureConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DeltamodelPackage.ADDED_ENTITIES__FEATURES:
				getFeatures().clear();
				return;
			case DeltamodelPackage.ADDED_ENTITIES__ASSETS:
				getAssets().clear();
				return;
			case DeltamodelPackage.ADDED_ENTITIES__USE_CASES:
				getUseCases().clear();
				return;
			case DeltamodelPackage.ADDED_ENTITIES__MAPPINGS:
				getMappings().clear();
				return;
			case DeltamodelPackage.ADDED_ENTITIES__ASSET_DEPENDENCIES:
				getAssetDependencies().clear();
				return;
			case DeltamodelPackage.ADDED_ENTITIES__FEATURE_CONSTRAINTS:
				getFeatureConstraints().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DeltamodelPackage.ADDED_ENTITIES__FEATURES:
				return features != null && !features.isEmpty();
			case DeltamodelPackage.ADDED_ENTITIES__ASSETS:
				return assets != null && !assets.isEmpty();
			case DeltamodelPackage.ADDED_ENTITIES__USE_CASES:
				return useCases != null && !useCases.isEmpty();
			case DeltamodelPackage.ADDED_ENTITIES__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
			case DeltamodelPackage.ADDED_ENTITIES__ASSET_DEPENDENCIES:
				return assetDependencies != null && !assetDependencies.isEmpty();
			case DeltamodelPackage.ADDED_ENTITIES__FEATURE_CONSTRAINTS:
				return featureConstraints != null && !featureConstraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AddedEntitiesImpl
