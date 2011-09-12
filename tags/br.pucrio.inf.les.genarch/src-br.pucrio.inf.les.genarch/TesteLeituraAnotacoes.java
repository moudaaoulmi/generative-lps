import java.util.HashMap;

import org.aspectj.org.eclipse.jdt.core.dom.AST;
import org.aspectj.org.eclipse.jdt.core.dom.ASTParser;
import org.aspectj.org.eclipse.jdt.core.dom.AjNaiveASTFlattener;
import org.aspectj.org.eclipse.jdt.core.dom.CompilationUnit;


public class TesteLeituraAnotacoes {

	public static void main(String []argv) {
	     ASTParser parser = ASTParser.newParser(AST.JLS3);
	     parser.setCompilerOptions(new HashMap());
	     parser.setSource(argv[0].toCharArray());
	     CompilationUnit cu2 = (CompilationUnit) parser.createAST(null);
	     AjNaiveASTFlattener visitor = new AjNaiveASTFlattener();
	     cu2.accept(visitor);
	     System.err.println(visitor.getResult());
	   }

}
