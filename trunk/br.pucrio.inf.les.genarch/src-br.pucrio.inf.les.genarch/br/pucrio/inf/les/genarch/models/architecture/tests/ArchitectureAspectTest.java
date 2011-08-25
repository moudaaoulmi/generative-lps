/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.tests;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitectureAspectTest extends ArchitectureEntityTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArchitectureAspectTest.class);
	}

	/**
	 * Constructs a new Aspect test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureAspectTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Aspect test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ArchitectureAspect getFixture() {
		return (ArchitectureAspect)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(ArchitectureFactory.eINSTANCE.createArchitectureAspect());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ArchitectureAspectTest
