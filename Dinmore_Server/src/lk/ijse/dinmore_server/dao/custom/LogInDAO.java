/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao.custom;

import lk.ijse.dinmore_server.dao.SuperDAO;
import lk.ijse.dinmore_server.entity.Employee;

/**
 *
 * @author Dell
 */
public interface LogInDAO extends SuperDAO {

    public Employee checkUser(Employee employee) throws Exception;
}
