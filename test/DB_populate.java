
import java.sql.Date;
import java.util.Calendar;
import util.JDBC;

/**
 *
 * @author Mahendra Tennakoon
 */
public class DB_populate {

    public static void main(String[] args) {
        JDBC j = new JDBC();
//        String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER"};
        Date paid_date = new Date(Calendar.getInstance().getTimeInMillis());
        int emp_id = 1600000000;
        float salary = 25000.00f;
        try {
            for (String month : months) {
                j.setData("INSERT INTO salary_details(employee_id, month, amount, paid_date) VALUES('"+ Integer.toString(emp_id) +"', '"+month+"', '"+ salary +"', paid_date)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
