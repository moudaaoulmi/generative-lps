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
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link impactanalysismodel.Class#getDeclaredMethods <em>Declared Methods</em>}</li>
 *   <li>{@link impactanalysismodel.Class#getDeclaredFields <em>Declared Fields</em>}</li>
 *   <li>{@link impactanalysismodel.Class#getClassDependencies <em>Class Dependencies</em>}</li>
 *   <li>{@link impactanalysismodel.Class#getFieldDependencies <em>Field Dependencies</em>}</li>
 *   <li>{@link impactanalysismodel.Class#getMethodDependencies <em>Method Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see impactanalysismodel.ImpactanalysismodelPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Asset {
	/**
	 * Returns the value of the '<em><b>Declared Methods</b></em>' containment reference list.
	 * The list contents are of type {@link impactanalysismodel.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Methods</em>' containment reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getClass_DeclaredMethods()
	 * @model containment="true"
	 * @generated
	 */
	EList<Method> getDeclaredMethods();

	/**
	 * Returns the value of the '<em><b>Declared Fields</b></em>' containment reference list.
	 * The list contents are of type {@link impactanalysismodel.Field}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Fields</em>' containment reference list.
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getClass_DeclaredFields()
	 * @model containment="true"
	 * @generated
	 */
	EList<Field> getDeclaredFields();

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
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getClass_ClassDependencies()
	 * @model
	 * @generated
	 */
	EList<Class> getClassDependencies();

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
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getClass_FieldDependencies()
	 * @model
	 * @generated
	 */
	EList<Field> getFieldDependencies();

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
	 * @see impactanalysismodel.ImpactanalysismodelPackage#getClass_MethodDependencies()
	 * @model
	 * @generated
	 */
	EList<Method> getMethodDependencies();

} // Class
