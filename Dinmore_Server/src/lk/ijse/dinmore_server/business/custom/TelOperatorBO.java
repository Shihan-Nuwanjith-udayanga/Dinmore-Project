/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business.custom;

import java.util.ArrayList;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_server.business.SuperBO;

/**
 *
 * @author Dell
 */
public interface TelOperatorBO extends SuperBO {

    public boolean addOrder(TelOperatorDTO dTO) throws Exception;

    public boolean updateOrder(TelOperatorDTO dTO) throws Exception;

    public boolean deleteOrder(int e_id) throws Exception;

    public ArrayList<TelOperatorDTO> getAllOrder() throws Exception;
    
    public int getOderID()throws Exception;
}
