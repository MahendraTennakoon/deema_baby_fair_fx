package views;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import util.JDBC;

/**
 * FXML Controller class
 *
 * @author Mahendra Tennakoon
 */
public class BusinessOverviewController implements Initializable {

    @FXML
    private LineChart<String, Number> line_chart_bo_profit;
    @FXML
    private BarChart<String, Number> bar_chart_bo_trending_items;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadOperatingProfitChart();
        loadTrendingItemsChart();
    }

    public void loadTrendingItemsChart() {
        bar_chart_bo_trending_items.getData().clear();
        int year = LocalDate.now().getYear();
        bar_chart_bo_trending_items.getData().addAll(getSalesHistoricalData(year));
        
    }

    public XYChart.Series<String, Number> getSalesHistoricalData(int year) {
        JDBC j = new JDBC();
        XYChart.Series<String, Number> series_curr = new XYChart.Series<String, Number>();
        series_curr.setName(LocalDate.now().getYear() + "");
        try {
            String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
            ResultSet rset = null;

            rset = j.getData("SELECT item_no, description, SUM(qty) AS 'qty' FROM sales WHERE YEAR(date) = '"+ year +"' GROUP BY(item_no) ORDER BY(qty) ASC");
            while (rset.next()) {
                int sales_qty = rset.getInt(3);
                String item = rset.getString(2);
                series_curr.getData().add(new XYChart.Data<String, Number>(item, sales_qty));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return series_curr;
    }

    public void loadOperatingProfitChart() {
        line_chart_bo_profit.getData().clear();
        int year = LocalDate.now().getYear();
        line_chart_bo_profit.getData().add(getProfitHistoricalData(year));
    }

    public XYChart.Series<String, Number> getProfitHistoricalData(int year) {
        JDBC j = new JDBC();
        XYChart.Series<String, Number> series_curr = new XYChart.Series<String, Number>();
        series_curr.setName(LocalDate.now().getYear() + "");
        try {
            String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
            ResultSet rset = null;

            for (String month : months) {
                rset = j.getData("SELECT SUM(net_tot) FROM invoice WHERE MONTHNAME(date) = '" + month + "' AND YEAR(date) = '" + year + "' ");
                if (rset.next()) {
                    float tot_invoice_profit = rset.getFloat(1);
                    series_curr.getData().add(new XYChart.Data<String, Number>(month, tot_invoice_profit));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return series_curr;
    }

}
