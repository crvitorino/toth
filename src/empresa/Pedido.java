/*
 * Pedido.java
 *
 * Criado em 13 de Agosto de 2006, 14:08
 *
 */

package empresa;

import app.ConSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Fernando Dettoni
 */
public class Pedido {
    
    private int id, idCliente, qtdade;
    private Vector itens;
    private double vlTotal, desc;
    private String data, formaPag;
    private Cliente cliente;
    private ConSQL con;
    
    /** Creates a new instance of Pedido */
    public Pedido(int idCliente, String data, ConSQL con) {
        this.idCliente = idCliente;
        this.data = data;
        this.con = con;
        itens = new Vector();
        try {
            this.cliente = new Cliente(idCliente, con);
            gravarDadosNovo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void gravarDadosNovo() throws SQLException{
        
        String sql = "insert INTO pedido VALUES (null,'"+idCliente+"','"+data+"','"+qtdade+"','"+formaPag+"','"+vlTotal+"','"+desc+"')";
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
            }
        catch (SQLException E) {
	    E.printStackTrace();
	}
	 
        
    }
    public Pedido(int id, ConSQL con) throws SQLException{
        String sql = "select * from pedido where id="+id;
        this.con = con;
        itens = new Vector();
        
        try {
            Statement stmt = con.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            this.id = rs.getInt(1);
            this.idCliente = rs.getInt(2);
            this.data = rs.getString(3);
            this.qtdade = rs.getInt(4);
            this.formaPag = rs.getString(5);
            this.vlTotal = rs.getDouble(6);
            this.desc = rs.getDouble(7);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cliente = new Cliente(idCliente, con);
    }
    public Pedido(ConSQL con) {
        this.con = con;
        itens = new Vector();
    }
    public void addItem(Produto itm) {
        itens.addElement(itm);
    }
    public boolean apagaUsuario() {
        String sql = "delete from pedido where id = "+id;
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
        
    }
    public Vector getItens() {
        return itens;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public int getId() {
        return id;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public double getVlTotal() {
        return vlTotal;
    }
    public double getDesconto() {
        return desc;
    }
    public String getData() {
        return data;
    }
    public String getFormaPag() {
        return formaPag;
    }
    
    
}
