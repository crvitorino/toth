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
public class Fornecedor {
    public int codigo;
    public boolean ativo;
    public String nome, data, fantasia, cnpj, inscest, endereco, bairro, numero, municipio, estado, cep, fone1, fone2, email; 
    private ConSQL con;

    /**
     * Creates a new instance of Cliente
     */
    
    public Fornecedor(String nome, boolean ativo, String data, String fantasia, String cnpj, String inscest, String endereco, String bairro, String numero, String municipio, String estado, String cep, String fone1, String fone2, String email, ConSQL con) {
        this.nome = nome;
        this.ativo = ativo;
        this.data = data;
        this.fantasia = fantasia;
        this.cnpj = cnpj;
        this.inscest = inscest;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numero = numero;
        this.municipio = municipio;
        this.estado = estado;
        this.cep = cep;
        this.fone1 = fone1;
        this.fone2 = fone2;
        this.email = email;
        this.con = con;
        try {
            gravarDadosNovo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void gravarDadosNovo() throws SQLException{
        
        String sql = "insert INTO fornecedores VALUES (null,'"+nome+"',"+ativo+",'"+data+"','"+fantasia+"','"+cnpj+"','"+inscest+"','"+
        endereco+"','"+bairro+"','"+numero+"','"+municipio+"','"+estado+"','"+cep+"','"+fone1+"','"+fone2+"','"+email+"')";
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("select id from fornecedores where nome='"+nome+"'");
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
    public Fornecedor(int id, ConSQL con) throws SQLException{
        String sql = "select * from fornecedores where id="+id;
        this.con = con;
        
        try {
            Statement stmt = con.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            this.codigo = rs.getInt(1);
            this.nome = rs.getString(2);
            this.ativo = rs.getBoolean(3);
            this.data = rs.getString(4);
            this.fantasia = rs.getString(5);
            this.cnpj = rs.getString(6);
            this.inscest = rs.getString(7);
            this.endereco = rs.getString(8);
            this.bairro = rs.getString(9);
            this.numero = rs.getString(10);
            this.municipio = rs.getString(11);
            this.estado = rs.getString(12);
            this.cep = rs.getString(13);
            this.fone1 = rs.getString(14);
            this.fone2 = rs.getString(15);
            this.email = rs.getString(16);
        } catch (SQLException e){
            e.printStackTrace();
            
        }
      
    }
    public Fornecedor(ConSQL con) {
        this.con = con;
    }    
    
    
}
