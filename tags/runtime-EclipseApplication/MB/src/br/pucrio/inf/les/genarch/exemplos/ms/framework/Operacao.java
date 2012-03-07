package br.pucrio.inf.les.genarch.exemplos.ms.framework;

import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.plus.Verificador;

@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
public abstract class Operacao {
	
	@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
	private float termoUm;
	
	@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
	private float termoDois;

	@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
	public void setTermoUm(float valor) {
		termoUm = valor;
	}
	
	@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
	public void setTermoDois(float valor) {
		termoDois = valor;
	}
			
	@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
	public float getTermoUm() {
		
		
		{
			int declaration;
			
			declaration = 2;
		}
		return termoUm;
	}

	@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
	public float getTermoDois() {
		return termoDois;
	}
	
	@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
	//metodo de teste do analisador, 
	//verifica o suo de artefatos opcionais por outros artefatos
	public float testeOpcional() {
		Verificador verificador =  new Verificador();
		verificador.verificaSubtracao();
		return termoDois;
	}

	@Feature(name="Operacao",parent="MB",type=FeatureType.mandatory)
	public abstract float resultado();
	
	
	
}
