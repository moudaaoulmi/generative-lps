package br.pucrio.inf.les.genarch.ui.wizards;

import java.net.URL;

import org.aspectj.org.eclipse.jdt.core.IPackageDeclaration;
import org.aspectj.org.eclipse.jdt.internal.core.JavaProject;
import org.aspectj.org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
import org.eclipse.jdt.internal.ui.wizards.TypedViewerFilter;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.Separator;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.JavaElementSorter;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

public class CreateDesignTestWizardPage extends WizardPage {

	private Text packageNameText;
	private Text packageNameText2;
	private Text packageNameText3;
	private Text packageNameText4;
	private Text packageNameText5;

	private IProject project;

	public CreateDesignTestWizardPage(final IProject project) {
		super("wizardPage");
		this.setTitle("GenArch - Create Design Test with DesignWizard");

		this.project = project;		
	}

	public void createControl(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		final GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;

		Label label = new Label(container, SWT.NULL);
		label.setText("&Model Package:");

		this.packageNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		this.packageNameText.setLayoutData(gd);
		this.packageNameText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				CreateDesignTestWizardPage.this.dialogChanged();
			}
		});

		final Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				CreateDesignTestWizardPage.this.handleBrowseModelPackage();
			}
		});

		new Separator(SWT.SEPARATOR | SWT.HORIZONTAL).doFillIntoGrid(container, 3);

		Label label2 = new Label(container, SWT.NULL);
		label2.setText("&Controller Package:");

		this.packageNameText2 = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		this.packageNameText2.setLayoutData(gd2);
		this.packageNameText2.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				CreateDesignTestWizardPage.this.dialogChanged();
			}
		});

		final Button button2 = new Button(container, SWT.PUSH);
		button2.setText("Browse...");
		button2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				CreateDesignTestWizardPage.this.handleBrowseControllerPackage();
			}
		});

		new Separator(SWT.SEPARATOR | SWT.HORIZONTAL).doFillIntoGrid(container, 3);

		Label label3 = new Label(container, SWT.NULL);
		label3.setText("&DAO Package:");

		this.packageNameText3 = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd3 = new GridData(GridData.FILL_HORIZONTAL);
		this.packageNameText3.setLayoutData(gd3);
		this.packageNameText3.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				CreateDesignTestWizardPage.this.dialogChanged();
			}
		});

		final Button button3 = new Button(container, SWT.PUSH);
		button3.setText("Browse...");
		button3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				CreateDesignTestWizardPage.this.handleBrowseDAOPackage();
			}
		});

		
		new Separator(SWT.SEPARATOR | SWT.HORIZONTAL).doFillIntoGrid(container, 3);

		Label label4 = new Label(container, SWT.NULL);
		label4.setText("&Project:");

		this.packageNameText4 = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd4 = new GridData(GridData.FILL_HORIZONTAL);
		this.packageNameText4.setLayoutData(gd4);
		this.packageNameText4.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				CreateDesignTestWizardPage.this.dialogChanged();
			}
		});

		final Button button4 = new Button(container, SWT.PUSH);
		button4.setText("Browse...");
		button4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				CreateDesignTestWizardPage.this.handleBrowseJarFile();
			}
		});		
		
		new Separator(SWT.SEPARATOR | SWT.HORIZONTAL).doFillIntoGrid(container, 3);

		Label label5 = new Label(container, SWT.NULL);
		label5.setText("&Nome da Unidade de Teste:");

		this.packageNameText5 = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd5 = new GridData(GridData.FILL_HORIZONTAL);
		this.packageNameText5.setLayoutData(gd5);
		this.packageNameText5.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				CreateDesignTestWizardPage.this.dialogChanged();
			}
		});
		/*gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;

		label = new Label(container, SWT.NULL);
		label.setText("Configurations");
		label.setLayoutData(gd);

		this.featureConfigurationsTable = new Table(container, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
		final TableColumn column = new TableColumn(this.featureConfigurationsTable, SWT.LEFT);
		column.setWidth(200);

		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 3;
		this.featureConfigurationsTable.setLayoutData(gd);

		this.featureConfigurationsTable.addSelectionListener(new MySelectionListener());

		this.addFeatureModelConfigurations();
*/
		this.initialize();
		this.dialogChanged();
		this.setControl(container);
	}

	private void initialize() {

	}

	private void handleBrowseModelPackage() {
		final StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider();
		final ILabelProvider labelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT); 
		final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(this.getShell(), labelProvider, provider);

		final Class[] acceptedClasses = new Class[] { IPackageFragment.class };
		final ViewerFilter filter = new TypedViewerFilter(acceptedClasses);

		dialog.setSorter(new JavaElementSorter());
		dialog.setTitle("");
		dialog.setMessage(""); 
		dialog.setInput(JavaCore.create(project));
