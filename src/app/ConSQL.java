/*
 * ConSQL.java
 *
 * Criado em 2 de Agosto de 2006, 22:17
 *
 */

package app;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Dettoni
 */
public class ConSQL{
    private String url = "jdbc:hsqldb:";
    private String driver = "org.hsqldb.jdbcDriver";
    private String user;
    private String password;
    private String os;
    private Connection con;
    private Statement stmt;
    private String path;
    /**
     * Creates a new instance of ConSQL
     */
    public ConSQL() throws ClassNotFoundException, SQLException, IOException{
      try {
        getConfig(); 
      } catch (IOException e) {
          e.printStackTrace();
      }
      
      try {
      Class.forName(driver);
      } catch (ClassNotFoundException e) {
          JOptionPane.showMessageDialog(null, "ClassNotFound", "ClassNotFound", JOptionPane.ERROR_MESSAGE);
      }
      try {
        con = DriverManager.getConnection(url,user,password);
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
      } catch (Exception e) {
          e.printStackTrace();
          System.exit(0);
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
    public void getConfig() throws IOException{
        int numLinhas = 0;
        String[] strLinhas = new String[5];
        BufferedReader stdin = null;
       
        try {
            stdin = new BufferedReader (
                                   new FileReader("config.ini"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro de entrada/saida ao ler o arquivo config.ini.", "Erro de Entrada/Saida", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        for (int i = 0; i<=4; i++) {
            strLinhas[i] = stdin.readLine();
            if (strLinhas[i] != null)
                numLinhas++;
        }
        if (!strLinhas[0].toUpperCase().equals("[DB CONFIG]") || (numLinhas != 5)) {
            JOptionPane.showMessageDialog(null, "O arquivo config.ini não é válido.", "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        StringTokenizer stOs = new StringTokenizer(strLinhas[1], "=");
        StringTokenizer stDb = new StringTokenizer(strLinhas[2], "=");
        StringTokenizer stUser = new StringTokenizer(strLinhas[3], "=");
        StringTokenizer stPassword = new StringTokenizer(strLinhas[4], "=");
        if (!(stOs.countTokens() == 2) || !(stDb.countTokens() == 2) || !(stUser.countTokens() == 2) || (!(stPassword.countTokens() == 1) && !(stPassword.countTokens() == 2))) {
            JOptionPane.showMessageDialog(null, "O arquivo config.ini não é válido.", "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        if (stOs.nextToken().toUpperCase().equals("OS")) 
            os = stOs.nextToken();
        else { 
            JOptionPane.showMessageDialog(null, "Não encontrado tag OS", "Erro em arquivo.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        if (stDb.nextToken().toUpperCase().equals("DB")) {
            if (os.equals("linux")){
                path = stDb.nextToken();
                url+=path+"/toth";
            } else if (os.equals("windows")) {
                path = stDb.nextToken();
                url+="file:"+path+"/toth";                 
            } else {
                JOptionPane.showMessageDialog(null, "OS Desconhecido", "Erro em arquivo config.ini.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não encontrado tag DB", "Erro em arquivo config.ini.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        if (stUser.nextToken().toUpperCase().equals("USER")) {
            user = stUser.nextToken();
        } else {
            JOptionPane.showMessageDialog(null, "Não encontrado tag USER", "Erro em arquivo config.ini.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        if (stPassword.nextToken().toUpperCase().equals("PASSWORD")) {
            if (stPassword.hasMoreTokens()) {
                password = stPassword.nextToken();
            } else {
                password = "";
            }                 
        } else {
            JOptionPane.showMessageDialog(null, "Não encontrado tag PASSWORD", "Erro em arquivo config.ini.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        validaConfig();
    }
    public void validaConfig() {
        File db = new File(path+"/toth.data");
        if (!db.exists() || !db.isFile()) {
            JOptionPane.showMessageDialog(null, "Não existe o banco de dados no caminho indicado.", "Erro em arquivo de db.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if (!db.canRead() || !db.canWrite()) {
            JOptionPane.showMessageDialog(null, "Sem permissões suficientes para acessar o arquivo de Banco de dados.", "Erro em arquivo de db.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        
    }
    
}

    

