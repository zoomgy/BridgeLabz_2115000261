import java.util.ArrayList;

public class Company {
    private ArrayList<Department> departments;

    public Company() {
        departments = new ArrayList<>();
        departments.add(new Department("HR"));
        departments.add(new Department("Engineering"));
    }

    class Department {
        private String name;
        private ArrayList<Employee> employees;

        public Department(String name) {
            this.name = name;
            employees = new ArrayList<>();
            employees.add(new Employee("Employee 1"));
            employees.add(new Employee("Employee 2"));
        }
    }

    class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Company company = new Company();
        // Departments and employees exist only while the company exists
    }
}