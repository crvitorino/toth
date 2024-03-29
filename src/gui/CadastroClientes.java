package gui;

import app.ConSQL;
import empresa.Cliente;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.brazilutils.br.cpfcnpj.CpfCnpj;
import utils.Funcoes;

/**
 *
 * @author  Karina
 */
public class CadastroClientes extends javax.swing.JPanel {
    private ConSQL con;
    private Cliente atual;
    private ResultSet atualIds;
    private boolean novo = false;
    
    /** Creates new form CadastroClientes */
    public CadastroClientes(ConSQL con){
        //Bloco de conex�o com SQL
        this.con = con;
        
        try {
            atuaIds();
            if (atualIds.first()){
                atual = new Cliente(atualIds.getInt(1), con);
            } else {
                atual = new Cliente(con);
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
        txtCode.setEditable(false);
        setAtual();
        this.setPreferredSize(new Dimension(500,350));
    }
    public void setAtual() {
        txtCode.setText(String.valueOf(atual.codigo));
        chkAtivo.setSelected(atual.ativo);
        txtNome.setText(atual.getNome());
        lblData.setText(Funcoes.trataData(atual.getData()));
        txtFantasia.setText(atual.getFantasia());
        txtCPF.setText(atual.getCpf());
        txtRg.setText(atual.getRg());
        txtEndereco.setText(atual.getEndereco());
        txtBairro.setText(atual.getBairro());
        txtNum.setText(atual.getNumero());
        txtCidade.setText(atual.getMunicipio());
        txtEstado.setText(atual.getEstado());
        txtCep.setText(atual.getCep());
        txtFone.setText(atual.getFone1());
        txtFone1.setText(atual.getFone2());
        txtEmail.setText(atual.getEmail());       
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
        txtCPF = new javax.swing.JTextField();
        lblRg = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
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
        btDeletar = new javax.swing.JButton();

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

        txtCode.setOpaque(false);

        chkAtivo.setText("Ativo");
        chkAtivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        chkAtivo.setMargin(new java.awt.Insets(0, 0, 0, 0));

        lblData.setFocusable(false);

        lblFantasia.setText("Fantasia: ");
        lblFantasia.setFocusable(false);

        lblCpfcnpj.setText("CPF/CNPJ: ");
        lblCpfcnpj.setFocusable(false);

        lblRg.setText("RG: ");
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

        btDeletar.setText("Deletar");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
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
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 410, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(lblEndereco)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 418, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblCode)
                            .add(jLabel1)
                            .add(lblBairro)
                            .add(lblCidade)
                            .add(lblCep)
                            .add(lblEmail))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 397, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtFantasia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 397, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(txtCPF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 81, Short.MAX_VALUE)
                                .add(lblRg)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtRg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtEndereco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 397, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtCidade)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 91, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createSequentialGroup()
                                        .add(lblNum)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtNum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(lblEstado)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createSequentialGroup()
                                .add(112, 112, 112)
                                .add(lblFoneFax)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                                .add(txtFone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 98, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtFone1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 397, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(btGravar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(txtCep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 297, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createSequentialGroup()
                                        .add(txtCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 58, Short.MAX_VALUE)
                                        .add(chkAtivo)
                                        .add(75, 75, 75)
                                        .add(lblDesde))
                                    .add(btDeletar))
                                .add(12, 12, 12)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(lblData, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(btNovo)))))
                    .add(layout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(btPrim)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btAnt)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btProx)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btUlt)))
                .add(90, 90, 90))
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
                    .add(btNovo)
                    .add(btDeletar))
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
                    .add(txtCPF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblRg)
                    .add(txtRg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblEndereco)
                    .add(txtEndereco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblBairro)
                            .add(txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblCidade)
                            .add(txtCidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblNum)
                            .add(txtNum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblEstado))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCep)
                    .add(txtCep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblFoneFax)
                    .add(txtFone1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Ser� apagado o cliente atual.", "Apagar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i==JOptionPane.YES_OPTION){
            if (!novo) {
                if (!atual.apagaCliente())
                        Funcoes.mensagemErro("N�o foi possivel apagar o Cliente do banco de dados. ");
            }
            try {
                atuaIds();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (atualIds.last()) {
                    atual = new Cliente(atualIds.getInt(1), this.con);
                    setAtual();
                }
                else {
                    atual = new Cliente(con);
                    setAtual();
                    novo = true; 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btDeletarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if (novo) {
            try {
            if (atualIds.last())
                atual = new Cliente(atualIds.getInt(1), this.con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            setAtual();
        } else {
            setAtual();
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        atual = new Cliente(con);
        novo = true;
        setAtual();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUltActionPerformed
        try {
            if (atualIds.last())
                atual = new Cliente(atualIds.getInt(1), this.con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }//GEN-LAST:event_btUltActionPerformed

    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProxActionPerformed
        try {
            if (atualIds.next())
                atual = new Cliente(atualIds.getInt(1), this.con);
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
                atual = new Cliente(atualIds.getInt(1), this.con);
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
                atual = new Cliente(atualIds.getInt(1), this.con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }//GEN-LAST:event_btPrimActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_btGravarActionPerformed
         if (novo){
            GregorianCalendar gc = new GregorianCalendar();
            lblData.setText(gc.get(gc.DAY_OF_MONTH)+"/"+gc.get(gc.MONTH)+"/"+gc.get(gc.YEAR));
            if (validaDados()){
                Cliente cli = new Cliente(txtNome.getText(), chkAtivo.isSelected(), gc.get(gc.YEAR)+"-"+gc.get(gc.MONTH)+"-"+gc.get(gc.DAY_OF_MONTH), txtFantasia.getText(),
                        txtCPF.getText(), txtRg.getText(), txtEndereco.getText(), txtBairro.getText(), 
                        txtNum.getText(), txtCidade.getText(), txtEstado.getText(), txtCep.getText(), 
                        txtFone.getText(), txtFone1.getText(), txtEmail.getText(), con);
            }
            try{
                atuaIds();
                atualIds.last();
                atual = new Cliente(atualIds.getInt(1), con);
                setAtual();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            novo = false;
         } else {

        if (validaDados()){
             atual.codigo = Integer.parseInt(txtCode.getText());
            atual.ativo = chkAtivo.isSelected();
            atual.setNome(txtNome.getText());
            atual.setData(lblData.getText());
            atual.setFantasia(txtFantasia.getText());
            atual.setCpf(txtCPF.getText());
            atual.setRg(txtRg.getText());
            atual.setEndereco(txtEndereco.getText());
            atual.setBairro(txtBairro.getText());
            atual.setNumero(txtNum.getText());
            atual.setMunicipio(txtCidade.getText());
            atual.setEstado(txtEstado.getText());
            atual.setCep(txtCep.getText());
            atual.setFone1(txtFone.getText());
            atual.setFone2(txtFone1.getText());
            atual.setEmail(txtEmail.getText());
            try {
                atual.update();
            } catch (SQLException e){
                e.printStackTrace();
            }
            }
                
            
         }
         
                
         
    }//GEN-LAST:event_btGravarActionPerformed
    protected boolean validaDados() {
        if (CpfCnpj.isValid(txtCPF.getText()))
            return true;
        JOptionPane.showMessageDialog(null, "Cpf/Cnpj inv�lido", "Erro em arquivo.", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    protected void atuaIds() throws SQLException {
        try {
            Statement stmt = con.getStatement();
            atualIds = stmt.executeQuery("select id from clientes");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDeletar;
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
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFantasia;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtFone1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtRg;
    // End of variables declaration//GEN-END:variables
    
}
