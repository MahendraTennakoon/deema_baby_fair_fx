/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileReader;
import java.util.Properties;

/**
 *
 * @author VTENNM1
 */
public class ReadConfigTest {

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("./src/config/db_config.properties");
            Properties prop = new Properties();
            prop.load(reader);
            System.out.println( prop.getProperty("user_name") );
            System.out.println( prop.getProperty("password") );
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
