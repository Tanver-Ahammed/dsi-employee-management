package com.dsi.dao.impl;

import com.dsi.dao.EmployeeDao;
import com.dsi.dao.JDBConnection;
import com.dsi.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private JDBConnection jdbConnection = JDBConnection.getJDBConnection();

    private Connection connection;

    private PreparedStatement preparedStatement;


    @Override
    public void addEmployee() {

    }

    @Override
    public Employee getEmployee() {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void deleteEmployee() {

    }
}
