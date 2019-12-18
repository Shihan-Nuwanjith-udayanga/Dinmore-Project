/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinmore_server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class CrudUtil {
    public static <T>T execute(String sql, Connection connection, Object... param) throws SQLException{
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        for (int i = 0; i < param.length; i++) {
            pstm.setObject(i+1,param[i]);
        }
        
        if (sql.startsWith("SELECT")) {
            return (T) pstm.executeQuery();
        }
        return (T) ((Boolean)(pstm.executeUpdate()>0));
    }
}
