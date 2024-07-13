package com.service;

import com.emolyeeInfo.employee;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


public class employeeServiceImpl implements employeeService { // interface implementation and realisation (polymorphism)

    private List<employee> employees;


    public employeeServiceImpl(List<employee> employees) {
        this.employees = employees;
    }

    @Override
    public void addEmployee(employee e) {
        employees.add(e);
    }

    @Override
    public void editEmployee(int id, employee updatedEmployee) {
        for (employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setRole(updatedEmployee.getRole());
                employee.setSalary(updatedEmployee.getSalary());
                break;
            }
        }
    }

    @Override
    public void fireEmployee(int id) {
        for (employee employee : employees) {
            if (employee.getId() == id) {
                employee.setEndDate(LocalDate.now());
                break;
            }
        }
    }

    @Override
    public employee searchEmployeeById(int id) {
        for (employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<employee> searchEmployeesByName(String name) {
        List<employee> result = new ArrayList<>();
        for (employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public List<employee> searchEmployeesByDepartment(String department) {
        List<employee> result = new ArrayList<>();
        for (employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public List<employee> listActiveEmployees() {
        List<employee> activeEmployees = new ArrayList<>();
        for (employee employee : employees) {
            if (employee.getEndDate() == null) {
                activeEmployees.add(employee);
            }
        }
        return activeEmployees;
    }
}
