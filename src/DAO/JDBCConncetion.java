/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thitipong
 */
public class JDBCConncetion {

    static final String DB_URL = "jdbc:mysql://localhost:3306/scb_db";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "root";
    static final String DB_PASSWD = "password";

    public Connection getConnection() {
        Connection connection = null;
        // connection db
        try {
            String connectionURL = DB_URL;
            Class.forName(DB_DRV).newInstance();
            connection = DriverManager.getConnection(connectionURL, DB_USER, DB_PASSWD);
            if (connection != null) {
                System.out.println("Database Connected.");
            } else {
                System.out.println("Database Connect Failed.");
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            e.getLocalizedMessage();
            e.printStackTrace();
        }
        return connection;
    }
}
