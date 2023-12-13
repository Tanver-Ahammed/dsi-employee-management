package com.dsi.dao;

import com.dsi.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    void addEmployee();

    Employee getEmployee();

    List<Employee>getAllEmployees();

    void updateEmployee();

    void deleteEmployee();

}
