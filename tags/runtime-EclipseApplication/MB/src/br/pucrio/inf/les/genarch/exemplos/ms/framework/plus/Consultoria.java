package br.pucrio.inf.les.genarch.exemplos.ms.framework.plus;

import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.core.annotations.UseCase;


@Feature(name="Consultoria",parent="MB",type=FeatureType.optional)
@UseCase(name="ConsultoriaUC")
public class Consultoria {

	@Feature(name="Consultoria",parent="MB",type=FeatureType.optional)
	Verificador vf = new Verificador();
	
	@Feature(name="Consultoria",parent="MB",type=FeatureType.optional)
	public void realizaConsultoria1(){
		vf.verificaAdicao();
	}
	@Feature(name="Consultoria",parent="MB",type=FeatureType.optional)
	public void realizaConsultoria2(){
		realizaConsultoria1();
	}
}
