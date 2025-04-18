package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

//cuma jadi koordinator data dan proses dari employee
public class Employee {
	private String employeeId;
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;

    private EmployeePersonalInfo personalInfo;
    private EmployeeFamilyInfo familyInfo;
    private EmployeeSalary salary;

    private int otherMonthlyIncome;
    private int annualDeductible;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {

        this.employeeId = employeeId;
        this.personalInfo = new EmployeePersonalInfo(firstName, lastName, idNumber, address, isForeigner, gender);
        this.familyInfo = new EmployeeFamilyInfo();
        this.salary = new EmployeeSalary();
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
    }
	
	public void setMonthlySalary(int grade) {
        salary.setMonthlySalary(grade, personalInfo.isForeigner());
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        familyInfo.setSpouse(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        familyInfo.addChild(childName, childIdNumber);
    }

    public int getAnnualIncomeTax() {
        LocalDate currentDate = LocalDate.now();
        this.monthWorkingInYear = (currentDate.getYear() == yearJoined)
                ? currentDate.getMonthValue() - monthJoined
                : 12;

        return TaxFunction.calculateTax(
                salary.getMonthlySalary(),
                otherMonthlyIncome,
                monthWorkingInYear,
                annualDeductible,
                familyInfo.isSingle(),
                familyInfo.getChildCount()
        );
    }
}
