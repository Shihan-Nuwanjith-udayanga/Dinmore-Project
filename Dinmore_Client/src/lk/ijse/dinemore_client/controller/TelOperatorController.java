/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore_client.controller;

import java.util.ArrayList;
import lk.ijse.dinemore_client.connector.ProxyHandler;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_common.service.custom.TelOperatorService;

/**
 *
 * @author Dell
 */
public class TelOperatorController {
    TelOperatorService teleOperatorService = ProxyHandler.getInstance().getTelOperatorService();
    
    public boolean addOrder(TelOperatorDTO operatorDTO) throws Exception{
        return teleOperatorService.addOrder(operatorDTO);
    }
    
    public boolean updateOrder(TelOperatorDTO operatorDTO) throws Exception{
        return teleOperatorService.updateOrder(operatorDTO);
    }
    public boolean deleteOrder(int oid) throws Exception{
        return teleOperatorService.deleteOrder(oid);
    }
    public ArrayList<TelOperatorDTO> getAllOrder() throws Exception{
        return teleOperatorService.getAllOrder();
    }
    public int getOrderID()throws Exception{
        return teleOperatorService.getOderID();
    }
}
