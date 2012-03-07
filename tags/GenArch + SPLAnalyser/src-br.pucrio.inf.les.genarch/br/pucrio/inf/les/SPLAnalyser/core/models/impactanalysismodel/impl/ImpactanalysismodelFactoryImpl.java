/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Asset;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.FeatureType;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelFactory;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Mapping;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Visibility;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImpactanalysismodelFactoryImpl extends EFactoryImpl implements ImpactanalysismodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImpactanalysismodelFactory init() {
		try {
			ImpactanalysismodelFactory theImpactanalysismodelFactory = (ImpactanalysismodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://impactanalysismodel/1.0"); 
			if (theImpactanalysismodelFactory != null) {
				return theImpactanalysismodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImpactanalysismodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactanalysismodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ImpactanalysismodelPackage.FEATURE: return createFeature();
			case ImpactanalysismodelPackage.MAPPING: return createMapping();
			case ImpactanalysismodelPackage.ASSET: return createAsset();
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL: return createImpactAnalysisModel();
			case ImpactanalysismodelPackage.USE_CASE: return createUseCase();
			case ImpactanalysismodelPackage.FIELD: return createField();
			case ImpactanalysismodelPackage.METHOD: return createMethod();
			case ImpactanalysismodelPackage.CLASS: return createClass();
			case ImpactanalysismodelPackage.CONSTRAINT: return createConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ImpactanalysismodelPackage.FEATURE_TYPE:
				return createFeatureTypeFromString(eDataType, initialValue);
			case ImpactanalysismodelPackage.TYPE:
				return createTypeFromString(eDataType, initialValue);
			case ImpactanalysismodelPackage.VISIBILITY:
				return createVisibilityFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ImpactanalysismodelPackage.FEATURE_TYPE:
				return convertFeatureTypeToString(eDataType, instanceValue);
			case ImpactanalysismodelPackage.TYPE:
				return convertTypeToString(eDataType, instanceValue);
			case ImpactanalysismodelPackage.VISIBILITY:
				return convertVisibilityToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Asset createAsset() {
		AssetImpl asset = new AssetImpl();
		return asset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactAnalysisModel createImpactAnalysisModel() {
		ImpactAnalysisModelImpl impactAnalysisModel = new ImpactAnalysisModelImpl();
		return impactAnalysisModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase createUseCase() {
		UseCaseImpl useCase = new UseCaseImpl();
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType createFeatureTypeFromString(EDataType eDataType, String initialValue) {
		FeatureType result = FeatureType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createTypeFromString(EDataType eDataType, String initialValue) {
		Type result = Type.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility createVisibilityFromString(EDataType eDataType, String initialValue) {
		Visibility result = Visibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactanalysismodelPackage getImpactanalysismodelPackage() {
		return (ImpactanalysismodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImpactanalysismodelPackage getPackage() {
		return ImpactanalysismodelPackage.eINSTANCE;
	}

} //ImpactanalysismodelFactoryImpl
