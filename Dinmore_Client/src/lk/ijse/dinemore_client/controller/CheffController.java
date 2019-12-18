/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore_client.controller;

import lk.ijse.dinemore_client.connector.ProxyHandler;
import lk.ijse.dinmore_common.dto.CheffDTO;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_common.service.custom.CheffService;

/**
 *
 * @author Dell
 */
public class CheffController {
    CheffService cheffService = ProxyHandler.getInstance().getCheffService();
    
    public boolean getOrder(TelOperatorDTO operatorDTO)throws Exception{
        return cheffService.getOrder(operatorDTO);
    }
    
    public boolean finishOrder(CheffDTO cheffDTO)throws Exception{
        return cheffService.finishOrder(cheffDTO);
    }
    
    public String getStartTime(int oid)throws Exception{
        String startTime = cheffService.getStartTime(oid);
        return startTime;
    }
    
    public boolean delete (int oid)throws Exception{
        return cheffService.delete(oid);
    }
    
}
