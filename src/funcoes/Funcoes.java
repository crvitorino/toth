/**
 * @version 03/10/2003 <BR>
 * @author Setpoint Inform�tica Ltda./Fernando Oliveira da Silva/Robson Sanchez
 *         <BR>
 * 
 * Projeto: Freedom <BR>
 * Pacote: org.freedom.funcoes <BR>
 * Classe:
 * @(#)Funcoes.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para
 * Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste
 * Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc�
 * pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa �
 * preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR>
 * <BR>
 * 
 * Coment�rios da classe.....
 */

package funcoes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Vector;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import componentes.JLabelPad;
import componentes.JPanelPad;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;



public class Funcoes {

	private static Vector vIE = new Vector(34);

	private static Vector vPesoIE = new Vector(13);

	//private static ImageIcon imgIcone = null;
	public static String sIEValida = "";

	private static JDialog dlErro = null;
	
	private static Timer tim = null;

	public Funcoes() {
	} 
	
    public static boolean executeURL(String os, String comando, String url) {
    	boolean retorno = false;
    	Vector comandos = new Vector();
    	if ( (comando!=null) && (!comando.equals("")) ) 
    		comandos.addElement(comando);
    	if (os.equalsIgnoreCase("windows")) {
    		comandos.addElement("start");
    		comandos.addElement("firefox");
    		comandos.addElement("explorer");
    	}
    	else if (os.equalsIgnoreCase("linux")) {
    		comandos.addElement("firefox");
    		comandos.addElement("konqueror");
    		comandos.addElement("mozilla");
    		comandos.addElement("nautilus");
    	}
    	for (int i=0; i<comandos.size(); i++) {
           try {
           	  String[] exec = {comandos.elementAt(i).toString(),url};
              Runtime.getRuntime().exec(exec);
              retorno = true;
              break;
           } catch (IOException e) {
              retorno = false;
           }
    	}
    	return retorno;
    }
	public static String getTimeString(Date data) {
		String bRetorno	= "";
		if (data!=null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
		   bRetorno = strZero(cal.get(Calendar.HOUR)+"",2)+":"+
		      strZero(cal.get(Calendar.MINUTE) +"",2)+":"+strZero(cal.get(Calendar.SECOND)+"",2);
		}
		return bRetorno;
	}
    public static int contaChar(String sTexto,char cChar) {
        int iRet = 0;
        
        char[] cChars = sTexto.toCharArray();
        
        for(int i=0;cChars.length>i;i++){
            if (cChars[i] == cChar)
                iRet++;
        }
        
        return iRet;
    }
    
	public static String replicate(String texto, int Quant) {
		/*String sRetorno = "";
		for (int i = 1; i <= Quant; i++) {
			sRetorno = sRetorno + texto;
		}*/
		// fazendo assim evita a copia de varias strings.
		StringBuffer sRetorno = new StringBuffer();
		sRetorno.append("");
		for (int i = 0; i < Quant; i++) {
			sRetorno.append(texto);
		}
		return sRetorno.toString();
	}

	public static double arredDouble(double deValor, int iDec) {
		BigDecimal bdValor = null;
		try {
			bdValor = new BigDecimal(deValor);
			bdValor = bdValor.setScale(iDec, BigDecimal.ROUND_HALF_UP);
			deValor = bdValor.doubleValue();
		} finally {
			bdValor = null;
		}
		return deValor;
	}

	public static float arredFloat(float fValor, int iDec) {
		BigDecimal bdValor = null;
		try {
			bdValor = new BigDecimal(fValor);
			bdValor = bdValor.setScale(iDec, BigDecimal.ROUND_HALF_UP);
			fValor = bdValor.floatValue();
		} finally {
			bdValor = null;
		}
		return fValor;
	}

	public static void espera(int iSec) {
		long iIni = getSeconds();
		long iFim = getSeconds();
		while ((iFim - iIni) < iSec) {
			iFim = getSeconds();
		}
	}

	public static long getSeconds() {
		java.util.Date dtHora = new Date();
		return dtHora.getTime() / 1000;
	}

	public static boolean ehInteiro(String sNum) {
		boolean bRetorno = false;
		for (int i = 0; i < sNum.length(); i++) {
			if ("0123456789-".indexOf(sNum.charAt(i)) == -1) {
				bRetorno = false;
				break;
			}
			bRetorno = true;
		}
		return bRetorno;
	}

	public static int[] decodeDate(java.util.Date dtSel) {
		GregorianCalendar gcSel = new GregorianCalendar();
		int[] iRetorno = { 0, 0, 0 };
		try {
			gcSel.setTime(dtSel);
			iRetorno[0] = gcSel.get(Calendar.YEAR);
			iRetorno[1] = gcSel.get(Calendar.MONTH) + 1;
			iRetorno[2] = gcSel.get(Calendar.DAY_OF_MONTH);
		} finally {
			gcSel = null;
		}
		return iRetorno;
	}

	public static Date encodeDate(int iAno, int iMes, int iDia) {
		Date dtRetorno = new Date();
		GregorianCalendar gcSel = new GregorianCalendar();
		try {
			gcSel.setTime(dtRetorno);
			gcSel.set(Calendar.YEAR, iAno);
			gcSel.set(Calendar.MONTH, iMes - 1);
			gcSel.set(Calendar.DAY_OF_MONTH, iDia);
			dtRetorno = gcSel.getTime();
		} finally {
			gcSel = null;
		}
		return dtRetorno;
	}

	public static java.util.Date strTimeToDate(String sTime) {
		java.util.Date retorno = null;
		try {
			int hora = Integer.parseInt(sTime.substring(0,2)) * 60 * 60 * 1000;
			int minuto = Integer.parseInt(sTime.substring(3,5)) * 60 * 1000;
			int segundo = Integer.parseInt(sTime.substring(6,8)) * 1000;
			retorno =  new Date(hora + minuto + segundo);
		}
	    catch (Exception e) {
			retorno = null;
	    }
		return retorno;
	}
	public static java.util.Date encodeTime(Date dtSel, int iHora, int iMinuto,
			int iSegundo, int iMilesegundo) {
		Date dtRetorno = dtSel;
		GregorianCalendar gcSel = new GregorianCalendar();
		try {
			gcSel.setTime(dtSel);
			gcSel.set(Calendar.HOUR_OF_DAY, iHora);
			gcSel.set(Calendar.MINUTE, iMinuto);
			gcSel.set(Calendar.SECOND, iSegundo);
			gcSel.set(Calendar.MILLISECOND, iMilesegundo);
			dtSel = gcSel.getTime();
		} finally {
			gcSel = null;
		}
		return dtRetorno;
	}

	public synchronized static int mensagemConfirma(Component frame,String sMensagem) {
	    String opt[] = {"Sim","N�o"}; 
		if (frame == null)		    
			return JOptionPane.showOptionDialog(frame, sMensagem,"Confirma��o", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,null, opt, opt[0]);
		return JOptionPane.showInternalOptionDialog(frame, sMensagem,"Confirma��o", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);
	}

	public static String adicEspacosEsquerda(String sTexto, int iEspacos) {
		if (iEspacos > sTexto.length()) {
			sTexto = replicate(" ", iEspacos - sTexto.length()) + sTexto;
		}
		return sTexto;
	}
	public static String adicEspacosDireita(String sTexto, int iEspacos) {
		if (iEspacos > sTexto.length()) {
			sTexto = sTexto + replicate(" ", iEspacos - sTexto.length());
		}
		return sTexto;
	}

	public static Vector quebraLinha(Vector vValor, int iTam) {
		Vector vRetorno = new Vector();
		String sLinha = null;
		String sValor = null;
		int iParte = 0;
		try {
			if (vValor != null) {
				for (int i = 0; i < vValor.size(); i++) {
					sLinha = vValor.elementAt(i).toString();
					while (!sLinha.equals("")) {
						if (sLinha.length() > iTam)
							iParte = iTam;
						else
							iParte = sLinha.length();
						sValor = sLinha.substring(0, iParte);
						vRetorno.addElement(sValor);
						if (sLinha.length() > iTam)
							sLinha = sLinha.substring(iParte);
						else
							sLinha = "";
					}
				}
			}
		} finally {
			sValor = null;
			sLinha = null;
		}
		return vRetorno;
	}

	public static Vector ordenaVector(Vector v, int iEspacos) {
		String s1 = "";
		String s2 = "";
		try {
			if (v != null) {
				for (int i1 = 1; i1 < v.size(); i1++) {
					s1 = adicEspacosEsquerda(v.elementAt(i1).toString().trim(),
							iEspacos);
					s2 = adicEspacosEsquerda(v.elementAt(i1 - 1).toString()
							.trim(), iEspacos);
					if (s1.compareTo(s2) < 0) {
						for (int i2 = 0; i2 < i1; i2++) {
							s1 = adicEspacosEsquerda(
									v.elementAt(i1).toString(), iEspacos);
							s2 = adicEspacosEsquerda(
									v.elementAt(i2).toString(), iEspacos);
							if (s1.compareTo(s2) < 0) {
								for (int i3 = i2; i3 < i1; i3++) {
									//mostraVector(v);
									s1 = v.elementAt(i1).toString();
									s2 = v.elementAt(i3).toString();
									v.setElementAt(s2, i1);
									v.setElementAt(s1, i3);
									//mostraVector(v);
								}
							}
						}
					}
				}
			}
		} finally {
			s1 = null;
			s2 = null;
		}
		return v;
	}

