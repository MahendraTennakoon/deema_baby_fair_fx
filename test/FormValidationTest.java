/**
 *
 * @author Mahendra Tennakoon
 */
public class FormValidationTest {
    public static void main(String[] args) {
        String val = "120000qaaa";
        char[] arr = val.toCharArray();
        
        for (char c : arr) {
            if (Character.isDigit(c)) {
                System.out.println("digit");
            } else {
                System.out.println("non digit");
            }
        }
    }
}
