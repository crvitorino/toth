/*
 * KeyNumerico.java
 *
 * Criado em 15 de Agosto de 2006, 20:49
 *
 */

package utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Fernando Dettoni
 */
public class KeyNumerico implements KeyListener{
    
    /** Creates a new instance of KeyNumerico */
    boolean inteiro;
    public KeyNumerico(boolean inte) {
        inteiro = inte;
    }

    public void keyTyped(KeyEvent e) {
        int k=e.getKeyChar();
        if((k>47 && k<58)) {
        } else { 
            e.setKeyChar((char)KeyEvent.VK_CLEAR);
        }
    }
   

    public void keyReleased(KeyEvent keyEvent) {
    }

    public void keyPressed(KeyEvent keyEvent) {
    }
    
}
