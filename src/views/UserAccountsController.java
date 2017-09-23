package views;

import java.net.URL;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.User;
import util.JDBC;

/**
 * FXML Controller class
 *
 * @author Mahendra Tennakoon
 */
public class UserAccountsController implements Initializable {

    @FXML
    private TableView table_user_accounts;
    @FXML
    private TextField txt_user_filter;
    @FXML
    private CheckBox chk_employee_id;
    @FXML
    private CheckBox chk_nic;
    @FXML
    private CheckBox chk_position;
    @FXML
    private Button btn_save_privileges;
    @FXML
    private CheckBox chb_business_overview;
    @FXML
    private CheckBox chb_human_resources;
    @FXML
    private CheckBox chb_sales;
    @FXML
    private CheckBox chb_inventory;
    @FXML
    private CheckBox chb_supplier;
    @FXML
    private CheckBox chb_finance;
    @FXML
    private CheckBox chb_customers;
    @FXML
    private CheckBox chb_deliveries;
    @FXML
    private CheckBox chb_advertising;
    @FXML
    private CheckBox chb_infrastructure;
    @FXML
    private CheckBox chb_user_accounts;

    private static User selectedUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadUserAccountsTable();
        btn_save_privileges.setDisable(true);

        table_user_accounts.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            User usr = (User) obs.getValue();
            if (usr == null) {
                return;
            }
            selectedUser = usr;
            String privileges = new User().getAccessPrivileges(usr.getUserName());
            clearPrivilegeCheckboxes();
            loadAccessPrivileges(privileges);
            btn_save_privileges.setDisable(false);
        });
        
        chb_business_overview.setDisable(true);
    }

    public void saveAccountPrivileges() {
        String username = selectedUser.getUserName();
        String privileges = getSelectedAccountPrivileges();
        JDBC j = new JDBC();
        
        Alert confDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confDialog.setTitle("Confirm action!");
        confDialog.setHeaderText("Are you sure you want to update access privileges of user " + selectedUser.getUserName() + "?");
        Optional<ButtonType> result = confDialog.showAndWait();
        
        if (result.get() != ButtonType.OK) {
            return;
        }

        try {
            j.setData("UPDATE user_account SET access_privileges = '" + privileges + "', acc_type = 'Custom' WHERE user_name = '" + username + "' ");
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notice");
            alert.setHeaderText("User account updated successfully!");
            alert.showAndWait();
            loadUserAccountsTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getSelectedAccountPrivileges() {
        String privileges = "";
        CheckBox[] privilege_flags = {chb_business_overview, chb_human_resources,
            chb_sales, chb_inventory, chb_supplier, chb_finance, chb_customers,
            chb_deliveries, chb_advertising, chb_infrastructure, chb_user_accounts};

        char[] granularPrivileges = new char[11];

        for (int i = 0; i < granularPrivileges.length; i++) {
            if (privilege_flags[i].isSelected()) {
                granularPrivileges[i] = '1';
            } else {
                granularPrivileges[i] = '0';
            }
        }

        privileges = new String(granularPrivileges);
        return privileges;
    }

    private void loadAccessPrivileges(String privileges) {
        char[] access_levels = privileges.toCharArray();
        CheckBox[] privilege_flags = {chb_business_overview, chb_human_resources,
            chb_sales, chb_inventory, chb_supplier, chb_finance, chb_customers,
            chb_deliveries, chb_advertising, chb_infrastructure, chb_user_accounts};

        for (int i = 0; i < privilege_flags.length; i++) {
            if (access_levels[i] == '1') {
                privilege_flags[i].setSelected(true);
            }
        }
    }

    private void clearPrivilegeCheckboxes() {
        chb_business_overview.setSelected(false);
        chb_human_resources.setSelected(false);
        chb_sales.setSelected(false);
        chb_inventory.setSelected(false);
        chb_supplier.setSelected(false);
        chb_finance.setSelected(false);
        chb_customers.setSelected(false);
        chb_deliveries.setSelected(false);
        chb_advertising.setSelected(false);
        chb_infrastructure.setSelected(false);
        chb_user_accounts.setSelected(false);
    }

    public void loadUserAccountsTable() {
        TableColumn<User, String> username_col = new TableColumn<>("User name");
        username_col.setCellValueFactory(new PropertyValueFactory<>("userName"));

        TableColumn<User, String> fname_col = new TableColumn<>("First name");
        fname_col.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<User, String> lname_col = new TableColumn<>("Last name");
        lname_col.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<User, String> email_col = new TableColumn<>("Email address");
        email_col.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        email_col.setMinWidth(100);

        TableColumn<User, String> acctype_col = new TableColumn<>("Account type");
        acctype_col.setCellValueFactory(new PropertyValueFactory<>("accType"));

        table_user_accounts.getColumns().clear();

        ObservableList<User> users = getAllUsers();
        FilteredList<User> filteredUsers = new FilteredList<>(users, p -> true);

        txt_user_filter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredUsers.setPredicate(user -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getUserName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<User> sortedUsers = new SortedList<>(filteredUsers);
        sortedUsers.comparatorProperty().bind(table_user_accounts.comparatorProperty());

        table_user_accounts.setItems(sortedUsers);
        table_user_accounts.getColumns().addAll(username_col, fname_col, lname_col, email_col, acctype_col);
    }

    public ObservableList<User> getAllUsers() {
        JDBC j = new JDBC();
        ObservableList<User> users = FXCollections.observableArrayList();
        try {
            ResultSet rset = j.getData("SELECT * FROM user_account WHERE user_name NOT LIKE '"+ LoginController.username +"' ");
            while (rset.next()) {
                String username = rset.getString(1);
                String email = rset.getString(3);
                String fname = rset.getString(4);
                String lname = rset.getString("lastname");
                String acc_type = rset.getString("acc_type");

                users.add(new User(username, email, fname, lname, acc_type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * open the user account creation window as a popup.
     */
    public void gotoUserAccountCreation() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/UserAccountCreation.fxml"));
            Scene home = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(home);
            stage.setResizable(false);
            stage.show();
            stage.setOnCloseRequest(e -> {
                loadUserAccountsTable();
                clearPrivilegeCheckboxes();
                btn_save_privileges.setDisable(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
