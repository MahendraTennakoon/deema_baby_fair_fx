package views;

//import static com.sun.deploy.config.JREInfo.clear;
//import static com.sun.org.glassfish.external.amx.AMXUtil.prop;
import java.awt.Label;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.customer;
import util.JDBC;
import models.CusModel;
import models.InvenModel;
import util.FormValidate;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Customer_DetailsController implements Initializable {

    JDBC db = new JDBC();
    @FXML
    private TextField txt_customer_id;

    @FXML
    private TextField txt_customer_name;

    @FXML
    private TextField txt_contact_no;

    @FXML
    private TextField txt_address;

    @FXML
    private TextField txt_email_address;

    @FXML
    private TextField txt_remark;

    @FXML
    private TextField txt_date;

    @FXML
    private TableView table_customer;

    @FXML
    private TextField txt_cus_filter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generateCustomerID();
        txt_date.setText(LocalDate.now().toString());
        loadCustomerTable();

        table_customer.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            CusModel cus = (CusModel) obs.getValue();
            loadrowfromtable();

            // updateCustomer(cus);
        });
    }

    public void loadCustomerTable() {
        TableColumn<CusModel, String> cus_id_col = new TableColumn<>("customer_id");
        cus_id_col.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        TableColumn<CusModel, String> cus_name_col = new TableColumn<>("customer_name");
        cus_name_col.setCellValueFactory(new PropertyValueFactory<>("customer_name"));

        TableColumn<CusModel, String> cus_contactno_col = new TableColumn<>("contact_no");
        cus_contactno_col.setCellValueFactory(new PropertyValueFactory<>("contact_no"));

        TableColumn<CusModel, String> cus_address_col = new TableColumn<>("address");
        cus_address_col.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<CusModel, String> cus_emailaddress_col = new TableColumn<>("email");
        cus_emailaddress_col.setCellValueFactory(new PropertyValueFactory<>("email_address"));

        TableColumn<CusModel, String> cus_date_col = new TableColumn<>("date");
        cus_date_col.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<CusModel, String> cus_remark_col = new TableColumn<>("remark");
        cus_remark_col.setCellValueFactory(new PropertyValueFactory<>("remark"));

        ObservableList<CusModel> customers = getAllCustomerData();
        FilteredList<CusModel> filteredCustomers = new FilteredList<>(customers, p -> true);

        txt_cus_filter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredCustomers.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (customer.getCustomerId().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<CusModel> sortedCustomer = new SortedList<>(filteredCustomers);
        sortedCustomer.comparatorProperty().bind(table_customer.comparatorProperty());

        table_customer.getColumns().clear();
        table_customer.setItems(getAllCustomerData());
        table_customer.getColumns().addAll(cus_id_col, cus_name_col, cus_date_col, cus_contactno_col, cus_address_col, cus_emailaddress_col, cus_remark_col);
    }

    public ObservableList<CusModel> getAllCustomerData() {
        ObservableList<CusModel> customer = FXCollections.observableArrayList();

        JDBC j = new JDBC();
        try {
            ResultSet rset = j.getData("SELECT * FROM customer");
            while (rset.next()) {
                String customer_id = rset.getString(1);
                String customer_name = rset.getString(2);
                String address = rset.getString(5);
                String contact_no = rset.getString(4);
                String email_address = rset.getString(6);
                String date = rset.getString(7);
                String remark = rset.getString(3);

                customer.add(new CusModel(customer_id, customer_name, contact_no, address, email_address, date, remark));

            }
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }

    public void generateCustomerID() {
        String customer_id = "";
        Calendar date = new GregorianCalendar();
        int year = date.get(Calendar.YEAR) % 100;
        int cusCount = new customer().getCustomerCount() + 1;//getCustomerCount() + 1;

        int curr_len = (year + "" + cusCount).length();
        int padding_len = 5 - curr_len;

        customer_id = customer_id + year;
        for (int i = 0; i < padding_len; i++) {
            customer_id = customer_id + 1;
        }
        customer_id = customer_id + cusCount;

        txt_customer_id.setText(customer_id);

    }

    public void saveCustomer() {

        if (!checkEmptyFields() || !CheckPhone() || !Checkemail()) {

            String customer_id = txt_customer_id.getText();
            String customer_name = txt_customer_name.getText();
            String contact_no = txt_contact_no.getText();
            String address = txt_address.getText();
            String email_address = txt_email_address.getText();
            String remark = txt_remark.getText();
            String date = txt_date.getText();

            customer cus = new customer(customer_id, customer_name, contact_no, address, email_address, remark, date);
            cus.AddNewCustomer(cus);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notice");
            alert.setHeaderText("customer " + cus.getCoustomerId() + " Succssfully saved!");
            alert.showAndWait();
        }
        loadCustomerTable();
        clear();

    }

    /*public  void loadrowfromtable(CusModel x){
    
     
            
            txt_customer_id.setText(x.getCustomerId()+"");
            txt_address.setText(x.getAddress()+"");
            txt_contact_no.setText(x.getContact_no()+"");
            txt_customer_name.setText(x.getCustomer_name()+"");
            txt_date.setText(x.getDate()+"");
            txt_email_address.setText(x.getEmail_address()+"");
            txt_remark.setText(x.getRemark()+"");
       
    }*/
    public void loadrowfromtable() {
        table_customer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            CusModel c = (CusModel) obs.getValue();
            if (c == null) {
                return;
            }
            String cus_id = c.getCustomerId();
            String name = c.getCustomer_name();
            String remark = c.getRemark();
            String contac = c.getContact_no();
            String address = c.getAddress();
            String email = c.getEmail_address();
            String date = c.getDate();

            txt_customer_id.setText(cus_id);
            txt_customer_name.setText(name);
            txt_remark.setText(remark);
            txt_contact_no.setText(contac);
            txt_address.setText(address);
            txt_email_address.setText(email);
            txt_date.setText(date);

        });
    }

    public void updateConfirm() {

        String customer_id = txt_customer_id.getText();
        String customer_name = txt_customer_name.getText();
        String remark = txt_remark.getText();
        String contact_no = txt_contact_no.getText();
        String address = txt_address.getText();
        String email_address = txt_email_address.getText();
        String date = txt_date.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setHeaderText(" Succssfully updated!");
        Optional<ButtonType> result = alert.showAndWait();
        System.out.println("popup");
        if (result.get() == ButtonType.OK) {
            System.out.println("ok");
            JDBC j = new JDBC();
            try {
                j.setData("UPDATE customer SET  customer_name='" + customer_name + "',contact_no='" + contact_no + "',address='" + address + "',email_address='" + email_address + "',date='" + date + "',remark='" + remark + "'WHERE customer_id='"+customer_id+"'");
          // db.setData("UPDATE inventory set Item_name='"+Itemname+"',Description='"+descript+"',Quantity='"+Qty+"', Receive_from='"+receivefrm+"', Receive_date='"+receivedate+"', Expire_date='"+Exprdate+"' WHERE Item_code='"+Item_code+"'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            ObservableList<CusModel> list = getAllCustomerData();
            table_customer.setItems(list);
        } else {
        }
    }

    public void clear() {
        txt_customer_id.setText("");
        txt_customer_name.setText("");
        // txt_date.setText("");
        txt_contact_no.setText("");
        txt_address.setText("");
        txt_email_address.setText("");
        txt_remark.setText("");
    }

    public void delectCustomer() {
        String customer_id = txt_customer_id.getText();

        Alert confDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confDialog.setTitle("Confirm action!");
        confDialog.setHeaderText("Are you sure you want to permanently delete employee " + customer_id + " ?");
        Optional<ButtonType> result = confDialog.showAndWait();

        if (result.get() != ButtonType.OK) {
            return;
        }
        new customer().deleteCustomer(customer_id);
        //new customer().deleteCustomer(customer_id);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        alert.setHeaderText("Customer  " + customer_id + "  successfully deleted!");
        alert.showAndWait();
        loadCustomerTable();

    }

    private boolean checkEmptyFields() {
        String customer_id = txt_customer_id.getText();
        String customer_name = txt_customer_name.getText();
        String contact_no = txt_contact_no.getText();
        String address = txt_address.getText();
        String email_address = txt_email_address.getText();
        FormValidate v = new FormValidate();

        if (v.isEmptyField(customer_id, "customer_id") || v.isEmptyField(customer_name, "customer_name") || v.isEmptyField(contact_no, "contact_no") || v.isEmptyField(address, "address") || v.isEmptyField(email_address, "email_address")) {
            return true;
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean CheckPhone() {

        FormValidate fv = new FormValidate();

        if (!fv.ValidatePhone(txt_contact_no.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Phone number.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    boolean Checkemail() {
        FormValidate fv = new FormValidate();

        if (fv.validateEmail(txt_email_address.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Email address");
            alert.showAndWait();
            return false;
        }
        return true;
    }
}
