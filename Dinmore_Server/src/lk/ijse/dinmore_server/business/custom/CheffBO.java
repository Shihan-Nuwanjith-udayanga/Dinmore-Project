/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business.custom;

import lk.ijse.dinmore_common.dto.CheffDTO;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_server.business.SuperBO;
import lk.ijse.dinmore_server.entity.Cheff;

/**
 *
 * @author Dell
 */
public interface CheffBO extends SuperBO{
    public Cheff getCheffDetail(int eid)throws Exception;
    
    public boolean finishOrder(CheffDTO cheffDTO)throws Exception;
    
    public boolean getOrder(TelOperatorDTO operatorDTO)throws Exception;
   
    public String getStartTime(int oid)throws Exception;
    
    public boolean delete(int oid)throws Exception;}
