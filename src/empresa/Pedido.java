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

    public Pedido(int idCliente, String data, ConSQL con) {
        this.idCliente = idCliente;
        this.data = data;
        this.con = con;
        itens = new Vector();
        try {
            this.cliente = new Cliente(idCliente, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void gravarDadosNovo() throws SQLException{
        String[] sql = new String[itens.size()+1]; 
        sql[0] = "insert INTO pedido VALUES (null,'"+idCliente+"','"+data+"','"+qtdade+"','"+formaPag+"','"+vlTotal+"','"+desc+"')";
        for (int i = 1; i<=itens.size(); i++) {
            Vector vi = (Vector)itens.get(i-1);
            sql[i] = "INSERT INTO itempedido VALUES("+id+", "+vi.get(0)+", "+vi.get(2)+", "+vi.get(5)+", "+vi.get(4)+")";
        }
        Statement stmt = con.getStatement();
        try {
            for (int i=0; i<itens.size(); i++)
                stmt.executeUpdate(sql[i]);
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
    public void addItem(Produto itm,int qtd, int desc) {
        Vector vec = itm.getVector(qtd,desc);
        itens.addElement(vec);
        
        
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
    
    public double CalculaValorUnitario(double valor, double desc){
        return valor*(1-desc);
    }
    
    
}
