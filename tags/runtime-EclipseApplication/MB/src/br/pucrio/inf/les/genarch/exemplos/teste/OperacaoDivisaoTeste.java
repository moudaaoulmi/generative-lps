package br.pucrio.inf.les.genarch.exemplos.teste;

import junit.framework.TestCase;
import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.annotations.Features;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.Operacao;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoDivisao;

@Features({@Feature(name="Divisao", parent="Operacao", type=FeatureType.optional),@Feature(name="Teste", parent="MB", type=FeatureType.optional)})
public class OperacaoDivisaoTeste extends TestCase {
	
	public OperacaoDivisaoTeste() {
		
	}
	@Features({@Feature(name="Divisao", parent="Operacao", type=FeatureType.optional),@Feature(name="Teste", parent="MB", type=FeatureType.optional)})
	public void testResultado() {
		Operacao op = new OperacaoDivisao();
		op.setTermoUm(1);
		op.setTermoDois(2);
		assertEquals(0.5f,op.resultado());
	}

}
