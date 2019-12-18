/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.main.service;

import java.rmi.server.UnicastRemoteObject;
import lk.ijse.dinmore_common.service.RemoteServiceFactory;
import lk.ijse.dinmore_common.service.ServiceTypes;
import lk.ijse.dinmore_common.service.SuperService;
import lk.ijse.dinmore_server.main.service.custom.impl.CheffServiceImpl;
import lk.ijse.dinmore_server.main.service.custom.impl.EmployeeServiceImpl;
import lk.ijse.dinmore_server.main.service.custom.impl.LogInServiceImpl;
import lk.ijse.dinmore_server.main.service.custom.impl.TelOperatorServiceImpl;

/**
 *
 * @author Dell
 */
public class ServiceFactory extends UnicastRemoteObject implements RemoteServiceFactory{
    
    private static ServiceFactory serviceFactory;
    private ServiceFactory()throws Exception{
        
    }

    public static ServiceFactory getInstance() throws Exception {
        return (serviceFactory== null)?(serviceFactory=new ServiceFactory()):serviceFactory;
    }
    @Override
    public SuperService getService(ServiceTypes serviceTypes) throws Exception {
        switch(serviceTypes){
            case TELOPERATOR:
                return new TelOperatorServiceImpl();
            case EMPLOYEE:
                return new EmployeeServiceImpl();
            case LOGIN:
                return new LogInServiceImpl();
            case CHEFF:
                return new CheffServiceImpl();
            default:
                return null;
        }
    }
    
}
