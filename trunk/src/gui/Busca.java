/*
 * Busca.java
 *
 * Created on 16 de Agosto de 2006, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui;

import Componentes.ModeloTabela;
import app.ConSQL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author fernando
 */
public class Busca extends JInternalFrame{
    protected JTable tabela;
    protected ModeloTabela tbModel;
    protected Vector colunas;
    protected JButton btPesquisar, btSelecionar;
    protected ConSQL con;
    protected PedidoVenda pedido;
    
    /** Creates a new instance of Busca */
    public Busca(String title) {
        super(title, false, true, false, true);
    }
    protected void displayResultSet(ResultSet rs ) throws SQLException { 
        boolean moreRecords = rs.next();
        if (! moreRecords) {
            JOptionPane.showMessageDialog(this, "Nao existem registros na tabela!!"); 
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
 
 protected Vector getNextRow( ResultSet rs, ResultSetMetaData rsmd) throws SQLException { 
    Vector currentRow = new Vector(); 
    for (int i = 1; i <= rsmd.getColumnCount(); ++i) 
        switch(rsmd.getColumnType(i)) { 
            case Types.VARCHAR: currentRow.addElement(rs.getString(i)); 
            break; 
            case Types.INTEGER:currentRow.addElement(new Integer(rs.getInt(i))); 
            break; 
            case Types.DOUBLE:currentRow.addElement(new Double(rs.getDouble(i))); 
            break;
            /*case Types.LONGCHAR:currentRow.addElement(rs.getString(i)); 
            break;*/ 
            default: System.out.println("Tipo dos Dados: " + rsmd.getColumnTypeName(i)); 
        } 
    return currentRow; 
 } 

    
}
