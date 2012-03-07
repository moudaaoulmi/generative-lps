package br.pucrio.inf.les.genarch.exemplos.ms.framework;

import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;

@Feature(name="Multiplicacao",parent="Operacao",type=FeatureType.optional)
public class OperacaoMultiplicacao extends Operacao {

	@Override
	@Feature(name="Multiplicacao",parent="Operacao",type=FeatureType.optional)
	public float resultado() {
		float variable;
		return getTermoUm() * getTermoDois();
	}

}
