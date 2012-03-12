/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel;

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
 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelFactory
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
	ImpactanalysismodelPackage eINSTANCE = br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getFeature()
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
	 * The feature id for the '<em><b>Is Alternative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__IS_ALTERNATIVE = 4;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.MappingImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getMapping()
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
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.AssetImpl <em>Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.AssetImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getAsset()
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
	 * The feature id for the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__SIGNATURE = 2;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET__DEPENDENCIES = 3;

	/**
	 * The number of structural features of the '<em>Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSET_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactAnalysisModelImpl <em>Impact Analysis Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactAnalysisModelImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getImpactAnalysisModel()
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
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.UseCaseImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getUseCase()
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
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FieldImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getField()
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
	 * The feature id for the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__SIGNATURE = ASSET__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__DEPENDENCIES = ASSET__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TYPE = ASSET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__VISIBILITY = ASSET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__MODIFIERS = ASSET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = ASSET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.MethodImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getMethod()
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
	 * The feature id for the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__SIGNATURE = ASSET__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DEPENDENCIES = ASSET__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__RETURN_TYPE = ASSET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__VISIBILITY = ASSET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__MODIFIERS = ASSET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ARGUMENTS = ASSET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = ASSET_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ClassImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getClass_()
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
	 * The feature id for the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SIGNATURE = ASSET__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__DEPENDENCIES = ASSET__DEPENDENCIES;

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
	 * The feature id for the '<em><b>Modifiers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MODIFIERS = ASSET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = ASSET_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ConstraintImpl
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getConstraint()
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
	 * The feature id for the '<em><b>Feature Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__FEATURE_TARGET = 3;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType <em>Feature Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getFeatureType()
	 * @generated
	 */
	int FEATURE_TYPE = 9;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 10;

	/**
	 * The meta object id for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Visibility
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 11;


	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#getType()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#getFeatureChild <em>Feature Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Child</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#getFeatureChild()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_FeatureChild();

	/**
	 * Returns the meta object for the reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#getConstraints()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#isIsAlternative <em>Is Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Alternative</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature#isIsAlternative()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_IsAlternative();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getFeatures()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Features();

	/**
	 * Returns the meta object for the reference '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getAssets <em>Assets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assets</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getAssets()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Assets();

	/**
	 * Returns the meta object for the reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getUseCases <em>Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Use Cases</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping#getUseCases()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_UseCases();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset <em>Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Asset</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset
	 * @generated
	 */
	EClass getAsset();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset#getName()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_Name();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset#getPath()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_Path();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signature</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset#getSignature()
	 * @see #getAsset()
	 * @generated
	 */
	EAttribute getAsset_Signature();

	/**
	 * Returns the meta object for the reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset#getDependencies()
	 * @see #getAsset()
	 * @generated
	 */
	EReference getAsset_Dependencies();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel <em>Impact Analysis Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analysis Model</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel
	 * @generated
	 */
	EClass getImpactAnalysisModel();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getFeaturesReference <em>Features Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features Reference</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getFeaturesReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_FeaturesReference();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getMappingsReference <em>Mappings Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings Reference</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getMappingsReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_MappingsReference();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getAssetsReference <em>Assets Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assets Reference</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getAssetsReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_AssetsReference();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getUseCasesReference <em>Use Cases Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Cases Reference</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getUseCasesReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_UseCasesReference();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getConstraintsReference <em>Constraints Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints Reference</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel#getConstraintsReference()
	 * @see #getImpactAnalysisModel()
	 * @generated
	 */
	EReference getImpactAnalysisModel_ConstraintsReference();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field#getType()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Type();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field#getVisibility()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifiers</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field#getModifiers()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Modifiers();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Type</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method#getReturnType()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_ReturnType();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method#getVisibility()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifiers</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method#getModifiers()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Modifiers();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arguments</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method#getArguments()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Arguments();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class#getDeclaredMethods <em>Declared Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Methods</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class#getDeclaredMethods()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DeclaredMethods();

	/**
	 * Returns the meta object for the containment reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class#getDeclaredFields <em>Declared Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Fields</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class#getDeclaredFields()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_DeclaredFields();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class#getModifiers <em>Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifiers</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class#getModifiers()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Modifiers();

	/**
	 * Returns the meta object for class '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getConstraintExpression <em>Constraint Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Expression</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getConstraintExpression()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_ConstraintExpression();

	/**
	 * Returns the meta object for the reference list '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getAssociatedFeatures <em>Associated Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Features</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getAssociatedFeatures()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_AssociatedFeatures();

	/**
	 * Returns the meta object for the attribute '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getConstraintType <em>Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Type</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getConstraintType()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_ConstraintType();

	/**
	 * Returns the meta object for the reference '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getFeatureTarget <em>Feature Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Target</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint#getFeatureTarget()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_FeatureTarget();

	/**
	 * Returns the meta object for enum '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature Type</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType
	 * @generated
	 */
	EEnum getFeatureType();

	/**
	 * Returns the meta object for enum '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the meta object for enum '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Visibility
	 * @generated
	 */
	EEnum getVisibility();

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
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FeatureImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getFeature()
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
		 * The meta object literal for the '<em><b>Is Alternative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__IS_ALTERNATIVE = eINSTANCE.getFeature_IsAlternative();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.MappingImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getMapping()
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
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.AssetImpl <em>Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.AssetImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getAsset()
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
		 * The meta object literal for the '<em><b>Signature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSET__SIGNATURE = eINSTANCE.getAsset_Signature();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSET__DEPENDENCIES = eINSTANCE.getAsset_Dependencies();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactAnalysisModelImpl <em>Impact Analysis Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactAnalysisModelImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getImpactAnalysisModel()
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
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.UseCaseImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getUseCase()
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
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.FieldImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__TYPE = eINSTANCE.getField_Type();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__VISIBILITY = eINSTANCE.getField_Visibility();

		/**
		 * The meta object literal for the '<em><b>Modifiers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__MODIFIERS = eINSTANCE.getField_Modifiers();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.MethodImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__RETURN_TYPE = eINSTANCE.getMethod_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__VISIBILITY = eINSTANCE.getMethod_Visibility();

		/**
		 * The meta object literal for the '<em><b>Modifiers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__MODIFIERS = eINSTANCE.getMethod_Modifiers();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__ARGUMENTS = eINSTANCE.getMethod_Arguments();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ClassImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getClass_()
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
		 * The meta object literal for the '<em><b>Modifiers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__MODIFIERS = eINSTANCE.getClass_Modifiers();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ConstraintImpl
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getConstraint()
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
		 * The meta object literal for the '<em><b>Feature Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__FEATURE_TARGET = eINSTANCE.getConstraint_FeatureTarget();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType <em>Feature Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getFeatureType()
		 * @generated
		 */
		EEnum FEATURE_TYPE = eINSTANCE.getFeatureType();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Visibility
		 * @see br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ImpactanalysismodelPackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

	}

} //ImpactanalysismodelPackage
