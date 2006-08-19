/*
 * Main.java
 *
 * Criado em 1 de Agosto de 2006, 18:23
 *
 */
package app;
import gui.Login;
import javax.swing.UIManager;

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
        Login principal = new Login(con);
        principal.pack();
        principal.setVisible(true);

    }
    
    
}
