/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.*;

import org.eclipse.emf.ecore.EClass;
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
public class DeltamodelFactoryImpl extends EFactoryImpl implements DeltamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DeltamodelFactory init() {
		try {
			DeltamodelFactory theDeltamodelFactory = (DeltamodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://deltamodel/1.0"); 
			if (theDeltamodelFactory != null) {
				return theDeltamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DeltamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltamodelFactoryImpl() {
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
			case DeltamodelPackage.ADDED_ENTITIES: return createAddedEntities();
			case DeltamodelPackage.REMOVED_ENTITIES: return createRemovedEntities();
			case DeltamodelPackage.CHANGED_ENTITIES: return createChangedEntities();
			case DeltamodelPackage.DEPENDENCIE: return createDependencie();
			case DeltamodelPackage.FEATURE_CHANGE: return createFeatureChange();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddedEntities createAddedEntities() {
		AddedEntitiesImpl addedEntities = new AddedEntitiesImpl();
		return addedEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemovedEntities createRemovedEntities() {
		RemovedEntitiesImpl removedEntities = new RemovedEntitiesImpl();
		return removedEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangedEntities createChangedEntities() {
		ChangedEntitiesImpl changedEntities = new ChangedEntitiesImpl();
		return changedEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependencie createDependencie() {
		DependencieImpl dependencie = new DependencieImpl();
		return dependencie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureChange createFeatureChange() {
		FeatureChangeImpl featureChange = new FeatureChangeImpl();
		return featureChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltamodelPackage getDeltamodelPackage() {
		return (DeltamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DeltamodelPackage getPackage() {
		return DeltamodelPackage.eINSTANCE;
	}

} //DeltamodelFactoryImpl
