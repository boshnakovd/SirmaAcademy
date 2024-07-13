package com.fileOps;

import com.emolyeeInfo.employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    public static void writeEmployeesToCSV(String fileName, List<employee> employees) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (employee empl : employees) {
                writer.append(String.valueOf(empl.getId()))
                        .append(',')
                        .append(empl.getName())
                        .append(',')
                        .append(empl.getStartDate().toString())
                        .append(',')
                        .append(empl.getEndDate() == null ? "null" : empl.getEndDate().toString())
                        .append(',')
                        .append(empl.getDepartment())
                        .append(',')
                        .append(empl.getRole())
                        .append(',')
                        .append(String.valueOf(empl.getSalary()))
                        .append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

