/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author User
 */
public class Exchange {
    private String date;
    private String invoice_no;
    private String item_no;
    private String exchange_id;
    private int ret_qty;
    private String description;
    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    
    
    public Exchange(){
        this.date="";
        this.invoice_no="";
        this.item_no= "";
        this.description="";
        this.exchange_id="";
        this.ret_qty=0;
        this.comments="";
    } 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
  

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getItem_no() {
        return item_no;
    }

    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    public String getExchange_id() {
        return exchange_id;
    }

    public void setExchange_id(String exchange_id) {
        this.exchange_id = exchange_id;
    }

    public int getRet_qty() {
        return ret_qty;
    }

    public void setRet_qty(int ret_qty) {
        this.ret_qty = ret_qty;
    }
    
      public Exchange(String exchange_id, String ret_date, String inv_no, String item_no,String description, int qty,String comm) {
     this.exchange_id=exchange_id;
     this.date=ret_date;
     this.invoice_no=inv_no;
     this.item_no=item_no;
     this.description=description;
     this.ret_qty=qty;
     this.comments=comm;
    }
    
}
