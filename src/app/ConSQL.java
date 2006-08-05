/*
 * ConSQL.java
 *
 * Criado em 2 de Agosto de 2006, 22:17
 *
 */

package app;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Dettoni
 */
public class ConSQL{
    final String url = "jdbc:hsqldb:/home/fernando/java/toth/db/toth";
    final String driver = "org.hsqldb.jdbcDriver";
    final String user = "sa";
    final String password = "";
    private Connection con;
    private Statement stmt;
    /**
     * Creates a new instance of ConSQL
     */
    public ConSQL() throws ClassNotFoundException, SQLException{
      try {
      Class.forName(driver);
      } catch (ClassNotFoundException e) {
          JOptionPane.showMessageDialog(null, "ClassNotFound", "ClassNotFound", JOptionPane.ERROR_MESSAGE);
      }
      try {
      con = DriverManager.getConnection(url,user,password);
      stmt = con.createStatement();
      } catch (Exception e) {
          e.printStackTrace();
      }
        
    }
    public Statement getStatement(){
        return stmt;
    }
    protected void finalize() throws SQLException{
        try {
            stmt.close(); 
            con.close();
         } catch (Exception e) {
          e.printStackTrace();
      }
        
        
    }
    public int getLastIdCliente() throws SQLException{
        try {
            String sql = "select id from clientes"; 
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {}
            rs.previous();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

    

