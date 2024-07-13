package com.emolyeeInfo;

import java.time.LocalDate;


public class employee {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate; // null if the employee is active
    private String department;
    private String role;
    private double salary;

    public employee(int id, String name, LocalDate startDate, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.endDate = null; // active by default
    }




    // getters and setters for encapsulation
    public int getId() { return id; }
    // no need to use setter for the id
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getStartDate() { return startDate; }
    // no need to use setter for start date
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Name='" + name + '\'' +
                ", Start Date=" + startDate +
                ", End Date=" + endDate +
                ", Department='" + department + '\'' +
                ", Role='" + role + '\'' +
                ", Salary=" + salary;
    }


}