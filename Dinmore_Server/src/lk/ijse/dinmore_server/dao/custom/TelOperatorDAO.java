/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao.custom;

import lk.ijse.dinmore_server.dao.CrudDAO;
import lk.ijse.dinmore_server.entity.Order;

/**
 *
 * @author Dell
 */
public interface TelOperatorDAO extends CrudDAO<Order, Integer>{
    public int getOrdeID()throws Exception;
}
