package br.pucrio.inf.les.genarch.core.impactanalyzer;

 
import java.io.StringReader;
import java.lang.reflect.Method;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.TargetJDK1_4;
import net.sourceforge.pmd.ast.ASTAnnotation;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceBody;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.ast.ASTCompilationUnit;
import net.sourceforge.pmd.ast.ASTConstructorDeclaration;
import net.sourceforge.pmd.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.ast.ASTLocalVariableDeclaration;
import net.sourceforge.pmd.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.ast.ASTResultType;
import net.sourceforge.pmd.ast.JavaParser;
import net.sourceforge.pmd.ast.Node;

public class UseSingleton {
	
	
	
	
	
	ASTClassOrInterfaceBody classe;
	Object dados;
	
	public UseSingleton(ASTClassOrInterfaceBody classe, Object data){
		this.classe = classe;
		this.dados = data;
		
		
		JavaParser parser = (new TargetJDK1_4()).createParser(new StringReader(TEST1));
		ASTCompilationUnit cu = parser.CompilationUnit();
		for(Method mt : cu.getType().getDeclaredMethods()){
			
		}
		ASTLocalVariableDeclaration node = cu.findChildrenOfType(ASTLocalVariableDeclaration.class).get(0);
		

	}
	
	 private static final String TEST1 ="class Foo {" + PMD.EOL +" void bar() {int x[] = null;}" + PMD.EOL +"}";

	
    public boolean visitante() {
    	    	
        if (classe.jjtGetParent() instanceof ASTClassOrInterfaceDeclaration) {
            ASTClassOrInterfaceDeclaration parent = (ASTClassOrInterfaceDeclaration) classe.jjtGetParent();
            int i = classe.jjtGetNumChildren();
            int methodCount = 0;
            boolean isOK = false;
            while (i > 0) {
                Node p = classe.jjtGetChild(--i);
                if (p.jjtGetNumChildren() == 0) {
                    continue;
                }
                Node n = p.jjtGetChild(0);
                if (n instanceof ASTAnnotation) {
                   n = p.jjtGetChild(1);
                }
                if (n instanceof ASTFieldDeclaration) {
                    if (!((ASTFieldDeclaration) n).isStatic()) {
                        isOK = true;
                        break;
                    }
                } else if (n instanceof ASTConstructorDeclaration) {
                    if (((ASTConstructorDeclaration) n).isPrivate()) {
                        isOK = true;
                        break;
                    }
                } else if (n instanceof ASTMethodDeclaration) {
                   ASTMethodDeclaration m = (ASTMethodDeclaration) n;
                    if (!m.isPrivate()) {
                       methodCount++;
                    }
                    if (!m.isStatic()) {
                        isOK = true;
                        break;
                    }

                    // TODO use symbol table
                   if (m.getMethodName().equals("suite")) {
                        ASTResultType res = m.getResultType();
                        ASTClassOrInterfaceType c = res.getFirstChildOfType(ASTClassOrInterfaceType.class);
                        if (c != null && c.hasImageEqualTo("Test")) {
                            isOK = true;
                            break;
                        }
                    }

                }
            }
            if (!isOK && methodCount > 0) {
                return false;
            }
        }
        return true;
    }

}
