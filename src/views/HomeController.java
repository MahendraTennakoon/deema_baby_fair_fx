package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import models.User;

/**
 * FXML Controller class
 *
 * @author Mahendra Tennakoon
 */
public class HomeController implements Initializable {

    @FXML
    private Button sidebar_business_overview;
    @FXML
    private Button sidebar_human_resources;
    @FXML
    private Button sidebar_sales;
    @FXML
    private Button sidebar_inventory;
    @FXML
    private Button sidebar_suppliers;
    @FXML
    private Button sidebar_finance;
    @FXML
    private Button sidebar_customers;
    @FXML
    private Button sidebar_deliveries;
    @FXML
    private Button sidebar_advertising;
    @FXML
    private Button sidebar_infrastructure;
    @FXML
    private Button sidebar_useraccounts;
    @FXML
    private BorderPane border_pane_home;
    @FXML
    private StackPane stackpane_home_center;
    @FXML
    private Label lbl_logged_in_user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadBusinessOverviewPanel();
        lbl_logged_in_user.setText(LoginController.username);
        lbl_logged_in_user.setVisible(false);
        
        User user = new User();
        String privileges = user.getAccessPrivileges(LoginController.username);
        setAccessPrivileges(privileges);
    }
    
    private void setAccessPrivileges(String privileges) {
        char[] access_values = privileges.toCharArray();
        Button[] btns = {sidebar_business_overview, sidebar_human_resources, 
            sidebar_sales, sidebar_inventory, sidebar_suppliers, sidebar_finance, 
            sidebar_customers, sidebar_deliveries, sidebar_advertising, sidebar_infrastructure, sidebar_useraccounts}; 
        
        for (int i = 0; i < btns.length; i++) {
            if (access_values[i] == '0') {
                btns[i].setDisable(true);
            }
        }
    }

    /**
     * load the Human Resources FXML into center of the home borderpane.
     */
    public void loadHumanResourcespanel() {
        loadCenterPanel("/views/HumanResources.fxml");
    }
    
    public void loadDeliveryPanel() {
        loadCenterPanel("/views/DeliveryandDeliveryServices.fxml");
    }
    
    public void loadInfrastructurePanel() {
        loadCenterPanel("/views/Infrastructure Management.fxml");
    }
    
    public void loadCustomerPanel() {
        loadCenterPanel("/views/Customer_Details.fxml");
    }
    
    public void loadOffersPanel() {
        loadCenterPanel("/views/Advertising.fxml");
    }
    
    /**
     * load the Human Resources FXML into center of the home borderpane.
     */
    public void loadSalesPanel() {
        loadCenterPanel("/views/Sale.fxml");
    }

    /**
     * load the Human Resources FXML into center of the home borderpane.
     */
    public void loadFinancepanel() {
        loadCenterPanel("/views/Finance.fxml");
    }

    /**
     * load the Inventory FXML into center of the home borderpane.
     */
    public void loadInventory() {
        loadCenterPanel("/views/Inventory.fxml");
    }

    /**
     * load Supplier FXML into center of the home borderpane.
     */
    public void loadSupplierPanel() {
        loadCenterPanel("/views/Supplier.fxml");
    }

    /**
     * load Supplier FXML into center of the home borderpane.
     */
    public void loadBusinessOverviewPanel() {
        loadCenterPanel("/views/BusinessOverview.fxml");
    }

    /**
     * load User Accounts FXML into center of the home borderpane.
     */
    public void loadUserAccountsPanel() {
        loadCenterPanel("/views/UserAccounts.fxml");
    }
    
    /**
     * Loads the FXML scene to the center of home borderpane.
     *
     * @param fxml_path
     */
    public void loadCenterPanel(String fxml_path) {
        stackpane_home_center.getChildren().clear();
        try {
            stackpane_home_center.getChildren().clear();
            stackpane_home_center.getChildren().add(FXMLLoader.load(getClass().getResource(fxml_path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
