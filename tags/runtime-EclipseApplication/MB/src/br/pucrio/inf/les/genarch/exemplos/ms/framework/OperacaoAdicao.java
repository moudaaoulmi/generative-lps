package br.pucrio.inf.les.genarch.exemplos.ms.framework;

import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.annotations.Features;
import br.pucrio.inf.les.genarch.core.annotations.UseCase;



@Feature(name="Adicao",parent="Operacao",type=FeatureType.optional)
@UseCase(name="SomarUC")
public class OperacaoAdicao extends Operacao {
	@Features({@Feature(name="Feature1",parent="Adicao",type=FeatureType.optional),@Feature(name="Feature2",parent="Adicao",type=FeatureType.optional)})
	@UseCase(name="testeFieldUC")
	private int testeField;
	
	@Override	
	@Feature(name="Adicao",parent="Operacao",type=FeatureType.optional)
	@UseCase(name="metodoResultadoUC")
	public float resultado() {
		return getTermoUm() + getTermoDois();
	}
	
	
}
