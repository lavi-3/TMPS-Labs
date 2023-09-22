package solid.company;

import solid.employee.Employee;
//Open-Closed Principle (We added to SalaryCalculator and DeveloperSalaryCalculator)
public interface SalaryCalculator {
    int calculateSalary(Employee employee);
}
