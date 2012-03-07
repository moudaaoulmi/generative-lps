package br.pucrio.inf.les.SPLAnalyser.impl.extractor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import sun.security.krb5.internal.MethodData;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Class;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Field;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Method;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.UseCase;
import br.pucrio.inf.les.SPLAnalyser.core.models.util.ImpactAnalysisModelContent;
import br.pucrio.inf.les.genarch.core.models.FeatureModelContent;
import br.pucrio.inf.les.genarch.core.project.elements.AnnotationClassVisitor;
import br.pucrio.inf.les.genarch.core.project.navigation.ResourceClient;

public class UseCaseResourceVisitor implements ResourceClient {

	private ImpactAnalysisModelContent analysisModelContent;
	

	public UseCaseResourceVisitor(ImpactAnalysisModel analysisModel) {
		analysisModelContent = new ImpactAnalysisModelContent(analysisModel);
	}

	public void visit(IResource resource) {
//		List<UseCaseData> useCases = new ArrayList<UseCaseData>();
		String resourceName = resource.getName();
		String resourcePhysicalPath = resource.getProjectRelativePath().toString();
		if ( resource.getType() == IResource.FILE ) {

			if ( resource.getFileExtension().equals("java") ) {	
				String useCaseName = "";
				UseCase useCase;
				for(NormalAnnotation normalAnnotation : getNormalAnnotations((IFile)resource)){
//					UseCaseData useCase = new UseCaseData();
					useCaseName = "";
					
					if ( normalAnnotation.getTypeName().getFullyQualifiedName().equals("UseCase") ) {

						IAnnotationBinding binding = normalAnnotation.resolveAnnotationBinding();

						if (binding == null ) {
							continue;
						}
						IMemberValuePairBinding[] membersValuePairBinding = binding.getDeclaredMemberValuePairs();
						for ( IMemberValuePairBinding memberValuePairBinding : membersValuePairBinding ) {								
							String name = memberValuePairBinding.getName();
							Object value = memberValuePairBinding.getValue();
							if(name.equals("name")){
								useCaseName = (String)value;
							}
						}
						useCase = analysisModelContent.addUseCase(useCaseName);
						//Adiciona classes anotados								
						if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.TypeDeclaration.class)) {
							TypeDeclaration clazz = (TypeDeclaration) normalAnnotation.getParent();
							Class classData = analysisModelContent.findClass(resourceName, classPathTranslator(resourcePhysicalPath, resourceName));
							analysisModelContent.addMapping(null, classData, useCase);
						}

						//Adiciona atributos anotados
						else if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.FieldDeclaration.class)) {
							FieldDeclaration field = (FieldDeclaration) normalAnnotation.getParent();

							List<VariableDeclarationFragment> fragments = field.fragments();

							if (fragments.size() == 1) {
								VariableDeclarationFragment frag = fragments.get(0);
								Field fieldData = analysisModelContent.findField(frag.getName().getFullyQualifiedName(), pathTranslator(resourcePhysicalPath));
								analysisModelContent.addMapping(null, fieldData, useCase);
							}

							//Adiciona metodos anotados
						}else if(normalAnnotation.getParent().getClass().equals(org.eclipse.jdt.core.dom.MethodDeclaration.class)) {
							MethodDeclaration method = (MethodDeclaration) normalAnnotation.getParent();
							Method methodData = analysisModelContent.findMethod(method.getName().toString(), pathTranslator(resourcePhysicalPath));
							analysisModelContent.addMapping(null, methodData, useCase);
						}
					}
				}
				
				

			} 
		}
	}
	

	public ImpactAnalysisModel getAnalysisModel() {
		return this.analysisModelContent.getAnalysisModel();
	}	
	
	private List<NormalAnnotation> getNormalAnnotations(IFile file) {	
		
		FeatureModelContent featuresContent = new FeatureModelContent();
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);

		ASTParser astParser = ASTParser.newParser(AST.JLS3);
		astParser.setSource(compilationUnit);
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);			
		astParser.setResolveBindings(true);
		ASTNode rootNode = astParser.createAST(new NullProgressMonitor());

		AnnotationClassVisitor visitor = new AnnotationClassVisitor();
		rootNode.accept(visitor);
		visitor.getSingleMemberAnnotations();
		visitor.getAnnotationsTypeDeclaration();
		visitor.getAnnotationsTypeMemberDeclaration();
		visitor.getMarkerAnnotations();		
		return visitor.getNormalAnnotations();
	}
	
	
	
	
	
	public String classPathTranslator(String path, String name){
		String newPath = "";
		newPath = path.replace("src/", "");
		newPath = newPath.replaceAll("(/)",".");
		newPath = newPath.replace("."+name,"");
		return newPath;
		
	}
	public String pathTranslator(String path){
		String newPath = "";
		newPath = path.replace("src/", "");
		newPath = newPath.replaceAll("(/)",".");
		newPath = newPath.replace(".java","");
		return newPath;
	}
	
}
