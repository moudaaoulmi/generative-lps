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
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link impactanalysismodel.Method#getMethodDependencies <em>Method Dependencies</em>}</li>
 *   <li>{@link impactanalysismodel.Method#getFieldDependencies <em>Field Dependencies</em>}</li>
 *   <li>{@link impactanalysismodel.Method#getClassDependencies <em>Class Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see impactanalysismodel.ImpactanalysismodelPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Asset {
	/**
	 * Returns the value of the '<em><b>Method Dependencies</b></em>' reference list.
	 * The list contents are of type {@link impactanalysismodel.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Dependencies</em>' reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getMethod_MethodDependencies()
	 * @model
	 * @generated
	 */
	EList<Method> getMethodDependencies();

	/**
	 * Returns the value of the '<em><b>Field Dependencies</b></em>' reference list.
	 * The list contents are of type {@link impactanalysismodel.Field}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Dependencies</em>' reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getMethod_FieldDependencies()
	 * @model
	 * @generated
	 */
	EList<Field> getFieldDependencies();

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
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getMethod_ClassDependencies()
	 * @model
	 * @generated
	 */
	EList<impactanalysismodel.Class> getClassDependencies();

} // Method
