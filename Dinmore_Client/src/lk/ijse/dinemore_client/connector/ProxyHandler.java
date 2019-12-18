/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore_client.connector;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinmore_common.service.RemoteServiceFactory;
import lk.ijse.dinmore_common.service.ServiceTypes;
import lk.ijse.dinmore_common.service.SuperService;
import lk.ijse.dinmore_common.service.custom.CheffService;
import lk.ijse.dinmore_common.service.custom.EmployeeService;
import lk.ijse.dinmore_common.service.custom.LogInService;
import lk.ijse.dinmore_common.service.custom.TelOperatorService;

/**
 *
 * @author Dell
 */
public class ProxyHandler {

    public static ProxyHandler proxyHandler;
    private TelOperatorService operatorService;
    private EmployeeService employeeService;
    private LogInService logInService;
    private CheffService cheffService;

    private ProxyHandler() {
        try {
            RemoteServiceFactory lookup = (RemoteServiceFactory) Naming.lookup("rmi://localhost:5050/Dinmore");
            operatorService = (TelOperatorService) lookup.getService(ServiceTypes.TELOPERATOR);
            employeeService  = (EmployeeService) lookup.getService(ServiceTypes.EMPLOYEE);
            logInService = (LogInService) lookup.getService(ServiceTypes.LOGIN);
            cheffService = (CheffService) lookup.getService(ServiceTypes.CHEFF);

        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ProxyHandler getInstance() {
        return (proxyHandler == null) ? (proxyHandler = new ProxyHandler()) : proxyHandler;
    }

    public TelOperatorService getTelOperatorService() {
        return operatorService;
    }
    
    public EmployeeService getEmployeeService(){
        return employeeService;
    }
    
    public LogInService getLogInService(){
        return logInService;
    }
    
    public CheffService getCheffService(){
        return cheffService;
    }
}
