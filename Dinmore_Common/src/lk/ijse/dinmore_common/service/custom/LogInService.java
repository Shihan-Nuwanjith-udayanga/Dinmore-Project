/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.service.custom;

import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_common.service.SuperService;

/**
 *
 * @author Dell
 */
public interface LogInService extends SuperService{
    public EmployeeDTO checkUser(EmployeeDTO employeeDTO)throws Exception;
}
