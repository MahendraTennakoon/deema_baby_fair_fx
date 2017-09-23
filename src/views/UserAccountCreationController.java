package views;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import util.Cypher;
import util.FormValidate;
import util.JDBC;

/**
 * FXML Controller class
 *
 * @author Mahendra Tennakoon
 */
public class UserAccountCreationController implements Initializable {

    @FXML
    private Button btn_save;
    @FXML
    private Button btn_cancel;
    @FXML
    private TextField txt_fname;
    @FXML
    private TextField txt_lname;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_username;
    @FXML
    private PasswordField txt_password;
    @FXML
    private PasswordField txt_confirm_password;
    @FXML
    private ChoiceBox chbox_acc_type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lodAccountTypeChoiceBox();
    }

    private void lodAccountTypeChoiceBox() {
        chbox_acc_type.getItems().addAll("Administrator", "Cashier");
        chbox_acc_type.setValue("Administrator");
    }

    public void createUserAccount() {
        if (!checkEmptyFields()) {
            if (FormValidate.validateEmailVerbose(txt_email.getText()) && validatePassword()) {
                if (!isExistingUsername(txt_username.getText())) {
                    String fname = txt_fname.getText();
                    String lname = txt_lname.getText();
                    String email = txt_email.getText();
                    String username = txt_username.getText();
                    String password = txt_password.getText();
                    String password_hash = Cypher.generateMD5(password);
                    String confirm_password = txt_confirm_password.getText();
                    String acc_type = chbox_acc_type.getValue().toString();
                    String privileges = getAccessprivileges(acc_type);

                    JDBC j = new JDBC();
                    j.setData("INSERT INTO user_account(user_name, password, email_address, firstname, lastname, acc_type, access_privileges) "
                            + "VALUES('" + username + "', '" + password_hash + "', '" + email + "', '" + fname + "', '" + lname + "', '" + acc_type + "', '" + privileges + "')");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Notice");
                    alert.setHeaderText("User account created successfully!");
                    alert.showAndWait();

                    //close stage
                    Stage stage = (Stage) txt_username.getScene().getWindow();
                    stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
                }
            }
        }
    }

    public String getAccessprivileges(String acc_type) {
        String privileges = "";
        if (acc_type.equals("Administrator")) {
            privileges = "11111111111";
        } else {
            privileges = "10111111110";
        }
        return privileges;
    }

    public boolean validatePassword() {
        String password = txt_password.getText();
        String confirm_password = txt_confirm_password.getText();

        if (password.length() < 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Password should be atleast 8 characters long.");
            alert.showAndWait();
            return false;
        }

        if (password.equals(confirm_password)) {
            return true;
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("The passwords do not match!");
        alert.showAndWait();
        return false;
    }

    private boolean isExistingUsername(String username) {
        JDBC j = new JDBC();
        try {
            ResultSet rset = j.getData("SELECT user_name FROM user_account WHERE user_name = '" + username + "' ");
            if (rset.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("User name " + username + " already exists. Please choose a different User name");
                alert.showAndWait();
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void closeStage() {
        Stage stage = (Stage) txt_username.getScene().getWindow();
        stage.close();
    }

    private boolean checkEmptyFields() {
        String fname = txt_fname.getText();
        String lname = txt_lname.getText();
        String email = txt_email.getText();
        String username = txt_username.getText();
        String password = txt_password.getText();
        String confirm_password = txt_confirm_password.getText();

        if (FormValidate.isEmptyField(fname, "First name") || FormValidate.isEmptyField(lname, "Last name")
                || FormValidate.isEmptyField(email, "Email address") || FormValidate.isEmptyField(username, "User name")
                || FormValidate.isEmptyField(password, "Password") || FormValidate.isEmptyField(confirm_password, "Confirm password")) {
            // there are empty fields
            return true;
        }

        // no fields are empty
        return false;
    }
}
