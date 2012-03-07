package br.pucrio.inf.les.genarch.exemplos.ms.framework.plus;

import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.annotations.UseCase;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoAdicao;
import br.pucrio.inf.les.genarch.exemplos.teste.OperacaoAdicaoTeste;
import br.pucrio.inf.les.genarch.exemplos.teste.OperacaoSubtracaoTeste;

@Feature(name="Verificador",parent="MB",type=FeatureType.optional)
@UseCase(name="VerificadorUC")
public class Verificador {
	
	OperacaoAdicaoTeste testeAdicao = new OperacaoAdicaoTeste();
	OperacaoSubtracaoTeste testeSubtracao = new OperacaoSubtracaoTeste();
	
	@Feature(name="VerificadorAdicao",parent="Verificador",type=FeatureType.optional)
	@UseCase(name="VerificadorAdicaoUC")
	public void verificaAdicao(){
		testeAdicao.getName();		
	}
	
	@Feature(name="VerificadorSubtracao",parent="Verificador",type=FeatureType.optional)
	@UseCase(name="VerificadorSubtracaoUC")
	public void verificaSubtracao(){
		testeSubtracao.getName();		
	}
	
	@Feature(name="VerificadorSubtracao",parent="Verificador",type=FeatureType.optional)
	@UseCase(name="VerificadorSubtracaoUC")
	public void verificaSubtracaoAlfa(){
		verificaSubtracao();		
	}

}
