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
public class BuscaProduto extends JInternalFrame{
    
    /** Creates a new instance of BuscaCliente */
    private ConSQL con;
    private JTable tabela;
    private JLabel lbNome, lbFab;
    private JButton btPesquisar, btSelecionar;
    private ModeloTabela tbModel;
    private JTextField txtNome, txtFab;
    private Vector colunas;
    private PedidoVenda pedido;
    public BuscaProduto(ConSQL con, PedidoVenda pedido) {
        super("Busca de Produtos", false, true, false, true);
        this.pedido = pedido;
        this.con = con;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(700, 190));
        colunas = new Vector();
        String[] cols = {"C�digo", "Descri�ao", "Fabricante", "Grupo", "Custo", "Venda"};
        for (int i=0; i<6; i++)
            colunas.addElement(cols[i]);
        
        tbModel =  new ModeloTabela(new Object [][] { }, cols);
        
        lbNome = new JLabel("Descri��o: ");
        lbFab = new JLabel("Fabricante: ");
        txtNome = new JTextField(10);
        txtFab = new JTextField(10);
        btPesquisar = new JButton("Pesquisar");
        btSelecionar =  new JButton("Selecionar");
        JScrollPane scroll = new JScrollPane();  
        tabela = new JTable();
        
        
        tabela.setModel(tbModel);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setMaximumSize(new java.awt.Dimension(650, 112));
        tabela.setMinimumSize(new java.awt.Dimension(650, 112));
        tabela.setOpaque(false);
        tabela.setPreferredSize(new java.awt.Dimension(650, 112));
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        scroll.setViewportView(tabela);
        scroll.setPreferredSize(new Dimension(650, 115));
        
        this.add(lbNome);
        this.add(txtNome);
        this.add(lbFab);
        this.add(txtFab);
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
    private void selecionaValor() {
        int indice = tabela.getSelectedRow();
        int id  = Integer.parseInt(tbModel.getValueAt(indice, 0).toString());
        pedido.recebeIdProduto(id);
        this.dispose();
        
        
        
    }
    private void getTable() {
      
        Statement statement; 
        ResultSet resultset; 
 
        try {
            String query;
            if (!txtNome.getText().equals("") && !txtFab.getText().equals("")) 
                query = "Select id,descricao,fabricante, grupo, custo, venda from produtos where upper(descricao) LIKE '"+txtNome.getText().toUpperCase()+"%' AND fabricante LIKE '"+txtFab.getText().toUpperCase()+"%' order by nome";
            else if (!txtNome.getText().equals(""))
                query = "Select id,descricao,fabricante, grupo, custo, venda from produtos where upper(descricao) LIKE '"+txtNome.getText().toUpperCase()+"%' order by nome";
            else if (!txtFab.getText().equals(""))
                query = "Select id,descricao,fabricante, grupo, custo, venda from produtos where  '"+txtFab.getText().toUpperCase()+" order by nome";
            else
                query = "Select id,descricao,fabricante, grupo, custo, venda from produtos order by descricao";
            statement = con.getStatement(); 
            resultset = statement.executeQuery(query); 
            displayResultSet(resultset); 
        } 
        catch ( SQLException sqlex ) { 
            sqlex.printStackTrace(); 
        } 
    } 
 
 private void displayResultSet(ResultSet rs ) throws SQLException { 
    boolean moreRecords = rs.next(); 
    if (! moreRecords) { 
        JOptionPane.showMessageDialog(this, "Nao existem registros na tabela!!"); 
    //setTitle(); 
    return; 
    } 
 

    Vector rows = new Vector(); 
 
    try { 
        ResultSetMetaData rsmd = rs.getMetaData(); 
        
 
        do { 
            rows.addElement(getNextRow(rs, rsmd)); 
        } while (rs.next());
        
        tbModel.setDataVector(rows, colunas);
        
    } catch (SQLException sqlex) { 
        sqlex.printStackTrace(); 
    } 
 } 
 
 private Vector getNextRow( ResultSet rs, ResultSetMetaData rsmd) throws SQLException { 
    Vector currentRow = new Vector(); 
    for (int i = 1; i <= rsmd.getColumnCount(); ++i) 
        switch(rsmd.getColumnType(i)) { 
            case Types.VARCHAR: currentRow.addElement(rs.getString(i)); 
            break; 
            case Types.INTEGER:currentRow.addElement(new Long(rs.getLong(i))); 
            break; 
            /*case Types.LONGCHAR:currentRow.addElement(rs.getString(i)); 
            break;*/ 
            default: System.out.println("Tipo dos Dados: " + rsmd.getColumnTypeName(i)); 
        } 
    return currentRow; 
 } 
 
 } 
   