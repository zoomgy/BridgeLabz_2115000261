import java.util.ArrayList;

public class University {
    private ArrayList<Department> departments;
    private ArrayList<Faculty> faculties;

    public University() {
        departments = new ArrayList<>();
        departments.add(new Department("Computer Science"));
        faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    class Department {
        private String name;

        public Department(String name) {
            this.name = name;
        }
    }
}

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }
}

class Main {
    public static void main(String[] args) {
        University uni = new University();
        Faculty faculty = new Faculty("Dr. Smith");
        uni.addFaculty(faculty);

        // Departments are destroyed when university is destroyed
        // Faculty exists independently
    }
}