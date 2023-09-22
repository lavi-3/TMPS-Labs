package solid.company;

import solid.employee.Employee;

import java.util.ArrayList;
import java.util.List;
public class ITCompany implements EmployeeManagement {
    private List<Employee> employees;

    //Dependency Inversion
    private SalaryCalculator salaryCalculator;

    public ITCompany(SalaryCalculator salaryCalculator) {
        employees = new ArrayList<>();
        //dependency injection in the constructor
        this.salaryCalculator = salaryCalculator;
    }

    @Override
    public void hire(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void paySalaries() {
        for (Employee employee : employees) {
            int salary = salaryCalculator.calculateSalary(employee);
            System.out.println("Paid $" + salary + " to " + employee.getName());
        }
    }
}