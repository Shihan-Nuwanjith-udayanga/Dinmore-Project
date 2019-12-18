/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business;

import lk.ijse.dinmore_server.business.custom.impl.CheffBOImpl;
import lk.ijse.dinmore_server.business.custom.impl.EmployeeBOImpl;
import lk.ijse.dinmore_server.business.custom.impl.LogInBOImpl;
import lk.ijse.dinmore_server.business.custom.impl.TelOperatorBOImpl;

/**
 *
 * @author Dell
 */
public class BOFactory {

    private static BOFactory bOFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        return (bOFactory == null) ? (bOFactory = new BOFactory()) : bOFactory;
    }

    public SuperBO getBO(BOTypes bOTypes) {
        switch (bOTypes) {
            case TELOPERATOR:
                return new TelOperatorBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case LOGIN:
                return new LogInBOImpl();
            case CHEFF:
                return new CheffBOImpl();
            default:
                return null;
        }
    }
}
