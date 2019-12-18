/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.service;

import java.rmi.Remote;
import lk.ijse.dinmore_common.observer.Subject;
import lk.ijse.dinmore_common.reservation.Reserve;

/**
 *
 * @author Dell
 */
public interface SuperService extends Remote, Subject, Reserve{
    
}
