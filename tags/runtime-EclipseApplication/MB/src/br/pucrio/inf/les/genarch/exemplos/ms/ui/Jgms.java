package br.pucrio.inf.les.genarch.exemplos.ms.ui;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Jgms extends JFrame {
	
	private JPanel jContentPane = null;

	private JTextField termoUmField = null;
	
	private JTextField termoDoisField = null;
	
	private JTextField resultadoField = null;
	
	private JLabel termoUmLbl = null;
	
	private JLabel termoDoisLbl = null;
	
	private JLabel resultadoLbl = null;
	
	public Jgms() {
		super("Metemática Básica");
		initialize("Matemática Básica");
	}
	
	private void initialize(String name) {
		this.setContentPane(getJContentPane());
		this.setTitle(name);
		this.setBounds(new Rectangle(0,0,470,210));
		this.setResizable(false);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				dispose();
			}
		});			
	}
	
	protected JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			addComponents();
		}
		return jContentPane;
	}
		
	private void addComponents() {			
		jContentPane.add(getTermoUmField(),null);
		jContentPane.add(getTermoDoisField(),null);
		jContentPane.add(getResultadoField(),null);	
		jContentPane.add(getTermoUmLbl(),null);
		jContentPane.add(getTermoDoisLbl(),null);
		jContentPane.add(getResultadoLbl(),null);			
	}
	
	
	
	public JLabel getTermoUmLbl() {
		if (termoUmLbl == null) {
			termoUmLbl = new JLabel();
			termoUmLbl.setText("Primerio Termo");
			termoUmLbl.setBounds(5, 8, 150, 10);
		}
		
		return termoUmLbl;
	}
	
	public JLabel getTermoDoisLbl() {
		if (termoDoisLbl == null) {
			termoDoisLbl = new JLabel();
			termoDoisLbl.setText("Segundo Termo");
			termoDoisLbl.setBounds(5, 68, 150, 10);
		}
		
		return termoDoisLbl;
	}
	
	public JLabel getResultadoLbl() {
		if (resultadoLbl == null) {
			resultadoLbl = new JLabel();
			resultadoLbl.setText("Resultado");
			resultadoLbl.setBounds(200, 8, 150, 10);
		}
		
		return resultadoLbl;
	}
	
	public JTextField getTermoUmField() {
		if (termoUmField == null) {
			termoUmField = new JTextField();
			termoUmField.setBounds(5, 20, 150, 25);
		}
		return termoUmField;
	}
	
	public JTextField getTermoDoisField() {
		if (termoDoisField == null) {
			termoDoisField = new JTextField();
			termoDoisField.setBounds(5, 80, 150, 25);
		}
		
		return termoDoisField;
	}
	
	public JTextField getResultadoField() {
		if (resultadoField == null) {
			resultadoField = new JTextField();
			resultadoField.setBounds(200, 20, 150, 25);
			resultadoField.setEditable(false);
		}
		
		return resultadoField;
	}
	
	public static void main(String[] args) {
		Jgms jgms = new Jgms();
		jgms.setVisible(true);
	}

}