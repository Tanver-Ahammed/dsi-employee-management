package com.dsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(AppsContent.DRIVER);
            connection = DriverManager.getConnection(AppsContent.URL, AppsContent.USER, AppsContent.PASSWORD);
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

}


/**
 * public JDBConnection() {
 * }
 * <p>
 * private static final class ObjHolder {
 * private static final JDBConnection obj = new JDBConnection();
 * }
 * <p>
 * public static JDBConnection getJDBConnection() {
 * //instance will be created at request time
 * return ObjHolder.obj;
 * }
 * <p>
 * public static Connection getConnection() {
 * Connection con = null;
 * try {
 * Class.forName(AppsContent.DRIVER);
 * con = DriverManager.getConnection(AppsContent.URL, AppsContent.USER, AppsContent.PASSWORD);
 * } catch (SQLException | ClassNotFoundException exception) {
 * exception.printStackTrace();
 * }
 * return con;
 * }
 */