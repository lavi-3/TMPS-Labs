package solid.employee;
//Liskov Substitution Principle We can substitute developer with Employee
public class Developer extends Employee {
    public Developer(String name, int employeeId, int salary) {
        super(name, employeeId, salary);
    }
}
