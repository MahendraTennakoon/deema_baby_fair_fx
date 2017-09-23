/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Waruna
 */
public class SupModel {
    private String supid;
    private String supname;
    private String description;
    private String address;
    private String tpnum;
    private String email;
    private String datejoin;
    private String bank;
    private String branch;
    private String accntno;
    
    public SupModel(){ 

    this.supid="";
    this.supname="";
    this.description="";
    this.address="";
    this.tpnum="";
    this.email="";
    this.datejoin="";
    this.bank="";
    this.branch="";
    this.accntno="";
    }
    
    public SupModel (String supID, String supname,String descript,String address,String tpnum,String email,String datejoin,String bank,String branch,String accntno){
    this.supid = supID;
    this.supname = supname;
    this.description = descript;
    this.address = address;
    this.tpnum = tpnum;
    this.email = email;
    this.datejoin = datejoin;
    this.bank= bank;
    this.branch = branch;
    this.accntno= accntno;
    }

    public String getSupid() {
        return supid;
    }

    public void setSupid(String supid) {
        this.supid = supid;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTpnum() {
        return tpnum;
    }

    public void setTpnum(String tpnum) {
        this.tpnum = tpnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatejoin() {
        return datejoin;
    }

    public void setDatejoin(String datejoin) {
        this.datejoin = datejoin;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccntno() {
        return accntno;
    }

    public void setAccntno(String accntno) {
        this.accntno = accntno;
    }

}
