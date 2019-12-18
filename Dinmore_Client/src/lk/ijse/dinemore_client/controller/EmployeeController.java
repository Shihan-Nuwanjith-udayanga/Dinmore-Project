/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore_client.controller;

import java.util.ArrayList;
import lk.ijse.dinemore_client.connector.ProxyHandler;
import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_common.service.custom.EmployeeService;
import lk.ijse.dinmore_common.service.custom.TelOperatorService;

/**
 *
 * @author Dell
 */
public class EmployeeController {
    
    EmployeeService employeeService = ProxyHandler.getInstance().getEmployeeService();

    
    public boolean addEmployee(EmployeeDTO employeeDTO) throws Exception{
        return employeeService.addEmployee(employeeDTO);
    }
    
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws Exception{
        return employeeService.updateEmployee(employeeDTO);
    }
    public boolean deleteEmployee(int e_id) throws Exception{
        return employeeService.deleteEmployee(e_id);
    }
    public ArrayList<EmployeeDTO> getAllEmployee() throws Exception{
        return employeeService.getAllEmployee();
    }
    public int getEmployeeID()throws Exception{
        return employeeService.getEmployeeID();
    }
}
