package com.manager;

import com.emolyeeInfo.employee;
import com.emolyeeInfo.fullTimeEmployee;
import com.emolyeeInfo.partTimeEmployee;
import com.exceptions.exceptionMessages;
import com.service.employeeService;
import com.fileOps.CSVWriter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class employeeManager {

    private final employeeService service; // polymorphism
    private static final Scanner scanner = new Scanner(System.in); //encapsulation

    public employeeManager(employeeService service) {
        this.service = service;
    }

    public void displayCommands() {
        System.out.println("Available commands:");
        System.out.println("1. Add Employee");
        System.out.println("2. Edit Employee");
        System.out.println("3. Fire Employee");
        System.out.println("4. List Employees");
        System.out.println("5. Search Employee by ID");
        System.out.println("6. Search Employees by Name");
        System.out.println("7. Search Employees by Department");
        System.out.println("8. Save & Exit");
    }

    public void executeCommand(String command) {
        switch (command.toLowerCase()) {
            case "1":
                addEmployee();
                break;
            case "2":
                editEmployee();
                break;
            case "3":
                fireEmployee();
                break;
            case "4":
                listEmployees();
                break;
            case "5":
                searchEmployeeById();
                break;
            case "6":
                searchEmployeesByName();
                break;
            case "7":
                searchEmployeesByDepartment();
                break;
            case "8":
                saveAndExit();
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    private void addEmployee() {
        System.out.println("Choose Employee Type (1: FullTime, 2: PartTime):");
        String type = scanner.nextLine().trim();
        try {
            System.out.println("Enter employee details: ");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Department: ");
            String department = scanner.nextLine().trim();
            System.out.print("Role: ");
            String role = scanner.nextLine().trim();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine().trim());
            if (type.equals("1")) { // FullTimeEmployee
                System.out.print("Bonus: ");
                double bonus = Double.parseDouble(scanner.nextLine().trim());
                fullTimeEmployee employee = new fullTimeEmployee(id, name, LocalDate.now(), department, role, salary, bonus);
                service.addEmployee(employee);
                System.out.println("Employee added successfully: " + employee.toString());
            } else if (type.equals("2")) { // PartTimeEmployee
                System.out.print("Hours per Week: ");
                int hoursPerWeek = Integer.parseInt(scanner.nextLine().trim());
                partTimeEmployee employee = new partTimeEmployee(id, name, LocalDate.now(), department, role, salary, hoursPerWeek);
                service.addEmployee(employee);
                System.out.println("Employee added successfully: " + employee.toString());
            } else {
                System.out.println("Invalid employee type.");
            }
        } catch (Exception e) {
            System.out.println(exceptionMessages.ERROR_ADDING_EMPLOYEE + e.getMessage());
        }
    }

    private void editEmployee() {
        System.out.println("Enter employee ID to edit:");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter new details: ");
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Department: ");
            String department = scanner.nextLine().trim();
            System.out.print("Role: ");
            String role = scanner.nextLine().trim();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine().trim());
            employee updatedEmployee = new employee(id, name, LocalDate.now(), department, role, salary);
            service.editEmployee(id, updatedEmployee);
            System.out.println("Employee updated successfully.");
        } catch (Exception e) {
            System.out.println(exceptionMessages.ERROR_EDITING_EMPLOYEE + e.getMessage());
        }
    }

    private void fireEmployee() {
        System.out.println("Enter employee ID to fire:");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            service.fireEmployee(id);
            System.out.println("Employee fired successfully.");
        } catch (Exception e) {
            System.out.println(exceptionMessages.ERROR_FIRING_EMPLOYEE + e.getMessage());
        }
    }

    private void listEmployees() {
        List<employee> employees = service.listActiveEmployees();
        if (employees.isEmpty()) {
            System.out.println("No active employees found.");
        } else {
            System.out.println("Active Employees:");
            for (employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private void searchEmployeeById() {
        System.out.println("Enter employee ID to search:");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            employee employee = service.searchEmployeeById(id);
            if (employee != null) {
                System.out.println("Employee found: " + employee);
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println(exceptionMessages.EMPLOYEE_NOT_FOUND + e.getMessage());
        }
    }

    private void searchEmployeesByName() {
        System.out.println("Enter employee name to search:");
        String name = scanner.nextLine().trim();
        List<employee> employees = service.searchEmployeesByName(name);
        if (employees.isEmpty()) {
            System.out.println("No employees found with the name: " + name);
        } else {
            System.out.println("Employees found:");
            for (employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private void searchEmployeesByDepartment() {
        System.out.println("Enter department to search:");
        String department = scanner.nextLine().trim();
        List<employee> employees = service.searchEmployeesByDepartment(department);
        if (employees.isEmpty()) {
            System.out.println("No employees found in department: " + department);
        } else {
            System.out.println("Employees found in " + department + ":");
            for (employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
    private void saveAndExit() {
        System.out.println("Enter file name to save data:");
        String fileName = scanner.nextLine().trim();
        CSVWriter.writeEmployeesToCSV(fileName, service.listActiveEmployees());
        System.out.println("Data saved successfully. Exiting...");
        System.exit(0);
    }
}
