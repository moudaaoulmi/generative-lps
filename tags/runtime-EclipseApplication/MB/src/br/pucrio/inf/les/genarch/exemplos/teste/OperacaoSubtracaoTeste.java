package br.pucrio.inf.les.genarch.exemplos.teste;

import junit.framework.TestCase;
import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.annotations.Features;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.Operacao;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoSubtracao;

/*comentario!*/
@Feature(name="Subtracao", parent="Operacao", type=FeatureType.optional)
public class OperacaoSubtracaoTeste extends TestCase {
	//comentario!
	/*comentario!*/
	public OperacaoSubtracaoTeste() {
		//comentario!
		/*comentario!*/
		{
			//outro
			/*comentario!*/
			int aux = 0;
			OperacaoDivisaoTeste outra = null;
			outra.testResultado();
		}
		
		/**
		 * javadoc
		 */
		{
			
		}
		/*comentario!*/
		
	}
	
	
	@Features({@Feature(name="Operador", parent="Operacao", type=FeatureType.optional),@Feature(name="GrandeTeste", parent="MB", type=FeatureType.optional)})
	public void consultoria() {
		Operacao op = new OperacaoSubtracao();
		op.setTermoUm(2);
		op.setTermoDois(1);
		assertEquals(1.0f,op.resultado());
	}

	@Features({@Feature(name="Subtracao", parent="Operacao", type=FeatureType.optional),@Feature(name="Teste", parent="MB", type=FeatureType.optional)})
	public void testResultado() {
		Operacao op = new OperacaoSubtracao();
		op.setTermoUm(2);
		op.setTermoDois(1);
		assertEquals(1.0f,op.resultado());
	}

}
