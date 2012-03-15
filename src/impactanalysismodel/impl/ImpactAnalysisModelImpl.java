/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package impactanalysismodel.impl;

import impactanalysismodel.Asset;
import impactanalysismodel.Constraint;
import impactanalysismodel.Feature;
import impactanalysismodel.ImpactAnalysisModel;
import impactanalysismodel.ImpactanalysismodelPackage;
import impactanalysismodel.Mapping;
import impactanalysismodel.UseCase;

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
 * An implementation of the model object '<em><b>Impact Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link impactanalysismodel.impl.ImpactAnalysisModelImpl#getFeaturesReference <em>Features Reference</em>}</li>
 *   <li>{@link impactanalysismodel.impl.ImpactAnalysisModelImpl#getMappingsReference <em>Mappings Reference</em>}</li>
 *   <li>{@link impactanalysismodel.impl.ImpactAnalysisModelImpl#getAssetsReference <em>Assets Reference</em>}</li>
 *   <li>{@link impactanalysismodel.impl.ImpactAnalysisModelImpl#getUseCasesReference <em>Use Cases Reference</em>}</li>
 *   <li>{@link impactanalysismodel.impl.ImpactAnalysisModelImpl#getConstraintsReference <em>Constraints Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImpactAnalysisModelImpl extends EObjectImpl implements ImpactAnalysisModel {
	/**
	 * The cached value of the '{@link #getFeaturesReference() <em>Features Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesReference()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> featuresReference;

	/**
	 * The cached value of the '{@link #getMappingsReference() <em>Mappings Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingsReference()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> mappingsReference;

	/**
	 * The cached value of the '{@link #getAssetsReference() <em>Assets Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssetsReference()
	 * @generated
	 * @ordered
	 */
	protected EList<Asset> assetsReference;

	/**
	 * The cached value of the '{@link #getUseCasesReference() <em>Use Cases Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCasesReference()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCasesReference;

	/**
	 * The cached value of the '{@link #getConstraintsReference() <em>Constraints Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintsReference()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraintsReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpactAnalysisModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeaturesReference() {
		if (featuresReference == null) {
			featuresReference = new EObjectContainmentEList<Feature>(Feature.class, this, ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE);
		}
		return featuresReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getMappingsReference() {
		if (mappingsReference == null) {
			mappingsReference = new EObjectContainmentEList<Mapping>(Mapping.class, this, ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE);
		}
		return mappingsReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Asset> getAssetsReference() {
		if (assetsReference == null) {
			assetsReference = new EObjectContainmentEList<Asset>(Asset.class, this, ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE);
		}
		return assetsReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCasesReference() {
		if (useCasesReference == null) {
			useCasesReference = new EObjectContainmentEList<UseCase>(UseCase.class, this, ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE);
		}
		return useCasesReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraintsReference() {
		if (constraintsReference == null) {
			constraintsReference = new EObjectContainmentEList<Constraint>(Constraint.class, this, ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE);
		}
		return constraintsReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE:
				return ((InternalEList<?>)getFeaturesReference()).basicRemove(otherEnd, msgs);
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE:
				return ((InternalEList<?>)getMappingsReference()).basicRemove(otherEnd, msgs);
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE:
				return ((InternalEList<?>)getAssetsReference()).basicRemove(otherEnd, msgs);
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE:
				return ((InternalEList<?>)getUseCasesReference()).basicRemove(otherEnd, msgs);
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE:
				return ((InternalEList<?>)getConstraintsReference()).basicRemove(otherEnd, msgs);
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
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE:
				return getFeaturesReference();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE:
				return getMappingsReference();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE:
				return getAssetsReference();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE:
				return getUseCasesReference();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE:
				return getConstraintsReference();
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
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE:
				getFeaturesReference().clear();
				getFeaturesReference().addAll((Collection<? extends Feature>)newValue);
				return;
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE:
				getMappingsReference().clear();
				getMappingsReference().addAll((Collection<? extends Mapping>)newValue);
				return;
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE:
				getAssetsReference().clear();
				getAssetsReference().addAll((Collection<? extends Asset>)newValue);
				return;
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE:
				getUseCasesReference().clear();
				getUseCasesReference().addAll((Collection<? extends UseCase>)newValue);
				return;
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE:
				getConstraintsReference().clear();
				getConstraintsReference().addAll((Collection<? extends Constraint>)newValue);
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
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE:
				getFeaturesReference().clear();
				return;
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE:
				getMappingsReference().clear();
				return;
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE:
				getAssetsReference().clear();
				return;
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE:
				getUseCasesReference().clear();
				return;
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE:
				getConstraintsReference().clear();
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
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE:
				return featuresReference != null && !featuresReference.isEmpty();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE:
				return mappingsReference != null && !mappingsReference.isEmpty();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE:
				return assetsReference != null && !assetsReference.isEmpty();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE:
				return useCasesReference != null && !useCasesReference.isEmpty();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE:
				return constraintsReference != null && !constraintsReference.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ImpactAnalysisModelImpl
