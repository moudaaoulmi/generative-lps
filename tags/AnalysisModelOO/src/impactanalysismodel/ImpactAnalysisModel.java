/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package impactanalysismodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link impactanalysismodel.ImpactAnalysisModel#getFeaturesReference <em>Features Reference</em>}</li>
 *   <li>{@link impactanalysismodel.ImpactAnalysisModel#getMappingsReference <em>Mappings Reference</em>}</li>
 *   <li>{@link impactanalysismodel.ImpactAnalysisModel#getAssetsReference <em>Assets Reference</em>}</li>
 *   <li>{@link impactanalysismodel.ImpactAnalysisModel#getUseCasesReference <em>Use Cases Reference</em>}</li>
 *   <li>{@link impactanalysismodel.ImpactAnalysisModel#getConstraintsReference <em>Constraints Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see impactanalysismodel.ImpactanalysismodelPackage#getImpactAnalysisModel()
 * @model
 * @generated
 */
public interface ImpactAnalysisModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Features Reference</b></em>' containment reference list.
	 * The list contents are of type {@link impactanalysismodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features Reference</em>' containment reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getImpactAnalysisModel_FeaturesReference()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getFeaturesReference();

	/**
	 * Returns the value of the '<em><b>Mappings Reference</b></em>' containment reference list.
	 * The list contents are of type {@link impactanalysismodel.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings Reference</em>' containment reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getImpactAnalysisModel_MappingsReference()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mapping> getMappingsReference();

	/**
	 * Returns the value of the '<em><b>Assets Reference</b></em>' containment reference list.
	 * The list contents are of type {@link impactanalysismodel.Asset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assets Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assets Reference</em>' containment reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getImpactAnalysisModel_AssetsReference()
	 * @model containment="true"
	 * @generated
	 */
	EList<Asset> getAssetsReference();

	/**
	 * Returns the value of the '<em><b>Use Cases Reference</b></em>' containment reference list.
	 * The list contents are of type {@link impactanalysismodel.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Cases Reference</em>' containment reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getImpactAnalysisModel_UseCasesReference()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCase> getUseCasesReference();

	/**
	 * Returns the value of the '<em><b>Constraints Reference</b></em>' containment reference list.
	 * The list contents are of type {@link impactanalysismodel.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints Reference</em>' containment reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getImpactAnalysisModel_ConstraintsReference()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraintsReference();

} // ImpactAnalysisModel
