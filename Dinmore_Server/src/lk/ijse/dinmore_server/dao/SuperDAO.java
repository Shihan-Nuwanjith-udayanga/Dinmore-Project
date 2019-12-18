/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao;

import java.sql.Connection;

/**
 *
 * @author Dell
 */
public interface SuperDAO {

    public void setConnection(Connection connection) throws Exception;
}
