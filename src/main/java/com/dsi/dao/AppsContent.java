package com.dsi.dao;

public class AppsContent {

    protected static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected static final String URL = "jdbc:mysql://localhost/dsi";

    protected static final String USER = "root";

    protected static final String PASSWORD = "12345";

    protected static final String INSERT_QUERY = "INSERT INTO `dsi`.`employee` (`name`, `email`, `contact`," +
            " `address`, `password`, `designation`, `arrival_date`, `departure_date`)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";


}
