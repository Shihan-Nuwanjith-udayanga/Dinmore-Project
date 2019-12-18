/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.entity;

/**
 *
 * @author Dell
 */
public class Cheff {
    private int e_id;
    private int totalOrders;
    private int totalQty;
    private String date;
    private String totalTime;

    public Cheff() {
    }

    public Cheff(int e_id, int totalOrders, int totalQty, String date, String totalTime) {
        this.e_id = e_id;
        this.totalOrders = totalOrders;
        this.totalQty = totalQty;
        this.date = date;
        this.totalTime = totalTime;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }
    
}
