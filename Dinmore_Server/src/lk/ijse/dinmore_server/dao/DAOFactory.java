/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao;

import lk.ijse.dinmore_server.dao.custom.impl.CheffDAOImpl;
import lk.ijse.dinmore_server.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.dinmore_server.dao.custom.impl.LogInDAOImpl;
import lk.ijse.dinmore_server.dao.custom.impl.TelOperatorDAOImpl;

/**
 *
 * @author Dell
 */
public class DAOFactory {
    private static DAOFactory dAOFactory;

    private DAOFactory() {
    }
    
   public static DAOFactory getInstance(){
       return (dAOFactory==null)? (dAOFactory=new DAOFactory()):dAOFactory;
   }
   public SuperDAO getDAO(DAOTypes dAOTypes){
       switch (dAOTypes){
           case TELOPERATOR:
               return new TelOperatorDAOImpl();
           case EMPLOYEE:
               return new EmployeeDAOImpl();
           case LOGIN:
               return new LogInDAOImpl();
           case CHEFF:
               return new CheffDAOImpl();
            default:
                return null;
       }
   }
}
