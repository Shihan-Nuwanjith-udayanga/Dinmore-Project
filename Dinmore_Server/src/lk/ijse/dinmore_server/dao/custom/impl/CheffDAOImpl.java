/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalTime;
import lk.ijse.dinmore_server.dao.CrudUtil;
import lk.ijse.dinmore_server.dao.custom.CheffDAO;
import lk.ijse.dinmore_server.entity.Cheff;
import lk.ijse.dinmore_server.entity.Finish;
import lk.ijse.dinmore_server.entity.Order;

/**
 *
 * @author Dell
 */
public class CheffDAOImpl implements CheffDAO{
    private Connection connection;

    @Override
    public boolean updateCheff(Cheff cheff) throws Exception {
        System.out.println("update cheff:" + cheff);
        return CrudUtil.execute("UPDATE cheff SET totalOrders=?,totalQty=?,date=?,totalTime=? WHERE e_id=?" ,connection,
                cheff.getTotalOrders(),
                cheff.getTotalQty(),
                cheff.getDate(),
                cheff.getTotalTime(),
                cheff.getE_id());
    }

    @Override
    public boolean finishOrder(Finish finish) throws Exception {
        return CrudUtil.execute("INSERT INTO finish VALUES(?,?,?,?,?,?,?)", connection, 
                finish.getOid(),
                finish.getE_id(),
                finish.getCustomer_name(),
                finish.getCustomer_contact(),
                finish.getFood(),
                finish.getQty(),
                finish.getDuration(),"1");
    }

    @Override
    public boolean getOrder(Order order) throws Exception {
        System.out.println("Set Time DAO : "+order);
        return CrudUtil.execute("UPDATE orders SET time=? WHERE oid=?", connection, 
                order.getTime(),
                order.getOid());
    }

    @Override
    public Cheff getCheffDetails(int eid) throws Exception {
        ResultSet set  = CrudUtil.execute("SELECT * FROM cheff WHERE e_id=?", connection, eid);
        System.out.println("Cheff Details");
        if (set.next()) {
            System.out.println("CHEFF DAO : 1");
            Cheff cheff = new Cheff(set.getInt(1),set.getInt(2),set.getInt(3),set.getString(4),set.getString(5));
            System.out.println("CHEFF DAO : "+cheff);
            return cheff;
        }
        return null;
    }

    @Override
    public String getStartTime(int oid) throws Exception {
        ResultSet rs = CrudUtil.execute("SELECT Time FROM orders WHERE oid=?", connection, oid);
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    @Override
    public boolean delete(int oid) throws Exception {
        return CrudUtil.execute("DELETE FROM orders Where oid=?", connection, oid);
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }
    
}
