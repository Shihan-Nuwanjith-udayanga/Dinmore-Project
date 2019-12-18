/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.dinmore_common.dto.TelOperatorDTO;
import lk.ijse.dinmore_server.business.custom.TelOperatorBO;
import lk.ijse.dinmore_server.dao.DAOFactory;
import lk.ijse.dinmore_server.dao.DAOTypes;
import lk.ijse.dinmore_server.dao.custom.TelOperatorDAO;
import lk.ijse.dinmore_server.db.DBConnection;
import lk.ijse.dinmore_server.entity.Order;

/**
 *
 * @author Dell
 */
public class TelOperatorBOImpl implements TelOperatorBO {

    TelOperatorDAO operatorDAO = (TelOperatorDAO) DAOFactory.getInstance().getDAO(DAOTypes.TELOPERATOR);

    public TelOperatorBOImpl() {

    }

    @Override
    public boolean addOrder(TelOperatorDTO dTO) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            operatorDAO.setConnection(connection);
            return operatorDAO.add(new Order(
                    dTO.getOid(),
                    dTO.getE_id(),
                    dTO.getCustomer_name(),
                    dTO.getCustomer_contact(),
                    dTO.getFood(),
                    dTO.getQty(),
                    dTO.getTime(),
                    dTO.getDate()));
        }
    }

    @Override
    public boolean updateOrder(TelOperatorDTO dTO) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            operatorDAO.setConnection(connection);
            return operatorDAO.update(new Order(
                    dTO.getOid(),
                    dTO.getE_id(),
                    dTO.getCustomer_name(),
                    dTO.getCustomer_contact(),
                    dTO.getFood(),
                    dTO.getQty(),
                    dTO.getTime(),
                    dTO.getDate()));
        }
    }

    @Override
    public boolean deleteOrder(int oid) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            operatorDAO.setConnection(connection);
            return operatorDAO.delete(oid);
        }
    }

    @Override
    public ArrayList<TelOperatorDTO> getAllOrder() throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            operatorDAO.setConnection(connection);
            ArrayList<Order> all = operatorDAO.getAll();
            ArrayList<TelOperatorDTO> orderList = new ArrayList<>();
            for (Order order : all) {
                orderList.add(new TelOperatorDTO(
                        order.getOid(),
                        order.getE_id(),
                        order.getCustomer_name(),
                        order.getCustomer_contact(),
                        order.getFood(),
                        order.getQty(),
                        order.getTime(),
                        order.getDate()));
            }
            return orderList;
        }
    }

    @Override
    public int getOderID() throws Exception {
        try(Connection connection = DBConnection.getInstance().getConnection()){
            operatorDAO.setConnection(connection);
            return operatorDAO.getOrdeID();
        }
    }
}
