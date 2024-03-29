/**
 * @version 05/06/2000 <BR>
 * @author Setpoint Inform�tica Ltda./Fernando Oliveira da Silva <BR>
 *
 * Projeto: Freedom <BR>
 * Pacote: org.freedom.telas <BR>
 * Classe: @(#)Calc.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc� pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa � preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR> <BR>
 *
 * Coment�rios da classe.....
 */

package gui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Container;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Calc extends JInternalFrame implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;

	
	GridBagConstraints gbConst = new GridBagConstraints();        
	GridBagLayout gbCalc = new GridBagLayout();
	JTextField txtRes = new JTextField();
	JTextArea txaCalc = new JTextArea();
	JButton btPerc = new JButton("%");
	JButton btRaiz = new JButton("Raiz");
	JButton btC = new JButton("C");
	JButton btCE = new JButton("CE");
	JButton btMC = new JButton("MC");
	JButton btMR = new JButton("MR");
	JButton btMmais = new JButton("M+");
	JButton btMmenos = new JButton("M-");
	JButton bt7 = new JButton("7");
	JButton bt8 = new JButton("8");
	JButton bt9 = new JButton("9");
	JButton btDiv = new JButton("�");
	JButton bt4 = new JButton("4");
	JButton bt5 = new JButton("5");
	JButton bt6 = new JButton("6");
	JButton btVez = new JButton("*");
	JButton bt1 = new JButton("1");
	JButton bt2 = new JButton("2");
	JButton bt3 = new JButton("3");
	JButton btMenos = new JButton("-");
	JButton bt0 = new JButton("0");
	JButton btPonto = new JButton(".");
	JButton btIgual = new JButton("=");
	JButton btMais = new JButton("+");
	JButton btPot = new JButton("x^x");
	JButton btAlt = new JButton("+/-");
	JButton btBac = new JButton("Back");
	JLabel lbMemo = new JLabel(" "); 
	JPanel pnTeclas = new JPanel();
	JPanel pnTeclas1 = new JPanel();
	JPanel pnTeclas2 = new JPanel();
	JPanel pnTeclas3 = new JPanel();
	JPanel pnTeclas4 = new JPanel();
	JPanel pnTeclas5 = new JPanel();
	JPanel pnTeclas6 = new JPanel(); 
	JPanel pnTeclas7 = new JPanel();
	GridLayout glTeclas = new GridLayout( 1, 4);
	String dg = "";
	double ret = 0;
	double men = 0;
	String num = "";
	double res = 0;
	double memo = 0;
	boolean soma = false;
	boolean somar = false;
	boolean sub = false;
	boolean subtrair = false;
	boolean mult = false;
	boolean multiplicar = false;
	boolean div = false;
	boolean dividir = false;
	boolean pot = false;
	boolean potencia = false;
	boolean calc = false;
	boolean vi = false;
	boolean Ctrl = false;
	boolean Esc = false;
	int esp = 32;
	public Calc() {
		//super(false);
                super("Calculadora", true, true, true, true);
                setClosable(true);
		Container c = getContentPane();
		txaCalc.setEnabled(false);
		txtRes.setEnabled(false);

		txtRes.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txaCalc.setFont(new Font( "fixed", Font.BOLD, 14));
		txtRes.setFont(new Font( "Arial", Font.BOLD, 20));
		lbMemo.setFont(new Font( "Arial", Font.BOLD, 20));
		
		JScrollPane pnCalc = new JScrollPane(txaCalc);
		pnCalc.setPreferredSize(new Dimension( 50, 130));

		gbConst.fill = GridBagConstraints.BOTH;
		gbConst.gridx = 0;
		gbConst.gridy = 0;
		gbConst.gridheight = 1;
		gbConst.gridwidth = 1;
		gbCalc.setConstraints(pnCalc, gbConst);
		
		c.add(pnCalc);

		gbConst.fill = GridBagConstraints.BOTH;
		gbConst.gridx = 0;
		gbConst.gridy = 1;
		gbConst.gridheight = 1;
		gbConst.gridwidth = 1;
		gbCalc.setConstraints(txtRes, gbConst);
		
		c.add(txtRes);

		pnTeclas.setLayout(new GridLayout(7,1));
		pnTeclas1.setLayout(glTeclas);
		pnTeclas1.add(lbMemo);
		btBac.addActionListener(this);
		btBac.addKeyListener(this);
		pnTeclas1.add(btBac);
		btAlt.addActionListener(this);
		btAlt.addKeyListener(this);
		pnTeclas1.add(btAlt);
		btPot.addActionListener(this);
		btPot.addKeyListener(this);
		pnTeclas1.add(btPot);
		pnTeclas.add(pnTeclas1);
		
		pnTeclas2.setLayout(glTeclas);
		btPerc.addActionListener(this);
		btPerc.addKeyListener(this);
		pnTeclas2.add(btPerc);
		btRaiz.addActionListener(this);
		btRaiz.addKeyListener(this);
		pnTeclas2.add(btRaiz);
		btC.addActionListener(this);
		btC.addKeyListener(this);
		pnTeclas2.add(btC);
		btCE.addActionListener(this);
		btCE.addKeyListener(this);
		pnTeclas2.add(btCE);
		pnTeclas.add(pnTeclas2);
		
		pnTeclas3.setLayout(glTeclas);
		btMC.addActionListener(this);
		btMC.addKeyListener(this);
		pnTeclas3.add(btMC);
		btMR.addActionListener(this);
		btMR.addKeyListener(this);
		pnTeclas3.add(btMR);
		btMmenos.addActionListener(this);
		btMmenos.addKeyListener(this);
		pnTeclas3.add(btMmenos);
		btMmais.addActionListener(this);
		btMmais.addKeyListener(this);
		pnTeclas3.add(btMmais);
		pnTeclas.add(pnTeclas3);
		
		pnTeclas4.setLayout(glTeclas);
		bt7.addActionListener(this);
		bt7.addKeyListener(this);
		pnTeclas4.add(bt7);
		bt8.addActionListener(this);
		bt8.addKeyListener(this);
		pnTeclas4.add(bt8);
		bt9.addActionListener(this);
		bt9.addKeyListener(this);
		pnTeclas4.add(bt9);
		btDiv.addActionListener(this);
		btDiv.addKeyListener(this);
		pnTeclas4.add(btDiv);
		pnTeclas.add(pnTeclas4);
		
		pnTeclas5.setLayout(glTeclas);
		bt4.addActionListener(this);
		bt4.addKeyListener(this);
		pnTeclas5.add(bt4);
		bt5.addActionListener(this);
		bt5.addKeyListener(this);
		pnTeclas5.add(bt5);
		bt6.addActionListener(this);
		bt6.addKeyListener(this);
		pnTeclas5.add(bt6);
		btVez.addActionListener(this);
		btVez.addKeyListener(this);
		pnTeclas5.add(btVez);
		pnTeclas.add(pnTeclas5);
		
		pnTeclas6.setLayout(glTeclas);
		bt1.addActionListener(this);
		bt1.addKeyListener(this);
		pnTeclas6.add(bt1);
		bt2.addActionListener(this);
		bt2.addKeyListener(this);
		pnTeclas6.add(bt2);
		bt3.addActionListener(this);
		bt3.addKeyListener(this);
		pnTeclas6.add(bt3);
		btMenos.addActionListener(this);
		btMenos.addKeyListener(this);
		pnTeclas6.add(btMenos);
		pnTeclas.add(pnTeclas6);
		
		pnTeclas7.setLayout(glTeclas);
		bt0.addActionListener(this);
		bt0.addKeyListener(this);
		pnTeclas7.add(bt0);
		btPonto.addActionListener(this);
		btPonto.addKeyListener(this);
		pnTeclas7.add(btPonto);
		btIgual.addActionListener(this);
		btIgual.addKeyListener(this);
		pnTeclas7.add(btIgual);
		btMais.addActionListener(this);
		btMais.addKeyListener(this);
		pnTeclas7.add(btMais);
		pnTeclas.add(pnTeclas7);
		
		gbConst.fill = GridBagConstraints.BOTH;
		gbConst.gridx = 0;
		gbConst.gridy = 2;
		gbConst.gridheight = GridBagConstraints.REMAINDER;
		gbConst.gridwidth = 1;
		gbConst.weightx = 1;
		gbConst.weighty = 1;
		gbCalc.setConstraints(pnTeclas, gbConst);	
		
		
		c.add(pnTeclas);

		c.setLayout(gbCalc);

		addKeyListener(this);


		setResizable(false);  
		setTitulo("Calculadora");
		setAtribos( 50, 50, 310, 390);
	}
        public void setTitulo(String tit) {
            if (getName() == null)
                setName(tit);
            setTitle(tit);
        }
        public void setAtribos(int esq, int topo, int larg, int alt) {
    	int altPrinc = 0;
    	int largPrinc = 0;
    	
//    	altAnt = alt;  // Guarda a altura anterior para acertar o painel principal
//    	largAnt = larg; // Guarda a largura anteriror para acertar o painel principal
    	
    	if ( (altPrinc<(topo+alt)) || (largPrinc<(esq+larg)) ) {
    		esq = 0;
    		topo = 0;
    		larg = largPrinc;
    		alt = altPrinc;
    	}
    	//spCliente.setBounds(0,0, larg, alt);
        this.setBounds(esq, topo, larg-3, alt-3);

    }

	public void actionPerformed(ActionEvent evt) { 
		((JButton)evt.getSource()).requestFocus();		
		calcular(evt.getActionCommand());
	}
	
	public void keyPressed( KeyEvent kevt) {
		
		if(kevt.getKeyCode() == KeyEvent.VK_CONTROL) Ctrl = true;  	
		if(kevt.getKeyCode() == KeyEvent.VK_ESCAPE) btC.doClick();
		if(kevt.getKeyCode() == KeyEvent.VK_BACK_SPACE) btBac.doClick();  	
		else if (kevt.getKeyCode() == KeyEvent.VK_ENTER) btIgual.doClick();  	
		if (Ctrl) {
			if ((kevt.getKeyCode() == KeyEvent.VK_PLUS) || (kevt.getKeyCode() == 107)) 
				btMmais.doClick();
			else if ((kevt.getKeyCode() == KeyEvent.VK_MINUS) || (kevt.getKeyCode() == 109)) 
				btMmenos.doClick();
			else if (kevt.getKeyCode() == KeyEvent.VK_ENTER) btMR.doClick();
			else if ((kevt.getKeyCode() == KeyEvent.VK_C) || kevt.getKeyCode() == 67) btMC.doClick();
			else if (kevt.getKeyCode() == KeyEvent.VK_BACK_SPACE) btCE.doClick();
			else if (kevt.getKeyCode() == KeyEvent.VK_ALT) btAlt.doClick();
			else if ((kevt.getKeyCode() == 80) || (kevt.getKeyCode() == KeyEvent.VK_P)) 
				btPot.doClick();
		}
		
	}
	
	public void keyReleased( KeyEvent kevt) {
		if(kevt.getKeyCode() == KeyEvent.VK_CONTROL) Ctrl = true; 
	}
	
	public void keyTyped( KeyEvent kevt ) {		
		if (kevt.getKeyChar() == '0') 
			bt0.doClick();
		else if (kevt.getKeyChar() == '1') 
			bt1.doClick();
		else if (kevt.getKeyChar() == '2') 
			bt2.doClick();
		else if (kevt.getKeyChar() == '3') 
			bt3.doClick();
		else if (kevt.getKeyChar() == '4') 
			bt4.doClick();
		else if (kevt.getKeyChar() == '5') 
			bt5.doClick();
		else if (kevt.getKeyChar() == '6') 
			bt6.doClick();
		else if (kevt.getKeyChar() == '7') 
			bt7.doClick();
		else if (kevt.getKeyChar() == '8') 
			bt8.doClick();
		else if (kevt.getKeyChar() == '9') 
			bt9.doClick();
		else if (kevt.getKeyChar() == '/') 
			btDiv.doClick();
		else if (kevt.getKeyChar() == '*') 
			btVez.doClick();
		else if (kevt.getKeyChar() == '-') 
			btMenos.doClick();
		else if (kevt.getKeyChar() == '+') 
			btMais.doClick();
		else if (kevt.getKeyChar() == '=') 
			btIgual.doClick();
		else if (kevt.getKeyChar() == '.') 
			btPonto.doClick();
		else if (kevt.getKeyChar() == ',') 
			btPonto.doClick();
		else if ((kevt.getKeyChar() == 'r') || (kevt.getKeyChar() == 'R')) 
			btRaiz.doClick();
		else if ((kevt.getKeyChar() == 'p') || (kevt.getKeyChar() == 'P')) 
			btPerc.doClick();
	}

	public void calcular(String lb) {
		String s = "";
		dg = lb;
		if (num == "0.0") num = "";
		if (dg == "1") num += 1;
		else if (dg == "2") num += 2;
		else if (dg == "3") num += 3;
		else if (dg == "4") num += 4;
		else if (dg == "5") num += 5;
		else if (dg == "6") num += 6;
		else if (dg == "7") num += 7;
		else if (dg == "8") num += 8;
		else if (dg == "9") num += 9;
		else if (dg == "0") num += 0;
		else if (dg == ".") { 
			if(num.indexOf(".")==-1)
				num += ".";
		}
		else if (dg == "Back") { if (num.length() > 0) num = num.substring( 0, num.length() - 1); }                       
		else if (dg == "CE") num = "0.0";
		else if (dg == "M+") 
			if (num.length() > 0) memo += Double.parseDouble(num); 
			else memo += res;
		else if (dg == "M-") 
			if (num.length() > 0) memo -= Double.parseDouble(num); 
			else memo -= res;
		else if (dg == "MR") { 
			num = ""+memo;    
			res = 0;
			txaCalc.setText(txaCalc.getText()+"\n"+alinha("--memo--")+"\n"+alinha(num)+"\n");
		} 
		else if (dg == "MC") memo = 0;
		else if (dg == "Raiz") {
			if (num.length() > 0) num = ""+Math.sqrt(Double.parseDouble(num));  
			else num = ""+Math.sqrt(res);  
			res = 0;
			txaCalc.setText(txaCalc.getText()+"\n"+alinha("--raiz--")+"\n"+alinha(num)+"\n");
		}
		else if (dg == "+/-") 
			if (num.length() > 0) 
				if (Double.parseDouble(num) < 0) 
					num = num.substring( 1, num.length());
				else 
					num = "-" + num;
			else 
				res *= (-1); 
		else if (dg.length() > 0) {
			if (num.length() == 0) num = "0.0";
			calc = true;
			reg(true);
		}
		if (dg == "+") soma = true;
		else if (dg == "-") sub = true;
		else if (dg == "*") mult = true;
		else if (dg == "�") div = true;
		else if (dg == "x^x") pot = true;
		else if (dg == "=") vi = true;
		else if (dg == "C") limpar();
		else if (dg == "%") {
			if (res == 0) {
				JOptionPane.showMessageDialog(null, "N�o � poss�vel obter percentagem de \"0\" !", "Erro", JOptionPane.ERROR_MESSAGE);
				limpar();
			}
			else {
				num = ""+(res / 100) * Double.parseDouble(num); 
			}
		}
		s = num;
		if (calc) {
			ret = Double.parseDouble(num);
			if (res == 0) res = ret;
			if (somar) { res = men + ret; somar = false; reg(true, null);} 
			else if (subtrair) { res = men - ret; subtrair = false; reg(true, null);} 
			else if (multiplicar) { res = men * ret; multiplicar = false; reg(true, null);} 
			else if (dividir) { res = men / ret; dividir = false; reg(true, null);} 
			else if (potencia) { res = pot( men, ret); potencia = false; reg(true, null);
			} 
			calc = false;
			if (soma) { men = res; somar = true; soma = false; vi = true; reg(false, "+"); }
			else if (sub) { men = res; subtrair = true; sub = false; vi = true; reg(false, "-"); }
			else if (mult) { men = res; multiplicar = true; mult = false; vi = true; reg(false, "*"); }
			else if (div) { 
				if ( res == 0 ) {
					JOptionPane.showMessageDialog(null, "N�o � poss�vel dividir \"0\" !", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
					limpar();
				} 
				else {
					men = res; dividir = true; div = false; vi = true; reg(false, "�"); 
				}
			}
			else if (pot) { men = res; potencia = true; pot = false; vi = true; reg(false, "^"); }
		}
		if (vi) { num = ""; s = ""+res; } 
		vi = false;
		if (memo != 0) lbMemo.setText(" M "); else lbMemo.setText("   ");
		txtRes.setText(s);

	}

	public void limpar() {
		soma = false;
		somar = false;
		sub = false;
		subtrair = false;
		mult = false;
		multiplicar = false;
		div = false;
		dividir = false;
		pot = false;
		potencia = false;
		num = "0.0";
		res = 0;
		men = 0;
		ret = 0;
		reg(false, "\n\n"+alinha("Clear!!")+"\n");
	}
	public double pot(double num, double ele) {
		double ret = num; 
		if ( ele > 0) for (int i = 1; i != ele; i++) ret = ret * num;
		else if ( ele == 0) ret = 1;
		else if ( ele < 0) ret = (1 / (num * (num * ele)));
		return ret;  
	}
	public void reg(boolean tot, String val) {
		if (tot) {  
			txaCalc.setText(txaCalc.getText()+"\n"+alinha("--------")+"\n"+alinha(""+res));
		}
		else txaCalc.setText(txaCalc.getText()+" "+val+"\n");
	}
	public void reg(boolean reg) {
		if (reg & num != "0.0") 
			txaCalc.setText(txaCalc.getText()+alinha(num));
	}
	public String alinha(String s) {
		String ret = "";
		ret = replica(" ", esp - s.length()) + s;
		return ret;
	}    
	public String replica(String c, int vez) {
		String ret = c;
		for (int i = 1; i != vez; i++) ret = ret + c;
		return ret;
	}
	
} 

