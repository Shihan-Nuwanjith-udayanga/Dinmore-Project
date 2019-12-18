/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao.custom;

import lk.ijse.dinmore_server.dao.SuperDAO;
import lk.ijse.dinmore_server.entity.Cheff;
import lk.ijse.dinmore_server.entity.Finish;
import lk.ijse.dinmore_server.entity.Order;

/**
 *
 * @author Dell
 */
public interface CheffDAO extends SuperDAO{
    public boolean updateCheff(Cheff cheff)throws Exception;
    
    public boolean finishOrder(Finish finish)throws Exception;
    
    public boolean getOrder(Order order)throws Exception;
    
    public Cheff getCheffDetails(int eid)throws Exception;
    
    public String getStartTime(int oid)throws Exception;
    
    public boolean delete(int oid)throws Exception;
    
}
