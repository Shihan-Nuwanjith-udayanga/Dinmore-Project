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
public class EmployeeDTO implements Serializable{
    private int e_id;
    private String e_name;
    private String e_passowrd;
    private String status;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int e_id, String e_name, String e_passowrd, String status) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_passowrd = e_passowrd;
        this.status = status;
    }

    public EmployeeDTO(String name, String password) {
        this.e_name = name;
        this.e_passowrd=password;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_passowrd() {
        return e_passowrd;
    }

    public void setE_passowrd(String e_passowrd) {
        this.e_passowrd = e_passowrd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
