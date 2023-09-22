package solid;

import solid.company.DeveloperSalaryCalculator;
import solid.company.EmployeeManagement;
import solid.company.ITCompany;
import solid.company.SalaryCalculator;
import solid.employee.Developer;
import solid.employee.Employee;

public class Main {
    public static void main(String[] args) {
        //interface segregation
        SalaryCalculator developerSalaryCalculator = new DeveloperSalaryCalculator();
        EmployeeManagement company = new ITCompany(developerSalaryCalculator);

        //Liskov Substitution
        Employee developer1 = new Developer("Maria", 101, 5000);
        Employee developer2 = new Developer("Vasea", 102, 6000);

        company.hire(developer1);
        company.hire(developer2);

        company.paySalaries();
    }
}
