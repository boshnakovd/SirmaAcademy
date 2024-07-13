package com.app;

import com.emolyeeInfo.employee;
import com.manager.employeeManager;
import com.service.employeeService;
import com.service.employeeServiceImpl;
import com.fileOps.CSVReader;

import java.util.List;
import java.util.Scanner;

public class employeeManagementApp {

    public static void main(String[] args) {
        List<employee> employees = CSVReader.readEmployeesFromCSV("employees.csv");
        employeeService service = new employeeServiceImpl(employees);
        employeeManager manager = new employeeManager(service);

        System.out.println("Welcome to Employee Management System");


        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            manager.displayCommands();
            System.out.println("Enter command:");
            String command = scanner.nextLine().trim();
            manager.executeCommand(command);
        }

        scanner.close();
    }
}