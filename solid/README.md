# Topic: *SOLID PRINCIPLES*
### Author: Cozlov Valeria

----

## Objectives:


&ensp; &ensp; __1. Study and understand the SOLID Principles.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp;__3. Create a sample project that respects SOLID Principles.__

## Implementation

* Introduction

I have have created a simulation of an IT Office with developers, employee and the functionality to count their salary.

* Snippets from your files.

* S -> Single Responsibility:
```java
public class Employee {
    private String name;
    private int employeeId;
    private int salary;

    public Employee(String name, int employeeId, int salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }
```
* O -> Open Close:

I have added SalaryCalculator, DeveloperSalaryCalculator.

* L -> Liskov Substitution:
```java
Employee developer1 = new Developer("Maria", 101, 5000);
Employee developer2 = new Developer("Vasea", 102, 6000);
```
* I -> Interface Segregation:
```java
SalaryCalculator developerSalaryCalculator = new DeveloperSalaryCalculator();
```

* D -> Dependency Inversion:
```java
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
```

## Conclusion
To sum up, I have created a simulation of IT company that have developers and the unction to count their salary.
In my code I managed to implement somehow all SOLID principles and I learned all tactics used in the SOLID design principles.
