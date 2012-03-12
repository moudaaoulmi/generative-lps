package br.pucrio.inf.les.genarch.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class CreateDesignTestWizard extends Wizard implements INewWizard {

	private CreateDesignTestWizardPage page;
	private IProject project;

	public CreateDesignTestWizard(final IProject project) {
		super();
		//this.setNeedsProgressMonitor(true);

		this.project = project;
	}

	@Override
	public void addPages() {
		this.page = new CreateDesignTestWizardPage(this.project);
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {
		final String model = this.page.getPackageNameText();
		final String controller = this.page.getPackageNameText2();
		final String dao = this.page.getPackageNameText3();
		final String jar = this.page.getPackageNameText4();
		final String nomeTeste = this.page.getPackageNameText5();
		

		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					CreateDesignTestWizard.this.criarArquivo(model,controller,dao,jar,nomeTeste,monitor);
				} catch (Exception e) {
					GenarchEMFPlugin.INSTANCE.log(e);
					e.printStackTrace();
				} finally {
					monitor.done();
				}
			}
		};

		try {
			this.getContainer().run(true, false, op);
		} catch (final InterruptedException e) {
			return false;
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
			Throwable realException = e.getTargetException();
			MessageDialog.openError(this.getShell(), "Error", realException.getMessage());
			return false;
		}

		return true;
	}

	private void doFinish(String source,String target,IProgressMonitor monitor) throws CoreException {
		//CreateDesignTestOperation createDesignTestOperation = new CreateDesignTestOperation(this.project,source,target,monitor);
		/*IProject newProductProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);		
		
		DerivateAsNewProjectOperation derivateNewProduct = new DerivateAsNewProjectOperation(this.project,newProductProject,featureConfigurationIndex,featureModelConfigurationName,monitor);
		derivateNewProduct.derivate();
		*/
		/*DerivateAsBuildFile derivator = new DerivateAsBuildFile(this.project,monitor);
		derivator.derivate();
		monitor.worked(1);*/
	}
	
	public void criarArquivo(String modelPackage,String controllerPackage,String daoPackage, String jarFile, String nomeTeste, IProgressMonitor monitor) throws InvocationTargetException,InterruptedException {

		IFile file;
		
		try {

			StringBuffer newContent = new StringBuffer();

			newContent.append("import java.io.IOException;\n");
			newContent.append("import java.util.Set;\n");
			newContent.append("\n");
			newContent.append("import junit.framework.TestCase;\n");
			newContent.append("\n");
			newContent.append("import org.designwizard.design.ClassNode;\n");
			newContent.append("import org.designwizard.design.PackageNode;\n");
			newContent.append("import org.designwizard.exception.InexistentEntityException;\n");
			newContent.append("import org.designwizard.main.DesignWizard;\n");
			newContent.append("\n");
			newContent.append("public class "+nomeTeste+" extends TestCase {\n");
			newContent.append("\n");
			newContent.append("	DesignWizard dw;\n");
			newContent.append("\n");
			newContent.append("	public "+nomeTeste+"() throws IOException {\n");
			newContent.append("		dw = new DesignWizard(\n");
//			newContent.append("				\"C:\\eclipseGalileo\\workspace\\DesignWizard\\src\\testes\\ecommerce.jar\");");
			newContent.append("\""+jarFile+"\");");
			newContent.append("	}\n");
			newContent.append("\n");
			newContent.append("	public void testModelCallers() throws IOException, InexistentEntityException {\n");
			newContent.append("\n");
			newContent.append("		PackageNode model = dw.getPackage(\""+modelPackage+"\");\n");
			newContent.append("		PackageNode managedBeans = dw.getPackage(\""+controllerPackage+"\");\n");
			if (daoPackage!=null || !daoPackage.equals(""))
				newContent.append("		PackageNode dao = dw.getPackage(\""+daoPackage+"\");\n");
			newContent.append("\n");
			newContent.append("		Set<PackageNode> modelSubPackages = dw.getSubPackages(model);\n");
			newContent.append("		Set<PackageNode> managedBeansSubPackages = dw.getSubPackages(managedBeans);\n");
			if (daoPackage!=null || !daoPackage.equals(""))
				newContent.append("		Set<PackageNode> daoSubPackages = dw.getSubPackages(dao);\n");
			newContent.append("\n");
			newContent.append("		Set<ClassNode> modelCallers;\n");
			newContent.append("\n");
			newContent.append("		for (ClassNode clazz : model.getAllClasses()) {\n");
			newContent.append("			modelCallers = clazz.getClassesThatUse();\n");
			newContent.append("			for (ClassNode classNode : modelCallers) {\n");
			newContent.append("				if (classNode instanceof ClassNode) {\n");
			newContent.append("					System.out.println(classNode.getName());\n");
			newContent.append("					assertTrue(classNode.getPackage().equals(model)\n");
			newContent.append("							|| classNode.getPackage().equals(managedBeans)\n");
			if (daoPackage!=null || !daoPackage.equals(""))
				newContent.append("							|| classNode.getPackage().equals(dao)\n");
			newContent.append("							|| modelSubPackages\n");
			newContent.append("									.contains(classNode.getPackage())\n");
			newContent.append("							|| managedBeansSubPackages.contains(classNode\n");
			newContent.append("									.getPackage())\n");
			if (daoPackage!=null || !daoPackage.equals("")) {
				newContent.append("									|| daoSubPackages.contains(classNode\n");
				newContent.append("											.getPackage())");
			}
			newContent.append(");\n");
			newContent.append("				}\n");
			newContent.append("			}\n");
			newContent.append("		}\n");
			newContent.append("\n");
			newContent.append("	}\n");
			
			newContent.append("		\n");
			newContent.append("PackageNode managedBeans = dw.getPackage(\""+controllerPackage+"\");\n");
			newContent.append("\n");
			newContent.append("		Set<PackageNode> managedBeansSubPackages = dw.getSubPackages(managedBeans);\n");
			newContent.append("\n");
			newContent.append("		Set<ClassNode> controllerCallers;\n");
			newContent.append("\n");
			newContent.append("		for (ClassNode clazz : managedBeans.getAllClasses()) {\n");
			newContent.append("			controllerCallers = clazz.getClassesThatUse();\n");
			newContent.append("			for (ClassNode classNode : controllerCallers) {\n");
			newContent.append("				if (classNode instanceof ClassNode) {\n");
			newContent.append("					System.out.println(classNode.getName());\n");
			newContent.append("					assertTrue(classNode.getPackage().equals(managedBeans)\n");
			newContent.append("							|| managedBeansSubPackages.contains(classNode\n");
			newContent.append("									.getPackage()));\n");
			newContent.append("				}\n");
			newContent.append("			}\n");
			newContent.append("		}\n");
			newContent.append("	}\n");
			
			newContent.append("	}\n");
			
			
			ByteArrayInputStream newInputStream = new ByteArrayInputStream(newContent.toString().getBytes());
			file = project.getFile("TESTANDO.java");
			IFile fileTemplate = file.getProject().getFile(file.getProjectRelativePath().removeLastSegments(1).append(nomeTeste + ".java"));
			//			IFile fileTemplate = new File(project.getProjectRelativePath().toString() + "/TESTANDO.JAVA");
			//project.getProjectRelativePath().removeLastSegments(1).append(file.getName() + ".xpt")
			fileTemplate.create(newInputStream, true, new NullProgressMonitor());

			newInputStream.close();
			
			//file.delete(false,monitor);
		} catch (CoreException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (IOException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		}		
	}	


	public void init(final IWorkbench workbench, final IStructuredSelection selection) {

	}
}