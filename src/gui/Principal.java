/*
 * Principal.java
 *
 * Created on 1 de Agosto de 2006, 18:27
 */

package gui;
import app.ConSQL;
import java.awt.Dimension;
import javax.swing.*;
import relatorios.RelatorioClientes;
import relatorios.RelatorioEstoque;


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
        intDesk = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        iClientes = new javax.swing.JMenuItem();
        iprodutos = new javax.swing.JMenuItem();
        ifornecedor = new javax.swing.JMenuItem();
        iUsuarios = new javax.swing.JMenuItem();
        mMovimento = new javax.swing.JMenu();
        mPedidoVenda = new javax.swing.JMenuItem();
        mPedidoCompra = new javax.swing.JMenuItem();
        mRelatorios = new javax.swing.JMenu();
        iRelatorioEstoque = new javax.swing.JMenuItem();
        iRelatorioCliente = new javax.swing.JMenuItem();
        mUtilitarios = new javax.swing.JMenu();
        iCalc = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Toth Gest\u00e3o Comercial");
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

        iprodutos.setText("Produtos");
        iprodutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iprodutosActionPerformed(evt);
            }
        });

        mCadastro.add(iprodutos);

        ifornecedor.setText("Fornecedor");
        ifornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ifornecedorActionPerformed(evt);
            }
        });

        mCadastro.add(ifornecedor);

        iUsuarios.setText("Usu\u00e1rios");
        iUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iUsuariosActionPerformed(evt);
            }
        });

        mCadastro.add(iUsuarios);

        menu.add(mCadastro);

        mMovimento.setText("Movimenta\u00e7\u00e3o");
        mPedidoVenda.setText("Pedido de Venda");
        mPedidoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPedidoVendaActionPerformed(evt);
            }
        });

        mMovimento.add(mPedidoVenda);

        mPedidoCompra.setText("Pedido de Compra");
        mPedidoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPedidoCompraActionPerformed(evt);
            }
        });

        mMovimento.add(mPedidoCompra);

        menu.add(mMovimento);

        mRelatorios.setText("Relat\u00f3rios");
        iRelatorioEstoque.setText("Relat\u00f3rio de Estoque");
        iRelatorioEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iRelatorioEstoqueActionPerformed(evt);
            }
        });

        mRelatorios.add(iRelatorioEstoque);

        iRelatorioCliente.setText("Clientes");
        iRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iRelatorioClienteActionPerformed(evt);
            }
        });

        mRelatorios.add(iRelatorioCliente);

        menu.add(mRelatorios);

        mUtilitarios.setText("Utilit\u00e1rios");
        mUtilitarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUtilitariosActionPerformed(evt);
            }
        });

        iCalc.setText("Calculadora");
        iCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iCalcActionPerformed(evt);
            }
        });

        mUtilitarios.add(iCalc);

        menu.add(mUtilitarios);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iRelatorioClienteActionPerformed
 try {
            new RelatorioClientes(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_iRelatorioClienteActionPerformed

    private void mPedidoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPedidoCompraActionPerformed
            intPed = new PedidoEntrada(con, this); 
            intDesk.add(intPed);
            intPed.pack();
            intPed.setVisible(true);
    }//GEN-LAST:event_mPedidoCompraActionPerformed

    private void iRelatorioEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iRelatorioEstoqueActionPerformed
        try {
            new RelatorioEstoque(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_iRelatorioEstoqueActionPerformed

    private void mPedidoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPedidoVendaActionPerformed
            intPed = new PedidoVenda(con, this); 
            intDesk.add(intPed);
            intPed.pack();
            intPed.setVisible(true);
       
    }//GEN-LAST:event_mPedidoVendaActionPerformed

    private void iprodutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iprodutosActionPerformed
        CadastroProdutos cad = new CadastroProdutos(con);
        intProdutos = new JInternalFrame("Cadastro de Produtos", false, true, false, true);
        intProdutos.setContentPane(cad);
        intDesk.add(intProdutos);
        intProdutos.pack();
        intProdutos.setVisible(true);
    }//GEN-LAST:event_iprodutosActionPerformed

    private void ifornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ifornecedorActionPerformed
        CadastroFornecedor fornecedor = new CadastroFornecedor(con);
        intFornecedor = new JInternalFrame("Cadastro de Fornecedores", true, true, true, true);
        intFornecedor.setContentPane(fornecedor);
        intDesk.add(intFornecedor);
        intFornecedor.pack();
        intFornecedor.setVisible(true);
                                             

    }//GEN-LAST:event_ifornecedorActionPerformed

    private void iUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iUsuariosActionPerformed
        CadastroUsuarios cad = new CadastroUsuarios(con);
        intUsuarios = new JInternalFrame("Cadastro de usu�rios", false, true, false, true);
        intUsuarios.setContentPane(cad);
        intUsuarios.setMaximizable(false);
        intUsuarios.setMinimumSize(new Dimension(300, 100));
        intDesk.add(intUsuarios);
        intUsuarios.pack();
        intUsuarios.setVisible(true);
    }//GEN-LAST:event_iUsuariosActionPerformed

    private void mUtilitariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUtilitariosActionPerformed
        
    }//GEN-LAST:event_mUtilitariosActionPerformed

    private void iCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iCalcActionPerformed
        calc = new Calc();
        intDesk.add(calc);
        calc.pack();
        calc.setVisible(true);
    }//GEN-LAST:event_iCalcActionPerformed

    private void iClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iClientesActionPerformed
        CadastroClientes cad = new CadastroClientes(con);
        intClientes = new JInternalFrame("Cadastro de Clientes", false, true, false, true);
        intClientes.setContentPane(cad);
        intDesk.add(intClientes);
        intClientes.pack();
        intClientes.setVisible(true);
    }//GEN-LAST:event_iClientesActionPerformed
    public void addFrame(JInternalFrame frame) {
        intDesk.add(frame);
    }

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem iCalc;
    private javax.swing.JMenuItem iClientes;
    private javax.swing.JMenuItem iRelatorioCliente;
    private javax.swing.JMenuItem iRelatorioEstoque;
    private javax.swing.JMenuItem iUsuarios;
    private javax.swing.JMenuItem ifornecedor;
    private javax.swing.JDesktopPane intDesk;
    private javax.swing.JMenuItem iprodutos;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenu mMovimento;
    private javax.swing.JMenuItem mPedidoCompra;
    private javax.swing.JMenuItem mPedidoVenda;
    private javax.swing.JMenu mRelatorios;
    private javax.swing.JMenu mUtilitarios;
    private javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JInternalFrame intClientes = null;
    private javax.swing.JInternalFrame intFornecedor = null;
    private javax.swing.JInternalFrame intUsuarios = null;
    private javax.swing.JInternalFrame intProdutos = null;
    private Calc calc = null;
    private javax.swing.JInternalFrame intPed = null;
}
