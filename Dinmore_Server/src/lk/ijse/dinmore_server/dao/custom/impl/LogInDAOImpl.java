/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import lk.ijse.dinmore_server.dao.CrudUtil;
import lk.ijse.dinmore_server.dao.custom.LogInDAO;
import lk.ijse.dinmore_server.entity.Employee;

/**
 *
 * @author Dell
 */
public class LogInDAOImpl implements LogInDAO{
    
    private Connection connection;

    @Override
    public Employee checkUser(Employee employee) throws Exception {
         ResultSet rst = CrudUtil.execute("SELECT * FROM employee WHERE e_name=? and e_password=?", connection,
                 employee.getE_name(),
                 employee.getE_passowrd());
        if (rst.next()) {
            return new Employee(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }
        return null;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }
    
}
