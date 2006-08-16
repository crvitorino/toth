package empresa;

import app.ConSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Produto {
    public int codigo;
    public boolean ativo;
    private String descricao, data, fabricante, grupo ; 
    private float custo, venda, estoqueatual, estoquemin ;
    private ConSQL con;
 
    public Produto(String descricao, boolean ativo, String data, String fabricante, String grupo, float custo, float venda, float estoqueatual, float estoquemin, ConSQL con) {
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
            this.custo = Float.valueOf(rs.getString(7));
            this.venda = Float.valueOf(rs.getString(8));
            this.estoqueatual = Float.valueOf(rs.getString(9));
            this.estoquemin = Float.valueOf(rs.getString(10));
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
      
    }
    public Produto(ConSQL con) {
        this.con = con;
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
   
   public float getCusto(){
       return custo;
    }
   
   public float getVenda(){
        return venda;
    }
   
   public float getEstoqueAtual(){
        return estoqueatual;
    }
   
   public float getEstoqueMin(){
        return estoquemin;
    }

    
}
