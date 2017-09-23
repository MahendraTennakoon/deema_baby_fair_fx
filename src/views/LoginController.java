package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.FormValidate;
import models.User;
import util.Cypher;

/**
 * FXML Controller class
 *
 * @author Mahendra Tennakoon
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txt_user_name;
    @FXML
    private PasswordField txt_password;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_close;
    @FXML
    private Label lbl_error;
    @FXML
    private Label lbl_attempts_count;

    private int remainingAttempts;
    public static String username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> btn_login.requestFocus());
        lbl_error.setVisible(false);

        // a user gets 5 login attempts per session
        remainingAttempts = 5;
        lbl_attempts_count.setVisible(false);
    }

    /**
     * close the window.
     */
    public void close() {
        Stage stage = (Stage) btn_close.getScene().getWindow();
        stage.close();
    }

    /**
     * Calculate and display the remaining number of login attempts. Close the
     * stage if the allowed number of attempts has exceeded.
     */
    private void calcAttemptsLeft() {
        remainingAttempts--;
        if (remainingAttempts == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fatal Error!");
            alert.setHeaderText("You have exceeded the maximum allowd number of login attempts. The program will now exit.");
            alert.showAndWait();
            close();
            return;
        }
        lbl_attempts_count.setText("Attempts left: " + remainingAttempts);
        lbl_attempts_count.setVisible(true);
    }

    /**
     * Compare the MD5 hash of the input password_hash to that stored in db.
     */
    public void validateLogin() {
        String user_name = txt_user_name.getText();
        String password = txt_password.getText();
        String password_hash = Cypher.generateMD5(password);

        if (!FormValidate.isEmptyField(user_name, "User name") && !FormValidate.isEmptyField(password, "Password")) {
            User user = new User();
            String stored_pwd = user.getAccountPassword(user_name);

            if (!stored_pwd.equals(password_hash)) {
                txt_password.setText("");
                lbl_error.setVisible(true);
                calcAttemptsLeft();
            } else {
                lbl_error.setVisible(false);
                lbl_attempts_count.setVisible(false);

                // create a new stage and set home as the scene
                try {
                    username = user_name;
                    Parent root = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
                    Scene home = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(home);
                    stage.setMaximized(true);
                    stage.show();

                    // close current window
                    close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Show password recovery wizard.
     */
    public void gotoPasswordRecovery() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/PasswordRecovery.fxml"));
            Scene home = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(home);
            stage.setResizable(false);
            stage.show();

            // close current window
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
