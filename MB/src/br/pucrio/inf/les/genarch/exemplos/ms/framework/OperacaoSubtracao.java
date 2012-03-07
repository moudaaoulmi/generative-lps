package br.pucrio.inf.les.genarch.exemplos.ms.framework;

import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.annotations.UseCase;

@Feature(name="Subtracao",parent="Operacao",type=FeatureType.optional)
@UseCase(name="classOpeSubUC")
public class OperacaoSubtracao extends Operacao {

	@Override
	@UseCase(name="metodoResultadoUC")
	@Feature(name="Subtracao",parent="Operacao",type=FeatureType.optional)
	public float resultado() {
		return getTermoUm() - getTermoDois();
	}

}
