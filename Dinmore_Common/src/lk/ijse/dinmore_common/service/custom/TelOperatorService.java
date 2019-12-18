/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.service.custom;

import java.util.ArrayList;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_common.service.SuperService;

/**
 *
 * @author Dell
 */
public interface TelOperatorService extends SuperService{

    public boolean addOrder(TelOperatorDTO dTO) throws Exception;

    public boolean updateOrder(TelOperatorDTO dTO) throws Exception;

    public boolean deleteOrder(int Oid) throws Exception;

    public ArrayList<TelOperatorDTO> getAllOrder() throws Exception;
    
    public int getOderID()throws Exception;
}
