/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.genarch.models.architecture.tests;

import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFactory;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitectureFolderTest extends ArchitectureEntityTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArchitectureFolderTest.class);
	}

	/**
	 * Constructs a new Folder test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureFolderTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Folder test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ArchitectureFolder getFixture() {
		return (ArchitectureFolder)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(ArchitectureFactory.eINSTANCE.createArchitectureFolder());
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

} //ArchitectureFolderTest
