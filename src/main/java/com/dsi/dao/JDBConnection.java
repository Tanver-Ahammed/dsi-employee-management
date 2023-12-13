package com.dsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {

    public JDBConnection() {
    }

    private static final class ObjHolder {
        private static final JDBConnection obj = new JDBConnection();
    }

    public static JDBConnection getJDBConnection() {
        //instance will be created at request time
        return ObjHolder.obj;
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(AppsContent.DRIVER);
            con = DriverManager.getConnection(AppsContent.URL, AppsContent.USER, AppsContent.PASSWORD);
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return con;
    }

}
