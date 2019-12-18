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
import lk.ijse.dinmore_server.dao.custom.TelOperatorDAO;
import lk.ijse.dinmore_server.entity.Order;

/**
 *
 * @author Dell
 */
public class TelOperatorDAOImpl implements TelOperatorDAO {
    
    private Connection connection;
    
    @Override
    public boolean add(Order t) throws Exception {
        return CrudUtil.execute("INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)", connection,
                t.getOid(),
                t.getE_id(),
                t.getCustomer_name(),
                t.getCustomer_contact(),
                t.getFood(),
                t.getQty(),
                t.getTime(),
                t.getDate());
    }
    
    @Override
    public boolean update(Order t) throws Exception {
        return CrudUtil.execute("UPDATE orders SET e_id=?,customer_name=?,customer_contact=?,food=?,qty=?,time=?,date=? WHERE oid=?", connection,
                t.getE_id(),
                t.getCustomer_name(),
                t.getCustomer_contact(),
                t.getFood(),
                t.getQty(),
                t.getTime(),
                t.getDate());
    }
    
    @Override
    public Order search(Integer id) throws Exception {
        return CrudUtil.execute("SELECT * FROM orders WHERE oid=?", connection, id);
    }
    
    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.execute("DELETE FROM orders WHERE oid=?", connection, id);
    }
    
    @Override
    public ArrayList<Order> getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM orders", connection);
        ArrayList<Order> arrayList = new ArrayList<>();
        while (rst.next()) {            
            arrayList.add(new Order(
                    rst.getInt(1),
                    rst.getInt(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getInt(6),
                    rst.getString(7),
                    rst.getString(8)
            ));
        }
        return arrayList;
    }
    
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public int getOrdeID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT oid FROM orders ORDER BY oid DESC LIMIT 1", connection);
        if (rst.next()) {
            int oid = rst.getInt(1);
            oid++;
            return oid;
        }else{
            return 1;
        }
        
    }
    
}
