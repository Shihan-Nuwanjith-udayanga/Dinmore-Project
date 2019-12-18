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
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_common.observer.Observer;
import lk.ijse.dinmore_common.service.custom.TelOperatorService;
import lk.ijse.dinmore_server.business.BOFactory;
import lk.ijse.dinmore_server.business.BOTypes;
import lk.ijse.dinmore_server.business.custom.TelOperatorBO;

/**
 *
 * @author Dell
 */
public class TelOperatorServiceImpl extends UnicastRemoteObject implements TelOperatorService{
    
    TelOperatorBO operatorBO = (TelOperatorBO) BOFactory.getInstance().getBO(BOTypes.TELOPERATOR);
    private static ArrayList<Observer> observers = new ArrayList<>();

    public TelOperatorServiceImpl()throws Exception {
       
    }
    
    @Override
    public boolean addOrder(TelOperatorDTO dTO) throws Exception {
        boolean addOrder = operatorBO.addOrder(dTO);
        if (addOrder) {
            notify("Order Placed Success...");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateOrder(TelOperatorDTO dTO) throws Exception {
        boolean updateOrder = operatorBO.updateOrder(dTO);
        if (updateOrder) {
            notify("Order Updated Success...");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOrder(int Oid) throws Exception {
        boolean deleteOrder = operatorBO.deleteOrder(Oid);
        if (deleteOrder) {
            notify("Order deleted Success...");
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<TelOperatorDTO> getAllOrder() throws Exception {
        return operatorBO.getAllOrder();
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
    public int getOderID() throws Exception {
        return operatorBO.getOderID();
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
    public boolean reserve(Object key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
