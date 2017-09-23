package views;

import java.sql.ResultSet;
import util.JDBC;

/**
 *
 * @author User
 */
public class Invoice {

    private String item_no;
    private String description;
    private int qty;
    private String date;
    private String invoice_no;
    private double discount;
    private String customer;
    private double gross_tot;
    private double tot_discount;
    private double net_tot;
    private double cash;
    private double balance;
    private double unitPrice;
    private double amount;
    private double net_amount;

    public Invoice() {

        this.item_no = "";
        this.description = "";
        this.qty = 0;
        this.date = "";
        this.invoice_no = "";
        this.discount = 0;
        this.customer = "";
        this.gross_tot = 0;
        this.tot_discount = 0;
        this.net_tot = 0;
        this.cash = 0;
        this.balance = 0;
        this.unitPrice = 0;
        this.amount = 0;
        this.net_amount = 0;

    }

    public double getNet_amount() {
        return net_amount;
    }

    public void setNet_amount(double net_amount) {
        this.net_amount = net_amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItem_no() {
        return item_no;
    }

    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getGross_tot() {
        return gross_tot;
    }

    public void setGross_tot(double gross_tot) {
        this.gross_tot = gross_tot;
    }

    public double getTot_discount() {
        return tot_discount;
    }

    public void setTot_discount(double tot_discount) {
        this.tot_discount = tot_discount;
    }

    public double getNet_tot() {
        return net_tot;
    }

    public void setNet_tot(double net_tot) {
        this.net_tot = net_tot;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Invoice(String invoice_no, String item_no, String description, int qty, double amount, double net_amount, double tot_disc, String date, double unitPrice) {
        this.invoice_no = invoice_no;
        this.item_no = item_no;
        this.description = description;
        this.qty = qty;
        this.amount = amount;
        this.net_amount = net_amount;
        this.discount = tot_disc;
        this.date = date;
        this.unitPrice = unitPrice;
    }

  

    public Invoice(String item_no, String description, int qty, double unitPrice, double amount) {
        this.item_no = item_no;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.amount = amount;

    }

   

    public String generateInvoiceNo() {
        int r_count = 1;

        JDBC j = new JDBC();
        try {
            ResultSet rset = j.getData("SELECT COUNT(inv_no) FROM invoice");
            if (rset.next()) {
                r_count = rset.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int invoice_int = (r_count * 1000) + 1;
        String invoice_num = Integer.toString(invoice_int);
        return invoice_num;
    }
    /**
     *
     */

}
