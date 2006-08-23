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
public class PedidoSaida {
    
    private int id, idCliente, qtdade; 
    private Vector itens;
    private double vlTotal, desc;
    private String data, formaPag;
    private Cliente cliente;
    private ConSQL con;

    public PedidoSaida(int idCliente, String data, ConSQL con) {
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
        Statement stmt = con.getStatement();
        try {
            ResultSet rs = stmt.executeQuery("select id from pedido");
            rs.last();
            this.id = rs.getInt(1)+1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 1; i<=itens.size(); i++) {
            Vector vi = (Vector)itens.get(i-1);
            sql[i] = "INSERT INTO itempedido VALUES("+id+", "+vi.get(0)+", "+vi.get(2)+", "+vi.get(5)+", "+vi.get(4)+")";
            Produto pro = new Produto(Integer.parseInt(vi.get(0).toString()), con);
            pro.atuaQtdade(Math.abs(Double.parseDouble(vi.get(2).toString()))*(-1));
        }
        
        try {
            for (int i=0; i<itens.size()+1; i++){
                stmt.executeUpdate(sql[i]);
                ResultSet rs = stmt.executeQuery("select * from itempedido where idpedido = "+2);
            }
        }
        catch (SQLException E) {
	    E.printStackTrace();
	}
        
	 
        
    }
    public PedidoSaida(int id, ConSQL con) throws SQLException{
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
            rs = stmt.executeQuery("select * from itempedido where idpedido ="+id);
            while(rs.next()){
                Produto pro = new Produto(rs.getInt(2), con);
                itens.addElement(pro.getVector(rs.getDouble(3), rs.getDouble(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cliente = new Cliente(idCliente, con);
    }
    public PedidoSaida(ConSQL con) {
        this.con = con;
        itens = new Vector();
    }
    public void apagaItem(int id) {
        Vector vec = (Vector)itens.get(id);
        vlTotal-=Double.parseDouble(vec.get(6).toString());
        itens.remove(id);
        
    }
    public void addItem(Produto itm,double qtd, double desc) {
        Vector vec = itm.getVector(qtd,desc);
        itens.addElement(vec);
        vlTotal+=Double.parseDouble(vec.get(6).toString());
        
        
    }
    public Vector getItens() {
        return itens;
    }
    public boolean apagaPedido() {
        String[] sql = new String[2]; 
        sql[0]="delete from pedido where id = "+id;
        sql[1]="delete from itempedido where idpedido="+id;
        
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql[0]);
            stmt.executeUpdate(sql[1]);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
        
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
