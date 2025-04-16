package lib;

public class CalculateSalary {
    public static int calculateSalaryForGrade(int grade, boolean isForeigner) {
        int baseSalary = 0;
        switch (grade) {
            case 1:
                baseSalary = 3000000;
                break;
            case 2:
                baseSalary = 5000000;
                break;
            case 3:
                baseSalary = 7000000;
                break;
            default:
                throw new IllegalArgumentException("Grade is invalid!");
        }

        if (isForeigner) {
            baseSalary = (int) (baseSalary * 1.5);
        }
        return baseSalary;
    }
}

