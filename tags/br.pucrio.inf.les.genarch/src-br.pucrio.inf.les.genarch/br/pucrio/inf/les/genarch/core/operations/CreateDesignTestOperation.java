package br.pucrio.inf.les.genarch.core.operations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;

public class CreateDesignTestOperation {

	private IFile file;
	private String source,target;
	private IProject project;
	private IProgressMonitor monitor;

	public CreateDesignTestOperation(IProject project, String source,
			String target, IProgressMonitor monitor) {
		this.source = source;
		this.target = target;
		this.project = project;
		this.monitor = monitor;
	}

	public void criarArquivo() throws InvocationTargetException,InterruptedException {

		try {
			//Construir File
			InputStream inputStream = file.getContents();


			StringBuffer newContent = new StringBuffer();

			newContent.append("import java.io.IOException;");
			newContent.append("import java.util.Iterator;");
			newContent.append("import java.util.Set;");
			newContent.append("");
			newContent.append("import junit.framework.TestCase;");
			newContent.append("");
			newContent.append("import org.designwizard.design.ClassNode;");
			newContent.append("import org.designwizard.design.PackageNode;");
			newContent.append("import org.designwizard.exception.InexistentEntityException;");
			newContent.append("import org.designwizard.main.DesignWizard;");
			newContent.append("");
			newContent.append("public class AbstractMBeanCallersTest extends TestCase {");
			newContent.append("");
			newContent.append("	DesignWizard dw;");
			newContent.append("");
			newContent.append("	public AbstractMBeanCallersTest() throws IOException {");
			newContent.append("		dw = new DesignWizard(");
			newContent.append("				\"C:\\eclipseGalileo\\workspace\\DesignWizard\\src\\testes\\ecommerce.jar\");");
			newContent.append("	}");
			newContent.append("");
			newContent.append("	public void testCallers() throws IOException, InexistentEntityException {");
			newContent.append("");
			newContent.append("		ClassNode clazz = dw");
			newContent.append("				.getClass(\"br.com.ecommerce.arq.jsf.AbstractController\");");
			newContent.append("		Set<ClassNode> subClasses = clazz.getSubClasses();");
			newContent.append("		for (ClassNode classNode : subClasses) {");
			newContent.append("			System.out.println(classNode.getName());");
			newContent.append("		}");
			newContent.append("");
			newContent.append("	}");
			newContent.append("");
			newContent.append("	public void testModelCalls() throws IOException, InexistentEntityException {");
			newContent.append("");
			newContent.append("		PackageNode model = dw.getPackage(\"br.com.ecommerce.dominio\");");
			newContent.append("		PackageNode managedBeans = dw.getPackage(\"br.com.ecommerce.jsf\");");
			newContent.append("		PackageNode dao = dw.getPackage(\"br.com.ecommerce.dao\");");
			newContent.append("");
			newContent.append("		Set<PackageNode> modelSubPackages = dw.getSubPackages(model);");
			newContent.append("		Set<PackageNode> managedBeansSubPackages = dw.getSubPackages(managedBeans);");
			newContent.append("		Set<PackageNode> daoSubPackages = dw.getSubPackages(dao);");
			newContent.append("");
			newContent.append("		Set<ClassNode> modelCallers;");
			newContent.append("");
			newContent.append("		for (ClassNode clazz : model.getAllClasses()) {");
			newContent.append("			modelCallers = clazz.getClassesThatUse();");
			newContent.append("			for (ClassNode classNode : modelCallers) {");
			newContent.append("				if (classNode instanceof ClassNode) {");
			newContent.append("					System.out.println(classNode.getName());");
			newContent.append("					assertTrue(classNode.getPackage().equals(model)");
			newContent.append("							|| classNode.getPackage().equals(managedBeans)");
			newContent.append("							|| classNode.getPackage().equals(dao)");
			newContent.append("							|| modelSubPackages");
			newContent.append("									.contains(classNode.getPackage())");
			newContent.append("							|| managedBeansSubPackages.contains(classNode");
			newContent.append("									.getPackage())");
			newContent.append("									|| daoSubPackages.contains(classNode");
			newContent.append("											.getPackage()));");
			newContent.append("				}");
			newContent.append("			}");
			newContent.append("		}");
			newContent.append("");
			newContent.append("	}");
			newContent.append("");
			newContent.append("	public void testMostraClasses() throws IOException,");
			newContent.append("			InexistentEntityException {");
			newContent.append("		PackageNode model = dw.getPackage(\"br.com.ecommerce.dominio\");");
			newContent.append("");
			newContent.append("		Set<PackageNode> subPackages = dw.getSubPackages(model);");
			newContent.append("");
			newContent.append("		for (Iterator iterator = subPackages.iterator(); iterator.hasNext();) {");
			newContent.append("			PackageNode packageNode = (PackageNode) iterator.next();");
			newContent.append("			System.out.println(packageNode.getName());");
			newContent.append("		}");
			newContent.append("	}");
			newContent.append("}");
			newContent.append("");

			ByteArrayInputStream newInputStream = new ByteArrayInputStream(newContent.toString().getBytes());
			IFile fileTemplate = file.getProject().getFile(file.getProjectRelativePath().removeLastSegments(1).append(file.getName() + ".xpt"));

			try {
				if ( fileTemplate.exists() ) {
					fileTemplate.setContents(newInputStream, true, true, monitor);					
				} else {
					fileTemplate.create(newInputStream, true, new NullProgressMonitor());
				}
			} catch (final CoreException e) {
				e.printStackTrace();
			}

			newInputStream.close();
			inputStream.close();
			
			file.delete(false,monitor);
		} catch (CoreException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		} catch (IOException e) {
			GenarchEMFPlugin.INSTANCE.log(e);
		}		
	}	
}
