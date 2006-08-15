/*
 * Cliente.java
 *
 * Criado em 3 de Agosto de 2006, 22:46
 *
 */

package empresa;

import app.ConSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fernando Dettoni
 */
public class Produto {
    public int codigo;
    public boolean ativo;
    public String descricao, data, fabricante, grupo, custo, venda, estoqueatual, estoquemin ; 
    private ConSQL con;

    /**
     * Creates a new instance of Cliente
     */
    
    public Produto(String descricao, boolean ativo, String data, String fabricante, String grupo, String custo, String venda, String estoqueatual, String estoquemin, ConSQL con) {
        this.descricao = descricao;
        this.ativo = ativo;
        this.data = data;
        this.fabricante = fabricante;
        this.grupo = grupo;
        this.custo = custo;
        this.venda = venda;
        this.estoquemin = estoquemin;
        this.estoqueatual = estoqueatual;
     
        this.con = con;
        try {
            gravarDadosNovo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void gravarDadosNovo() throws SQLException{
        
        String sql = "insert INTO produtos VALUES (null,'"+descricao+"',"+ativo+",'"+data+"','"+fabricante+"','"+grupo+"','"+custo+"','"+
        venda+"','"+estoqueatual+"','"+estoquemin+"')";
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("select id from produtos where descricao='"+descricao+"'");
            rs.next();
            this.codigo = rs.getInt(1);
            }
        catch (SQLException E) {
	    E.printStackTrace();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
        
        
      }
    public Produto(int id, ConSQL con) throws SQLException{
        String sql = "select * from produtos where id="+id;
        this.con = con;
        
        try {
            Statement stmt = con.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            this.codigo = rs.getInt(1);
            this.descricao = rs.getString(2);
            this.ativo = rs.getBoolean(3);
            this.data = rs.getString(4);
            this.fabricante = rs.getString(5);
            this.grupo = rs.getString(6);
            this.custo = rs.getString(7);
            this.venda = rs.getString(8);
            this.estoqueatual = rs.getString(9);
            this.estoquemin = rs.getString(10);
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
      
    }
    public Produto(ConSQL con) {
        this.con = con;
    }    
    
    
}
