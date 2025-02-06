import java.util.ArrayList;
import java.util.List;

// Course Class
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.getName() + " is assigned to teach " + courseName);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println(student.getName() + " enrolled in " + courseName);
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}

// Professor Class
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Student Class
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Main Class
public class UniversitySystem {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Dr. Smith");
        Course course1 = new Course("Mathematics");

        course1.assignProfessor(professor1);

        Student student1 = new Student("John");
        Student student2 = new Student("Alice");

        course1.enrollStudent(student1);
        course1.enrollStudent(student2);

        course1.displayCourseInfo();
    }
}
