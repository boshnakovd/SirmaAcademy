package com.fileOps;

import com.emolyeeInfo.employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<employee> readEmployeesFromCSV(String fileName) {
        List<employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                employee employee = parseEmployee(values);
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private static employee parseEmployee(String[] values) {
        int id = Integer.parseInt(values[0]);
        String name = values[1];
        LocalDate startDate = LocalDate.parse(values[2]);
        LocalDate endDate = values[3].equals("null") ? null : LocalDate.parse(values[3]);
        String department = values[4];
        String role = values[5];
        double salary = Double.parseDouble(values[6]);

        employee employee = new employee(id, name, startDate, department, role, salary);
        if (endDate != null) {
            employee.setEndDate(endDate);
        }
        return employee;
    }
}