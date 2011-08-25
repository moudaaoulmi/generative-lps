/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.tests;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitectureFileTest extends ArchitectureEntityTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArchitectureFileTest.class);
	}

	/**
	 * Constructs a new File test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureFileTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this File test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ArchitectureFile getFixture() {
		return (ArchitectureFile)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(ArchitectureFactory.eINSTANCE.createArchitectureFile());
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

} //ArchitectureFileTest
