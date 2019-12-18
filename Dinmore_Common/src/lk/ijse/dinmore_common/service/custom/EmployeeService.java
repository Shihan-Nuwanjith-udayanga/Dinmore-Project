/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_common.service.custom;

import java.util.ArrayList;
import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_common.service.SuperService;

/**
 *
 * @author Dell
 */
public interface EmployeeService extends SuperService{
    public boolean addEmployee(EmployeeDTO dTO) throws Exception;

    public boolean updateEmployee(EmployeeDTO dTO) throws Exception;

    public boolean deleteEmployee(int e_id) throws Exception;

    public ArrayList<EmployeeDTO> getAllEmployee() throws Exception;
    
    public int getEmployeeID()throws Exception;
}
