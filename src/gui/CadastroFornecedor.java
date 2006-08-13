/*
 * CadastroClientes.java
 *
 * Created on 1 de Agosto de 2006, 19:48
 */

package gui;

import app.ConSQL;
import empresa.Fornecedor;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import utils.Funcoes;

/**
 *
 * @author  Karina
 */
public class CadastroFornecedor extends javax.swing.JPanel {
    private ConSQL con;
    private Fornecedor atual;
    private ResultSet atualIds;
    private boolean novo = false;
    
    /** Creates new form CadastroClientes */
    public CadastroFornecedor(ConSQL con){
        //Bloco de conex�o com SQL
        this.con = con;
        
        try {
            atuaIds();
            if (atualIds.first()){
                atual = new Fornecedor(atualIds.getInt(1), con);
            } else {
                atual = new Fornecedor(con);
                novo = true;
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initComponents();
        if (CadastroClientes.class.getResource("/images/btOk.gif") != null) {
            this.btGravar.setIcon(new ImageIcon(CadastroClientes.class.getResource("/images/btOk.gif")));
        } else {
            this.btGravar.setText("Gravar"); 
        }
        if (CadastroClientes.class.getResource("/images/btCancelar.gif") != null) {
            this.btCancelar.setIcon(new ImageIcon(CadastroClientes.class.getResource("/images/btCancelar.gif")));
        } else {
            this.btCancelar.setText("Cancelar");
        }
        if (CadastroClientes.class.getResource("/images/btPrim.gif") != null) {
            this.btPrim.setIcon(new ImageIcon(CadastroClientes.class.getResource("/images/btPrim.gif")));
        } else {
            this.btPrim.setText("<|"); 
        }
        if (CadastroClientes.class.getResource("/images/btUlt.gif") != null) {
            this.btUlt.setIcon(new ImageIcon(CadastroClientes.class.getResource("/images/btUlt.gif")));
        } else {
            this.btUlt.setText("|>"); 
        }
        if (CadastroClientes.class.getResource("/images/btFlechaDir.gif") != null) {
            this.btProx.setIcon(new ImageIcon(CadastroClientes.class.getResource("/images/btFlechaDir.gif")));
        } else {
            this.btProx.setText(">"); 
        }
        if (CadastroClientes.class.getResource("/images/btFlechaEsq.gif") != null) {
            this.btAnt.setIcon(new ImageIcon(CadastroClientes.class.getResource("/images/btFlechaEsq.gif")));
        } else {
            this.btAnt.setText("<"); 
        }
        setAtual();
        this.setPreferredSize(new Dimension(500,350));
    }
    public void setAtual() {
        txtCode.setText(String.valueOf(atual.codigo));
        chkAtivo.setSelected(atual.ativo);
        txtNome.setText(atual.nome);
        lblData.setText(Funcoes.trataData(atual.data));
        txtFantasia.setText(atual.fantasia);
        txtCNPJ.setText(atual.cnpj);
        txtIEST.setText(atual.inscest);
        txtEndereco.setText(atual.endereco);
        txtBairro.setText(atual.bairro);
        txtNum.setText(atual.numero);
        txtCidade.setText(atual.municipio);
        txtEstado.setText(atual.estado);
        txtCep.setText(atual.cep);
        txtFone.setText(atual.fone1);
        txtFone1.setText(atual.fone2);
        txtEmail.setText(atual.email);       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        chkAtivo = new javax.swing.JCheckBox();
        lblData = new javax.swing.JLabel();
        lblFantasia = new javax.swing.JLabel();
        txtFantasia = new javax.swing.JTextField();
        lblCpfcnpj = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        lblRg = new javax.swing.JLabel();
        txtIEST = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        lblFoneFax = new javax.swing.JLabel();
        txtFone = new javax.swing.JTextField();
        txtFone1 = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btPrim = new javax.swing.JButton();
        lblDesde = new javax.swing.JLabel();
        btAnt = new javax.swing.JButton();
        btProx = new javax.swing.JButton();
        btUlt = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();

        setToolTipText("Cadastro de Clientes");
        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(500, 400));

        lblEndereco.setText("Endere\u00e7o:");
        lblEndereco.setFocusable(false);

        lblNum.setText("N\u00famero:");
        lblNum.setFocusable(false);

        lblBairro.setText("Bairro: ");
        lblBairro.setFocusable(false);

        jLabel1.setText("Nome:");
        jLabel1.setFocusable(false);

        lblCode.setText("C\u00f3digo: ");
        lblCode.setFocusable(false);

        txtCode.setEnabled(false);
        txtCode.setOpaque(false);

        chkAtivo.setText("Ativo");
        chkAtivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkAtivo.setMargin(new java.awt.Insets(0, 0, 0, 0));

        lblData.setFocusable(false);

        lblFantasia.setText("Fantasia: ");
        lblFantasia.setFocusable(false);

        lblCpfcnpj.setText("CNPJ: ");
        lblCpfcnpj.setFocusable(false);

        lblRg.setText("INSCR. ESTADUAL");
        lblRg.setFocusable(false);

        lblCidade.setText("Munic\u00edpio: ");
        lblCidade.setFocusable(false);

        lblEstado.setText("Estado: ");
        lblEstado.setFocusable(false);

        lblCep.setText("CEP: ");
        lblCep.setFocusable(false);

        lblFoneFax.setText("Fone/Fax: ");
        lblFoneFax.setFocusable(false);

        lblEmail.setText("e-mail: ");
        lblEmail.setFocusable(false);

        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btGravar.setMnemonic('G');
        btGravar.setToolTipText("Pressione para gravar o cliente atual");
        btGravar.setDisabledIcon(new javax.swing.ImageIcon(""));
        btGravar.setDisabledSelectedIcon(new javax.swing.ImageIcon(""));
        btGravar.setPressedIcon(new javax.swing.ImageIcon(""));
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrimActionPerformed(evt);
            }
        });

        lblDesde.setText("Desde: ");

        btAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAntActionPerformed(evt);
            }
        });

        btProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProxActionPerformed(evt);
            }
        });

        btUlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUltActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(lblFantasia)
                        .add(418, 418, 418))
                    .add(layout.createSequentialGroup()
                        .add(lblCpfcnpj)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 445, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(lblEndereco)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 423, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblCode)
                            .add(jLabel1)
                            .add(lblBairro)
                            .add(lblCidade)
                            .add(lblCep)
                            .add(lblEmail))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(txtCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 69, Short.MAX_VALUE)
                                .add(chkAtivo)
                                .add(75, 75, 75)
                                .add(lblDesde)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(lblData, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(btGravar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(txtCNPJ, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(23, 23, 23)
                                        .add(lblRg)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtIEST, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                    .add(txtNome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                    .add(txtFantasia, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtEndereco, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                    .add(txtEmail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                    .add(layout.createSequentialGroup()
                                        .add(txtCep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(lblFoneFax)
                                        .add(16, 16, 16)
                                        .add(txtFone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtFone1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtCidade)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(35, 35, 35)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createSequentialGroup()
                                                .add(lblEstado)
                                                .add(5, 5, 5))
                                            .add(layout.createSequentialGroup()
                                                .add(lblNum)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtEstado, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                    .add(txtNum, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))))))
                                .add(22, 22, 22)))))
                .add(340, 340, 340))
            .add(layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(btPrim)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btAnt)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btProx)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btUlt)
                .add(56, 56, 56)
                .add(btNovo)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btPrim)
                    .add(btAnt)
                    .add(btProx)
                    .add(btUlt)
                    .add(btNovo))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCode)
                    .add(txtCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chkAtivo)
                    .add(lblData, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblDesde))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblFantasia)
                    .add(txtFantasia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCpfcnpj)
                    .add(txtCNPJ, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblRg)
                    .add(txtIEST, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblEndereco)
                    .add(txtEndereco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblBairro)
                            .add(txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblNum))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblCidade)
                            .add(txtCidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblEstado)))
                    .add(layout.createSequentialGroup()
                        .add(txtNum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCep)
                    .add(lblFoneFax)
                    .add(txtFone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFone1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtCep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblEmail)
                    .add(txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btGravar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if (novo) {
            try {
            if (atualIds.last())
                atual = new Fornecedor(atualIds.getInt(1), this.con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            setAtual();
        } else {
            setAtual();
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        atual = new Fornecedor(con);
        setAtual();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUltActionPerformed
        try {
            if (atualIds.last())
                atual = new Fornecedor(atualIds.getInt(1), this.con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }//GEN-LAST:event_btUltActionPerformed

    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProxActionPerformed
        try {
            if (atualIds.next())
                atual = new Fornecedor(atualIds.getInt(1), this.con);
            else
                atualIds.previous();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }//GEN-LAST:event_btProxActionPerformed

    private void btAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAntActionPerformed
        try {
            if (atualIds.previous())
                atual = new Fornecedor(atualIds.getInt(1), this.con);
            else
                atualIds.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }//GEN-LAST:event_btAntActionPerformed

    private void btPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrimActionPerformed
        try {
            if (atualIds.first())
                atual = new Fornecedor(atualIds.getInt(1), this.con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }//GEN-LAST:event_btPrimActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_btGravarActionPerformed
         if (novo){
            GregorianCalendar gc = new GregorianCalendar();
            lblData.setText(gc.get(gc.DAY_OF_MONTH)+"/"+gc.get(gc.MONTH)+"/"+gc.get(gc.YEAR));
            Fornecedor fornecedor = new Fornecedor(txtNome.getText(), chkAtivo.isSelected(), gc.get(gc.YEAR)+"-"+gc.get(gc.MONTH)+"-"+gc.get(gc.DAY_OF_MONTH), txtFantasia.getText(),
                    txtCNPJ.getText(), txtIEST.getText(), txtEndereco.getText(), txtBairro.getText(), 
                    txtNum.getText(), txtCidade.getText(), txtEstado.getText(), txtCep.getText(), 
                    txtFone.getText(), txtFone1.getText(), txtEmail.getText(), con);
            try{
                atuaIds();
                atualIds.last();
                txtCode.setText(atualIds.getString(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
         } else {
             
         }
         
                
         
    }//GEN-LAST:event_btGravarActionPerformed
    protected void atuaIds() throws SQLException {
        try {
            Statement stmt = con.getStatement();
            atualIds = stmt.executeQuery("select id from fornecedores");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPrim;
    private javax.swing.JButton btProx;
    private javax.swing.JButton btUlt;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblCpfcnpj;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFantasia;
    private javax.swing.JLabel lblFoneFax;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblRg;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFantasia;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtFone1;
    private javax.swing.JTextField txtIEST;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
    
}