//		dialog.addFilter(filter);
		dialog.setHelpAvailable(false);

		if (dialog.open() == Window.OK) {
			final Object element= dialog.getFirstResult();
			if (element instanceof IPackageFragment) {
				final IPackageFragment project = (IPackageFragment)element;
				this.packageNameText.setText(project.getElementName());
			}					
		}
	}
	
	private void handleBrowseControllerPackage() {
		final StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider();
		final ILabelProvider labelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT); 
		final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(this.getShell(), labelProvider, provider);

		final Class[] acceptedClasses = new Class[] { IPackageFragment.class };
		final ViewerFilter filter = new TypedViewerFilter(acceptedClasses);

		dialog.setSorter(new JavaElementSorter());
		dialog.setTitle("");
		dialog.setMessage(""); 
		dialog.setInput(JavaCore.create(project));
//		dialog.addFilter(filter);
		dialog.setHelpAvailable(false);

		if (dialog.open() == Window.OK) {
			final Object element= dialog.getFirstResult();
			if (element instanceof IPackageFragment) {
				final IPackageFragment project = (IPackageFragment)element;
				this.packageNameText2.setText(project.getElementName());
			}					
		}
	}
	
	private void handleBrowseDAOPackage() {
		final StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider();
		final ILabelProvider labelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT); 
		final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(this.getShell(), labelProvider, provider);

		final Class[] acceptedClasses = new Class[] { IPackageFragment.class };
		final ViewerFilter filter = new TypedViewerFilter(acceptedClasses);

		dialog.setSorter(new JavaElementSorter());
		dialog.setTitle("");
		dialog.setMessage(""); 
		dialog.setInput(JavaCore.create(project));
//		dialog.addFilter(filter);
		dialog.setHelpAvailable(false);

		if (dialog.open() == Window.OK) {
			final Object element= dialog.getFirstResult();
			if (element instanceof IPackageFragment) {
				final IPackageFragment project = (IPackageFragment)element;
				this.packageNameText3.setText(project.getElementName());
			}					
		}
	}
	
	private void handleBrowseJarFile() {
		final StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider();
		final ILabelProvider labelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT); 
		final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(this.getShell(), labelProvider, provider);

		final Class[] acceptedClasses = new Class[] { IJavaProject.class };
		final ViewerFilter filter = new TypedViewerFilter(acceptedClasses);

		dialog.setSorter(new JavaElementSorter());
		dialog.setTitle("");
		dialog.setMessage(""); 
		dialog.setInput(JavaCore.create(project.getWorkspace().getRoot()));
		dialog.addFilter(filter);
		dialog.setHelpAvailable(false);

		if (dialog.open() == Window.OK) {
			final Object element= dialog.getFirstResult();
			if (element instanceof IJavaProject) {
				final IJavaProject var = (IJavaProject)element;
				this.packageNameText4.setText(var.getProject().getFullPath().toString());
			}					
		}
	}

	private void dialogChanged() {
		final IResource project = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(this.getPackageNameText()));
		
		if (this.getPackageNameText().length() == 0) {
			this.updateStatus("Package must be specified");
			return;
		}

		if (this.getPackageNameText2().length() == 0) {
			this.updateStatus("Package must be specified");
			return;
		}
		
		/*if (this.getPackageNameText3().length() == 0) {
			this.updateStatus("Package must be specified");
			return;
		}*/
	
		this.updateStatus(null);
	}

	private void updateStatus(final String message) {
		this.setErrorMessage(message);
		this.setPageComplete(message == null);
	}
	
	private class MySelectionListener implements SelectionListener {

		public void widgetDefaultSelected(final SelectionEvent e) {

		}

		public void widgetSelected(final SelectionEvent e) {
			CreateDesignTestWizardPage.this.dialogChanged();			
		}		
	}

	public String getPackageNameText() {
		return packageNameText.getText();
	}

	public String getPackageNameText2() {
		return packageNameText2.getText();
	}

	public String getPackageNameText3() {
		return packageNameText3.getText();
	}
	
	public String getPackageNameText4() {
		return packageNameText4.getText();
	}
	
	public String getPackageNameText5() {
		return packageNameText5.getText();
	}
}
