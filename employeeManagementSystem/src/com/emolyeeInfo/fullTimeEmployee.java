package com.emolyeeInfo;
import com.emolyeeInfo.employee;

import java.time.LocalDate;

public class fullTimeEmployee extends employee { // inheritance
    private double bonus;

    public fullTimeEmployee(int id, String name, LocalDate startDate, String department, String role, double salary, double bonus) {
        super(id, name, startDate, department, role, salary);
        this.bonus = bonus;
    }

    public double getTotalCompensation() {
        return getSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Bonus=" + bonus;
    }
}
