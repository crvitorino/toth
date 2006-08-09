/*
 * CadastroUsuarios.java
 *
 * Criado em 5 de Agosto de 2006, 22:36
 *
 */

package gui;

import app.ConSQL;
import empresa.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import utils.Funcoes;

/**
 *
 * @author Fernando Dettoni
 */
public class CadastroUsuarios extends JPanel{
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPrim;
    private javax.swing.JButton btProx;
    private javax.swing.JButton btSenha;
    private javax.swing.JButton btUlt;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbUser;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JButton btDeletar;
    
    private ResultSet atualIds;
    private ConSQL con;
    private Usuario atual;
    private boolean novo = false;
    
    public CadastroUsuarios(ConSQL con) {
        
        this.con = con;
        try {
            atuaIds();
            if (atualIds.first())
                atual = new Usuario(atualIds.getInt(1), con);
            else {
                atual = new Usuario(con);
                novo = true; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
                
        initComponents();
        
          if (CadastroUsuarios.class.getResource("/images/btOk.gif") != null) {
            this.btGravar.setIcon(new ImageIcon(CadastroUsuarios.class.getResource("/images/btOk.gif")));
        } else {
            this.btGravar.setText("Gravar"); 
        }
        if (CadastroUsuarios.class.getResource("/images/btCancelar.gif") != null) {
            this.btCancelar.setIcon(new ImageIcon(CadastroUsuarios.class.getResource("/images/btCancelar.gif")));
        } else {
            this.btCancelar.setText("Cancelar");
        }
        if (CadastroUsuarios.class.getResource("/images/btPrim.gif") != null) {
            this.btPrim.setIcon(new ImageIcon(CadastroUsuarios.class.getResource("/images/btPrim.gif")));
        } else {
            this.btPrim.setText("<|"); 
        }
        if (CadastroUsuarios.class.getResource("/images/btUlt.gif") != null) {
            this.btUlt.setIcon(new ImageIcon(CadastroUsuarios.class.getResource("/images/btUlt.gif")));
        } else {
            this.btUlt.setText("|>"); 
        }
        if (CadastroUsuarios.class.getResource("/images/btFlechaDir.gif") != null) {
            this.btProx.setIcon(new ImageIcon(CadastroUsuarios.class.getResource("/images/btFlechaDir.gif")));
        } else {
            this.btProx.setText(">"); 
        }
        if (CadastroUsuarios.class.getResource("/images/btFlechaEsq.gif") != null) {
            this.btAnt.setIcon(new ImageIcon(CadastroUsuarios.class.getResource("/images/btFlechaEsq.gif")));
        } else {
            this.btAnt.setText("<"); 
        }
        setAtual();
        if (novo)
            btSenha.setEnabled(false);
 

        
    }
    protected void atuaIds() throws SQLException {
        try {
            Statement stmt = con.getStatement();
            atualIds = stmt.executeQuery("select id from usuarios");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    private void initComponents() {
        btPrim = new javax.swing.JButton();
        btAnt = new javax.swing.JButton();
        btProx = new javax.swing.JButton();
        btUlt = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        lbNome = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        btSenha = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        
        btSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSenhaActionPerformed(evt);
            }
        });
        
        btPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrimActionPerformed(evt);
            }
        });

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

        btNovo.setText("Novo");

        lbNome.setText("Nome: ");

        lbUser.setText("Login: ");

        lbCargo.setText("Cargo: ");

        btSenha.setText("Trocar Senha");
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(btPrim)
                            .add(lbNome))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(btAnt)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btProx)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btUlt)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btDeletar)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 114, Short.MAX_VALUE)
                                .add(btNovo))
                            .add(txtNome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(lbUser)
                                .add(14, 14, 14)
                                .add(txtLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(btSenha))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(btGravar)
                                .add(74, 74, 74)
                                .add(btCancelar))
                            .add(layout.createSequentialGroup()
                                .add(lbCargo)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtCargo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(btPrim)
                        .add(btAnt)
                        .add(btProx)
                        .add(btUlt))
                    .add(btDeletar)
                    .add(btNovo))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lbNome)
                    .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbUser)
                    .add(txtLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lbCargo)
                    .add(txtCargo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btSenha)
                    .add(btGravar)
                    .add(btCancelar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (!novo) {
            if (!atual.apagaUsuario())
                    Funcoes.mensagemErro("Não foi possivel apagar o usuario do banco de dados. ");
        }
        try {
            atuaIds();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (atualIds.last())
                atual = new Usuario(atualIds.getInt(1), this.con);
            else {
                atual = new Usuario(con);
                setAtual();
                btSenha.setEnabled(false);
                novo = true; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        if (novo) {
            try {
            if (atualIds.last())
                atual = new Usuario(atualIds.getInt(1), this.con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            setAtual();
        } else {
            setAtual();
        }
            
    }

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {
        if (novo) {
            GregorianCalendar gc = new GregorianCalendar();
         
            Usuario usr = new Usuario(gc.get(gc.YEAR)+"-"+gc.get(gc.MONTH)+"-"+gc.get(gc.DAY_OF_MONTH), txtNome.getText(), txtLogin.getText(),
                  txtCargo.getText(), "", con);
            try{
                atuaIds();
                atualIds.last();
                atual = new Usuario(atualIds.getInt(1), con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            btSenha.setEnabled(true);
            pergSenha();
            novo = false;
        } else {
            atual.setNome(txtNome.getText());
            atual.setUsuario(txtLogin.getText());
            atual.setCargo(txtCargo.getText());
            try {
                atual.update();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
    }

    private void btSenhaActionPerformed(java.awt.event.ActionEvent evt) {
        pergSenha();
    }
    
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {                                       
        atual = new Usuario(con);
        setAtual();
        btSenha.setEnabled(false);
        novo = true;
        
    }                                      

    private void btUltActionPerformed(java.awt.event.ActionEvent evt) {                                      
        try {
            if (atualIds.last())
                atual = new Usuario(atualIds.getInt(1), this.con);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
        
    }                                     

    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
            if (atualIds.next())
                atual = new Usuario(atualIds.getInt(1), this.con);
            else
                atualIds.previous();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }                                      

    private void btAntActionPerformed(java.awt.event.ActionEvent evt) {                                      
        try {
            if (atualIds.previous())
                atual = new Usuario(atualIds.getInt(1), this.con);
            else
                atualIds.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }                                     

    private void btPrimActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
            if (atualIds.first())
                atual = new Usuario(atualIds.getInt(1), this.con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setAtual();
    }
    public void setAtual() {
        txtNome.setText(atual.getNome());
        txtLogin.setText(atual.getUsuario());
        txtCargo.setText(atual.getCargo());
        
    }
    public void pergSenha() {
        JPasswordField pass = new JPasswordField(); 
        String senha1 = null;
        String senha2 = null;
        int action = JOptionPane.showConfirmDialog(this, pass,"Digite a nova senha",JOptionPane.OK_CANCEL_OPTION);
        if(action == JOptionPane.CANCEL_OPTION || action == JOptionPane.CLOSED_OPTION)
            JOptionPane.showMessageDialog(this,"Cancelar, X ou tecla Esc pressionada");
        else {
            senha1 = new String(pass.getPassword());
            JPasswordField pass2 = new JPasswordField(); 
            int action2 = JOptionPane.showConfirmDialog(this, pass2,"Digite novamente senha",JOptionPane.OK_CANCEL_OPTION);
            if(action == JOptionPane.CANCEL_OPTION || action == JOptionPane.CLOSED_OPTION)
                JOptionPane.showMessageDialog(this,"Cancelar, X ou tecla Esc pressionada");
            else
                senha2 = new String(pass2.getPassword());
        }
        if (senha1 != null && senha2 != null)
            if (senha1.equals(senha2)) {
                atual.setSenha(senha1);
                try {
                    atual.update();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        } else
            JOptionPane.showMessageDialog(this,"As duas senhas digitadas não conferem.");
        
    }
    
    
}
