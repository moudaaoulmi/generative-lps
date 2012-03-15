/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package impactanalysismodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link impactanalysismodel.Field#getClassDependencies <em>Class Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see impactanalysismodel.ImpactanalysismodelPackage#getField()
 * @model
 * @generated
 */
public interface Field extends Asset {
	/**
	 * Returns the value of the '<em><b>Class Dependencies</b></em>' reference list.
	 * The list contents are of type {@link impactanalysismodel.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Dependencies</em>' reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getField_ClassDependencies()
	 * @model
	 * @generated
	 */
	EList<impactanalysismodel.Class> getClassDependencies();

} // Field
