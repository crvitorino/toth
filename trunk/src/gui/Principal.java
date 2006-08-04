/*
 * Principal.java
 *
 * Created on 1 de Agosto de 2006, 18:27
 */

package gui;

import app.ConSQL;
import javax.swing.*;


/**
 *
 * @author  fernando
 */
public class Principal extends javax.swing.JFrame {
    
    /**
     * Creates new form Principal
     */
    private ConSQL con;
    public Principal(ConSQL con) {
        this.con = con;
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        status1 = new javax.swing.JLabel();
        intDesk = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        iClientes = new javax.swing.JMenuItem();
        mMovimento = new javax.swing.JMenu();
        mAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Toth Gest\u00e3o Comercial");
        status1.setText("status");
        status1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        status1.setAutoscrolls(true);
        status1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        getContentPane().add(status1, java.awt.BorderLayout.SOUTH);

        intDesk.setAutoscrolls(true);
        intDesk.setFocusable(false);
        intDesk.setMaximumSize(new java.awt.Dimension(0, 0));
        getContentPane().add(intDesk, java.awt.BorderLayout.CENTER);

        mCadastro.setText("Cadastro");
        iClientes.setText("Clientes");
        iClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iClientesActionPerformed(evt);
            }
        });

        mCadastro.add(iClientes);

        menu.add(mCadastro);

        mMovimento.setText("Movimenta\u00e7\u00e3o");
        menu.add(mMovimento);

        mAjuda.setText("Ajuda");
        menu.add(mAjuda);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iClientesActionPerformed
        CadastroClientes cad = new CadastroClientes(con);
        intClientes = new JInternalFrame("Cadastro de Clientes", true, true, true, true);
        intClientes.setContentPane(cad);
        intDesk.add(intClientes);
        intClientes.pack();
        intClientes.setVisible(true);
    }//GEN-LAST:event_iClientesActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem iClientes;
    private javax.swing.JDesktopPane intDesk;
    private javax.swing.JMenu mAjuda;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenu mMovimento;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel status1;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JInternalFrame intClientes;
}