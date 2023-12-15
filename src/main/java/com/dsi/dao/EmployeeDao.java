package com.dsi.dao;

import com.dsi.entities.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    boolean addEmployee(Employee employee) throws SQLException;

    Employee getEmployeeById(int employeeId) throws SQLException;

    Employee getEmployeeByEmail(String employeeEmail) throws SQLException;

    List<Employee>getAllEmployees() throws SQLException;

    void updateEmployee(Employee employee, int employeeId) throws SQLException;

    boolean deleteEmployee(int employeeId) throws SQLException;

}
