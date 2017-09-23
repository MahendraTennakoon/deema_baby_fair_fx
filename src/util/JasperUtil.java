package util;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Mahendra Tennakoon
 */
public class JasperUtil {
    public static void main(String[] args) {
        JasperUtil js = new JasperUtil();
        js.generateReport("C:\\Users\\VTENNM1\\JaspersoftWorkspace\\deema_baby_fair\\SalaryHistory.jrxml");
    }
    public void generateReport(String source) {
        JDBC j = new JDBC();
        try {
            Connection con = j.getCon();
            Map<String, Object> params = new HashMap<>();
            JasperReport jasperReport = JasperCompileManager.compileReport(source);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void generateSalaryReport(String source, String param) {
        JDBC j = new JDBC();

        try {
            Connection con;
            con = j.getCon();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("month", param);
            JasperReport jasperReport = JasperCompileManager.compileReport(source);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
