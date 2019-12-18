/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore_client.controller;

import lk.ijse.dinemore_client.connector.ProxyHandler;
import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_common.service.custom.LogInService;

/**
 *
 * @author Dell
 */
public class LogInController {
    
    LogInService loginService = ProxyHandler.getInstance().getLogInService();
    
    
    public EmployeeDTO checkUser(EmployeeDTO employeeDTO)throws Exception{
        return loginService.checkUser(employeeDTO);
    }
}
