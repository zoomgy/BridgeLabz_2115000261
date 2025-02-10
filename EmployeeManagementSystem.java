// Abstract Employee class
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee {
    private double fixedSalary;

    public FullTimeEmployee(int employeeId, String name, double fixedSalary) {
        super(employeeId, name, fixedSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, int hoursWorked, double hourlyRate) {
        super(employeeId, name, hoursWorked * hourlyRate);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Interface for Department
interface Department {
    void assignDepartment(String departmentName);

    String getDepartmentDetails();
}

// Main Class to Test
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(1, "Alice", 50000);
        Employee emp2 = new PartTimeEmployee(2, "Bob", 20, 500);

        emp1.displayDetails();
        emp2.displayDetails();
    }
}
