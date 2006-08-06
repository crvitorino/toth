/*
 * Main.java
 *
 * Criado em 1 de Agosto de 2006, 18:23
 *
 */
package app;
import gui.Principal;
import java.awt.Dimension;
import java.security.NoSuchAlgorithmException;
import javax.swing.UIManager;
import utils.CriptoUtils;

/**
 *
 * @author Fernando Dettoni
 */
public class Main {
    
    /** Creates a new instance of Main */
    public static void main(String args[]) {
        Main main = new Main();
        javax.swing.UIManager.LookAndFeelInfo looks[];
        looks = javax.swing.UIManager.getInstalledLookAndFeels();
        try{
            UIManager.setLookAndFeel(looks[0].getClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConSQL con =  null;
        try {
        con = new ConSQL();}
        catch (Exception e) {
            e.printStackTrace();
        }
        Principal principal = new Principal(con);
        principal.setPreferredSize(new Dimension(700,500));
        principal.pack();
        principal.setVisible(true);
    }
    
    
}
