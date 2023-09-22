package solid.company;

import solid.employee.Employee;

public class DeveloperSalaryCalculator implements SalaryCalculator {
    @Override
    public int calculateSalary(Employee employee) {
        return employee.getSalary();
    }
}