
import models.Employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahendra Tennakoon
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee e = new Employee();
        
        String emp_no = "1600000019";
        int wall = emp_no.lastIndexOf("0") + 1;
        String order = emp_no.substring(wall, emp_no.length());
        System.out.println(order);
//        System.out.println(emp_no);
    }
}
