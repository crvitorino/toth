package empresa;

import app.ConSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Produto {
    public int codigo;
    public boolean ativo;
    private String descricao, data, fabricante, grupo ; 
    private double custo, venda, estoqueatual, estoquemin ;
    private ConSQL con;
 
    public Produto(String descricao, boolean ativo, String data, String fabricante, String grupo, double custo, double venda, double estoqueatual, double estoquemin, ConSQL con) {
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
    public String[] getDadosPedido() {

     return null;   



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
            this.custo = Double.valueOf(rs.getString(7));
            this.venda = Double.valueOf(rs.getString(8));
            this.estoqueatual = Float.valueOf(rs.getString(9));
            this.estoquemin = Float.valueOf(rs.getString(10));
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
      
    }
    public Produto(ConSQL con) {
        this.con = con;
    }    
    
    
     public boolean apagaProduto() {
        String sql = "delete from produtos where id = "+codigo;
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
        String sql = "update produtos set descricao='"+descricao+"',ativo ="+ativo+",fabricante='"+fabricante+"',grupo='"+grupo+"',custo='"+custo+"',venda='"+
                        venda+"',estoqueatual='"+estoqueatual+"',estoquemin='"+estoquemin;
        Statement stmt = con.getStatement();
        try {
            stmt.executeUpdate(sql);
            }
        catch (SQLException e) {
	    e.printStackTrace();
	}
 
    }
   public void setDescricao(String Descricao){
        this.descricao = Descricao;
    }
    
   public void setData(String Data){
        this.data = Data;
    }
   
   public void setFabricante(String Fabricante){
        this.fabricante = Fabricante;
    }
   
   public void setGrupo(String Grupo){
        this.grupo = Grupo;
    }
   
   public void setCusto(String Custo){
       this.custo = Float.valueOf(Custo);
    }
   
   public void setVenda(String Venda){
        this.venda = Float.valueOf(Venda);
    }
   
   public void setEstoqueAtual(String Atual){
       this.estoqueatual = Float.valueOf(Atual);
    }
   
   public void setEstoqueMin(String Min){
      this.estoquemin = Float.valueOf(Min);
    }
   
   public String getDescricao(){
        return descricao;
    }
   
   public String getData(){
        return data;
    }
   
   public String getFabricante(){
        return fabricante;
    }
   
   public String getGrupo(){
        return grupo;
    }
   
   public double getCusto(){
       return custo;
    }
   
   public double getVenda(){
        return venda;
    }
   
   public double getEstoqueAtual(){
        return estoqueatual;
    }
   
   public double getEstoqueMin(){
        return estoquemin;
    }

    
}
