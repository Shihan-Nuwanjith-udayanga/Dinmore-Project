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
import lk.ijse.dinmore_common.dto.CheffDTO;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_common.observer.Observer;
import lk.ijse.dinmore_common.service.custom.CheffService;
import lk.ijse.dinmore_server.business.BOFactory;
import lk.ijse.dinmore_server.business.BOTypes;
import lk.ijse.dinmore_server.business.custom.CheffBO;
import lk.ijse.dinmore_server.reservation.impl.ReservationImpl;

/**
 *
 * @author Dell
 */
public class CheffServiceImpl extends UnicastRemoteObject implements CheffService{

    CheffBO cheffBO = (CheffBO) BOFactory.getInstance().getBO(BOTypes.CHEFF);
    private static ArrayList<Observer> observers = new ArrayList<>();
    private static ReservationImpl<CheffService> reservationImpl = new ReservationImpl<>();

    public CheffServiceImpl()throws Exception{
        
    }
    
    @Override
    public boolean getOrder(TelOperatorDTO operatorDTO) throws Exception {
        boolean order = cheffBO.getOrder(operatorDTO);
        if (order) {
            notify(operatorDTO.getOid()+"was taken");
            return true;
        }
        return false;
    }

    @Override
    public boolean finishOrder(CheffDTO cheffDTO) throws Exception {
        cheffBO.getCheffDetail(cheffDTO.getE_id());
        boolean finishOrder =cheffBO.finishOrder(cheffDTO);
        if (finishOrder) {
            notify("");
            return true;
        }
        return false;
    }

    @Override
    public String getStartTime(int oid) throws Exception {
        String startTime = cheffBO.getStartTime(oid);
        return startTime;
    }

    @Override
    public boolean delete(int oid) throws Exception {
        boolean delete = cheffBO.delete(oid);
        if (delete) {
            notify("");
            return true;
        }
        return false;
    }

    @Override
    public void register(Observer observer) throws Exception {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) throws Exception {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) throws Exception {
        for (Observer observer : observers) {
            new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    try {
                        observer.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(CheffServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
