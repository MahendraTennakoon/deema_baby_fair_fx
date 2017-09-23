/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import util.JDBC;

/**
 *
 * @author Waruni
 */
public class Services {
    
    private String service_id;
    private String name ;
    private String address;
    private String contact_number ;
            
    public Services ()
            {
                this.service_id = "";
                this.name = "";
                this.address = "";
                this.contact_number = "";
                
            }
    public Services (String service_id, String name, String address, String contact_number){
        
        this.service_id = service_id;
        this.name = name;
        this.address = address;
        this.contact_number = contact_number;
    }
  
    
    
    
    public void addNewservices(Services ser) {
        String services_id = ser.service_id;
        String name = ser.name;
        String address = ser.address;
        String contact_number = ser.contact_number;
        
        
         JDBC j = new JDBC();
        j.setData("INSERT INTO services(services_id, name, address, contact_number)"
                +"Values('"+service_id+"', '"+name+"', '"+address+"', '"+contact_number+"')");
                
}

    public String getservice_id() {
        return service_id;
    }

    public void setservice_id(String service_id) {
        this.service_id = service_id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getcontact_number() {
        return contact_number;
    }

    public void setcontact_number(String contact_number) {
        this.contact_number = contact_number;
    }
    
    public void updateNewservices(Services ser){
        String service_id = ser.service_id;
        String name = ser.name;
        String address = ser.address;
        String contact_number = ser.contact_number;
        
JDBC j = new JDBC();
 j.setData("UPDATE services SET services_id='"+service_id+"',name'"+name+"',address'"+address+"',contact_number'"+contact_number+"'"+"WHERE service_id='"+service_id+"'");
    }
    
public void deleteservices(String ser_id){
    JDBC j = new JDBC();
    j.setData("DELETE from services WHERE services_id='"+"'");
}
   }
