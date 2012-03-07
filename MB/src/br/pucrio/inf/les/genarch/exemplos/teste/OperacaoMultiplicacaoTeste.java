package br.pucrio.inf.les.genarch.exemplos.teste;

import junit.framework.TestCase;
import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.annotations.Features;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.Operacao;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoMultiplicacao;

@Features({@Feature(name="Multiplicacao", parent="Operacao", type=FeatureType.optional),@Feature(name="Teste", parent="MB", type=FeatureType.optional)})
public class OperacaoMultiplicacaoTeste extends TestCase {
	
	public OperacaoMultiplicacaoTeste() {
		
	}
	@Features({@Feature(name="Multiplicacao", parent="Operacao", type=FeatureType.optional),@Feature(name="Teste", parent="MB", type=FeatureType.optional)})
	public void testResultado() {
		Operacao op = new OperacaoMultiplicacao();
		op.setTermoUm(2);
		op.setTermoDois(2);
		assertEquals(4.0f,op.resultado());
	}

}
