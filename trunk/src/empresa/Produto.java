package empresa;

import app.ConSQL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;


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
    public Vector getVector(int qtd,int desc) {
        String sql = "select * from produtos where id="+codigo;
        Vector currentRow =  null;
        try{
            Statement stmt = con.getStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
        
            ResultSetMetaData rsmd = rs.getMetaData();
            currentRow = new Vector(); 
            for (int i = 1; i <= 7; ++i) {
                if (i == 3) {
                    currentRow.addElement(qtd);
                    continue;
                }    
                if (i ==5) {
                    currentRow.addElement(desc);
                    continue;
                }  
                if (i == 4) {
                    currentRow.addElement(new Double(rs.getDouble(8)));
                    continue;
                }
                if (i == 6) {
                    currentRow.addElement(Double.parseDouble(currentRow.get(3).toString())*(100-desc)/100);
                    continue;
                }
                if (i == 7) {
                    currentRow.addElement(Double.parseDouble(currentRow.get(5).toString())*qtd);
                    continue;
                }
                switch(rsmd.getColumnType(i)) { 
                    case Types.VARCHAR: currentRow.addElement(rs.getString(i)); 
                    break; 
                    case Types.INTEGER:currentRow.addElement(new Integer(rs.getInt(i))); 
                    break; 
                    case Types.DOUBLE:currentRow.addElement(new Double(rs.getDouble(i))); 
                    break;
                    case Types.BOOLEAN:currentRow.addElement(new Boolean(rs.getBoolean(i))); 
                    break;
                    case Types.DATE:currentRow.addElement(new String(rs.getString(i))); 
                    break;
                    default: System.out.println("Tipo dos Dados: " + rsmd.getColumnTypeName(i)); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentRow;
            
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
            this.custo = rs.getDouble(7);
            this.venda = rs.getDouble(8);
            this.estoqueatual = rs.getDouble(9);
            this.estoquemin = rs.getDouble(10);
            
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
