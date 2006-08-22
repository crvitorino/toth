/*
 * BuscaCliente.java
 *
 * Created on 15 de Agosto de 2006, 10:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui;

import Componentes.ModeloTabela;
import app.ConSQL;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author fernando
 */
public class BuscaCliente extends Busca{
    
    /** Creates a new instance of BuscaCliente */
   
    private JLabel lbNome, lbCPF;
    private JTextField txtNome, txtCPF;
    private PedidoVenda pedido;
    public BuscaCliente(ConSQL con, PedidoVenda pedido) {
        super("Busca de Clientes");
        this.pedido = pedido;
        super.con = con;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(700, 190));
        colunas = new Vector();
        String[] cols = {"Código", "Nome", "Fantasia", "CPF/CNPJ", "Cidade", "Estado"};
        for (int i=0; i<6; i++)
            colunas.addElement(cols[i]);
        
        tbModel =  new ModeloTabela(new Object [][] { }, cols);
        lbNome = new JLabel("Nome: ");
        lbCPF = new JLabel("CPF/CNPJ: ");
        txtNome = new JTextField(10);
        txtCPF = new JTextField(10);
        btPesquisar = new JButton("Pesquisar");
        btSelecionar =  new JButton("Selecionar");
        tabela = new JTable();
        
        JScrollPane scroll = new JScrollPane(tabela);
        
        tabela.setModel(tbModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(10);
        scroll.setPreferredSize(new Dimension(650, 115));
        
        this.add(lbNome);
        this.add(txtNome);
        this.add(lbCPF);
        this.add(txtCPF);
        this.add(btPesquisar);
        this.add(btSelecionar);
        this.add(scroll);
      
        
        btPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getTable();
            }
        });
        btSelecionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selecionaValor();
            }
        });
               
        
    }
      protected void selecionaValor() {
        int indice = tabela.getSelectedRow();
        if (indice > -1) {
            int id  = Integer.parseInt(tbModel.getValueAt(indice, 0).toString());
            pedido.recebeId(id);
            this.dispose();
        } else 
            JOptionPane.showMessageDialog(this, "Nenhum cliente foi selecionado!","Cliente não selecionado", JOptionPane.ERROR_MESSAGE);
        
    }


    private void getTable() {
      
        Statement statement; 
        ResultSet resultset; 
 
        try {
            String query;
            if (!txtNome.getText().equals("") && !txtCPF.getText().equals("")) 
                query = "Select id,nome,fantasia, cpf, cidade, estado from clientes where upper(nome) LIKE '"+txtNome.getText().toUpperCase()+"%' AND cpf = '"+txtCPF.getText()+"' order by nome";
            else if (!txtNome.getText().equals(""))
                query = "Select id,nome,fantasia, cpf, cidade, estado from clientes where upper(nome) LIKE '"+txtNome.getText().toUpperCase()+"%' order by nome";
            else if (!txtCPF.getText().equals(""))
                query = "Select id,nome,fantasia, cpf, cidade, estado from clientes where cpf = '"+txtCPF.getText()+" order by nome";
            else
                query = "Select id,nome,fantasia, cpf, cidade, estado from clientes order by nome";
            statement = con.getStatement(); 
            resultset = statement.executeQuery(query); 
            displayResultSet(resultset); 
        } 
        catch ( SQLException sqlex ) { 
            sqlex.printStackTrace(); 
        } 
    } 
}

   
