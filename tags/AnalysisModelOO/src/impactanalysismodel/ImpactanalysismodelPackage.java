/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package impactanalysismodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see impactanalysismodel.ImpactanalysismodelFactory
 * @model kind="package"
 * @generated
 */
public interface ImpactanalysismodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "impactanalysismodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://impactanalysismodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "impactanalysismodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImpactanalysismodelPackage eINSTANCE = impactanalysismodel.impl.ImpactanalysismodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.FeatureImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Feature Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__FEATURE_CHILD = 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONSTRAINTS = 3;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.MappingImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__FEATURES = 0;

	/**
	 * The feature id for the '<em><b>Assets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ASSETS = 1;

	/**
	 * The feature id for the '<em><b>Use Cases</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__USE_CASES = 2;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.AssetImpl <em>Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.AssetImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getAsset()
	 * @generated
	 */
	int ASSET = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__PATH = 1;

	/**
	 * The number of structural features of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.ImpactAnalysisModelImpl <em>Impact Analysis Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.ImpactAnalysisModelImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getImpactAnalysisModel()
	 * @generated
	 */
	int IMPACT_ANALYSIS_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Features Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Mappings Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Assets Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Use Cases Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Constraints Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE = 4;

	/**
	 * The number of structural features of the '<em>Impact Analysis Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYSIS_MODEL_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.UseCaseImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.FieldImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__NAME = ASSET__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__PATH = ASSET__PATH;

	/**
	 * The feature id for the '<em><b>Class Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__CLASS_DEPENDENCIES = ASSET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = ASSET_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.MethodImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NAME = ASSET__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__PATH = ASSET__PATH;

	/**
	 * The feature id for the '<em><b>Method Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__METHOD_DEPENDENCIES = ASSET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Field Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__FIELD_DEPENDENCIES = ASSET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__CLASS_DEPENDENCIES = ASSET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = ASSET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.ClassImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = ASSET__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__PATH = ASSET__PATH;

	/**
	 * The feature id for the '<em><b>Declared Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DECLARED_METHODS = ASSET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declared Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DECLARED_FIELDS = ASSET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CLASS_DEPENDENCIES = ASSET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Field Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__FIELD_DEPENDENCIES = ASSET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Method Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__METHOD_DEPENDENCIES = ASSET_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = ASSET_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link impactanalysismodel.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.impl.ConstraintImpl
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Constraint Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONSTRAINT_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Associated Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ASSOCIATED_FEATURES = 1;

	/**
	 * The feature id for the '<em><b>Constraint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONSTRAINT_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link impactanalysismodel.FeatureType <em>Feature Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.FeatureType
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getFeatureType()
	 * @generated
	 */
	int FEATURE_TYPE = 9;

	/**
	 * The meta object id for the '{@link impactanalysismodel.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see impactanalysismodel.Type
	 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 10;


	/**
	 * Returns the meta object for class '{@link impactanalysismodel.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see impactanalysismodel.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link impactanalysismodel.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see impactanalysismodel.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link impactanalysismodel.Feature#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see impactanalysismodel.Feature#getType()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link impactanalysismodel.Feature#getFeatureChild <em>Feature Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Child</em>'.
	 * @see impactanalysismodel.Feature#getFeatureChild()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_FeatureChild();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Feature#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see impactanalysismodel.Feature#getConstraints()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Constraints();

	/**
	 * Returns the meta object for class '{@link impactanalysismodel.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see impactanalysismodel.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Mapping#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see impactanalysismodel.Mapping#getFeatures()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Features();

	/**
	 * Returns the meta object for the reference '{@link impactanalysismodel.Mapping#getAssets <em>Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assets</em>'.
	 * @see impactanalysismodel.Mapping#getAssets()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Assets();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Mapping#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Use Cases</em>'.
	 * @see impactanalysismodel.Mapping#getUseCases()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_UseCases();

	/**
	 * Returns the meta object for class '{@link impactanalysismodel.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asset</em>'.
	 * @see impactanalysismodel.Asset
	 * @generated
	 */
	EClass getAsset();

	/**
	 * Returns the meta object for the attribute '{@link impactanalysismodel.Asset#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see impactanalysismodel.Asset#getName()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_Name();

	/**
	 * Returns the meta object for the attribute '{@link impactanalysismodel.Asset#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see impactanalysismodel.Asset#getPath()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_Path();

	/**
	 * Returns the meta object for class '{@link impactanalysismodel.ImpactAnalysisModel <em>Impact Analysis Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analysis Model</em>'.
	 * @see impactanalysismodel.ImpactAnalysisModel
	 * @generated
	 */
	EClass getImpactAnalysisModel();

	/**
	 * Returns the meta object for the containment reference list '{@link impactanalysismodel.ImpactAnalysisModel#getFeaturesReference <em>Features Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features Reference</em>'.
	 * @see impactanalysismodel.ImpactAnalysisModel#getFeaturesReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_FeaturesReference();

	/**
	 * Returns the meta object for the containment reference list '{@link impactanalysismodel.ImpactAnalysisModel#getMappingsReference <em>Mappings Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings Reference</em>'.
	 * @see impactanalysismodel.ImpactAnalysisModel#getMappingsReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_MappingsReference();

	/**
	 * Returns the meta object for the containment reference list '{@link impactanalysismodel.ImpactAnalysisModel#getAssetsReference <em>Assets Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assets Reference</em>'.
	 * @see impactanalysismodel.ImpactAnalysisModel#getAssetsReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_AssetsReference();

	/**
	 * Returns the meta object for the containment reference list '{@link impactanalysismodel.ImpactAnalysisModel#getUseCasesReference <em>Use Cases Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Cases Reference</em>'.
	 * @see impactanalysismodel.ImpactAnalysisModel#getUseCasesReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_UseCasesReference();

	/**
	 * Returns the meta object for the containment reference list '{@link impactanalysismodel.ImpactAnalysisModel#getConstraintsReference <em>Constraints Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints Reference</em>'.
	 * @see impactanalysismodel.ImpactAnalysisModel#getConstraintsReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_ConstraintsReference();

	/**
	 * Returns the meta object for class '{@link impactanalysismodel.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see impactanalysismodel.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the attribute '{@link impactanalysismodel.UseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see impactanalysismodel.UseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for class '{@link impactanalysismodel.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see impactanalysismodel.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Field#getClassDependencies <em>Class Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Class Dependencies</em>'.
	 * @see impactanalysismodel.Field#getClassDependencies()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_ClassDependencies();

	/**
	 * Returns the meta object for class '{@link impactanalysismodel.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see impactanalysismodel.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Method#getMethodDependencies <em>Method Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Method Dependencies</em>'.
	 * @see impactanalysismodel.Method#getMethodDependencies()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_MethodDependencies();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Method#getFieldDependencies <em>Field Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Field Dependencies</em>'.
	 * @see impactanalysismodel.Method#getFieldDependencies()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_FieldDependencies();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Method#getClassDependencies <em>Class Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Class Dependencies</em>'.
	 * @see impactanalysismodel.Method#getClassDependencies()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_ClassDependencies();

	/**
	 * Returns the meta object for class '{@link impactanalysismodel.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see impactanalysismodel.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link impactanalysismodel.Class#getDeclaredMethods <em>Declared Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Methods</em>'.
	 * @see impactanalysismodel.Class#getDeclaredMethods()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DeclaredMethods();

	/**
	 * Returns the meta object for the containment reference list '{@link impactanalysismodel.Class#getDeclaredFields <em>Declared Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Fields</em>'.
	 * @see impactanalysismodel.Class#getDeclaredFields()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DeclaredFields();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Class#getClassDependencies <em>Class Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Class Dependencies</em>'.
	 * @see impactanalysismodel.Class#getClassDependencies()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_ClassDependencies();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Class#getFieldDependencies <em>Field Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Field Dependencies</em>'.
	 * @see impactanalysismodel.Class#getFieldDependencies()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_FieldDependencies();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Class#getMethodDependencies <em>Method Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Method Dependencies</em>'.
	 * @see impactanalysismodel.Class#getMethodDependencies()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_MethodDependencies();

	/**
	 * Returns the meta object for class '{@link impactanalysismodel.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see impactanalysismodel.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link impactanalysismodel.Constraint#getConstraintExpression <em>Constraint Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Expression</em>'.
	 * @see impactanalysismodel.Constraint#getConstraintExpression()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_ConstraintExpression();

	/**
	 * Returns the meta object for the reference list '{@link impactanalysismodel.Constraint#getAssociatedFeatures <em>Associated Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Features</em>'.
	 * @see impactanalysismodel.Constraint#getAssociatedFeatures()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_AssociatedFeatures();

	/**
	 * Returns the meta object for the attribute '{@link impactanalysismodel.Constraint#getConstraintType <em>Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Type</em>'.
	 * @see impactanalysismodel.Constraint#getConstraintType()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_ConstraintType();

	/**
	 * Returns the meta object for enum '{@link impactanalysismodel.FeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Type</em>'.
	 * @see impactanalysismodel.FeatureType
	 * @generated
	 */
	EEnum getFeatureType();

	/**
	 * Returns the meta object for enum '{@link impactanalysismodel.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see impactanalysismodel.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImpactanalysismodelFactory getImpactanalysismodelFactory();

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
		 * The meta object literal for the '{@link impactanalysismodel.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.FeatureImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__TYPE = eINSTANCE.getFeature_Type();

		/**
		 * The meta object literal for the '<em><b>Feature Child</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__FEATURE_CHILD = eINSTANCE.getFeature_FeatureChild();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CONSTRAINTS = eINSTANCE.getFeature_Constraints();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.MappingImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__FEATURES = eINSTANCE.getMapping_Features();

		/**
		 * The meta object literal for the '<em><b>Assets</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__ASSETS = eINSTANCE.getMapping_Assets();

		/**
		 * The meta object literal for the '<em><b>Use Cases</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__USE_CASES = eINSTANCE.getMapping_UseCases();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.impl.AssetImpl <em>Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.AssetImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getAsset()
		 * @generated
		 */
		EClass ASSET = eINSTANCE.getAsset();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__NAME = eINSTANCE.getAsset_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__PATH = eINSTANCE.getAsset_Path();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.impl.ImpactAnalysisModelImpl <em>Impact Analysis Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.ImpactAnalysisModelImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getImpactAnalysisModel()
		 * @generated
		 */
		EClass IMPACT_ANALYSIS_MODEL = eINSTANCE.getImpactAnalysisModel();

		/**
		 * The meta object literal for the '<em><b>Features Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE = eINSTANCE.getImpactAnalysisModel_FeaturesReference();

		/**
		 * The meta object literal for the '<em><b>Mappings Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE = eINSTANCE.getImpactAnalysisModel_MappingsReference();

		/**
		 * The meta object literal for the '<em><b>Assets Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE = eINSTANCE.getImpactAnalysisModel_AssetsReference();

		/**
		 * The meta object literal for the '<em><b>Use Cases Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE = eINSTANCE.getImpactAnalysisModel_UseCasesReference();

		/**
		 * The meta object literal for the '<em><b>Constraints Reference</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE = eINSTANCE.getImpactAnalysisModel_ConstraintsReference();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.UseCaseImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__NAME = eINSTANCE.getUseCase_Name();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.FieldImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Class Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD__CLASS_DEPENDENCIES = eINSTANCE.getField_ClassDependencies();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.MethodImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Method Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__METHOD_DEPENDENCIES = eINSTANCE.getMethod_MethodDependencies();

		/**
		 * The meta object literal for the '<em><b>Field Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__FIELD_DEPENDENCIES = eINSTANCE.getMethod_FieldDependencies();

		/**
		 * The meta object literal for the '<em><b>Class Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__CLASS_DEPENDENCIES = eINSTANCE.getMethod_ClassDependencies();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.ClassImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Declared Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__DECLARED_METHODS = eINSTANCE.getClass_DeclaredMethods();

		/**
		 * The meta object literal for the '<em><b>Declared Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__DECLARED_FIELDS = eINSTANCE.getClass_DeclaredFields();

		/**
		 * The meta object literal for the '<em><b>Class Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__CLASS_DEPENDENCIES = eINSTANCE.getClass_ClassDependencies();

		/**
		 * The meta object literal for the '<em><b>Field Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__FIELD_DEPENDENCIES = eINSTANCE.getClass_FieldDependencies();

		/**
		 * The meta object literal for the '<em><b>Method Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__METHOD_DEPENDENCIES = eINSTANCE.getClass_MethodDependencies();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.impl.ConstraintImpl
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__CONSTRAINT_EXPRESSION = eINSTANCE.getConstraint_ConstraintExpression();

		/**
		 * The meta object literal for the '<em><b>Associated Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__ASSOCIATED_FEATURES = eINSTANCE.getConstraint_AssociatedFeatures();

		/**
		 * The meta object literal for the '<em><b>Constraint Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__CONSTRAINT_TYPE = eINSTANCE.getConstraint_ConstraintType();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.FeatureType <em>Feature Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.FeatureType
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getFeatureType()
		 * @generated
		 */
		EEnum FEATURE_TYPE = eINSTANCE.getFeatureType();

		/**
		 * The meta object literal for the '{@link impactanalysismodel.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see impactanalysismodel.Type
		 * @see impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

	}

} //ImpactanalysismodelPackage
