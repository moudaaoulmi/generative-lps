package br.pucrio.inf.les.genarch.exemplos.ms.framework;

public class ClasseStatic {
	
	public static final String teste = "5";
	public static String teste2 = "5";
	public String teste3 = "5";
	
	
	public static OperacaoAdicao getOperacaoAdicao(){
		
		return new OperacaoAdicao();
	}

	public static String getTeste() {
		return teste;
	}

	private static void setTeste2(String teste2) {
		ClasseStatic.teste2 = teste2;
	}

	private static String getTeste2() {
		return teste2;
	}

}
