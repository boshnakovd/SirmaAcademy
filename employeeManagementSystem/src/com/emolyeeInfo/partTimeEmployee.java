package com.emolyeeInfo;
import java.time.LocalDate;

public class partTimeEmployee extends employee { //inheritance
    private int hoursPerWeek;

    public partTimeEmployee(int id, String name, LocalDate startDate, String department, String role, double salary, int hoursPerWeek) {
        super(id, name, startDate, department, role, salary);
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public String toString() {
        return super.toString() + ", Hours Per Week=" + hoursPerWeek;
    }
}
