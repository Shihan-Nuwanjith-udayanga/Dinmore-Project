/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.reservation;

import java.rmi.Remote;

/**
 *
 * @author Dell
 */
public interface Reserve extends Remote{
    public boolean reserve(Object key)throws Exception;
    public boolean release(Object key)throws Exception;
}
