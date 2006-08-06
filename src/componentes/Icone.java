/**
 * @version 14/11/2000 <BR>
 * @author Setpoint Inform�tica Ltda./Fernando Oliveira da Silva <BR>
 *         Projeto: Freedom <BR>
 *         Pacote: bmps <BR>
 *         Classe:
 * @(#)Icone.java <BR>
 *                Este programa � licenciado de acordo com a LPG-PC (Licen�a
 *                P�blica Geral para Programas de Computador), <BR>
 *                vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 *                A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e
 *                REPRODU��ES deste Programa. <BR>
 *                Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este
 *                Programa, voc� pode contatar <BR>
 *                o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 *                Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 *                Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR
 *                este Programa � preciso estar <BR>
 *                de acordo com os termos da LPG-PC <BR>
 *                <BR>
 *                Coment�rios para a classe...
 */

package componentes;

import java.net.URL;

import javax.swing.ImageIcon;

public class Icone {
    
    public static String dirImages = "/org/freedom/images/";
	public Icone() {}

	public static ImageIcon novo(String nome) {
		ImageIcon retorno = null;
		URL url = Icone.class.getResource(dirImages + nome);

		if (url == null)
			System.out.println("N�o foi poss�vel carregar a imagem: '" + nome + "'");
		else
			retorno = new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
					.getImage(url));

		return retorno;
	}
}