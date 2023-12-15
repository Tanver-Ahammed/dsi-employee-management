package com.dsi.dao.impl;

import com.dsi.dao.EmployeeDao;
import com.dsi.dao.JDBConnection;
import com.dsi.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static Connection jdbConnection = JDBConnection.getConnection();

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;

    private ResultSet resultSet = null;

    private static String INSERT_EMPLOYEE = "INSERT INTO employee (name, email, contact, address, password," +
            " designation, arrival_date, departure_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";

    private static String SELECT_EMPLOYEE_BY_EMAIL = "SELECT * FROM employee WHERE email = ?";

    private static String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";

    private static String UPDATE_EMPLOYEE = "UPDATE employee SET name = ?, email = ?, contact = ?, address = ?," +
            " password = ?, designation = ?, arrival_date = ?, departure_date = ? WHERE id = ?";

    private static String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";


    @Override
    public boolean addEmployee(Employee employee) throws SQLException {
        this.connection = JDBConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement(INSERT_EMPLOYEE);
        this.preparedStatement.setString(1, employee.getName());
        this.preparedStatement.setString(2, employee.getEmail());
        this.preparedStatement.setString(3, employee.getContact());
        this.preparedStatement.setString(4, employee.getAddress());
        this.preparedStatement.setString(5, employee.getPassword());
        this.preparedStatement.setString(6, employee.getDesignation());
        this.preparedStatement.setString(7, employee.getArrivalDate());
        this.preparedStatement.setString(8, employee.getDepartureDate());
        int affectedRows = this.preparedStatement.executeUpdate();
        this.connection.close();
        this.preparedStatement.close();
        return affectedRows > 0;
    }

    @Override
    public Employee getEmployeeById(int employeeId) throws SQLException {
        this.connection = JDBConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
        this.preparedStatement.setInt(1, employeeId);
        this.resultSet = this.preparedStatement.executeQuery();
        Employee employee = this.resultSetToEmployee(this.resultSet);
        employee.setId(employeeId);
        this.resultSet.close();
        this.connection.close();
        this.preparedStatement.close();
        return employee;
    }

    @Override
    public Employee getEmployeeByEmail(String employeeEmail) throws SQLException {
        this.connection = JDBConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement(SELECT_EMPLOYEE_BY_EMAIL);
        this.preparedStatement.setString(1, employeeEmail);
        this.resultSet = this.preparedStatement.executeQuery();
        Employee employee = this.resultSetToEmployee(this.resultSet);
        this.resultSet.close();
        this.connection.close();
        this.preparedStatement.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        this.connection = JDBConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement(SELECT_ALL_EMPLOYEES);
        this.resultSet = this.preparedStatement.executeQuery();
        List<Employee> employees = new ArrayList<>();
        while (this.resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(this.resultSet.getInt("id"));
            employee.setName(this.resultSet.getString("name"));
            employee.setEmail(this.resultSet.getString("email"));
            employee.setContact(this.resultSet.getString("contact"));
            employee.setAddress(this.resultSet.getString("address"));
            employee.setPassword(this.resultSet.getString("password"));
            employee.setDesignation(this.resultSet.getString("designation"));
            employee.setArrivalDate(this.resultSet.getString("arrival_date"));
            employee.setDepartureDate(this.resultSet.getString("departure_date"));
            employees.add(employee);
        }
        this.resultSet.close();
        this.connection.close();
        this.preparedStatement.close();
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee, int employeeId) throws SQLException {
        this.connection = JDBConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement(UPDATE_EMPLOYEE);
        this.preparedStatement.setString(1, employee.getName());
        this.preparedStatement.setString(2, employee.getEmail());
        this.preparedStatement.setString(3, employee.getContact());
        this.preparedStatement.setString(4, employee.getAddress());
        this.preparedStatement.setString(5, employee.getPassword());
        this.preparedStatement.setString(6, employee.getDesignation());
        this.preparedStatement.setString(7, employee.getArrivalDate());
        this.preparedStatement.setString(8, employee.getDepartureDate());
        this.preparedStatement.setInt(9, employeeId);
        int affectedRows = this.preparedStatement.executeUpdate();
        System.out.println(affectedRows + " updated into database");
        this.connection.close();
        this.preparedStatement.close();
    }

    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        try {
            System.out.println(employeeDao.getEmployeeById(1));
            System.out.println(employeeDao.getEmployeeById(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) throws SQLException {
        this.connection = JDBConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement(DELETE_EMPLOYEE);
        this.preparedStatement.setInt(1, employeeId);
        int affectedRows = this.preparedStatement.executeUpdate();
        this.connection.close();
        this.preparedStatement.close();
        return affectedRows > 0;
    }

    private Employee resultSetToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        while (resultSet.next()) {
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setEmail(resultSet.getString("email"));
            employee.setContact(resultSet.getString("contact"));
            employee.setAddress(resultSet.getString("address"));
            employee.setPassword(resultSet.getString("password"));
            employee.setDesignation(resultSet.getString("designation"));
            employee.setArrivalDate(resultSet.getString("arrival_date"));
            employee.setDepartureDate(resultSet.getString("departure_date"));
        }
        return employee;
    }
}