	public static void mostraVector(Vector v) {
		String sMostra = "";
		try {
			for (int i = 0; i < v.size(); i++) {
				sMostra += v.elementAt(i).toString() + ";";
			}
			mensagemInforma(null, sMostra);
		} finally {
			sMostra = null;
		}
	}

	public static long getNumDias(Date dt1, Date dt2) {
		long lResult = 0;
		long lDias1 = 0;
		long lDias2 = 0;
		GregorianCalendar cal1 = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
		cal1.setTime(dt1);
		cal1.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1
				.get(Calendar.DATE), 0, 0, 0);
		cal2.setTime(dt2);
		cal2.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2
				.get(Calendar.DATE), 0, 0, 0);

		lDias1 = cal1.getTimeInMillis();
		lDias2 = cal2.getTimeInMillis();

		lResult = (lDias2 - lDias1) / (60 * 24 * 60 * 1000);
		return lResult;
	}

	public static long getNumDiasAbs(Date dt1, Date dt2) {
		long lResult = 0;
		long lDias1 = 0;
		long lDias2 = 0;
		GregorianCalendar cal1 = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
		cal1.setTime(dt1);
		cal1.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1
				.get(Calendar.DATE), 0, 0, 0);
		cal2.setTime(dt2);
		cal2.set(cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2
				.get(Calendar.DATE), 0, 0, 0);

		lDias1 = cal1.getTimeInMillis();
		lDias2 = cal2.getTimeInMillis();
		if (lDias1 > lDias2)
			lResult = (lDias1 - lDias2) / (60 * 24 * 60 * 1000);
		else
			lResult = (lDias2 - lDias1) / (60 * 24 * 60 * 1000);
		return lResult;
	}
	public static Date getDataFimMes(int iMes, int iAno){				
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.MONTH,iMes);
		cal.set(Calendar.YEAR,iAno);
		int iUltimoDia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	
		cal.set(Calendar.DAY_OF_MONTH,iUltimoDia);
		return cal.getTime();
	}
	public static Date getDataIniMes(int iMes, int iAno){				
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.MONTH,iMes);
		cal.set(Calendar.YEAR,iAno);
		return cal.getTime();
	}

	public static void mensagem(String sMensagem, String sTitulo,int iOpcao) {
		//	imgIcone = Aplicativo.imgIcone;
			JOptionPane.showMessageDialog(null, sMensagem, sTitulo, iOpcao);
	}
	

	/**
	 * Mostra uma mensagem sem bot�es n�o-modal por N segundos.
	 * 
	 * @see #mensagemTemp(JFrame,String,String,int)
	 */
	//public static FFDialogo mensagemTemp(final String sMensagem, final String sTitulo,int iTempoShow) {
		//return mensagemTemp(null,sMensagem,sTitulo,iTempoShow);x
	//}
	
	/**
	 * Mostra uma mensagem sem bot�es n�o-modal por N segundos.
	 * 
	 * @see #mensagemTemp(String,String,int)
	 */
	
	public static void mensagemInforma(Component frame, String sMensagem) {
		mensagem(sMensagem, "Informa��o", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void mensagemErro(Component frame, String sMensagem) {		
		mensagem(sMensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}
		
	public static String trimFinal(String sVal) {
		char[] cVal = sVal.toCharArray();
		String sRetorno = sVal;
		for (int i = sVal.length() - 1; i >= 0; i--) {
			if (cVal[i] != ' ') {
				sRetorno = sVal.substring(0, i + 1);
				break;
			}
		}
		return sRetorno;
	}

	public static void setBordReq(JComponent comp) {
		setBordReq(comp, true);
	}

	public static void setBordReq(JComponent comp, boolean bReq) {
		if (bReq) {
			comp.setBorder(BorderFactory.createCompoundBorder(BorderFactory
					.createMatteBorder(1, 1, 1, 1, Color.red), BorderFactory
					.createEtchedBorder()));
		} else {
			comp.setBorder(BorderFactory.createCompoundBorder(BorderFactory
					.createMatteBorder(0, 0, 0, 0, Color.darkGray),
					BorderFactory.createEtchedBorder()));
		}
	}

	public static void setBorder(JComponent comp, Color color, boolean border) {
		if (border) {
			comp.setBorder(BorderFactory.createCompoundBorder(BorderFactory
					.createMatteBorder(1, 1, 1, 1, color), BorderFactory
					.createEtchedBorder()));
		} else {
			comp.setBorder(BorderFactory.createCompoundBorder(BorderFactory
					.createMatteBorder(0, 0, 0, 0, Color.darkGray),
					BorderFactory.createEtchedBorder()));
		}
	}
	
	public static char getPontoDec() {
		return ',';
	}

	public static String setPontoDec(String sVal) {
		int iLocal = sVal.indexOf('.') >= 0 ? sVal.indexOf('.') : sVal
				.indexOf(',');
		if (iLocal >= 0) {
			char[] cVal = new char[sVal.length()];
			cVal = sVal.toCharArray();
			cVal[iLocal] = getPontoDec();
			sVal = new String(cVal);
		}
		return sVal;
	}

	public static String substringByChar(String sVal, char cVal, boolean bOrient) {
		String sRetorno = "";
		sVal = copy(sVal, 0, sVal.length());
		char[] cStr = sVal.toCharArray();
		if (bOrient) {
			for (int i = 0; i < sVal.length(); i++) {
				if (cStr[i] == cVal)
					break;
				sRetorno += cStr[i];
			}
		} else {
			for (int i = (sVal.length() - 1); i >= 0; i--) {
				if (cStr[i] == cVal)
					break;
				sRetorno = cStr[i] + sRetorno;
			}
		}
		return sRetorno;
	}

	public static String copy(String sTmp, int iPos, int iTam) {
		if (sTmp == null)
			sTmp = "";
		if (sTmp.length() < (iTam + 1)) {
			sTmp = sTmp + replicate(" ", iTam - sTmp.length());
		} else {
			sTmp = sTmp.substring(iPos, iTam);
		}
		return sTmp;
	}

	public static String copy(String sTmp, int iTam) {
		return copy(sTmp, 0, iTam);
	}

	public static String limpaString(String sTexto) {
		String sResult = "";
		String sCaracs = "- .,;/\\";
		if (sTexto != null) {
			for (int i = 0; i < sTexto.length(); i++) {
				if (sCaracs.indexOf(sTexto.substring(i, i + 1)) == -1)
					sResult = sResult + sTexto.substring(i, i + 1);
			}
		}
		return sResult;
	}
	
	public static int contaMeses(Date dDataIni, Date dDataFim) {
		int iMeses = 0;
		GregorianCalendar cIni = new GregorianCalendar();
		GregorianCalendar cFim = new GregorianCalendar();
		cIni.setTime(dDataIni);
		cFim.setTime(dDataFim);

		try {
			iMeses = 1 + (cFim.get(Calendar.MONTH) + (12 * ((cFim
					.get(Calendar.YEAR)
					- cIni.get(Calendar.YEAR) - 1)) + (12 - cIni
					.get(Calendar.MONTH))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMeses;
	}

	public static String dateToStrExtenso(Date data) {
		String sRet = "";
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(data);
		int iDia = 0;
		int iAno = 0;
		int iMes = 0;
		if (data != null) {
			iDia = cal.get(Calendar.DAY_OF_MONTH);
			iMes = cal.get(Calendar.MONTH) + 1;
			iAno = cal.get(Calendar.YEAR);
		}
		sRet = strZero("" + iDia, 2) + " de " + strMes(iMes).toLowerCase()
				+ " de " + iAno;
		return sRet;
	}

	public static String strMes(int iMes) {
		String sRet = "";
		switch (iMes) {
		case 1:
			sRet = "Janeiro";
			break;
		case 2:
			sRet = "Fevereiro";
			break;
		case 3:
			sRet = "Mar�o";
			break;
		case 4:
			sRet = "Abril";
			break;
		case 5:
			sRet = "Maio";
			break;
		case 6:
			sRet = "Junho";
			break;
		case 7:
			sRet = "Julho";
			break;
		case 8:
			sRet = "Agosto";
			break;
		case 9:
			sRet = "Setembro";
			break;
		case 10:
			sRet = "Outubro";
			break;
		case 11:
			sRet = "Novembro";
			break;
		case 12:
			sRet = "Dezembro";
			break;
		}
		return sRet;
	}

	public static String dataAAAAMMDD(Date data) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(data);
		int iDia = 0;
		int iAno = 0;
		int iMes = 0;
		if (data != null) {
			iDia = cal.get(Calendar.DAY_OF_MONTH);
			iMes = cal.get(Calendar.MONTH) + 1;
			iAno = cal.get(Calendar.YEAR);
		}
		return strZero(iAno + "", 4) + strZero(iMes + "", 2)
				+ strZero(iDia + "", 2);
	}

	public static String dataDDMMAAAA(Date data) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(data);
		int iDia = 0;
		int iAno = 0;
		int iMes = 0;
		if (data != null) {
			iDia = cal.get(Calendar.DAY_OF_MONTH);
			iMes = cal.get(Calendar.MONTH) + 1;
			iAno = cal.get(Calendar.YEAR);
		}
		return strZero(iDia + "", 2) + strZero(iMes + "", 2)
				+ strZero(iAno + "", 4);
	}

	public static String doubleToStrCurExtenso(double dVal, String sMoeda[]) {
		String sRet = "";
		String sVals[] = ("" + dVal).split("\\.");
		String sTmp = intToStrExtenso(new Integer(sVals[0]).intValue());
		if (!sTmp.trim().equals("")) {
			sRet = sTmp;
			if (sRet.substring(0, 2).indexOf("um") == 0)
				sRet += " " + sMoeda[2];
			else if (sRet.substring(sRet.length() - 2).indexOf("�o") == 0)
				sRet += " de " + sMoeda[3];
			else if (sRet.substring(sRet.length() - 3).indexOf("�es") == 0)
				sRet += " de " + sMoeda[3];
			else
				sRet += " " + sMoeda[3];
		}

		if (!sVals[1].equals("") && (new Integer(sVals[1])).intValue() > 0) {
			if (!sRet.equals(""))
				sTmp = " e ";
			else
				sTmp = " ";
			sTmp += intToStrExtenso(new Integer(sVals[1]).intValue());
			if (!sTmp.trim().equals("")) {
				if (sTmp.substring(0, 2).indexOf("um") < 4) //4 porque pode ter
					// o 'e' na frente.
					sRet += sTmp + " " + sMoeda[0];
				else
					sRet += sTmp + " " + sMoeda[1];
			}
		}
		return sRet;
	}

	public static String intToStrExtenso(int iVal) {
		String sRet = "";
		int iTmp = 0;
		String sNomes[][] = {
				{ "", "um", "dois", "tr�s", "quatro", "cinco", "seis", "sete",
						"oito", "nove", "dez", "onze", "doze", "treze",
						"quatorze", "quinze", "dezesseis", "dezesete",
						"dezoito", "dezenove" },
				{ "", "", "vinte", "trinta", "quarenta", "cinquenta",
						"sessenta", "setenta", "oitenta", "noventa" },
				{ "", "cem", "duzentos", "trezentos", "quatrocentos",
						"quinhentos", "seiscentos", "setecentos", "oitocentos",
						"novecentos" } };
		if (iVal == 1000000000) {
			sRet += sNomes[0][1] + " bilh�o";
			iVal = 0;
		}
		if (iVal > 999999999) {
			iTmp = iVal / 1000000000;
			sRet += intToStrExtenso(iTmp) + " bilh�es";
			iVal -= iTmp * 1000000000;
			sRet += iVal > 0 ? " e " : "";
		}
		if (iVal == 1000000) {
			sRet += sNomes[0][1] + " milh�o";
			iVal = 0;
		}
		if (iVal > 999999) {
			iTmp = iVal / 1000000;
			sRet += intToStrExtenso(iTmp) + " milh�es";
			iVal -= iTmp * 1000000;
			sRet += iVal > 0 ? " e " : "";
		}
		if (iVal > 999) {
			iTmp = iVal / 1000;
			sRet += (iTmp > 1) ? intToStrExtenso(iTmp) + " mil" : "mil";
			iVal -= iTmp * 1000;
			// Regra do 'e':
			if (iVal != 0) {
				int iCent = (iVal / 100);
				int iDez = (iVal - (iCent * 100)) / 10;
				int iUnid = (iVal - ((iDez * 10) + (iCent * 100)));
				if (iCent == 0 || (iDez == 0 && iUnid == 0))
					sRet += " e ";
				else
					sRet += " ";
			} else
				sRet += "";
		}
		if (iVal > 99) {
			iTmp = iVal / 100;
			sRet += sNomes[2][iTmp];
			iVal -= iTmp * 100;
			if(sRet.equals("cem") && iVal > 0)
				sRet = "cento";
			sRet += iVal > 0 ? " e " : "";
		}
		if (iVal > 19) {
			iTmp = iVal / 10;
			sRet += sNomes[1][iTmp];
			iVal -= iTmp * 10;
			sRet += iVal > 0 ? " e " : "";
		}
		if (iVal > 0) {
			iTmp = iVal;
			sRet += sNomes[0][iTmp];
		}
		return sRet;
	}

	public static String tiraAcentos(String sTexto) {
		String sRet = "";
		char cVals[] = sTexto.toCharArray();
		for (int i = 0; i < cVals.length; i++) {
			cVals[i] = tiraAcento(cVals[i]);
		}
		sRet = new String(cVals);
		return sRet;
	}

	public static char tiraAcento(char cKey) {

		char cTmp = cKey;

		if (contido(cTmp, "����"))
			cTmp = 'a';
		else if (contido(cTmp, "����"))
			cTmp = 'A';
		else if (contido(cTmp, "���"))
			cTmp = 'e';
		else if (contido(cTmp, "���"))
			cTmp = 'E';
		else if (contido(cTmp, "���"))
			cTmp = 'i';
		else if (contido(cTmp, "���"))
			cTmp = 'I';
		else if (contido(cTmp, "����"))
			cTmp = 'o';
		else if (contido(cTmp, "����"))
			cTmp = 'O';
		else if (contido(cTmp, "���"))
			cTmp = 'u';
		else if (contido(cTmp, "���"))
			cTmp = 'U';
		else if (contido(cTmp, "�"))
			cTmp = 'c';
		else if (contido(cTmp, "�"))
			cTmp = 'C';
		return cTmp;
	}

	public static boolean contido(char cTexto, String sTexto) {
		boolean bRetorno = false;
		for (int i = 0; i < sTexto.length(); i++) {
			if (cTexto == sTexto.charAt(i)) {
				bRetorno = true;
				break;
			}
		}
		return bRetorno;
	}

	public static String adicionaEspacos(String sTexto, int iTamanho) {
		int iTamIni = 0;
		String sRetorno = "";
		if (sTexto == null)
			sTexto = "";
		iTamIni = sTexto.length();
		if (iTamIni > iTamanho) {
			sRetorno = sTexto.substring(0, iTamanho);
		} else {
			sRetorno = sTexto;
			for (int i = iTamIni; i < iTamanho; i++) {
				sRetorno = sRetorno + ' ';
			}
		}
		return sRetorno;
	}

	public static String alinhaCentro(int iValor, int iTam) {
		return alinhaCentro("" + iValor, iTam);
	}
	
	public static String alinhaCentro(String sVal, int iTam) {
		if (sVal != null)
			sVal = sVal.trim();
		else
			sVal = "";
		int iTamStr = sVal.length();
		if(iTamStr > iTam)
			sVal = sVal.substring(iTam);
		else if (iTamStr < iTam) {
			int iSpaceAdic = (iTam - iTamStr) / 2;
			sVal = replicate(" ", iSpaceAdic) + sVal + replicate(" ", iSpaceAdic);
		}
		return sVal;
	}

	public static String alinhaDir(int iValor, int iTam) {
		return alinhaDir("" + iValor, iTam);
	}

	public static String alinhaDir(String sVal, int iTam) {
		if (sVal != null)
			sVal = sVal.trim();
		else
			sVal = "";
		int iTamStr = sVal.length();
		if (iTamStr <= iTam) {
			sVal = replicate(" ", iTam - iTamStr) + sVal;
		}
		return sVal;
	}

	public static BigDecimal transValorInv(String sVal) {
	    BigDecimal bigRet = new BigDecimal("0.00");
	    if (sVal == null)
	        return bigRet;
	    if (sVal.length() < 3)
	        sVal = "0"+replicate("0",2 - sVal.length()) + sVal;
	    
	    sVal = sVal.substring(0,sVal.length()-2)+"."+sVal.substring(sVal.length()-2);
	    bigRet = new BigDecimal(sVal);
	    return bigRet;
	}
	
	public static String transValor(String sValor, int iTam, int iDec,
			boolean bZeroEsq) {
		if (sValor == null) {
			sValor = "0";
		}
		//    System.out.println("Antes de converter: "+sValor);
		String sDec = "";
		String sResult = sValor;
		for (int i = 0; i < sValor.length(); i++) {
			if ((sValor.substring(i, i + 1).equals("."))
					| (sValor.substring(i, i + 1).equals(","))) {
				sResult = sValor.substring(0, i);
				sDec = sValor.substring(i + 1, sValor.length());
				if (sDec.length() < iDec) {
					//           System.out.println("sDec e menor que idec");
					sDec = sDec + replicate("0", iDec - sDec.length());
				} else if (sDec.length() > iDec) {
					//           System.out.println("sDec e maior que idec");
					sDec = sDec.substring(0, iDec);
				}
				break;
			}
		}

		if ((sDec.trim().equals("")) & (iDec > 0)) {
			sDec = replicate("0", iDec);
		}
		if (sResult.length() > (iTam - iDec)) {
			sResult = sResult.substring(sResult.length() - (iTam - iDec) - 1,
					(iTam - iDec));
		}
		if (bZeroEsq) {
			if (sResult.length() < (iTam - iDec))
				sResult = replicate("0", (iTam - iDec) - sResult.length())
						+ sResult;
		}
		//  System.out.println("Depois de converter: "+sResult+sDec);

		return sResult + sDec;
	}

	public static void setImpAtrib(PrintRequestAttributeSet p) {
		HashPrintRequestAttributeSet pra = (HashPrintRequestAttributeSet) p;
		File fArq = new File("impres.cfg");
		try {
			if (!fArq.exists())
				if (!fArq.createNewFile())
					return;
			FileOutputStream foArq = new FileOutputStream(fArq);
			ObjectOutputStream obj = new ObjectOutputStream(foArq);
			obj.writeObject(pra);
			obj.flush();
			foArq.close();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}

	public static PrintRequestAttributeSet getImpAtrib() {
		HashPrintRequestAttributeSet pra = new HashPrintRequestAttributeSet();
		File fArq = new File("impres.cfg");
		try {
			if (!fArq.exists())
				return pra;
			FileInputStream foArq = new FileInputStream(fArq);
			ObjectInputStream obj = new ObjectInputStream(foArq);
			pra = (HashPrintRequestAttributeSet) obj.readObject();
			foArq.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
		return pra;
	}

	public static Component getOwnerTela(Component comp) {
		Component cFrame = null;
		Component cRetorno = null;
		cFrame = comp.getParent();
		if (cFrame != null) {
			for (int i = 1; 1 <= 10; i++) {
				if ((cFrame instanceof JFrame)
						|| (cFrame instanceof JInternalFrame)
						|| (cFrame instanceof JDialog)) {
					cRetorno = cFrame;
					break;
				}
				cFrame = cFrame.getParent();
			}
		}
		return cRetorno;
	}

	public static Vector stringToVector(String sTexto,String sSep) {
		Vector vRetorno = new Vector();
		String sLinha = "";
		if (sTexto != null) {
			int iPos = sTexto.indexOf(sSep);
			int iPosIni = 0;
			int iTam = sTexto.length();
			if ((iPos == -1) & (sTexto != null))
				vRetorno.addElement(sTexto);
			while (iPos >= 0) {
				sLinha = sTexto.substring(iPosIni, iPos);
				vRetorno.addElement(sLinha);
				iPosIni = iPos + sSep.length();

				iPos = sTexto.indexOf(sSep, iPosIni);
				if ((iPos == -1) & (iTam > iPosIni)) {
					sLinha = sTexto.substring(iPosIni);
					vRetorno.addElement(sLinha);
					break;
				}
			}
		}
		return vRetorno;
	}
	public static Vector stringToVector(String sTexto) {
		Vector vRetorno = new Vector();
		String sLinha = "";
		char c10 = (char) 10;
		char c13 = (char) 13;
		if (sTexto != null) {
			int iPos = sTexto.indexOf(c13);
			int iPosIni = 0;
			int iTam = sTexto.length();
			if (iPos == -1)
				iPos = sTexto.indexOf(c10);
			if ((iPos == -1) & (sTexto != null))
				vRetorno.addElement(sTexto);
			while (iPos >= 0) {
				//	  System.out.println("PosIni: "+iPosIni);
				//	  System.out.println("Pos: "+iPos);
				sLinha = sTexto.substring(iPosIni, iPos);
				vRetorno.addElement(sLinha);
				iPosIni = iPos + 1;
				if ((iPosIni) < iTam) {
					if (sTexto.charAt(iPosIni) == c10)
						iPosIni++;
				}
				iPos = sTexto.indexOf(c13, iPosIni);
				if (iPos == -1)
					iPos = sTexto.indexOf(c10, iPosIni);
				if ((iPos == -1) & (iTam > iPosIni)) {
					sLinha = sTexto.substring(iPosIni);
					vRetorno.addElement(sLinha);
					break;
				}
			}
		}
		return vRetorno;
	}

	public static String tiraChar(String sVal, String sChar) {
		String sRetorno = sVal;
		sVal = sVal.trim();
		int iPos = sVal.indexOf(sChar);
		if (iPos >= 0) {
			if (iPos < (sVal.length() - 1))
				sRetorno = sVal.substring(0, iPos) + sVal.substring(iPos + 1);
			else
				sRetorno = sVal.substring(0, iPos);
		}
		return sRetorno;
	} 
 
    public static String tiraString(String sTexto,String sParc) {
    	String sRetorno =   sTexto; 
    	int iPos = 0; 
    	if (!sParc.equals("")) {
	    	while (iPos>-1) {
	    		iPos = sRetorno.indexOf(sParc);
	    		if (iPos>-1) {
	    			sRetorno = sRetorno.substring(0,iPos)+sRetorno.substring(iPos+sParc.length(),sRetorno.length()); 
	    		} 
	    	}
    	}
      return sRetorno; 
    }
    
	public static String verData(String sData) {
		if (sData.length() < 10) {
			return "";
		}
		char cDate[] = sData.toCharArray();
		if (!Character.isDigit(cDate[0]))
			return "";
		else if (!Character.isDigit(cDate[1]))
			return "";
		else if (cDate[2] != '/')
			return "";
		else if (!Character.isDigit(cDate[3]))
			return "";
		else if (!Character.isDigit(cDate[4]))
			return "";
		else if (cDate[5] != '/')
			return "";
		else if (!Character.isDigit(cDate[6]))
			return "";
		else if (!Character.isDigit(cDate[7]))
			return "";
		else if (!Character.isDigit(cDate[8]))
			return "";
		else if (!Character.isDigit(cDate[9]))
			return "";
		else if (!validaData(sData))
			return "";
		return sData;
	}

	public static String verTime(String sTime) {
		if (sTime.length() < 8) {
			return "";
		}
		char cTime[] = sTime.toCharArray();
		if (!Character.isDigit(cTime[0]))
			return "";
		else if (!Character.isDigit(cTime[1]))
			return "";
		else if (cTime[2] != ':')
			return "";
		else if (!Character.isDigit(cTime[3]))
			return "";
		else if (!Character.isDigit(cTime[4]))
			return "";
		else if (cTime[5] != ':')
			return "";
		else if (!Character.isDigit(cTime[6]))
			return "";
		else if (!Character.isDigit(cTime[7]))
			return "";
		else if (!validaTime(sTime))
			return "";
		return sTime;
	}
	
	/**
	 * Retorna o path para um arquivo que ser� criado radomicamento no diret�rio
	 * TEMP.
	 * 
	 * @return - Path para o arquivo.
	 */
	

	/**
	 * Retorna um File j� verificado que foi selecionado pelo usu�rio.
	 * 
	 * @return - Ponteiro do arquivo.
	 * @see #criaArqTemp(String)
	 */
	public static File buscaArq(Component pai, String sExt) {
		File fRet = null;
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(Funcoes.getFiler(new String[] { sExt }));
		fc.setAcceptAllFileFilterUsed(false);
		if (fc.showSaveDialog(pai) == JFileChooser.APPROVE_OPTION) {
			fRet = fc.getSelectedFile();
			if (!fRet.getPath().trim().equals("")) {
				if (fRet.getPath().indexOf(".") == -1) {
					fRet = new File(fRet.getPath().trim() + "." + sExt);
				}
			}
		}
		try {
			if (fRet.exists()) {
				if (Funcoes.mensagemConfirma(pai,
						"Arquivo j� existe, sobrescrever?") != JOptionPane.YES_OPTION)
					return null;
			} else
				fRet.createNewFile();
		} catch (IOException err) {
			Funcoes.mensagemErro(pai, "Erro ao verificar o arquivo!\n"
					+ err.getMessage());
			err.printStackTrace();
		}
		return fRet;
	}

	public static FileFilter getFiler(final String sExts[]) {
		return new FileFilter() {
			public boolean accept(File fArq) {
				boolean bRet = false;
				if (fArq.isDirectory())
					return true;
				String sExt = getExt(fArq);
				for (int i = 0; i < sExts.length; i++)
					if (sExt.equals(sExts[i]))
						bRet = true;
				return bRet;
			}

			public String getDescription() {
				String sVal = "";
				String sVirg = "";
				for (int i = 0; i < sExts.length; i++) {
					sVal += sVirg + sExts[i];
					sVirg = ",";
				}
				return "Arquivo(s): " + sVal;
			}

			public String getExt(File f) {
				String ext = "";
				String s = f.getName();
				int i = s.lastIndexOf('.');

				if (i > 0 && i < s.length() - 1) {
					ext = s.substring(i + 1).toLowerCase();
				}
				return ext;
			}
		};
	}

	/**
	 * Retorna um File que foi gerado autom�ticamente no diret�rio tempor�rio.
	 * 
	 * @return - Ponteiro do arquivo.
	 * @see #criaArqTemp(String)
	 */
	public static File criaArqTemp() {
		return criaArqTemp("tmp");
	}

	/**
	 * Retorna um File que foi gerado autom�ticamente no diret�rio tempor�rio.
	 * Este arquivo ser� excluido autom�ticamente quando o java for finalizado.
	 * 
	 * @return - Ponteiro do arquivo.
	 */
	public static File criaArqTemp(String sExt) {
		File fRet = null;
		try {
			fRet = File.createTempFile("arq", "." + sExt);
		} catch (IOException err) {
			JOptionPane.showMessageDialog(null,
					"Erro ao criar arquivo tempor�rio!!" + err.getMessage());
		}
		fRet.deleteOnExit();
		return fRet;
	}

	public static Date[] periodoMes(int iMes, int iAno) {
		Date[] dRets = new Date[2];
		GregorianCalendar cal = new GregorianCalendar(iAno, iMes, 1);
		dRets[0] = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, cal.getMaximum(Calendar.DAY_OF_MONTH));
		dRets[1] = (cal.getTime());
		return dRets;
	}

	public static String binToStr(byte[] byteData) {
		if (byteData == null)
			return null;
		int iSrcIdx; // index into source (byteData)
		int iDestIdx; // index into destination (byteDest)
		byte byteDest[] = new byte[((byteData.length + 2) / 3) * 4];

		for (iSrcIdx = 0, iDestIdx = 0; iSrcIdx < byteData.length - 2; iSrcIdx += 3) {
			byteDest[iDestIdx++] = (byte) ((byteData[iSrcIdx] >>> 2) & 077);
			byteDest[iDestIdx++] = (byte) ((byteData[iSrcIdx + 1] >>> 4) & 017 | (byteData[iSrcIdx] << 4) & 077);
			byteDest[iDestIdx++] = (byte) ((byteData[iSrcIdx + 2] >>> 6) & 003 | (byteData[iSrcIdx + 1] << 2) & 077);
			byteDest[iDestIdx++] = (byte) (byteData[iSrcIdx + 2] & 077);

			if (iSrcIdx < byteData.length) {
				byteDest[iDestIdx++] = (byte) ((byteData[iSrcIdx] >>> 2) & 077);
				if (iSrcIdx < byteData.length - 1) {
					byteDest[iDestIdx++] = (byte) ((byteData[iSrcIdx + 1] >>> 4) & 017 | (byteData[iSrcIdx] << 4) & 077);
					byteDest[iDestIdx++] = (byte) ((byteData[iSrcIdx + 1] << 2) & 077);
				} else
					byteDest[iDestIdx++] = (byte) ((byteData[iSrcIdx] << 4) & 077);
			}

			for (iSrcIdx = 0; iSrcIdx < iDestIdx; iSrcIdx++) {
				if (byteDest[iSrcIdx] < 26)
					byteDest[iSrcIdx] = (byte) (byteDest[iSrcIdx] + 'A');
				else if (byteDest[iSrcIdx] < 52)
					byteDest[iSrcIdx] = (byte) (byteDest[iSrcIdx] + 'a' - 26);
				else if (byteDest[iSrcIdx] < 62)
					byteDest[iSrcIdx] = (byte) (byteDest[iSrcIdx] + '0' - 52);
				else if (byteDest[iSrcIdx] < 63)
					byteDest[iSrcIdx] = '+';
				else
					byteDest[iSrcIdx] = '/';
			}

			for (; iSrcIdx < byteDest.length; iSrcIdx++)
				byteDest[iSrcIdx] = '=';

		}

		return new String(byteDest);
	}

	public static String arredondaData(String sData) {
		if (sData.length() < 10)
			return "";
		int iDia = 0;
		int iMes = 0;
		int iAno = 0;
		int ano = Integer.parseInt(sData.substring(6, 10));
		int mes = Integer.parseInt(sData.substring(3, 5));
		int dia = Integer.parseInt(sData.substring(0, 2));
		if (mes > 12)
			mes = 13;
		if (dia > 32)
			dia = 32;
		GregorianCalendar cal = new GregorianCalendar(ano, mes - 1, dia);

		if (mes != (cal.get(Calendar.MONTH) + 1)) {
			cal.set(Calendar.DAY_OF_MONTH, 0);
			iDia = cal.get(Calendar.DAY_OF_MONTH);
			iMes = cal.get(Calendar.MONTH) + 1;
			iAno = cal.get(Calendar.YEAR);
		}
		return strZero("" + iDia, 2) + "/" + strZero("" + iMes, 2) + "/"
				+ strZero("" + iAno, 4);
	}

	public static boolean validaData(String data) {
		boolean retorno = true;
		GregorianCalendar cal = null;
		if (data.length() < 10)
			return false;
		int ano = Integer.parseInt(data.substring(6, 10));
		int mes = Integer.parseInt(data.substring(3, 5));
		int dia = Integer.parseInt(data.substring(0, 2));

		cal = new GregorianCalendar(ano, mes - 1, dia);

		if ((mes > 12) | (ano == 0))
			retorno = false;
		else if ((mes != (cal.get(Calendar.MONTH) + 1)) | (dia == 0)) {
			retorno = false;
		} else if ((ano != (cal.get(Calendar.YEAR))) | (mes == 0))
			retorno = false;
		return retorno;
	}

	public static boolean validaTime(String time) {
		boolean retorno = true;
		if (time.length() < 8)
			return false;
		int hora = Integer.parseInt(time.substring(0,2));
		int minuto = Integer.parseInt(time.substring(3, 5));
		int segundo = Integer.parseInt(time.substring(6, 8));


		if ((hora > 23) || (hora < 0))
			retorno = false;
		else if ( (minuto>59) || (minuto<0) )
			retorno = false;
		else if ( (segundo>59) || (segundo<0) ) 
			retorno = false;
		return retorno;
	}
	
	public static String timeStampToStrDate(Timestamp tVal) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(tVal);
		String sRetorno = strZero("" + cal.get(Calendar.DATE), 2);
		sRetorno += "/" + strZero("" + (cal.get(Calendar.MONTH) + 1), 2);
		sRetorno += "/" + (cal.get(Calendar.YEAR));
		return sRetorno;
	}

	public static java.sql.Date dateToSQLDate(Date d) {
		return new java.sql.Date(d.getTime());
	}

	public static java.sql.Time dateToSQLTime(Date d) {
		return new java.sql.Time(d.getTime());
	}

	public static Date sqlDateToDate(java.sql.Date dVal) {
		Date dRetorno = new Date(dVal.getTime());
		return dRetorno;
	}

	public static GregorianCalendar sqlDateToGregorianCalendar(
			java.sql.Date dVal) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(dVal.getTime());
		return cal;
	}

	public static String[] strToStrArray(String sVals) {
		int iConta = 0;
		int iPos = 0;
		if (sVals != null) {
			while (iPos >= 0) {
				iPos = sVals.indexOf('\n', iPos + 1);
				iConta++;
			}
		}
		return strToStrArray(sVals, iConta);
	}

	public static String[] strToStrArray(String sVals, int iNumLinhas) {
		String[] sRetorno = new String[iNumLinhas];
		String sTemp = sVals != null ? sVals : "";
		int iPos;
		for (int i = 0; i < iNumLinhas; i++) {
			iPos = sTemp.indexOf('\n');
			if (iPos >= 0) {
				sRetorno[i] = sTemp.substring(0, iPos);
				if (iPos + 1 < sTemp.length())
					sTemp = sTemp.substring(iPos + 1, sTemp.length());
				else
					sTemp = "";
			} else if ((iPos == -1) && (sTemp.length() == 0)) {
				sRetorno[i] = "";
			} else {
				sRetorno[i] = sTemp;
				sTemp = "";
			}
		}
		return sRetorno;
	}

	public static String[] strToStrArray(String sVals,String sSep) {
		int iConta = 0;
		int iPos = 0;
		if (sVals != null) {
			while (iPos >= 0) {
				iPos = sVals.indexOf(sSep, iPos + 1);
				iConta++;
			}
		}
		return strToStrArray(sVals, iConta,sSep);
	}

	public static String[] strToStrArray(String sVals, int iNumLinhas,String sSep) {
		String[] sRetorno = new String[iNumLinhas];
		String sTemp = sVals != null ? sVals : "";
		int iPos;
		int iTamSep = sSep.length();
		for (int i = 0; i < iNumLinhas; i++) {
			iPos = sTemp.indexOf(sSep);
			if (iPos >= 0) {
				sRetorno[i] = sTemp.substring(0, iPos);
				if (iPos + 1 < sTemp.length())
					sTemp = sTemp.substring(iPos + iTamSep, sTemp.length());
				else
					sTemp = "";
			} else if ((iPos == -1) && (sTemp.length() == 0)) {
				sRetorno[i] = "";
			} else {
				sRetorno[i] = sTemp;
				sTemp = "";
			}
		}
		return sRetorno;
	}


	
	public static String strTostrQuebra(String sVals, int iNumChar) {
		String sRetorno = "";
		int iPos = 0;
		int iPosBranco = 0;
		int iPosEnter = 0;
		String sBusca = sVals;
		String sResto = "";
		if ((sVals != null) && (sVals.length() > iNumChar)) {
			while ((sBusca.length() > iNumChar)
					&& (((sBusca.indexOf(" ") > iNumChar) || (sBusca
							.indexOf("\n") > iNumChar)) || ((sBusca
							.indexOf(" ") < 0) || (sBusca.indexOf("\n") < 0)))) {
				iPos = 0;
				iPosBranco = sBusca.lastIndexOf(" ");
				iPosEnter = sBusca.lastIndexOf("\n");
				if (((iPosBranco < iPosEnter) && (iPosBranco > 0))
						|| ((iPosEnter < 0) && (iPosBranco > 0))) {
					iPos = iPosBranco;
				} else if (((iPosBranco > iPosEnter) || (iPosBranco == 0))
						&& (iPosEnter > 0)) {
					iPos = iPosEnter;
				}
				if ((iPosEnter == iPosBranco) || (iPos > iNumChar)
						|| (iPos == 0)) {
					iPos = iNumChar;
				}
				if (iPos > iNumChar) {
					sResto = sBusca.substring(0, iPos);
					sBusca = sBusca.substring(iPos, sBusca.length());
					sRetorno += sResto + " ";
				} else {
					sRetorno = sVals;
					sBusca = "";
				}
			}
			sRetorno += sBusca;
		} else {
			return sBusca;
		}
		return sRetorno;
	}

	public static Vector strToVectorSilabas(String sVals, int iNumColunas) {
		sVals = strTostrQuebra(sVals, iNumColunas);
		Vector vRetorno = new Vector();
		String[] sSeparadaPorEnter = null;
		String sLinhaAnt = "";
		String sLinhaNova = "";
		String sResto = "";
		String sLinhaCortada = "";
		if (sVals != null) {
			sSeparadaPorEnter = strToStrArray(sVals);
			for (int i = 0; sSeparadaPorEnter.length > i; i++) {
				if (!sResto.trim().equals(""))
					sLinhaAnt = sResto + " " + sSeparadaPorEnter[i];
				else
					sLinhaAnt = sSeparadaPorEnter[i];
				if (sLinhaAnt.length() > iNumColunas) {
					sLinhaCortada = sLinhaAnt.substring(0,
							iNumColunas < sLinhaAnt.length() ? iNumColunas
									: sLinhaAnt.length());
					if (sLinhaCortada.lastIndexOf(" ") > 0)
						sLinhaNova = sLinhaCortada.substring(0, sLinhaCortada
								.lastIndexOf(' '));
					else
						sLinhaNova = sLinhaCortada.substring(0, iNumColunas);

					sResto = sLinhaAnt.substring(sLinhaNova.length());

				} else {
					sLinhaNova = sLinhaAnt;
					sResto = "";
				}
				sLinhaNova = (sLinhaNova.replaceAll(" +", " "));
				if (sLinhaNova.indexOf(" ") == 0)
					vRetorno.addElement(sLinhaNova.substring(1));
				else
					vRetorno.addElement(sLinhaNova);
			}
			if (sResto.length() > 0) {
				while (sResto.length() > 0) {
					sLinhaAnt = sResto;
					sLinhaCortada = sLinhaAnt.substring(0,
							iNumColunas < sLinhaAnt.length() ? iNumColunas
									: sLinhaAnt.length());
					if (sLinhaAnt.length() > iNumColunas) {
						if (sLinhaCortada.lastIndexOf(" ") > 0) {
							sLinhaNova = sLinhaCortada.substring(0,
									sLinhaCortada.lastIndexOf(' '));
						} else if (sLinhaCortada.length() > iNumColunas)
							sLinhaNova = sLinhaCortada
									.substring(0, iNumColunas);
						else
							sLinhaNova = sLinhaCortada;

						sResto = sLinhaAnt.substring(sLinhaNova.length());

						sLinhaNova = (sLinhaNova.replaceAll(" +", " "));
						if (sLinhaNova.indexOf(" ") == 0)
							vRetorno.addElement(sLinhaNova.substring(1));
						else
							vRetorno.addElement(sLinhaNova);

					} else {
						sLinhaCortada = (sLinhaCortada.replaceAll(" +", " "));
						if (sLinhaCortada.indexOf(" ") == 0)
							vRetorno.addElement(sLinhaCortada.substring(1));
						else {
							vRetorno.addElement(sLinhaCortada);
						}
						sResto = "";
					}
				}
			}
		}
		return vRetorno;
	}

	public static String sqlDateToStrDate(java.sql.Date d) {
		if (d == null)
			return "";
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		int iDia = cal.get(Calendar.DAY_OF_MONTH);
		int iMes = cal.get(Calendar.MONTH) + 1;
		int iAno = cal.get(Calendar.YEAR);
		return strZero("" + iDia, 2) + "/" + strZero("" + iMes, 2) + "/" + iAno;
	}

	public static String sqlTimeToStrTime(java.sql.Time t) {
		if (t == null)
			return "";
		System.out.println("Data "+t);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(t);
		int iHora = cal.get(Calendar.HOUR_OF_DAY);
		int iMinuto = cal.get(Calendar.MINUTE);
		int iSegundo = cal.get(Calendar.SECOND);
		System.out.println(strZero("" + iHora, 2) + ":" + strZero("" + iMinuto, 2) + ":" + strZero("" + iSegundo, 2));

		return strZero("" + iHora, 2) + ":" + strZero("" + iMinuto, 2) + ":" + strZero("" + iSegundo, 2);
	}
	
	public static java.sql.Date strDateToSqlDate(String sVal) {
		GregorianCalendar cal = new GregorianCalendar();
		if (sVal.trim().length() == 10) {
			sVal = sVal.trim();
			try {
				int iAno = Integer.parseInt(sVal.substring(6));
				int iMes = Integer.parseInt(sVal.substring(3, 5)) - 1;
				int iDia = Integer.parseInt(sVal.substring(0, 2));
				cal = new GregorianCalendar(iAno, iMes, iDia);
			} catch (Exception err) {
				cal = null;
			}
		} else
			cal = null;
		if (cal == null)
			return null;
		return new java.sql.Date(cal.getTimeInMillis());
	}

	public static Date strDateToDate(String sVal) {
		GregorianCalendar cal = new GregorianCalendar();
		if (sVal.trim().length() == 10) {
			sVal = sVal.trim();
			try {
				int iAno = Integer.parseInt(sVal.substring(6));
				int iMes = Integer.parseInt(sVal.substring(3, 5)) - 1;
				int iDia = Integer.parseInt(sVal.substring(0, 2));
				cal = new GregorianCalendar(iAno, iMes, iDia);
			} catch (Exception err) {
				cal = null;
			}
		} else
			cal = null;
		if (cal == null)
			return null;
		return cal.getTime();
	}

	public static String dateToStrDataHora(Date dVal) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dVal);
		int iAno = cal.get(Calendar.YEAR);
		int iMes = cal.get(Calendar.MONTH) + 1;
		int iDia = cal.get(Calendar.DAY_OF_MONTH);
		int iHora = cal.get(Calendar.HOUR_OF_DAY);
		int iMinuto = cal.get(Calendar.MINUTE);
		int iSegundo = cal.get(Calendar.SECOND);
		return strZero("" + iDia, 2) + "/" + strZero("" + iMes, 2) + "/" + iAno
				+ " - " + Funcoes.strZero("" + iHora, 2) + ":"
				+ Funcoes.strZero("" + iMinuto, 2) + ":"
				+ Funcoes.strZero("" + iSegundo, 2);
	}

	public static String dateToStrDate(Date dVal) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dVal);
		int iAno = cal.get(Calendar.YEAR);
		int iMes = cal.get(Calendar.MONTH) + 1;
		int iDia = cal.get(Calendar.DAY_OF_MONTH);
		return strZero(String.valueOf(iDia), 2) + "/" + strZero(String.valueOf(iMes), 2) + "/" + String.valueOf(iAno);
	}

	public static String dateToStrTime(Date dVal) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dVal);
		int iHora = cal.get(Calendar.HOUR_OF_DAY);
		int iMinuto = cal.get(Calendar.MINUTE);
		int iSegundo = cal.get(Calendar.SECOND);
		return strZero(String.valueOf(iHora), 2) + ":" + strZero(String.valueOf(iMinuto), 2) + ":" + iSegundo;
	}

	public static String strDateToStrDB(String sVal) {
		String sRet = "";
		if (sVal.trim().length() == 10) {
			sVal = sVal.trim();
			try {
				int iAno = Integer.parseInt(sVal.substring(6));
				int iMes = Integer.parseInt(sVal.substring(3, 5));
				int iDia = Integer.parseInt(sVal.substring(0, 2));
				sRet = iAno + "-" + iMes + "-" + iDia;
			} catch (Exception err) {
				sRet = "";
			}
		} else
			sRet = "";
		return sRet;
	}

	public static String dateToStrDB(Date d) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		String sDia = "" + cal.get(Calendar.DAY_OF_MONTH);
		String sMes = "" + (cal.get(Calendar.MONTH) + 1);
		String sAno = "" + cal.get(Calendar.YEAR);
		return sAno + "-" + sMes + "-" + sDia;
	}

	public static Timestamp dateToTimestamp(Date d) {
		return new Timestamp(d.getTime());
	}

	public static BigDecimal strCurrencyToBigDecimal(String sVal) {
		BigDecimal bigRetorno = new BigDecimal("0");
		if (sVal == null)
			return new BigDecimal("0");
		int iPosPonto = sVal.indexOf('.');
		if (iPosPonto > -1)
			sVal = sVal.substring(0, iPosPonto) + sVal.substring(iPosPonto + 1);
		char[] cVal = sVal.toCharArray();
		int iPos = sVal.indexOf(",");
		if (iPos >= 0)
			cVal[iPos] = '.';
		sVal = new String(cVal);
		try {
			bigRetorno = new BigDecimal(sVal.trim());
		} catch (Exception err) {
		}
		return bigRetorno;
	}

	public static double strCurrencyToDouble(String sVal) {
		if (sVal == null)
			return 0;
		sVal = sVal.replace(getPontoDec(), '.');
		int iPos = sVal.lastIndexOf('.');
		int iPosTmp = -1;
		if (iPos >= 0) {
			while (iPos != (iPosTmp = sVal.indexOf('.'))) {//Tirando os pontos
				// de milhar.
				sVal = sVal.substring(0, iPosTmp) + sVal.substring(iPosTmp + 1);
				iPos--;
			}
		}
		return Double.parseDouble(sVal);
	}

	/**
	 * Aplica uma mascara sobre uma string. <BR>
	 * A mascara funciona da seguinte forma: <BR>
	 * Uma string cont�m a mascara, esta string <BR>
	 * ser� a matriz para transforma��o, esta matriz <BR>
	 * � composta de caracteres mas um caracter em especial <BR>
	 * o '#' que serve para busca de seu respectivo valor bruto. <BR>
	 * Por exemplo a mascara a seguir: <BR>
	 * "###.###,##". <BR>
	 * Se aplicarmos esta marcara sobre a string: <BR>
	 * "1022000" <BR>
	 * O Resultado ser�: "10.220,00".
	 * 
	 * @param sVal -
	 *            String com o valor 'bruto'.
	 * @param sMasc -
	 *            String com a mascara.
	 * @return Rotorna o valor bruto mascarado.
	 */
	public static String setMascara(String sVal, String sMasc) {
		if (sVal == null)
			return "";
		String texto = "";
		int i2 = 0;
		if ((sVal.length() > 0) & (sMasc.length() > 0)
				& (sMasc.length() > sVal.length())) {
			char[] va = sVal.toCharArray();
			char[] ma = sMasc.toCharArray();
			for (int i = 0; i < sVal.length(); i++) {
				if (ma[i2] == '#') {
					texto += va[i];
				} else {
					texto += ma[i2];
					texto += va[i];
					i2++;
				}
				i2++;
			}
		} else
			texto = sVal;
		return texto;
	}

	public static BigDecimal strDecimalToBigDecimal(int iDec, String sVal) {
		double deVal = 0;
		BigDecimal bigRet = null;
		try {
		   if (sVal==null)
		      sVal = "0";
		   deVal = Float.parseFloat(sVal);
		   deVal = Funcoes.arredDouble(deVal, iDec);
		}
		finally {
			bigRet = new BigDecimal(deVal);
		}
		return bigRet;
	}

	public static String strDecimalToStrCurrency(int iTam, int iDec, String sVal) {
		if (sVal == null)
			return replicate(" ", iTam);

		sVal = strDecimalToStrCurrency(iDec, sVal);
		sVal = replicate(" ", iTam - sVal.length()) + sVal;
		return sVal;
	}

	public static String strDecimalToStrCurrency(int iDec, String sVal) {
		String sRetorno = "";
		if (sVal == null || sVal.trim().equals(""))
			return sRetorno;
		int iPonto = sVal.indexOf('.');
		char[] cVal = sVal.toCharArray();
		int iCont = (iDec + 1) * -1;
		if (iPonto != -1) {
			cVal[iPonto] = ',';
			sVal = new String(cVal);
			sVal += replicate("0", iDec - (sVal.length() - (iPonto + 1)));
			sVal = sVal.substring(0, iPonto + 1 + iDec);
			cVal = sVal.toCharArray();
			for (int i = (sVal.length() - 1); i >= 0; i--) {
				if (iCont == 3) {
					if (cVal[i] == '-')
						sRetorno = cVal[i] + sRetorno;
					else
						sRetorno = cVal[i] + "." + sRetorno;
					iCont = 1;
				} else {
					sRetorno = cVal[i] + sRetorno;
					iCont++;
				}
			}
		} else {
			sRetorno = sVal + ',' + replicate("0", iDec);
		}
		if (iDec == 0) {
			sRetorno = sRetorno.substring(0, sRetorno.length() - 1);
		}
		return sRetorno;
	}

	public static void criaTelaErro(String sErro) {
		dlErro = new JDialog();
		dlErro.setSize(600, 350);
		dlErro.setLocationRelativeTo(dlErro);
		dlErro.setTitle("Relat�rio de Erros");
		Container c = dlErro.getContentPane();
		JPanelPad pnRod = new JPanelPad(JPanelPad.TP_JPANEL);
		JPanelPad pnOK = new JPanelPad(JPanelPad.TP_JPANEL);
		JTextArea txt = new JTextArea(sErro);
		txt.setEditable(false);
		JScrollPane spnTxt = new JScrollPane(txt);
		JButton btOK = new JButton("OK");
		c.setLayout(new BorderLayout());
		c.add(pnRod, BorderLayout.SOUTH);
		pnRod.setPreferredSize(new Dimension(400, 40));
		btOK.setPreferredSize(new Dimension(90, 30));
		pnRod.add(pnOK);
		pnOK.add(btOK);
		c.add(spnTxt, BorderLayout.CENTER);
		btOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dlErro.dispose();
			}
		});
		dlErro.setModal(true);
		dlErro.setVisible(true);
	}

	public static String strZero(String val, int zeros) {
		if (val == null)
			return val;
		String sRetorno = replicate("0", zeros - val.trim().length());
		sRetorno += val.trim();
		return sRetorno;
	}

	public static boolean ValidaCNPJ(String sDado) {
		byte[] D1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int DF1, DF2, DF3, DF4, DF5, DF6, Resto1, Resto2, PrimeiroDigito, SegundoDigito;
		String sConvert = " " + sDado.trim();
		char[] Dado = sConvert.toCharArray();
		boolean bRetorno = true;
		if (sDado.trim().length() == 14) {
			for (int i = 1; i <= 12; i++)
				if (Character.isDigit(Dado[i]))
					D1[i] = Byte.parseByte("" + Dado[i]);
				else
					bRetorno = false;
			if (bRetorno) {
				DF1 = 5 * D1[1] + 4 * D1[2] + 3 * D1[3] + 2 * D1[4] + 9 * D1[5]
						+ 8 * D1[6] + 7 * D1[7] + 6 * D1[8] + 5 * D1[9] + 4
						* D1[10] + 3 * D1[11] + 2 * D1[12];
				DF2 = DF1 / 11;
				DF3 = DF2 * 11;
				Resto1 = DF1 - DF3;
				if ((Resto1 == 0) | (Resto1 == 1))
					PrimeiroDigito = 0;
				else
					PrimeiroDigito = 11 - Resto1;
				DF4 = 6 * D1[1] + 5 * D1[2] + 4 * D1[3] + 3 * D1[4] + 2 * D1[5]
						+ 9 * D1[6] + 8 * D1[7] + 7 * D1[8] + 6 * D1[9] + 5
						* D1[10] + 4 * D1[11] + 3 * D1[12] + 2 * PrimeiroDigito;
				DF5 = DF4 / 11;
				DF6 = DF5 * 11;
				Resto2 = DF4 - DF6;
				if ((Resto2 == 0) | (Resto2 == 1))
					SegundoDigito = 0;
				else
					SegundoDigito = 11 - Resto2;
				if ((PrimeiroDigito != Integer.parseInt("" + Dado[13]))
						| (SegundoDigito != Integer.parseInt("" + Dado[14])))
					bRetorno = false;
			}
		} else if (sDado.trim().length() != 0)
			bRetorno = false;
		return bRetorno;
	}

	public static boolean ValidaCPF(String sDado) {
		byte[] D1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int DF1, DF2, DF3, DF4, DF5, DF6, Resto1, Resto2, PrimeiroDigito, SegundoDigito;
		String sConvert = sDado.trim();
		char[] Dado = sConvert.toCharArray();
		boolean bRetorno = true;
		if (sDado.trim().length() == 11) {
			for (int i = 1; i <= 9; i++)
				if (Character.isDigit(Dado[i]))
					D1[i] = Byte.parseByte("" + Dado[i - 1]);
				else
					bRetorno = false;
			if (bRetorno) {
				DF1 = 10 * D1[1] + 9 * D1[2] + 8 * D1[3] + 7 * D1[4] + 6
						* D1[5] + 5 * D1[6] + 4 * D1[7] + 3 * D1[8] + 2 * D1[9];
				DF2 = DF1 / 11;
				DF3 = DF2 * 11;
				Resto1 = DF1 - DF3;
				if ((Resto1 == 0) || (Resto1 == 1))
					PrimeiroDigito = 0;
				else
					PrimeiroDigito = 11 - Resto1;
				DF4 = 11 * D1[1] + 10 * D1[2] + 9 * D1[3] + 8 * D1[4] + 7
						* D1[5] + 6 * D1[6] + 5 * D1[7] + 4 * D1[8] + 3 * D1[9]
						+ 2 * PrimeiroDigito;
				DF5 = DF4 / 11;
				DF6 = DF5 * 11;
				Resto2 = DF4 - DF6;
				if ((Resto2 == 0) || (Resto2 == 1))
					SegundoDigito = 0;
				else
					SegundoDigito = 11 - Resto2;
				if ((PrimeiroDigito != Integer.parseInt(Dado[9] + ""))
						|| (SegundoDigito != Integer.parseInt(Dado[10] + "")))
					bRetorno = false;
			}
		} else if (sDado.trim().length() != 0)
			bRetorno = false;
		return bRetorno;
	}

	public static boolean vIE(String sIE, String sEstado) {
		boolean bRetorno = false;
		sEstado.toUpperCase();
		
		
		for (int i = 1; i <= 3; i++) {
			if (testaDigIE(sEstado, sIE, i)) {
				bRetorno = true;
				break;
			}
		}
		return bRetorno;
	}

	private static boolean testaDigIE(String sEstado, String sIE, int iCaso) {
		boolean bRetorno = false;
		String sIE2 = "";

		for (int i = 0; i < 34; i++) {
			if (((String) ((Vector) vIE.elementAt(i)).elementAt(0))
					.equals(sEstado)
					&& ((Integer) ((Vector) vIE.elementAt(i)).elementAt(1))
							.intValue() == iCaso) {
				sIE2 = sIE;
				if (testaCasoIE(sIE2, (Vector) vIE.elementAt(i))) {
					sIE = sIE2;
					bRetorno = true;
					break;
				}
			}
		}
		return bRetorno;
	}

	private static boolean testaCasoIE(String sIE, Vector vXIE) {
		String sIENova = "";
		int iSX, iSY, iSQiX, iSQiY, iPosDVX, iPosDVY;
		int iDVX = -1;
		int iDVY = -1;
		int[] aMiX, aMiY, aQiX, aQiY;
		int[] vPesoX, vPesoY;
		boolean bDVY = false;
		iPosDVX = carregaPosDV(vXIE)[0];
		iPosDVY = carregaPosDV(vXIE)[1];
		vPesoX = retPeso(vXIE, 'X');
		if (iPosDVY > 0)
			bDVY = true;
		else
			bDVY = false;
		for (int i = 0; i < sIE.length(); i++) {
			if (Character.isDigit(sIE.toCharArray()[i]))
				sIENova += sIE.toCharArray()[i];
		}
		if (sIENova.length() != ((Integer) vXIE.elementAt(2)).intValue())
			return false;
		for (int i = (24 - sIENova.length()); i < 24; i++) {
			if (retValUF((String) vXIE.elementAt(i)).indexOf(
					(sIENova.toCharArray())[i - (24 - sIENova.length())]) < 0)
				return false;
		}
		//****** Ir� calcular digitos verificadores !!!
		aMiX = new int[14];
		aQiX = new int[14];
		iSX = 0;
		iSQiX = 0;
		for (int i = 0; i < sIENova.length(); i++) {
			if ((i != iPosDVX) & (i != iPosDVY)) {
				aMiX[i] = (Integer.parseInt("" + (sIENova.toCharArray())[i]))
						* vPesoX[i];
				iSX += aMiX[i];
			}
		}
		//    System.out.println("iSX: "+iSX);
		if (((String) vXIE.elementAt(4)).indexOf('A') == 0) {
			for (int i = (sIENova.length() - 1); i > 0; i--) {
				if ((i != iPosDVX) & (i != iPosDVY)) {
					aQiX[i] = aMiX[i] / 10;
					iSQiX += aQiX[i];
				}
			}
			iSX += iSQiX;
		} else if (((String) vXIE.elementAt(4)).indexOf('B') >= 0)
			iSX *= 10;
		else if (((String) vXIE.elementAt(4)).indexOf('C') >= 0)
			iSX += (5 + (4 * ((Integer) vXIE.elementAt(3)).intValue()));
		if (((String) vXIE.elementAt(4)).indexOf('D') >= 0)
			iDVX = iSX % ((Integer) vXIE.elementAt(5)).intValue();
		else if (((String) vXIE.elementAt(4)).indexOf('E') >= 0) {
			iDVX = iSX % ((Integer) vXIE.elementAt(5)).intValue();
			iDVX = ((Integer) vXIE.elementAt(5)).intValue() - iDVX;
		}
		if (iDVX == 10)
			iDVX = 0;
		else if (iDVX == 11)
			iDVX = ((Integer) vXIE.elementAt(3)).intValue();
		if (bDVY) {
			vPesoY = retPeso(vXIE, 'Y');
			aMiY = new int[14];
			aQiY = new int[14];
			iSY = 0;
			iSQiY = 0;
			for (int i = 0; i < sIENova.length(); i++) {
				if (i != iPosDVY) {
					aMiY[i] = (Integer
							.parseInt("" + (sIENova.toCharArray())[i]))
							* vPesoY[i];
					iSY += aMiY[i];
					//          System.out.println("MI:
					// "+Integer.parseInt(""+(sIENova.toCharArray())[i])+" X
					// "+vPesoY[i]);
				}
			}
			//     System.out.println("iSY: "+iSY);
			if (((String) vXIE.elementAt(7)).indexOf('A') >= 0) {
				for (int i = (sIENova.length() - 1); i > 0; i--) {
					if (i != iPosDVY) {
						aQiY[i] = aMiY[i] / 10;
						iSQiY += aQiY[i];
					}
				}
				iSY += iSQiY;
			} else if (((String) vXIE.elementAt(7)).indexOf('B') >= 0)
				iSY *= 10;
			else if (((String) vXIE.elementAt(7)).indexOf('C') >= 0)
				iSY += (5 + (4 * ((Integer) vXIE.elementAt(3)).intValue()));
			if (((String) vXIE.elementAt(7)).indexOf('D') >= 0)
				iDVY = iSY % ((Integer) vXIE.elementAt(8)).intValue();
			else if (((String) vXIE.elementAt(7)).indexOf('E') >= 0) {
				iDVY = iSY % ((Integer) vXIE.elementAt(8)).intValue();
				iDVY = ((Integer) vXIE.elementAt(8)).intValue() - iDVY;
			}
			if (iDVY == 10)
				iDVY = 0;
			else if (iDVY == 11)
				iDVY = ((Integer) vXIE.elementAt(3)).intValue();
		}
		//      System.out.println(Integer.parseInt(""+(sIENova.toCharArray())[sIENova.length()-(14-iPosDVX)])+"
		// = "+iDVX);
		//    if (bDVY)
		//      System.out.println(""+(sIENova.toCharArray())[sIENova.length()-(14-iPosDVY)]+"
		// = "+iDVY);
		if (Integer.parseInt(""
				+ (sIENova.toCharArray())[sIENova.length() - (14 - iPosDVX)]) == iDVX) {
			if (bDVY) {
				if (Integer.parseInt(""
						+ (sIENova.toCharArray())[sIENova.length()
								- (14 - iPosDVY)]) != iDVY) {
					return false;
				}
			}
		} else {
			return false;
		}
		sIEValida = setMascara(sIENova, (String) vXIE.elementAt(24));
		//    System.out.println("TRUE");
		return true;
	}

	private static int[] retPeso(Vector vXIE, char XY) {
		String sPeso = "";
		int[] aRetorno = new int[14];
		int tam = ((Integer) vXIE.elementAt(2)).intValue();
		String peso = "";
		if (XY == 'X') {
			sPeso = (String) vXIE.elementAt(6);
			for (int i = 0; i < vPesoIE.size(); i++) {
				if (((String) ((Vector) vPesoIE.elementAt(i)).elementAt(0))
						.compareTo(sPeso) == 0) {
					for (int i2 = (15 - tam); i2 <= 14; i2++) {
						aRetorno[i2 - (15 - tam)] = ((Integer) ((Vector) vPesoIE
								.elementAt(i)).elementAt(i2)).intValue();
					}
					break;
				}
			}
		} else if (XY == 'Y') {
			sPeso = (String) vXIE.elementAt(9);
			for (int i = 1; i < vPesoIE.size(); i++) {
				if (((String) ((Vector) vPesoIE.elementAt(i)).elementAt(0))
						.compareTo(sPeso) == 0) {
					for (int i2 = (15 - tam); i2 <= 14; i2++) {
						aRetorno[i2 - (15 - tam)] = ((Integer) ((Vector) vPesoIE
								.elementAt(i)).elementAt(i2)).intValue();
						peso += ((Vector) vPesoIE.elementAt(i)).elementAt(i2)
								+ " ,";
					}
					break;
				}
			}
		}
		//    System.out.println(peso);
		return aRetorno;
	}

	private static String retValUF(String sVal) {
		String sRetorno = "";
		if (sVal == null)
			return "";
		char[] cVal = sVal.toCharArray();
		if (sVal.compareTo("0/9") == 0)
			sRetorno = "0123456789";
		else if (sVal.compareTo("DVX") == 0)
			sRetorno = "0123456789";
		else if (sVal.compareTo("DVY") == 0)
			sRetorno = "0123456789";
		else if (cVal[0] == '=') {
			sRetorno = sVal;
		} else if (cVal[1] == '/') {
			for (int i = cVal[0]; i <= cVal[2]; i++) {
				sRetorno += i;
			}
		}
		return sRetorno;
	}

	private static int[] carregaPosDV(Vector vXIE) {
		int[] aRetorno = new int[2];
		aRetorno[0] = -1;
		aRetorno[1] = -1;
		for (int i = 10; i <= 24; i++) {
			if (vXIE.elementAt(i) != null) {
				if (((String) vXIE.elementAt(i)).compareTo("DVX") == 0)
					aRetorno[0] = i - 10;
				else if (((String) vXIE.elementAt(i)).compareTo("DVY") == 0)
					aRetorno[1] = i - 10;
			}
		}
		return aRetorno;
	}

	public static String transValor(BigDecimal bdValor, int iTam, int iDec,
			boolean bZeroEsq) {
		String sValor;
		sValor = strDecimalToStrCurrency(iTam + 1, iDec, "" + bdValor);

		//    System.out.println("sValor: "+sValor);
		if (sValor.indexOf(",") >= 0)
			sValor = sValor.replaceAll(",", "");
		//    System.out.println("sValor: "+sValor);

		if (sValor.indexOf(".") >= 0)
			sValor = sValor.replaceAll(".", "");
		//    System.out.println("sValor: "+sValor);

		if (bZeroEsq)
			if (sValor.indexOf(" ") >= 0)
				sValor = sValor.replace(' ', '0');

		//    System.out.println("sValor: "+sValor);

		return sValor;
	}

}
