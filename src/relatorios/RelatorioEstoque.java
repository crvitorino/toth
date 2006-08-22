/*
 * RelatorioEstoque.java
 *
 * Criado em 18 de Agosto de 2006, 05:38
 *
 */

package relatorios;

import app.ConSQL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Fernando Dettoni
 */
public class RelatorioEstoque {
    ConSQL con;
    /** Creates a new instance of RelatorioEstoque */
    public RelatorioEstoque(ConSQL con) {
        this.con = con;
        try{
        geraRelatorio();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* Gera Relatorio e visualiza-o */
    public void geraRelatorio( ) throws JRException, Exception
    {
        try{
            Statement stm = con.getStatement( );
            String query = "select * from produtos";
            ResultSet rs = stm.executeQuery( query );
            JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
            Map parameters = new HashMap();
            JasperFillManager.fillReportToFile( "relatorios/Estoque.jasper", parameters, jrRS );
            JasperViewer.viewReport( "relatorios/Estoque.jrprint",false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    
}
