package lib;

import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    private EmployeeJoinDate joinDate;
    private boolean isForeigner;
    private Gender gender;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private String spouseName;
    private String spouseIdNumber;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, EmployeeJoinDate joinDate, boolean isForeigner, Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.joinDate = joinDate;
        this.isForeigner = isForeigner;
        this.gender = gender;

        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }

    public void setMonthlySalary(int grade) {    
        this.monthlySalary = CalculateSalary.calculateSalaryForGrade(grade, isForeigner);
    }

    public void setAnnualDeductible(int deductible) {    
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {    
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {
        int monthsWorked = joinDate.calculateMonthsWorkedInYear();
        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthsWorked, annualDeductible, spouseIdNumber != null, childIdNumbers.size());
    }
}
