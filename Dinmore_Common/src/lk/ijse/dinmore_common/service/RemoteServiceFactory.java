/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.service;

import java.rmi.Remote;

/**
 *
 * @author Dell
 */
public interface RemoteServiceFactory extends Remote {

    public SuperService getService(ServiceTypes serviceTypes) throws Exception;
}
