package lib;

import java.time.LocalDate;

public class EmployeeJoinDate {
    private int year;
    private int month;
    private int day;

    public EmployeeJoinDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int calculateMonthsWorkedInYear() {
        LocalDate now = LocalDate.now();
        if (now.getYear() == year) {
            return now.getMonthValue() - month;
        } else {
            return 12;
        }
    }
}
