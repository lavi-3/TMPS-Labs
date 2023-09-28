package solid;

import solid.company.DeveloperSalaryCalculator;
import solid.company.EmployeeManagement;
import solid.company.ITCompany;
import solid.company.SalaryCalculator;
import solid.employee.Developer;
import solid.employee.Employee;

public class Main {
    public static void main(String[] args) {
        //I - clasa noua DevSalCalc (concret) depinde de interfata SalCalc (abstract)
        SalaryCalculator developerSalaryCalculator = new DeveloperSalaryCalculator();
        // clasa ITComp depinde de interfata EmpManag
        EmployeeManagement company = new ITCompany(developerSalaryCalculator);

        //L - daca se substituie subclasa cu supraclasa, codul trebuie sa lucreze fara probleme
        Employee developer1 = new Developer("Maria", 101, 5000);
        Employee developer2 = new Developer("Vasea", 102, 6000);

        company.hire(developer1);
        company.hire(developer2);

        company.paySalaries();
    }
}
