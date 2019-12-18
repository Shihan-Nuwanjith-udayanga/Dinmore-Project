/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.dinmore_common.dto.EmployeeDTO;
import lk.ijse.dinmore_server.business.custom.EmployeeBO;
import lk.ijse.dinmore_server.dao.DAOFactory;
import lk.ijse.dinmore_server.dao.DAOTypes;
import lk.ijse.dinmore_server.dao.SuperDAO;
import lk.ijse.dinmore_server.dao.custom.EmployeeDAO;
import lk.ijse.dinmore_server.db.DBConnection;
import lk.ijse.dinmore_server.entity.Employee;

/**
 *
 * @author Dell
 */
public class EmployeeBOImpl implements EmployeeBO{
    
    EmployeeDAO dAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOTypes.EMPLOYEE);

    public EmployeeBOImpl() {
       
    }
    
    

    @Override
    public boolean addEmployee(EmployeeDTO dTO) throws Exception {
         try(Connection connection = DBConnection.getInstance().getConnection()){
             dAO.setConnection(connection);
                return dAO.add(new Employee(
                        dTO.getE_id(),
                        dTO.getE_name(),
                        dTO.getE_passowrd(),
                        dTO.getStatus()));
         }
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dTO) throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
             dAO.setConnection(connection);
                return dAO.update(new Employee(
                        dTO.getE_id(),
                        dTO.getE_name(),
                        dTO.getE_passowrd(),
                        dTO.getStatus()));
         }
    }

    @Override
    public boolean delete(int e_id) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dAO.setConnection(connection);
            return dAO.delete(e_id);
        }
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
            dAO.setConnection(connection);
            ArrayList<Employee> all = dAO.getAll();
            ArrayList<EmployeeDTO> arrayList = new ArrayList<>();
            for(Employee employee:all){
                arrayList.add(new EmployeeDTO(
                    employee.getE_id(),
                    employee.getE_name(),
                    employee.getE_passowrd(),
                    employee.getStatus()));
            }
            return arrayList;
        }
    }

    @Override
    public int getEmployeeID() throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
            dAO.setConnection(connection);
            return dAO.getEmployeeID();
        }
    }
    
}
