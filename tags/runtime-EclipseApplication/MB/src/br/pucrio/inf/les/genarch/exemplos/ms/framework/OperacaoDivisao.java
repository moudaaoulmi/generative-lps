package br.pucrio.inf.les.genarch.exemplos.ms.framework;

import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.annotations.UseCase;

@Feature(name="Divisao",parent="Operacao",type=FeatureType.optional)
@UseCase(name="DivisaoUC")
public class OperacaoDivisao extends Operacao {

	OperacaoAdicao opAd = ClasseStatic.getOperacaoAdicao();
	
	OperacaoAdicao opAd2;
	ClasseStatic classeStatic = new ClasseStatic();
	
	
	@Override
	@Feature(name="Divisao",parent="Operacao",type=FeatureType.optional)
	public float resultado() {
		return getTermoUm() / getTermoDois();
//		ClasseStatic.getOperacaoAdicao();
	}
	@Feature(name="Divisao",parent="Operacao",type=FeatureType.optional)
	
	public OperacaoAdicao getOperacaoAdicao(){
		return new OperacaoAdicao();
	}

}
