/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Dell
 */
public class DBConnection {

    private static DBConnection dBConnection;
    private BasicDataSource bds;

    private DBConnection() {
        bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/dinmore");
        bds.setUsername("root");
        bds.setPassword("nuwanjith");
        bds.setInitialSize(4);
        bds.setMaxTotal(4);
    }

    public static DBConnection getInstance() {
        return (dBConnection == null) ? (dBConnection = new DBConnection()) : dBConnection;
    }

    public Connection getConnection() throws SQLException {
        return bds.getConnection();
    }
}
