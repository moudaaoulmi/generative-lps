package br.pucrio.inf.les.genarch.exemplos.ms.ui.aspects;
import javax.swing.JButton;
import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.Operacao;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoMultiplicacao;
import br.pucrio.inf.les.genarch.exemplos.ms.ui.Jgms;

@Feature(name="Multiplicacao", parent="Operacao", type=FeatureType.optional)
public privileged aspect OperacaoMultiplicacaoUI {

	after(Jgms cthis) returning:  execution(private void Jgms.addComponents()) && this (cthis) {
		cthis.jContentPane.add(cthis.getMultiplicaoBtn(),null);

	}
	public JButton Jgms.getMultiplicaoBtn(){
		if (multiplicacaoBtn == null) {
				multiplicacaoBtn=new JButton();
				multiplicacaoBtn.setText("Multiplicação");
				multiplicacaoBtn.setBounds(235,150,110,30);
				multiplicacaoBtn.addActionListener(new java.awt.event.ActionListener(){
						public void actionPerformed(						java.awt.event.ActionEvent e){
								Operacao op=new OperacaoMultiplicacao();
								op.setTermoUm(Float.valueOf(getTermoUmField().getText()));
								op.setTermoDois(Float.valueOf(getTermoDoisField().getText()));
								getResultadoField().setText(String.valueOf(op.resultado()));
						}
				}
);
		}
		return multiplicacaoBtn;
	}

	public JButton Jgms.multiplicacaoBtn = null;

}