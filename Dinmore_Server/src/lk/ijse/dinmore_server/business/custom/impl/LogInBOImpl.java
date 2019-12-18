/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business.custom.impl;

import java.sql.Connection;
import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_server.business.custom.LogInBO;
import lk.ijse.dinmore_server.dao.DAOFactory;
import lk.ijse.dinmore_server.dao.DAOTypes;
import lk.ijse.dinmore_server.dao.SuperDAO;
import lk.ijse.dinmore_server.dao.custom.LogInDAO;
import lk.ijse.dinmore_server.db.DBConnection;
import lk.ijse.dinmore_server.entity.Employee;

/**
 *
 * @author Dell
 */
public class LogInBOImpl implements LogInBO{
    
    LogInDAO loginDAO  = (LogInDAO) DAOFactory.getInstance().getDAO(DAOTypes.LOGIN);
    

    @Override
    public EmployeeDTO checkUser(EmployeeDTO employeeDTO) throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
            loginDAO.setConnection(connection);
            Employee login = loginDAO.checkUser(new Employee(employeeDTO.getE_id(),employeeDTO.getE_name(),employeeDTO.getE_passowrd(),employeeDTO.getStatus()));
            EmployeeDTO eDTO = new EmployeeDTO(login.getE_id(),login.getE_name(),login.getE_passowrd(),login.getStatus());
            System.out.println("Log IN DTO : "+eDTO);
            return eDTO;
        }
    }
    
}
