/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business.custom;

import java.util.ArrayList;
import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_server.business.SuperBO;

/**
 *
 * @author Dell
 */
public interface EmployeeBO extends SuperBO{
     public boolean addEmployee(EmployeeDTO dTO) throws Exception;

    public boolean updateEmployee(EmployeeDTO dTO) throws Exception;

    public boolean delete(int oid) throws Exception;

    public ArrayList<EmployeeDTO> getAllEmployee() throws Exception;
    
    public int getEmployeeID()throws Exception;
}
