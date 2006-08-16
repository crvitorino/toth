
package empresa;

import app.ConSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.brazilutils.br.cpfcnpj.CpfCnpj;

/**
 *
 * @author Fernando Dettoni
 */
public class Cliente {
    public int codigo;
    public boolean ativo;
    private String nome, data, fantasia, cpf, rg, endereco, bairro, numero, municipio, estado, cep, fone1, fone2, email; 
    
    private ConSQL con;
    
    public Cliente(String nome, boolean ativo, String data, String fantasia, String cpf, String rg, String endereco, String bairro, String numero, String municipio, String estado, String cep, String fone1, String fone2, String email, ConSQL con) {
        this.nome = nome;
        this.ativo = ativo;
        this.data = data;
        this.fantasia = fantasia;
        this.cpf = cpf;
        this.rg = rg;
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
        
        String sql = "insert INTO clientes VALUES (null,'"+nome+"',"+ativo+",'"+data+"','"+fantasia+"','"+cpf+"','"+rg+"','"+
        endereco+"','"+bairro+"','"+numero+"','"+municipio+"','"+estado+"','"+cep+"','"+fone1+"','"+fone2+"','"+email+"')";
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("select id from clientes where nome='"+nome+"'");
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
    public Cliente(int id, ConSQL con) throws SQLException{
        String sql = "select * from clientes where id="+id;
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
            this.cpf = rs.getString(6);
            this.rg = rs.getString(7);
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
    public Cliente(ConSQL con) {
        this.con = con;
    }    
   
    public boolean apagaCliente() {
        String sql = "delete from clientes where id = "+codigo;
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
    public void update() throws SQLException{
        String sql = "update clientes set nome='"+nome+"',ativo ="+ativo+",fantasia='"+fantasia+"',cpf='"+cpf+"',rg='"+rg+"',endereco='"+
                        endereco+"',bairro='"+bairro+"',numero='"+numero+"',cidade='"+municipio+"',estado='"+estado+"',cep='"+cep+
                        "',telefone='"+fone1+"',telefone2='"+fone2+"',email='"+email+"' where id ="+codigo;
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
            }
        catch (SQLException e) {
	    e.printStackTrace();
	}

        
    }
    public void setNome(String Nome){
        this.nome = Nome;
    }
    public void setData(String Data){
        this.data = Data;
    }
    public void setFantasia(String Fantasia){
        this.fantasia = Fantasia;
    }
    public void setCpf(String Cpf){
        this.cpf = Cpf;
    }
    public void setRg(String Rg){
        this.rg = Rg;
    }
    public void setEndereco(String Endereco){
        this.endereco = Endereco;
    }
    public void setBairro(String Bairro){
        this.bairro = Bairro;
    }
    public void setNumero(String Numero){
        this.numero = Numero;
    }
    public void setMunicipio(String Municipio){
        this.municipio = Municipio;
    }
    public void setEstado(String Estado){
        this.estado = Estado;
    }
    public void setCep(String Cep){
        this.cep = Cep;
    }
    public void setFone1(String Fone1){
        this.fone1 = Fone1;
    }
    public void setFone2(String Fone2){
        this.fone2 = Fone2;
    }
    public void setEmail(String Email){
        this.email = Email;
    }
    public String getNome(){
        return nome;
    }
    public String getData(){
        return data;
    }
    public String getFantasia(){
        return fantasia;
    }
    public String getCpf(){
        return cpf;
    }
    public String getRg(){
        return rg;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getBairro(){
        return bairro;
    }
    public String getNumero(){
        return numero;
    }
    public String getMunicipio(){
        return municipio;
    }
    public String getEstado(){
        return estado;
    }
    public String getCep(){
        return cep;
    }
    public String getFone1(){
        return fone1;
    }
    public String getFone2(){
        return fone2;
    }
    public String getEmail(){
        return email;
    }
    
    
}
