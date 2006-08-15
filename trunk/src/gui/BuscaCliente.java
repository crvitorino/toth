/*
 * BuscaCliente.java
 *
 * Created on 15 de Agosto de 2006, 10:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui;

import app.ConSQL;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fernando
 */
public class BuscaCliente extends JInternalFrame{
    
    /** Creates a new instance of BuscaCliente */
    private ConSQL con;
    private JTable tabela;
    private JLabel lbNome, lbCPF, lbFantasia;
    private JButton pesquisar;
    private DefaultTableModel tbModel;
    private JTextField txtNome, txtCPF, txtFantasia;
    public BuscaCliente(JInternalFrame frame) {
        super("Busca de Clientes", false, true, false, true);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(700, 600));
        tbModel =  new DefaultTableModel(new Object [][] { },
            new String [] {"Código", "Nome", "Fantasia", "CPF/CNPJ", "Cidade", "Estado"}
        );
        lbNome = new JLabel("Nome: ");
        txtNome = new JTextField();
        pesquisar = new JButton("Pesquisar: ");
        JScrollPane scroll = new JScrollPane();
        tabela = new JTable();
        tabela.setModel(tbModel);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setMaximumSize(new java.awt.Dimension(650, 112));
        tabela.setMinimumSize(new java.awt.Dimension(650, 112));
        tabela.setOpaque(false);
        tabela.setPreferredSize(new java.awt.Dimension(650, 112));
        scroll.setViewportView(tabela);
        this.add(lbNome);
        this.add(txtNome);
        this.add(pesquisar);
        this.add(scroll);
        
        
        
        
        
    }
    private void getTable() {
      
        Statement statement; 
        ResultSet resultset; 
 
        try { 
            String query = "Select codigo,nome,fantasia, cpf, cidade, estado from clientes where nome LIKE '"+txtNome.getText()+"' order by nome "; 
            statement = con.getStatement(); 
            resultset = statement.executeQuery(query); 
            displayResultSet(resultset); 
            statement.close(); 
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
 
    Vector columnHeads = new Vector(); 
    Vector rows = new Vector(); 
 
    try { 
        ResultSetMetaData rsmd = rs.getMetaData(); 
        
        for (int i = 1; i <= rsmd.getColumnCount(); ++i) 
            columnHeads.addElement(rsmd.getColumnName(i)); 
 
        do { 
            rows.addElement(getNextRow(rs, rsmd)); 
        } while (rs.next()); 
 
        tabela = new JTable(rows, columnHeads); 
        JScrollPane scroller = new JScrollPane(tabela); 
        add(scroller,BorderLayout.CENTER); 
        scroller.setPreferredSize(new java.awt.Dimension(447, 353));
        validate(); 
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
   
