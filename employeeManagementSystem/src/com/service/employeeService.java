package com.service;

import com.emolyeeInfo.employee;

import java.util.List;

public interface employeeService { //using interface to level up the abstraction
    void addEmployee(employee e);
    void editEmployee(int id, employee updatedEmployee);
    void fireEmployee(int id);
    employee searchEmployeeById(int id);
    List<employee> searchEmployeesByName(String name);
    List<employee> searchEmployeesByDepartment(String department);
    List<employee> listActiveEmployees();
}
