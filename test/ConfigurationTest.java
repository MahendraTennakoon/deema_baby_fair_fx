import java.util.Properties;
import models.Configuration;

/**
 *
 * @author Mahendra Tennakoon
 */
public class ConfigurationTest {
    public static void main(String[] args) {
        Configuration c = new Configuration();
        
        Properties prop = c.readEmailConfig();
        System.out.println(prop);
    }
}
