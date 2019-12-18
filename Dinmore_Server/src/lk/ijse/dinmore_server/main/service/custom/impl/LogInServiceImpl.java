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
import lk.ijse.dinmore_common.service.custom.LogInService;
import lk.ijse.dinmore_server.business.BOFactory;
import lk.ijse.dinmore_server.business.BOTypes;
import lk.ijse.dinmore_server.business.custom.LogInBO;

/**
 *
 * @author Dell
 */
public class LogInServiceImpl extends UnicastRemoteObject implements LogInService{

     LogInBO loginBO = (LogInBO) BOFactory.getInstance().getBO(BOTypes.LOGIN);
    private static ArrayList<Observer> observerList = new ArrayList<>();
    
    public LogInServiceImpl()throws Exception{
        
    }

    @Override
    public EmployeeDTO checkUser(EmployeeDTO employeeDTO) throws Exception {
         return loginBO.checkUser(employeeDTO);
    }

    @Override
    public void register(Observer observer) throws Exception {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) throws Exception {
        observerList.remove(observer);
    }

    @Override
    public void notify(String message) throws Exception {
        for (Observer observer : observerList) {
            new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    try {
                        observer.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(LogInServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
