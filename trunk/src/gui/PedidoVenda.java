

package gui;

import app.ConSQL;
import empresa.Pedido;
import empresa.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import utils.Funcoes;
import utils.KeyNumerico;

public class PedidoVenda extends javax.swing.JInternalFrame {
    
    
    private ResultSet atualIds;
    private ConSQL con;
    private Pedido atual;
    private boolean novo = false;
    private Principal principal;
    private Vector colunas;
    
    public PedidoVenda(ConSQL con, Principal frame) {
        super("Pedido de Venda", false, true, false, true);
        principal = frame;
       
        this.con = con;
        colunas = new Vector();
        String[] cols = {"C�digo", "Produto", "Quantidade", "Val. Bruto", "Desc.", "Val. Unit", "Val. Total"};
        for (int i=0; i<7; i++)
            colunas.addElement(cols[i]);
        tbModel =  new DefaultTableModel(new Object [][] { }, cols);
        try {
            atuaIds();
            if (atualIds.first())
                atual = new Pedido(atualIds.getInt(1), con);
            else {
                atual = new Pedido(con);
                novo = true; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        this.con = con;
        initComponents();
        //setAtual();
        txtNome.setEditable(false);
        txtCpf.setEditable(false);
        txtData.setEditable(false);
        txtEndereco.setEditable(false);
        txtEstado.setEditable(false);
        txtFone.setEditable(false);
        txtFone2.setEditable(false);
        txtPedido.setEditable(false);
        txtVlTotal.setEditable(false);
        txtNumero.setEditable(false);
        txtMunicipio.setEditable(false);
        txtCodCliente.addKeyListener(new KeyNumerico(true));
        txtCodCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recebeId(Integer.parseInt(txtCodCliente.getText()));
            }
        });
        
        

    }
    protected void setClienteAtual() {
        txtPedido.setText(String.valueOf(atual.getId()));
        txtData.setText(Funcoes.trataData(atual.getData()));
        txtCodCliente.setText(String.valueOf(atual.getIdCliente()));

        txtNome.setText(atual.getCliente().getNome());
        txtCpf.setText(atual.getCliente().getCpf());
        txtEndereco.setText(atual.getCliente().getEndereco());
        txtNumero.setText(atual.getCliente().getNumero());
        txtMunicipio.setText(atual.getCliente().getMunicipio());
        txtEstado.setText(atual.getCliente().getEstado());
        txtFone.setText(atual.getCliente().getFone1());
        txtFone2.setText(atual.getCliente().getFone2());

        txtNome.setText(atual.getCliente().getNome());
        txtCpf.setText(atual.getCliente().getCpf());  
        txtEndereco.setText(atual.getCliente().getEndereco());
        txtNumero.setText(atual.getCliente().getNumero());
        txtMunicipio.setText(atual.getCliente().getMunicipio());
        txtEstado.setText(atual.getCliente().getEstado());
        txtFone.setText(atual.getCliente().getFone1());
        txtFone2.setText(atual.getCliente().getFone2());

        
        
    }
    protected void atuaIds() throws SQLException {
        try {
            Statement stmt = con.getStatement();
            atualIds = stmt.executeQuery("select id from pedido");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        btBusca = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtFone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFone2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        btPrim = new javax.swing.JButton();
        btAnt = new javax.swing.JButton();
        btProx = new javax.swing.JButton();
        btUlt = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btDelIt = new javax.swing.JButton();
        btEfetivar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbForma = new javax.swing.JLabel();
        txtForma = new javax.swing.JTextField();
        lbDesc = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        txtVlTotal = new javax.swing.JTextField();

        setIconifiable(true);
        setTitle("Pedido de Vendas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btVenda.gif")));
        jLabel1.setText("Pedido: ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel2.setText("Emiss\u00e3o: ");

        txtPedido.setOpaque(false);
        txtPedido.setPreferredSize(new java.awt.Dimension(69, 19));

        txtData.setOpaque(false);
        txtData.setPreferredSize(new java.awt.Dimension(60, 19));

        jLabel3.setText("C\u00f3d. Cliente:");

        jLabel4.setText("Nome / Raz\u00e3o Social: ");

        jLabel5.setText("Cpf/CNPJ: ");

        txtCodCliente.setPreferredSize(new java.awt.Dimension(69, 19));

        txtNome.setOpaque(false);

        txtCpf.setOpaque(false);
        txtCpf.setPreferredSize(new java.awt.Dimension(150, 19));

        btBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.gif")));
        btBusca.setPreferredSize(new java.awt.Dimension(34, 30));
        btBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaActionPerformed(evt);
            }
        });

        jLabel6.setText("Endere\u00e7o: ");

        jLabel7.setText("Numero: ");

        txtEndereco.setOpaque(false);

        txtNumero.setOpaque(false);

        jLabel8.setText("Municipio: ");

        jLabel9.setText("Estado: ");

        jLabel10.setText("Telefone: ");

        txtMunicipio.setOpaque(false);

        txtEstado.setOpaque(false);

        txtFone.setOpaque(false);

        jLabel11.setText("Telefone 2: ");

        txtFone2.setOpaque(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(552, 130));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(552, 130));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setRequestFocusEnabled(false);
        tbItens.setModel(tbModel);
        tbItens.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbItens.setMaximumSize(new java.awt.Dimension(650, 112));
        tbItens.setMinimumSize(new java.awt.Dimension(650, 112));
        tbItens.setOpaque(false);
        tbItens.setPreferredSize(new java.awt.Dimension(650, 112));
        jScrollPane1.setViewportView(tbItens);

        btPrim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btPrim.gif")));
        btPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrimActionPerformed(evt);
            }
        });

        btAnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btFlechaEsq.gif")));
        btAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAntActionPerformed(evt);
            }
        });

        btProx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btFlechaDir.gif")));
        btProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProxActionPerformed(evt);
            }
        });

        btUlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btUlt.gif")));
        btUlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUltActionPerformed(evt);
            }
        });

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btExcluir.gif")));
        btDeletar.setText("Apagar");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btNovo.gif")));
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAdd.setText("Ad. Item");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDelIt.setText("Apag. Item");
        btDelIt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelItActionPerformed(evt);
            }
        });

        btEfetivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btOk.gif")));
        btEfetivar.setText("Efetivar");

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btCancelar.gif")));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        lbForma.setText("Forma de Pagamento");

        lbDesc.setText("Desconto");

        jLabel12.setText("Valor Total");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(btAdd)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btDelIt))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(lbForma)
                                    .add(txtForma, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                        .add(29, 29, 29)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtDesc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lbDesc)
                            .add(btEfetivar))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel12)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(btCancelar)
                                .add(txtVlTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 144, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 483, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(btPrim)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btAnt)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btProx)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btUlt)
                                .add(24, 24, 24))
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtPedido, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 66, Short.MAX_VALUE)
                                .add(jLabel2)
                                .add(12, 12, 12)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(btDeletar)
                                .add(24, 24, 24)
                                .add(btNovo))
                            .add(txtData, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(txtCodCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btBusca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel5)
                            .add(txtCpf, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtEndereco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 316, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel8)
                                    .add(txtMunicipio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(txtEstado)
                                    .add(jLabel9))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(txtFone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel10))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel11)
                            .add(layout.createSequentialGroup()
                                .add(jLabel7)
                                .add(96, 96, 96))
                            .add(txtNumero, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .add(txtFone2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btPrim)
                    .add(btAnt)
                    .add(btProx)
                    .add(btUlt)
                    .add(btDeletar)
                    .add(btNovo))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtPedido, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(txtData, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel5))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCodCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btBusca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jLabel7))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtEndereco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtNumero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel8)
                            .add(jLabel9))
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtMunicipio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel10)
                            .add(jLabel11))
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtFone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtFone2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbForma)
                    .add(lbDesc)
                    .add(jLabel12))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtForma, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtDesc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtVlTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 39, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btAdd)
                    .add(btDelIt)
                    .add(btEfetivar)
                    .add(btCancelar))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btDelItActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelItActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btDelItActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        BuscaProduto busca = new BuscaProduto(con, this);
        principal.addFrame(busca);
        busca.pack();
        busca.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void btBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaActionPerformed
        BuscaCliente busca = new BuscaCliente(con, this);
        principal.addFrame(busca);
        busca.pack();
        busca.setVisible(true);
    }//GEN-LAST:event_btBuscaActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btDeletarActionPerformed

    private void btUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUltActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btUltActionPerformed

    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProxActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btProxActionPerformed

    private void btAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAntActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btAntActionPerformed

    private void btPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrimActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btPrimActionPerformed
    
    public void recebeId(int cod) {
        GregorianCalendar gc = new GregorianCalendar();
        atual = new Pedido(cod, gc.get(gc.YEAR)+"-"+gc.get(gc.MONTH)+"-"+gc.get(gc.DAY_OF_MONTH), con);
        setClienteAtual();
        
    }
    public void recebeIdProduto(int cod) {
        Produto atualProd =  null;
        try {
            atualProd = new Produto(cod, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        atual.addItem(atualProd);
        tbModel.setDataVector(atual.getItens(), colunas);
        
        
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btBusca;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDelIt;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btEfetivar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPrim;
    private javax.swing.JButton btProx;
    private javax.swing.JButton btUlt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDesc;
    private javax.swing.JLabel lbForma;
    private javax.swing.JTable tbItens;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtFone2;
    private javax.swing.JTextField txtForma;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPedido;
    private javax.swing.JTextField txtVlTotal;
    // End of variables declaration//GEN-END:variables
    private javax.swing.table.DefaultTableModel tbModel;
}
