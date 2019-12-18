/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business.custom.impl;

import java.sql.Connection;
import lk.ijse.dinmore_common.dto.CheffDTO;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_server.business.custom.CheffBO;
import lk.ijse.dinmore_server.dao.DAOFactory;
import lk.ijse.dinmore_server.dao.DAOTypes;
import lk.ijse.dinmore_server.dao.custom.CheffDAO;
import lk.ijse.dinmore_server.db.DBConnection;
import lk.ijse.dinmore_server.entity.Cheff;
import lk.ijse.dinmore_server.entity.Finish;
import lk.ijse.dinmore_server.entity.Order;

/**
 *
 * @author Dell
 */
public class CheffBOImpl implements CheffBO{

    CheffDAO cheffDAO  = (CheffDAO) DAOFactory.getInstance().getDAO(DAOTypes.CHEFF);
    private int totalOrders;
    private int totalQty;
    private String date;
    private String totalDuration;
    

    @Override
    public Cheff getCheffDetail(int eid) throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
            cheffDAO.setConnection(connection);
            Cheff cheff = cheffDAO.getCheffDetails(eid);
            System.out.println("Cheff BO : "+cheff);
            totalOrders = cheff.getTotalOrders();
            totalQty = cheff.getTotalQty();
            totalDuration= cheff.getTotalTime();
            return cheff;
        }
    }

    @Override
    public boolean finishOrder(CheffDTO cheffDTO) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        try{
            cheffDAO.setConnection(connection);
            connection.setAutoCommit(false);
            boolean finishOrder = cheffDAO.finishOrder(new Finish(
                    cheffDTO.getOid(),
                    cheffDTO.getE_id(),
                    cheffDTO.getCustomer_name(),
                    cheffDTO.getCustomer_contact(),
                    cheffDTO.getFood(),
                    cheffDTO.getQty(),
                    cheffDTO.getDuration()
            ));
            if (finishOrder) {
                totalOrders = totalOrders +1;
                totalQty = totalQty + cheffDTO.getQty();
                boolean updateCheff = cheffDAO.updateCheff(new Cheff(cheffDTO.getE_id(), totalOrders , totalQty, date, "1:0:0"));
                if (updateCheff) {
                    connection.commit();
                    return true;
                }
            }else{
                connection.rollback();
                return false;
            }
        }finally{
            connection.setAutoCommit(true);
            return true;
    }
}

    @Override
    public boolean getOrder(TelOperatorDTO operatorDTO) throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
            cheffDAO.setConnection(connection);
            return cheffDAO.getOrder(new Order(operatorDTO.getOid(),operatorDTO.getTime()));
        }
    }

    @Override
    public String getStartTime(int oid) throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
            cheffDAO.setConnection(connection);
            String startTime = cheffDAO.getStartTime(oid);
            return startTime;
        }
    }

    @Override
    public boolean delete(int oid) throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
            cheffDAO.setConnection(connection);
            return cheffDAO.delete(oid);
        }
    }
    
}
