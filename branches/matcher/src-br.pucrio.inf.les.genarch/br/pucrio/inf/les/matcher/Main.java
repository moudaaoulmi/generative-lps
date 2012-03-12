package br.pucrio.inf.les.matcher;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;


import br.pucrio.inf.les.genarch.models.instance.InstanceFactory;
import br.pucrio.inf.les.genarch.models.instance.InstancePackage;
import br.pucrio.inf.les.matcher.util.GenerativeModelDiffEngine;
import br.pucrio.inf.les.matcher.util.GenerativeModelMatchEngine;
import br.pucrio.inf.les.matcher.util.filter.EMFFileFilter;

public class Main {
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		File file01;
		File file02;
		EMFFileFilter filter = new EMFFileFilter();
		int returnval;
		
		// [Demóstenes] - Escolhendo o modelo de uma versão.
		JFileChooser chooser01 = new JFileChooser();
		
		chooser01.setFileFilter(filter);
		returnval = chooser01.showOpenDialog(null);
			
		if(returnval != JFileChooser.APPROVE_OPTION){
			JOptionPane.showMessageDialog(null, "Operação cancelada!");
			return;
		}

		// [Demóstenes] - Escolhendo o modelo da outra versão.
		JFileChooser chooser02 = new JFileChooser();
		
		chooser02.setFileFilter(filter);
		returnval = chooser02.showOpenDialog(null);
			
		if(returnval != JFileChooser.APPROVE_OPTION){
			JOptionPane.showMessageDialog(null, "Operação cancelada!");
			return;
		}
		
		file01 = chooser01.getSelectedFile();
		file02 = chooser02.getSelectedFile();
		
		if(file01 == null || file02 == null){
			System.out.println("Fail on load files.");
		}
						
		if (file01.canRead() && file02.canRead()) {
			// Creates the resourceSet where we'll load the models
			final ResourceSet resourceSet = new ResourceSetImpl();
			
			// Register additionnal packages here. 			
			resourceSet.getResourceFactoryRegistry().
				getExtensionToFactoryMap().
					put(".generativemodel",InstanceFactory.eINSTANCE);			
			resourceSet.
				getPackageRegistry().
					put(InstancePackage.eNS_URI, InstancePackage.eINSTANCE);			
						
			try {
				System.out.println("Loading resources.\n"); //$NON-NLS-1$
				// Loads the two models passed as arguments
				final EObject model1 = ModelUtils.load(file01, resourceSet);
				final EObject model2 = ModelUtils.load(file02, resourceSet);

				// Creates the match then the diff model for those two models
				System.out.println("Matching models.\n"); //$NON-NLS-1$							
				
				//Using Eclipse match.
				final MatchModel match = MatchService.doMatch(model1, model2, Collections.<String, Object> emptyMap());
				
				//[Demóstenes] - Using GenericMatchEngine.
				//final MatchModel match = new GenericMatchEngine().contentMatch(model1, model2, Collections.<String, Object> emptyMap());
				
				//[Demóstenes] - Using customized match.
				//GenerativeModelMatchEngine matchEngine = new GenerativeModelMatchEngine();
				//Map<String,Object> options = new HashMap<String, Object>();				
				
				//options.put(MatchOptions.OPTION_IGNORE_ID, false);
				//options.put(MatchOptions.OPTION_IGNORE_XMI_ID, false);
				
				//final MatchModel match = matchEngine.contentMatch(model1, model2, options);							
				
				System.out.println("Differencing models.\n"); //$NON-NLS-1$
				
				//[Demóstenes] - Using Eclipse diff.
				final DiffModel diff = DiffService.doDiff(match, false);
								
				//[Demóstenes] - Using GenericDiff for Stand-alone application.
				//final DiffModel diff = new GenericDiffEngine().doDiff(match);			
				
				//[Demóstenes] - Using customized diff.
				//GenerativeModelDiffEngine diffEngine = new GenerativeModelDiffEngine();
				//final DiffModel diff = diffEngine.doDiff(match_model); 
				
				//System.out.println("Merging difference to args[1].\n"); //$NON-NLS-1$
				//final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());
				//This will merge all references to the right model (second argument).
				//MergeService.merge(differences, true);
								
				// Prints the results
				try {
					System.out.println("MatchModel :\n"); //$NON-NLS-1$
					System.out.println(ModelUtils.serialize(match));
					System.out.println("DiffModel :\n"); //$NON-NLS-1$
					System.out.println(ModelUtils.serialize(diff));
				} catch (IOException e) {
					e.printStackTrace();
				}

				// Serializes the result as "result.emfdiff" in the directory this class has been called from.
				System.out.println("saving emfdiff as \"result.emfdiff\""); //$NON-NLS-1$				
								
				ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();
				
				snapshot.setDate(Calendar.getInstance().getTime());
				snapshot.setMatch(match);
				snapshot.setDiff(diff);
				ModelUtils.save(snapshot, "result.emfdiff"); //$NON-NLS-1$
			} catch (IOException e) {
				// shouldn't be thrown
				e.printStackTrace();
			}
		} else {
			System.out.println("usage : ExampleLauncher <Model1> <Model2>"); //$NON-NLS-1$
		}

	}

}
