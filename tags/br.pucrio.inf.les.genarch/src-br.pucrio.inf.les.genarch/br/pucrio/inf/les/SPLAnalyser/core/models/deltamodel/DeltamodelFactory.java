/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage
 * @generated
 */
public interface DeltamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeltamodelFactory eINSTANCE = br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.impl.DeltamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Added Entities</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Added Entities</em>'.
	 * @generated
	 */
	AddedEntities createAddedEntities();

	/**
	 * Returns a new object of class '<em>Removed Entities</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Removed Entities</em>'.
	 * @generated
	 */
	RemovedEntities createRemovedEntities();

	/**
	 * Returns a new object of class '<em>Changed Entities</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Changed Entities</em>'.
	 * @generated
	 */
	ChangedEntities createChangedEntities();

	/**
	 * Returns a new object of class '<em>Dependencie</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependencie</em>'.
	 * @generated
	 */
	Dependencie createDependencie();

	/**
	 * Returns a new object of class '<em>Feature Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Change</em>'.
	 * @generated
	 */
	FeatureChange createFeatureChange();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DeltamodelPackage getDeltamodelPackage();

} //DeltamodelFactory
