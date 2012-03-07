package br.pucrio.inf.les.genarch.exemplos.ms.ui.aspects;
import javax.swing.JButton;
import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.Operacao;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoSubtracao;
import br.pucrio.inf.les.genarch.exemplos.ms.ui.Jgms;

@Feature(name="Subtracao", parent="Operacao", type=FeatureType.optional)
public privileged aspect OperacaoSubtracaoUI {

	after(Jgms cthis) returning:  execution(private void Jgms.addComponents()) && this (cthis) {
		cthis.jContentPane.add(cthis.getSubtracaoBtn(),null);

	}
	public JButton Jgms.getSubtracaoBtn(){
		if (subtracaoBtn == null) {
				subtracaoBtn=new JButton();
				subtracaoBtn.setText("Subtração");
				subtracaoBtn.setBounds(120,150,110,30);
				subtracaoBtn.addActionListener(new java.awt.event.ActionListener(){
						public void actionPerformed(						java.awt.event.ActionEvent e){
								Operacao op=new OperacaoSubtracao();
								op.setTermoUm(Float.valueOf(getTermoUmField().getText()));
								op.setTermoDois(Float.valueOf(getTermoDoisField().getText()));
								getResultadoField().setText(String.valueOf(op.resultado()));
						}
				}
);
		}
		return subtracaoBtn;
	}

	public JButton Jgms.subtracaoBtn = null;

}