/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.dto;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class CheffDTO implements Serializable{
    private int oid;
    private int e_id;
    private String customer_name;
    private int customer_contact;
    private String food;
    private int qty;
    private String duration;

    public CheffDTO() {
    }

    public CheffDTO(int oid, int e_id, String customer_name, int customer_contact, String food, int qty, String duration) {
        this.oid = oid;
        this.e_id = e_id;
        this.customer_name = customer_name;
        this.customer_contact = customer_contact;
        this.food = food;
        this.qty = qty;
        this.duration = duration;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(int customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
}
