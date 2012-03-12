package br.pucrio.inf.les.matcher.util.filter;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import br.pucrio.inf.les.matcher.util.Utils;

public class EMFFileFilter extends FileFilter{
	
	@Override
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		
		String extension = Utils.getExtension(pathname);
		if(extension != null){
			if(extension.equals(Utils.emf_extension))
				return true;
			else
				return false;
		}
		
		return false;
	}
	
	public String getDescription(){
		return "EMF - Generative Model";
	}
	
	
}
