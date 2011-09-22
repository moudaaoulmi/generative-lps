package br.pucrio.inf.les.genarch.core.operations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import br.pucrio.inf.les.genarch.GenarchEMFPlugin;
import br.pucrio.inf.les.genarch.core.logic.Logic;
import br.pucrio.inf.les.genarch.core.project.GenarchProjectConfigurationFile;
import br.pucrio.inf.les.genarch.core.resources.dsl.AspectAnnotationUtil;
import br.pucrio.inf.les.genarch.core.resources.dsl.JavaAnnotationUtil;
import br.pucrio.inf.les.genarch.core.templates.GenerateXPandTemplates;
import br.pucrio.inf.les.genarch.models.architecture.Architecture;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureAspect;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureClass;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureComponent;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFile;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFolder;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragment;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureFragmentContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureResourcesContainer;
import br.pucrio.inf.les.genarch.models.architecture.ArchitectureTemplate;
import br.pucrio.inf.les.genarch.models.configuration.Configuration;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationAspect;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationClass;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationComponent;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFile;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFolder;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationFragment;
import br.pucrio.inf.les.genarch.models.configuration.ConfigurationTemplate;
import br.pucrio.inf.les.genarch.models.configuration.MappingEntity;
import br.pucrio.inf.les.genarch.models.configuration.MappingRelationships;
import br.pucrio.inf.les.genarch.models.instance.ArchitectureInstance;
import br.pucrio.inf.les.genarch.models.instance.FeatureElements;
import br.pucrio.inf.les.genarch.models.instance.FeatureInstance;
import br.pucrio.inf.les.genarch.models.instance.Instance;
import br.pucrio.inf.les.genarch.models.instance.InstanceFactory;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;
import br.pucrio.inf.les.genarch.models.instance.impl.InstancePackageImpl;
import ca.uwaterloo.gp.fmp.Feature;
import ca.uwaterloo.gp.fmp.FeatureGroup;
import ca.uwaterloo.gp.fmp.Project;
import ca.uwaterloo.gp.fmp.util.FmpExternalLoader;
import ca.uwaterloo.gp.fmp.util.FmpResourceImpl;

/**
 * Problemas: 
 * - m�todos para remover annotations de c�digo AspectJ est�o comentados. Verificar qual o problema.
 *
 */
public class DerivateAsNewProjectOperation {

	/**
	 * Instancia do projeto da Linha de Produto
	 */
	private IProject project;
	/**
	 * Instancia do projeto alvo do produto
	 */
	private IProject newProductProject;
	private IProgressMonitor monitor;
	private int featureModelInstance;
	private String featureModelConfigurationName;
	
	private InstanceFactory instanceFactory = InstancePackage.eINSTANCE.getInstanceFactory();
	private MappingRelationships mappingRelationships;

	private List<ArchitectureTemplate> architectureTemplates = new ArrayList<ArchitectureTemplate>();

