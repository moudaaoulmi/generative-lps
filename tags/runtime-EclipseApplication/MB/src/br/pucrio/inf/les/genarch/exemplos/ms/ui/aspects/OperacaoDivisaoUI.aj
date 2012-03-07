package br.pucrio.inf.les.genarch.exemplos.ms.ui.aspects;
import javax.swing.JButton;
import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.Operacao;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoDivisao;
import br.pucrio.inf.les.genarch.exemplos.ms.ui.Jgms;

@Feature(name="Divisao", parent="Operacao", type=FeatureType.optional)
public privileged aspect OperacaoDivisaoUI {

	after(Jgms cthis) returning:  execution(private void Jgms.addComponents()) && this (cthis) {
		cthis.jContentPane.add(cthis.getDivisaoBtn(),null);

	}
	public JButton Jgms.getDivisaoBtn(){
		if (divisaoBtn == null) {
				divisaoBtn=new JButton();
				divisaoBtn.setText("Divisão");
				divisaoBtn.setBounds(350,150,110,30);
				divisaoBtn.addActionListener(new java.awt.event.ActionListener(){
						public void actionPerformed(						java.awt.event.ActionEvent e){
								Operacao op=new OperacaoDivisao();
								op.setTermoUm(Float.valueOf(getTermoUmField().getText()));
								op.setTermoDois(Float.valueOf(getTermoDoisField().getText()));
								getResultadoField().setText(String.valueOf(op.resultado()));
						}
				}
);
		}
		return divisaoBtn;
	}

	public JButton Jgms.divisaoBtn = null;

}