/*
 * Usuario.java
 *
 * Criado em 5 de Agosto de 2006, 23:09
 *
 */

package empresa;

import app.ConSQL;
import java.math.BigInteger;
import java.security.MessageDigest;
import utils.CriptoUtils; 
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fernando Dettoni
 */
public class Usuario {
    private int id;
    private String nome, usuario, cargo, senha, data;  
    ConSQL con;
    
    /** Creates a new instance of Usuario */
    public Usuario(String data, String nome, String usuario, String cargo, String senha, ConSQL con) {
        this.nome = nome;
        this.data = data;
        this.usuario = usuario;
        this.cargo = cargo;
        this.senha = senha;
        byte[] b = new byte[32];
        try {
           b = CriptoUtils.digest(senha.getBytes(), "md5");  
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();            
        }
        this.senha = CriptoUtils.byteArrayToHexString(b);
                
        this.con = con;
        try {
            gravarDadosNovo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void gravarDadosNovo() throws SQLException{
        
        String sql = "insert INTO usuarios VALUES (null,'"+data+"','"+nome+"','"+usuario+"','"+cargo+"','"+senha+"')";
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
            }
        catch (SQLException E) {
	    E.printStackTrace();
	}
	 
        
      }
    public Usuario(int id, ConSQL con) throws SQLException{
        String sql = "select * from Usuarios where id="+id;
        this.con = con;
        
        try {
            Statement stmt = con.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            this.id = rs.getInt(1);
            this.data = rs.getString(2);
            this.nome = rs.getString(3);
            this.usuario = rs.getString(4);
            this.cargo = rs.getString(5);
            this.senha = rs.getString(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Usuario(ConSQL con) {
        this.con = con;
    }   
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getData() {
        return data;
    }
    public String getSenha() {
        return senha;
    }
    public String getCargo() {
        return cargo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setSenha(String Senha) {
        /*byte[] b = new byte[32];
        try {
           b = CriptoUtils.digest(senha.getBytes(), "md5");  
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();            
        }
        String teste = new String(b);
        this.senha = CriptoUtils.byteArrayToHexString(b);    */
         String hashword = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(senha.getBytes());
            BigInteger hash = new BigInteger(1, md5.digest());
            hashword = hash.toString(16);
        } catch (NoSuchAlgorithmException nsae) {
            // ignore
        }
            this.senha = hashword;

    }
    public void update() throws SQLException{
        String sql = "update usuarios set nome='"+nome+"',usuario ='"+usuario+"',cargo='"+cargo+"',senha='"+senha+"' where id ="+id;
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
            }
        catch (SQLException e) {
	    e.printStackTrace();
	}
        
    }
    

    
}
