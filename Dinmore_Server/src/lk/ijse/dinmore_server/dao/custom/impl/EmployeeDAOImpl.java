/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.dinmore_server.dao.CrudUtil;
import lk.ijse.dinmore_server.dao.custom.EmployeeDAO;
import lk.ijse.dinmore_server.entity.Employee;

/**
 *
 * @author Dell
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    
    private Connection connection;

    @Override
    public int getEmployeeID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT e_id FROM employee ORDER BY e_id DESC LIMIT 1", connection);
        if (rst.next()) {
            int e_id = rst.getInt(1);
            e_id++;
            return e_id;
        }else{
            return 1;
        }
    }

    @Override
    public boolean add(Employee t) throws Exception {
        return CrudUtil.execute("INSERT INTO employee VALUES(?,?,?,?)", connection,
                t.getE_id(),
                t.getE_name(),
                t.getE_passowrd(),
                t.getStatus());
    }

    @Override
    public boolean update(Employee t) throws Exception {
        return CrudUtil.execute("UPDATE employee SET e_id=?, e_name=? , e_password=?, status=? WHERE e_id=? ", connection,
                t.getE_id(),
                t.getE_name(),
                t.getE_passowrd(),
                t.getStatus(),
                t.getE_id());
    }

    @Override
    public Employee search(Integer id) throws Exception {
        return CrudUtil.execute("SELECT * FROM orders WHERE e_id=?", connection, id);
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.execute("DELETE FROM employee WHERE e_id=?", connection, id);
    }

    @Override
    public ArrayList<Employee> getAll() throws Exception {
        ResultSet rst  = CrudUtil.execute("SELECT * FROM employee", connection);
        ArrayList<Employee> arrayList = new ArrayList<>();
        while(rst.next()){
            arrayList.add(new Employee(
                rst.getInt(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4)
            ));
        }
        return arrayList;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }
}
