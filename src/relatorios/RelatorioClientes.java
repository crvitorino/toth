

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


public class RelatorioClientes {
    ConSQL con;
    /** Creates a new instance of RelatorioEstoque */
    public RelatorioClientes(ConSQL con) {
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
            String query = "select * from clientes";
            ResultSet rs = stm.executeQuery( query );
            JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
            Map parameters = new HashMap();
            JasperFillManager.fillReportToFile( "relatorios/clientes.jasper", parameters, jrRS );
           // JasperExportManager.exportReportToPdfFile( "relatorios/clientes.jrprint" );
            JasperViewer.viewReport( "relatorios/clientes.jrprint",false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    
}
