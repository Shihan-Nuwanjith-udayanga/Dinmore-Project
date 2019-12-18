/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.service.custom;

import lk.ijse.dinmore_common.dto.CheffDTO;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_common.service.SuperService;

/**
 *
 * @author Dell
 */
public interface CheffService extends SuperService {

    public boolean getOrder(TelOperatorDTO operatorDTO) throws Exception;

    public boolean finishOrder(CheffDTO cheffDTO) throws Exception;

    public String getStartTime(int oid) throws Exception;

    public boolean delete(int oid) throws Exception;
}
