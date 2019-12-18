/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.observer;

import java.rmi.Remote;

/**
 *
 * @author Dell
 */
public interface Subject extends Remote{
    public void register(Observer observer) throws Exception;

    public void remove(Observer observer) throws Exception;

    public void notify(String message) throws Exception;
}