	public DerivateAsNewProjectOperation(IProject project,IProject newProductProject,int featureModelInstance,String featureModelConfigurationName,IProgressMonitor monitor) {		
		this.project = project;
		this.newProductProject = newProductProject;
		this.monitor = monitor;
		this.featureModelConfigurationName = featureModelConfigurationName;
		this.featureModelInstance = featureModelInstance;
	}

/**
 * M�todo repons�vel por coordenar o processo de deriva��o realiza diversas chamadas para verificar features selecionadas, 
 * mapeamentos e assim incluir os arquivos no projeto do produto.
 * M�todo chamado pela interface.
 */
	public void derivate() {
		//Abre o arquivo de configura��o do GenArch
		GenarchProjectConfigurationFile genarchProjectConfigurationFile = GenarchProjectConfigurationFile.open(project);

		//Do arquivo de configura��o pega o caminho para os 3 modelos.
		String architectureModelFileName = genarchProjectConfigurationFile.getArchitectureModelPath();
		String configurationModelFileName = genarchProjectConfigurationFile.getConfigurationModelPath();
		String featureModelFileName = genarchProjectConfigurationFile.getFeatureModelPath();

		
		IFile architectureModelFile = project.getFile(architectureModelFileName);
		URI architectureFileURI = URI.createPlatformResourceURI(architectureModelFile.getFullPath().toString());

		ResourceSet architectureResourceSet = new ResourceSetImpl();
		Resource architectureResource = architectureResourceSet.getResource(architectureFileURI,true);

		//Extrai informa��es e do modelo de arquitetura
		Architecture architecture = (Architecture)architectureResource.getContents().get(0);

		IFile configurationModelFile = project.getFile(configurationModelFileName);
		URI configurationFileURI = URI.createPlatformResourceURI(configurationModelFile.getFullPath().toString());

		//Extrai informa��es e do modelo de configura��o
		ResourceSet configurationResourceSet = new ResourceSetImpl();
		Resource configurationResource = configurationResourceSet.getResource(configurationFileURI, true);

		Configuration configuration = (Configuration)configurationResource.getContents().get(0);
		//Preenche o mapping entre Artefatos e Features. (rela��o Feature-Artefato)
		this.mappingRelationships = configuration.getMappingRelationships();

		IFile fmpModelFile = project.getFile(featureModelFileName);

		//Extrai informa��es e da configura��o do modelo de Features
		FmpExternalLoader externalLoader = new FmpExternalLoader();
		externalLoader.load(fmpModelFile);					
		EList resourceList = externalLoader.getResources();					
		FmpResourceImpl fmpResource = (FmpResourceImpl)resourceList.get(0);
		Project fmpProject = (Project)fmpResource.getAllContents().next();

		InstancePackageImpl.init();
		Instance instance = instanceFactory.createInstance();
		
		//Instancia da configura��o do modelo de features.
		FeatureInstance featureConfiguration = readFeatureModelConfiguration(fmpProject); 
		
		instance.setFeatureInstance(featureConfiguration);

		ArchitectureInstance architectureInstance = instanceFactory.createArchitectureInstance();

		instance.setArchitecture(architectureInstance);		

		architectureTemplates.clear();

		EList containers = architecture.getContainers(); //Pega todas as pastas da raiz
		
		

		for ( int y = 0; y < containers.size(); y++ ) {
			ArchitectureContainer container = (ArchitectureContainer)containers.get(y); //Passa por todos os containers
			EList components = container.getComponents(); //Pega os elementos do container

			for (int x = 0; x < components.size(); x++) { //Varre todos os componentes;
				ArchitectureComponent component = (ArchitectureComponent)components.get(x);
				//Atrav�s do path encontra o mapeamento do componente(artefato) com u featuresma
				ConfigurationComponent configurationComponent = (ConfigurationComponent)this.findConfigurationElementByPath(component.getPath());

				
				if ( configurationComponent != null ) { // quando o artefato esta relacionado com uma feature
					//Verifica na configura��o do modelo de features se a feature esta marcada como true ou false.
					boolean status = this.evalFeatureConfiguration(configurationComponent,featureConfiguration.getRoot());
					if (status) {// Caso sim insere componente no produto final.
						createComponent(component,architectureInstance,featureConfiguration.getRoot());   
					}
				} else {
					/* Quando o componente(artefato) n�o esta mapeado com uma feature,
					 * neste caso o componente(artefato) sempre � inserido no produto.*/
					createComponent(component,architectureInstance,featureConfiguration.getRoot());
				}		
			}
		}

		EList resourcesContainers = architecture.getResourcesContainer();

		for ( int y = 0; y < resourcesContainers.size(); y++ ) {
			ArchitectureResourcesContainer container = (ArchitectureResourcesContainer)resourcesContainers.get(y);
						
			createSingleFolder(container.getName(),container.getName(), architectureInstance);
			
			EList folders = container.getFolders();

			for (int x = 0; x < folders.size(); x++) {
				ArchitectureFolder folder = (ArchitectureFolder)folders.get(x);	    
				ConfigurationFolder configurationFolder = (ConfigurationFolder)this.findConfigurationElementByPath(folder.getPath());

				if ( configurationFolder != null ) {
					boolean status = this.evalFeatureConfiguration(configurationFolder,featureConfiguration.getRoot());
					if (status) {
						createFolder(folder,architectureInstance,featureConfiguration.getRoot());
					}
				} else {
					createFolder(folder,architectureInstance,featureConfiguration.getRoot());
				}		
			}

			EList templates = container.getTemplates();

			for ( int templatesCount = 0; templatesCount < templates.size(); templatesCount++ ) {
				ArchitectureTemplate template = (ArchitectureTemplate)templates.get(templatesCount);
				ConfigurationTemplate configurationTemplate = (ConfigurationTemplate)this.findConfigurationElementByPath(template.getPath());

				if ( configurationTemplate != null ) {
					boolean status = this.evalFeatureConfiguration(configurationTemplate,featureConfiguration.getRoot());
					if ( status ) {				
						architectureTemplates.add(template);
					}
				} else {
					architectureTemplates.add(template);
				}
			}

			EList files = container.getFiles();

			for ( int filesCount = 0; filesCount < files.size(); filesCount++ ) {
				ArchitectureFile file = (ArchitectureFile)files.get(filesCount);
				ConfigurationFile configurationFile = (ConfigurationFile)this.findConfigurationElementByPath(file.getPath());

				if ( configurationFile != null ) {
					boolean status = this.evalFeatureConfiguration(configurationFile,featureConfiguration.getRoot());
					if (status) {
						br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
						fileInstanceTwo.setName(file.getName());
						fileInstanceTwo.setPath(file.getPath());

						architectureInstance.getFiles().add(fileInstanceTwo);

						copyEntity(file);
					}
				} else {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
					fileInstanceTwo.setName(file.getName());
					fileInstanceTwo.setPath(file.getPath());

					architectureInstance.getFiles().add(fileInstanceTwo);

					copyEntity(file);
				}
			}
		}

		EList fragmentContainer = architecture.getFragmentsContainer();

		for ( int y = 0; y < fragmentContainer.size(); y++ ) {

			EList fragments = ((ArchitectureFragmentContainer)fragmentContainer.get(y)).getFragments();

			br.pucrio.inf.les.genarch.models.instance.ArchitectureFragmentContainer fragmentContainerOne = instanceFactory.createArchitectureFragmentContainer();
			fragmentContainerOne.setName(((ArchitectureFragmentContainer)fragmentContainer.get(y)).getName());

			for ( int fragmentCount = 0; fragmentCount < fragments.size(); fragmentCount++ ) {
				ArchitectureFragment fragment = (ArchitectureFragment)fragments.get(fragmentCount);
				ConfigurationFragment configurationFragment = this.findFragmentByName(fragment.getName());

				if ( configurationFragment != null ) {
					boolean status = this.evalFeatureConfiguration(configurationFragment,featureConfiguration.getRoot());
					if (status) {
						br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment fragmentInstanceTwo = instanceFactory.createArchitectureFragment();
						fragmentInstanceTwo.setName(fragment.getName());
						fragmentInstanceTwo.setContent(fragment.getContent());
						fragmentInstanceTwo.setPath(fragment.getPath());

						br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment fragmentInstanceThree = instanceFactory.createArchitectureFragment();
						fragmentInstanceThree.setName(fragment.getName());
						fragmentInstanceThree.setContent(fragment.getContent());
						fragmentInstanceThree.setPath(fragment.getPath());

						architectureInstance.getFragments().add(fragmentInstanceTwo);
						fragmentContainerOne.getFragments().add(fragmentInstanceThree);
					}
				} else {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment fragmentInstanceTwo = instanceFactory.createArchitectureFragment();
					fragmentInstanceTwo.setName(fragment.getName());
					fragmentInstanceTwo.setContent(fragment.getContent());
					fragmentInstanceTwo.setPath(fragment.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureFragment fragmentInstanceThree = instanceFactory.createArchitectureFragment();
					fragmentInstanceThree.setName(fragment.getName());
					fragmentInstanceThree.setContent(fragment.getContent());
					fragmentInstanceThree.setPath(fragment.getPath());

					architectureInstance.getFragments().add(fragmentInstanceTwo);
					fragmentContainerOne.getFragments().add(fragmentInstanceThree);
				}

				architectureInstance.getFragmentContainers().add(fragmentContainerOne);
			}
		}

		//Para cada  template incluso realiza o processamento do template.
		for ( ArchitectureTemplate template : architectureTemplates ) {
			processTemplate(template,instance);
		}		
	}

	/**
	 * M�todo retorna a configura��o do modelo de features para o produto alvo
	 * @param fmpProject
	 * @return
	 */
	private FeatureInstance readFeatureModelConfiguration(Project fmpProject) {
		Feature model = fmpProject.getModel();
		EList modelChildren = model.getChildren();
		Feature modelChild = (Feature)modelChildren.get(0);
		EList modelChildConfs = modelChild.getConfs();
		Feature childConf = (Feature)modelChildConfs.get(featureModelInstance);

		FeatureInstance featureInstance = instanceFactory.createFeatureInstance();	
		featureInstance.setName(childConf.getName());

		if ( childConf.getTypedValue() != null ) {
			featureInstance.setAttribute(childConf.getTypedValue().getStringValue());
		}

		br.pucrio.inf.les.genarch.models.instance.Feature rootFeature = toFeature((Feature)childConf);		
		featureInstance.setRoot(rootFeature);
		
		return featureInstance;
	}

	private br.pucrio.inf.les.genarch.models.instance.Feature toFeature(Feature fmpFeature) {
		String name = fmpFeature.getName();
		String id = fmpFeature.getId();
		String value = "";

		if ( fmpFeature.getTypedValue() != null ) {
			value = fmpFeature.getTypedValue().getValueToString();
		}

		int max = fmpFeature.getMax();
		int min = fmpFeature.getMin();

		br.pucrio.inf.les.genarch.models.instance.Feature newFeature = br.pucrio.inf.les.genarch.models.instance.InstanceFactory.eINSTANCE.createFeature();
		newFeature.setId(id);
		newFeature.setName(name);
		newFeature.setAttribute(value);
		newFeature.setMax(max);
		newFeature.setMin(min);

		boolean checked = true;

		if ( fmpFeature.isOptional() ) {			
			if ( (fmpFeature.getState().getValue() == 1) || (fmpFeature.getState().getValue() == 3) ) {
				checked = true;				
			} else {
				checked = false;
			}
		} 

		newFeature.setIsSelected(checked);

		for ( Object child : fmpFeature.getChildren() ) {
			if ( child instanceof FeatureGroup ) {
				FeatureGroup group = (FeatureGroup)child;				
				for ( Object childGroup : group.getChildren() ) {
					newFeature.getFeatures().add(this.toFeature((Feature)childGroup));
				}
			} else {
				newFeature.getFeatures().add(this.toFeature((Feature)child));
			}			
		}

		return newFeature;		
	}

	/**
	 * M�todo aparentemente n�o utilizado
	 * @param fmpFeature
	 * @param parentFeature
	 */
	private void toFeatureChild(Feature fmpFeature,br.pucrio.inf.les.genarch.models.instance.Feature parentFeature) {
		boolean checked = true;

		if ( fmpFeature.isOptional() ) {			
			if ( (fmpFeature.getState().getValue() == 1) || (fmpFeature.getState().getValue() == 3) ) {
				checked = true;				
			} else {
				checked = false;
			}
		} else {
			checked = checkParent(fmpFeature);
		}

		if ( checked ) {
			String name = fmpFeature.getName();
			String value = "";

			if ( fmpFeature.getTypedValue() != null ) {
				value = fmpFeature.getTypedValue().getValueToString();
			}

			int max = fmpFeature.getMax();
			int min = fmpFeature.getMin();

			br.pucrio.inf.les.genarch.models.instance.Feature newFeature = br.pucrio.inf.les.genarch.models.instance.InstanceFactory.eINSTANCE.createFeature();
			newFeature.setName(name);
			newFeature.setAttribute(value);
			newFeature.setMax(max);
			newFeature.setMin(min);
			newFeature.setIsSelected(checked); 

			for ( Object child : fmpFeature.getChildren() ) {
				if ( child instanceof FeatureGroup ) {
					FeatureGroup group = (FeatureGroup)child;				
					for ( Object childGroup : group.getChildren() ) {
						this.toFeatureChild((Feature)childGroup,newFeature);
					}
				} else {
					this.toFeatureChild((Feature)child,newFeature);
				}			
			}

			parentFeature.getFeatures().add(newFeature);
		}				
	}

	private boolean checkParent(Feature fmpFeature) {
		Object parent = fmpFeature.eContainer();

		if ( parent != null ) {
			Feature fmpParent = null;

			if ( parent instanceof Feature ) {
				fmpParent = (Feature)parent;
			} else if ( parent instanceof FeatureGroup ) {
				fmpParent = ((Feature)((FeatureGroup)parent).eContainer());
			}

			if ( fmpParent != null ) {
				if ( fmpParent.isOptional() ) {
					if ( (fmpParent.getState().getValue() == 1) || (fmpParent.getState().getValue() == 3) ) {
						return true;
					} else {
						return false;
					}
				} else {
					return checkParent(fmpParent);
				}
			}

			return true;
		} else {
			return true;
		}
	}

	/**
	 * Inclui um diret�rio no produto final, incluindo tamb�m subdiretorios recurcivamente, 
	 * se o diretorio possuir arquivos inclui tamb�m sempre verificando a configura��o das features do produto.
	 * @param folder Diret�rio a ser incluso
	 * @param architectureInstance Instancia da Arquitetura
	 * @param featureConfiguration Instancia da Configura��o do modelo de Features
	 * @return
	 */
	private br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder createFolder(ArchitectureFolder folder,ArchitectureInstance architectureInstance,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {

		IFolder newFolder = buildFolder(folder.getPath());

		br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder folderInstance = instanceFactory.createArchitectureFolder();
		folderInstance.setName(folder.getName());
		folderInstance.setPath(folder.getPath());

		EList templates = folder.getTemplates();

		for ( int templatesCount = 0; templatesCount < templates.size(); templatesCount++ ) {
			ArchitectureTemplate template = (ArchitectureTemplate)templates.get(templatesCount);
			ConfigurationTemplate configurationTemplate = (ConfigurationTemplate)this.findConfigurationElementByPath(template.getPath());

			if ( configurationTemplate != null ) {
				boolean status = this.evalFeatureConfiguration(configurationTemplate,featureConfiguration);
				if ( status ) {				
					architectureTemplates.add(template);
				}
			} else {
				architectureTemplates.add(template);
			}
		}

		EList files = folder.getFiles();

		for ( int filesCount = 0; filesCount < files.size(); filesCount++ ) {
			ArchitectureFile file = (ArchitectureFile)files.get(filesCount);
			ConfigurationFile configurationFile = (ConfigurationFile)this.findConfigurationElementByPath(file.getPath());

			if ( configurationFile != null ) {
				boolean status = this.evalFeatureConfiguration(configurationFile,featureConfiguration);
				if (status) {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceOne = instanceFactory.createArchitectureFile();
					fileInstanceOne.setName(file.getName());
					fileInstanceOne.setPath(file.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
					fileInstanceTwo.setName(file.getName());
					fileInstanceTwo.setPath(file.getPath());

					folderInstance.getFiles().add(fileInstanceOne);
					architectureInstance.getFiles().add(fileInstanceTwo);

					copyEntity(file);
				}
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceOne = instanceFactory.createArchitectureFile();
				fileInstanceOne.setName(file.getName());
				fileInstanceOne.setPath(file.getPath());

				br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
				fileInstanceTwo.setName(file.getName());
				fileInstanceTwo.setPath(file.getPath());

				folderInstance.getFiles().add(fileInstanceOne);
				architectureInstance.getFiles().add(fileInstanceTwo);

				copyEntity(file);
			}
		}

		EList subFolders = folder.getSubFolders();

		for ( int subFoldersCount = 0; subFoldersCount < subFolders.size(); subFoldersCount++ ) {
			ArchitectureFolder subFolder = (ArchitectureFolder)subFolders.get(subFoldersCount);
			ConfigurationFolder configurationSubFolder = (ConfigurationFolder)this.findConfigurationElementByPath(subFolder.getPath());

			if ( configurationSubFolder != null ) {
				boolean status = this.evalFeatureConfiguration(configurationSubFolder,featureConfiguration);
				if ( status ) {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder subFolderInstance = createFolder(subFolder,architectureInstance,featureConfiguration);
					if ( subFolderInstance.eAllContents().hasNext() ) {
						architectureInstance.getFolders().add(subFolderInstance);
						folderInstance.getSubFolders().add(subFolderInstance);
					}
				}
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder subFolderInstance = createFolder(subFolder,architectureInstance,featureConfiguration);
				if ( subFolderInstance.eAllContents().hasNext() ) {
					architectureInstance.getFolders().add(subFolderInstance);
					folderInstance.getSubFolders().add(subFolderInstance);
				}
			}
		}

		if ( folderInstance.eAllContents().hasNext() ) {
			architectureInstance.getFolders().add(folderInstance);
		}

		try {
			if ( newFolder.members().length == 0 ) {
				newFolder.delete(true, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return folderInstance;
	}
	
	
	
	/**
	 * Inclui um diret�rio no produto final
	 * @param name Nome do diretorio a ser criado
	 * @param path Caminho do diretorio a ser criado
	 * @param architectureInstance Instancia da Arquitetura
	 * @return
	 */
	private br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder createSingleFolder(String name, String path, ArchitectureInstance architectureInstance) {

		buildFolder(path);
		br.pucrio.inf.les.genarch.models.instance.ArchitectureFolder folderInstance = instanceFactory.createArchitectureFolder();
		folderInstance.setName(name);
		folderInstance.setPath(path);

		if ( folderInstance.eAllContents().hasNext() ) {
			architectureInstance.getFolders().add(folderInstance);
		}

		

		return folderInstance;
	}

	/**
	 * Insere um componente (artefato) no produto Java, AspectJ e Templates
	 * @param component O componente(artefato) a ser incluido no produto
	 * @param architectureInstance Instancia da arquitetura
	 * @param featureConfiguration Configura��o features do produto
	 * @return
	 */
	private br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent createComponent(ArchitectureComponent component,ArchitectureInstance architectureInstance,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {		
		IFolder newFolder = buildFolder(component.getPath());//Cria o caminho de diret�rios ate o componente

		//Cria uma inst�ncia do componente
		br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent componentInstance = instanceFactory.createArchitectureComponent();
		componentInstance.setName(component.getName());
		componentInstance.setPath(component.getPath());

		//Trata classes Java
		EList classes = component.getClasses();
		

		for ( int classesCount = 0; classesCount < classes.size(); classesCount++ ) {
			ArchitectureClass clazz = (ArchitectureClass)classes.get(classesCount);
			//Encontra o componente de mapeamento para a classe
			ConfigurationClass configurationClass = (ConfigurationClass)this.findConfigurationElementByPath(clazz.getPath());

			//Se for  uma classe anotada
			if ( configurationClass != null ) {
				//verifica se a classe foi marcada selecioanda ou n�o na configura��o das features do produto.
				boolean status = this.evalFeatureConfiguration(configurationClass,featureConfiguration);
				if (status) {//Cria duas instancias da classe 				
					br.pucrio.inf.les.genarch.models.instance.ArchitectureClass classInstanceOne = instanceFactory.createArchitectureClass();
					classInstanceOne.setName(clazz.getName());
					classInstanceOne.setPath(clazz.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureClass classInstanceTwo = instanceFactory.createArchitectureClass();
					classInstanceTwo.setName(clazz.getName());
					classInstanceTwo.setPath(clazz.getPath());

					componentInstance.getClasses().add(classInstanceOne);
					architectureInstance.getClasses().add(classInstanceTwo);//Adiciona a classe no modelo de arquitetura do protudo.

					copyEntity(clazz);//Copia a entidade para o novo produto.
				}		
			} else {//Se � uma classe normal apenas inclui
				br.pucrio.inf.les.genarch.models.instance.ArchitectureClass classInstanceOne = instanceFactory.createArchitectureClass();
				classInstanceOne.setName(clazz.getName());
				classInstanceOne.setPath(clazz.getPath());

				br.pucrio.inf.les.genarch.models.instance.ArchitectureClass classInstanceTwo = instanceFactory.createArchitectureClass();
				classInstanceTwo.setName(clazz.getName());
				classInstanceTwo.setPath(clazz.getPath());

				componentInstance.getClasses().add(classInstanceOne);
				architectureInstance.getClasses().add(classInstanceTwo);

				copyEntity(clazz);
			}
		}

		//Trata aspectos AspectJ
		EList aspects = component.getAspects();

		for ( int aspectsCount = 0; aspectsCount < aspects.size(); aspectsCount++ ) {
			ArchitectureAspect aspect = (ArchitectureAspect)aspects.get(aspectsCount);
			ConfigurationAspect configurationAspect = (ConfigurationAspect)findConfigurationElementByPath(aspect.getPath());

			//Aspecto anotado, ent�o verifica se selecionado nas configura��es de features do produto
			if ( configurationAspect != null ) {
				boolean status = this.evalFeatureConfiguration(configurationAspect,featureConfiguration);
				if (status) {					
					br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect aspectInstanceOne = instanceFactory.createArchitectureAspect();
					aspectInstanceOne.setName(aspect.getName());
					aspectInstanceOne.setPath(aspect.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect aspectInstanceTwo = instanceFactory.createArchitectureAspect();
					aspectInstanceTwo.setName(aspect.getName());
					aspectInstanceTwo.setPath(aspect.getPath());

					architectureInstance.getAspects().add(aspectInstanceOne);
					componentInstance.getAspects().add(aspectInstanceTwo);

					copyEntity(aspect);
				}							
			} else {// Aspecto n�oa notado � incluso
				br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect aspectInstanceOne = instanceFactory.createArchitectureAspect();
				aspectInstanceOne.setName(aspect.getName());
				aspectInstanceOne.setPath(aspect.getPath());

				br.pucrio.inf.les.genarch.models.instance.ArchitectureAspect aspectInstanceTwo = instanceFactory.createArchitectureAspect();
				aspectInstanceTwo.setName(aspect.getName());
				aspectInstanceTwo.setPath(aspect.getPath());

				architectureInstance.getAspects().add(aspectInstanceOne);
				componentInstance.getAspects().add(aspectInstanceTwo);

				copyEntity(aspect);
			}
		}

		//Trata templates
		EList templates = component.getTemplates();

		for ( int templatesCount = 0; templatesCount < templates.size(); templatesCount++ ) {
			ArchitectureTemplate template = (ArchitectureTemplate)templates.get(templatesCount);
			ConfigurationTemplate configurationTemplate = (ConfigurationTemplate)this.findConfigurationElementByPath(template.getPath());

			if ( configurationTemplate != null ) { //se o template for anotado
				System.out.println(configurationTemplate.getFeatureExpression().getExpression());
				boolean status = this.evalFeatureConfiguration(configurationTemplate,featureConfiguration);
				if ( status ) {
					architectureTemplates.add(template);
				}
			} else {
				architectureTemplates.add(template);
			}
		}

		//Trata arquivos como componentes.
		EList files = component.getFiles();

		for ( int filesCount = 0; filesCount < files.size(); filesCount++ ) {
			ArchitectureFile file = (ArchitectureFile)files.get(filesCount);
			ConfigurationFile configurationFile = (ConfigurationFile)this.findConfigurationElementByPath(file.getPath());

			if ( configurationFile != null ) {
				boolean status = this.evalFeatureConfiguration(configurationFile,featureConfiguration);
				if (status) {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceOne = instanceFactory.createArchitectureFile();
					fileInstanceOne.setName(file.getName());
					fileInstanceOne.setPath(file.getPath());

					br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
					fileInstanceTwo.setName(file.getName());
					fileInstanceTwo.setPath(file.getPath());

					componentInstance.getFiles().add(fileInstanceOne);
					architectureInstance.getFiles().add(fileInstanceTwo);

					copyEntity(file);
				}
			} else {
				br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceOne = instanceFactory.createArchitectureFile();
				fileInstanceOne.setName(file.getName());
				fileInstanceOne.setPath(file.getPath());

				br.pucrio.inf.les.genarch.models.instance.ArchitectureFile fileInstanceTwo = instanceFactory.createArchitectureFile();
				fileInstanceTwo.setName(file.getName());
				fileInstanceTwo.setPath(file.getPath());

				componentInstance.getFiles().add(fileInstanceOne);
				architectureInstance.getFiles().add(fileInstanceTwo);

				copyEntity(file);
			}
		}

		//Trata subcomponentes para o caso dos componentes inclusos tem pastas
		EList subComponents = component.getSubComponents();

		for ( int subComponentCount = 0; subComponentCount < subComponents.size(); subComponentCount++ ) {
			ArchitectureComponent subComponent = (ArchitectureComponent)subComponents.get(subComponentCount);
			ConfigurationComponent configurationSubComponent = (ConfigurationComponent)this.findConfigurationElementByPath(subComponent.getPath());

			if ( configurationSubComponent != null ) { //Se o subComponente estiver mapeado verifica se foi selecionado.
				boolean status = this.evalFeatureConfiguration(configurationSubComponent,featureConfiguration);
				if ( status ) {
					br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent subComponentInstance = createComponent(subComponent,architectureInstance,featureConfiguration);
					if ( subComponentInstance.eAllContents().hasNext() ) {
						architectureInstance.getComponents().add(subComponentInstance);
						componentInstance.getSubComponents().add(subComponentInstance);
					}
				}
			} else {//Se o subcomponente n�o estiver mapeado inclui
				br.pucrio.inf.les.genarch.models.instance.ArchitectureComponent subComponentInstance = createComponent(subComponent,architectureInstance,featureConfiguration);
				if ( subComponentInstance.eAllContents().hasNext() ) {
					architectureInstance.getComponents().add(subComponentInstance);
					componentInstance.getSubComponents().add(subComponentInstance);
				}
			}
		}
		
		//??
		if ( componentInstance.eAllContents().hasNext() ) {
			architectureInstance.getComponents().add(componentInstance);
		}

		//Caso tenho sido criada um diretorio mas o arquivo n�o foi incluso ent�o deleta o diretorio.
		try {
			if ( newFolder.members().length == 0 ) {
				newFolder.delete(true, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		return componentInstance;
	}

	/**
	 * Processa o template
	 * @param template
	 * @param instance
	 */
	private void processTemplate(ArchitectureTemplate template,Instance instance) {
		monitor.subTask("Processing Template \"" + template.getPath() + "\"");

		IPath filePath = new Path(template.getPath());
		IResource entityResource = this.project.findMember(filePath);

		IPath resourcePath = entityResource.getProjectRelativePath();

		IPath instantiationPath = newProductProject.getLocation().append(template.getGenerationPath());

		if ( filePath.getFileExtension().equals("xpt") ) {
			IPath templatePath = project.getFile(template.getPath()).getFullPath();

			String xPandPath = resourcePath.removeFirstSegments(1).removeFileExtension().toString().replace("/", "::") + "::Main";
			GenerateXPandTemplates.getInstance().generate(instantiationPath,templatePath,xPandPath,instance,InstancePackage.eINSTANCE);
		}

		monitor.worked(1);
	}
	/**
	 * Verifica se feature esta selecionada, retornando true ou false
	 */
	private boolean evalFeatureConfiguration(MappingEntity entity,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {
		if ( entity.getFeatureExpression() != null ) {
			return Logic.eval(entity.getFeatureExpression().getExpression(),featureConfiguration);
		} else {
			return true;
		}
	}

	/**
	 * Verifica se feature esta selecionada, retornando true ou false
	 */
	private boolean evalFeatureConfiguration(ConfigurationFragment entity,br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {
		if ( entity.getFeatureExpression() != null ) {
			return Logic.eval(entity.getFeatureExpression().getExpression(),featureConfiguration);
		} else {
			return true;
		}
	}

	/**
	 * Copia artefato para o produto.
	 * @param entity
	 */
	private void copyEntity(br.pucrio.inf.les.genarch.models.architecture.ArchitectureEntity entity) {
		monitor.subTask("Coping File \"" + entity.getPath() + "\"");

		String filePath = entity.getPath();
		System.out.println(filePath);

		IResource entityResource = this.project.findMember(filePath);

		IPath instProjectPath = this.newProductProject.getFullPath();
		IPath resourcePath = entityResource.getProjectRelativePath();

		try {
			entityResource.copy(instProjectPath.append(resourcePath), true, null);
		} catch (CoreException e) {
			e.printStackTrace();
			GenarchEMFPlugin.INSTANCE.log(e);
		}

		if ( entityResource instanceof IFile ) {
			IFile newEntityFile = newProductProject.getFile(entity.getPath());
			
			//remove as annotations do c�digo java
			if ( "java".equals(newEntityFile.getFileExtension()) ) {
				JavaAnnotationUtil.removeFeatureAnnotations(newEntityFile);
				JavaAnnotationUtil.removeVariabilityAnnotation(newEntityFile);				
			} else if ( "aj".equals(newEntityFile.getFileExtension())) {//remove as annotations do c�digo AspectJ
				AspectAnnotationUtil.removeFeaturesAnnotation(newEntityFile);
				AspectAnnotationUtil.removeVariabilityAnnotation(newEntityFile);
			}				
		}

		monitor.worked(1);
	}

	/**
	 * Cria um diretorio no caminho especificado
	 * @param folderPath
	 * @return
	 */
	private IFolder buildFolder(String folderPath) {
		monitor.subTask("Creating Folder \"" + folderPath + "\"");
		IFolder subComponentFolder = this.newProductProject.getFolder(new Path(folderPath));

		if ( !subComponentFolder.exists() ) {
			try {
				subComponentFolder.create(false, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
				GenarchEMFPlugin.INSTANCE.log(e);
			}
		}

		monitor.worked(1);

		return subComponentFolder;
	}

	/**
	 * M�todo procura o mapeamento de um componente(artefato) no mapeamento proveniente do modelo de configura��es.
	 * @param path
	 * @return Mapeamento encontrado para o artefato 
	 */
	private EObject findConfigurationElementByPath(String path) {	
		TreeIterator configurationContents = mappingRelationships.eAllContents();

		while ( configurationContents.hasNext() ) {
			EObject o = (EObject)configurationContents.next();
			if ( o instanceof MappingEntity ) {
				MappingEntity entity = (MappingEntity)o;

				if ( entity.getPath().equals(path) ) {
					return entity;
				}
			}
		}

		return null;
	}
	
	
	/**
	 * Procura o fragmento pelo nome e retorna o mapeamento se exisitr.
	 * @param name
	 * @return mapeamento (fragmento - feature)
	 */
	private ConfigurationFragment findFragmentByName(String name) {
		TreeIterator configurationContents = mappingRelationships.eAllContents();

		while ( configurationContents.hasNext() ) {
			EObject o = (EObject)configurationContents.next();
			if ( o instanceof ConfigurationFragment ) {
				ConfigurationFragment fragment = (ConfigurationFragment)o;

				if ( fragment.getName().equals(name) ) {
					return fragment;
				}
			}
		}

		return null;
	}

	class DerivationInstance {

		private FeatureInstance featureInstance;
		private FeatureElements featureElements;
		private br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration;

		public FeatureInstance getFeatureInstance() {
			return featureInstance;
		}

		public void setFeatureInstance(FeatureInstance featureInstance) {
			this.featureInstance = featureInstance;
		}

		public FeatureElements getFeatureElements() {
			return featureElements;
		}

		public void setFeatureElements(FeatureElements featureElements) {
			this.featureElements = featureElements;
		}

		public br.pucrio.inf.les.genarch.models.instance.Feature getFeatureConfiguration() {
			return featureConfiguration;
		}

		public void setFeatureConfiguration(br.pucrio.inf.les.genarch.models.instance.Feature featureConfiguration) {
			this.featureConfiguration = featureConfiguration;
		}
	}
}
