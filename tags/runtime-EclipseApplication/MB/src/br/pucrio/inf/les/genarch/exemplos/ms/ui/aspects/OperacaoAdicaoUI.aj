package br.pucrio.inf.les.genarch.exemplos.ms.ui.aspects;
import br.pucrio.inf.les.genarch.core.annotations.Feature;
import br.pucrio.inf.les.genarch.core.annotations.FeatureType;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.Operacao;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoDivisao;
import br.pucrio.inf.les.genarch.exemplos.ms.ui.Jgms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import br.pucrio.inf.les.genarch.exemplos.ms.framework.OperacaoAdicao;

@Feature(name="Adicao", parent="Operacao", type=FeatureType.optional)
public privileged aspect OperacaoAdicaoUI {
	
	after(Jgms cthis) returning:  execution(private void Jgms.addComponents()) && this (cthis) {
		cthis.jContentPane.add(cthis.getAdicaoBtn(),null);

	}
	
	public JButton Jgms.adicaoBtn = null;

	public JButton Jgms.getAdicaoBtn(){
		if (adicaoBtn == null) {
				adicaoBtn=new JButton();
				adicaoBtn.setText("Adição");
				adicaoBtn.setBounds(5,150,110,30);
				adicaoBtn.addActionListener(new java.awt.event.ActionListener(){
						public void actionPerformed(						java.awt.event.ActionEvent e){
								Operacao op=new OperacaoAdicao();
								op.setTermoUm(Float.valueOf(getTermoUmField().getText()));
								op.setTermoDois(Float.valueOf(getTermoDoisField().getText()));
								getResultadoField().setText(String.valueOf(op.resultado()));
						}
				}
);
		}
		return adicaoBtn;
	}

}