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
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link impactanalysismodel.Mapping#getFeatures <em>Features</em>}</li>
 *   <li>{@link impactanalysismodel.Mapping#getAssets <em>Assets</em>}</li>
 *   <li>{@link impactanalysismodel.Mapping#getUseCases <em>Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see impactanalysismodel.ImpactanalysismodelPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link impactanalysismodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getMapping_Features()
	 * @model
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Assets</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assets</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assets</em>' reference.
	 * @see #setAssets(Asset)
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getMapping_Assets()
	 * @model required="true"
	 * @generated
	 */
	Asset getAssets();

	/**
	 * Sets the value of the '{@link impactanalysismodel.Mapping#getAssets <em>Assets</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assets</em>' reference.
	 * @see #getAssets()
	 * @generated
	 */
	void setAssets(Asset value);

	/**
	 * Returns the value of the '<em><b>Use Cases</b></em>' reference list.
	 * The list contents are of type {@link impactanalysismodel.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Cases</em>' reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getMapping_UseCases()
	 * @model
	 * @generated
	 */
	EList<UseCase> getUseCases();

} // Mapping
