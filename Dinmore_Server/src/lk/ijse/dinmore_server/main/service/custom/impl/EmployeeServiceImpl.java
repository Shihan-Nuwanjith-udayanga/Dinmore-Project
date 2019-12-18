/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.main.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_common.observer.Observer;
import lk.ijse.dinmore_common.service.custom.EmployeeService;
import lk.ijse.dinmore_server.business.BOFactory;
import lk.ijse.dinmore_server.business.BOTypes;
import lk.ijse.dinmore_server.business.SuperBO;
import lk.ijse.dinmore_server.business.custom.EmployeeBO;

/**
 *
 * @author Dell
 */
public class EmployeeServiceImpl extends UnicastRemoteObject implements EmployeeService{
    
    EmployeeBO bO  = (EmployeeBO)BOFactory.getInstance().getBO(BOTypes.EMPLOYEE);
    public static ArrayList<Observer> observers = new ArrayList<>();
    
    public EmployeeServiceImpl()throws Exception{
        
    }

    @Override
    public boolean addEmployee(EmployeeDTO dTO) throws Exception {
         boolean addEmployee = this.bO.addEmployee(dTO);
        if (addEmployee) {
            notify("Order Placed Success...");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dTO) throws Exception {
        boolean updateEmployee = bO.updateEmployee(dTO);
        if (updateEmployee) {
            notify("Order Updated Success...");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int e_id) throws Exception {
        boolean delete = bO.delete(e_id);
        if (delete) {
            notify("Order deleted Success...");
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws Exception {
        return bO.getAllEmployee();
    }

    @Override
    public int getEmployeeID() throws Exception {
        return bO.getEmployeeID();
    }

    @Override
    public void register(Observer observer) throws Exception {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) throws Exception {
        observers.remove(0);
    }

    @Override
    public void notify(String message) throws Exception {
        for(Observer observer:observers){
            new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    try {
                        observer.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(TelOperatorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            ).start();
        }
    }

    @Override
    public boolean reserve(Object key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
