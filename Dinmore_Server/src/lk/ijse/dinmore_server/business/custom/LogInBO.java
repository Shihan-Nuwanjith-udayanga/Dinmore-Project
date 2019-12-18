/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business.custom;

import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_server.business.SuperBO;

/**
 *
 * @author Dell
 */
public interface LogInBO extends SuperBO{
    public EmployeeDTO checkUser(EmployeeDTO employeeDTO)throws Exception;
}
