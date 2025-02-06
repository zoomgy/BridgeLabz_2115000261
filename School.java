import java.util.ArrayList;

public class School {
    private ArrayList<Student> students;

    public School() {
        students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public void enroll(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void listCourses() {
        System.out.println(name + "'s courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }
}

class Course {
    private String name;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        School school = new School();
        Student alice = new Student("Alice");
        school.enrollStudent(alice);

        Course math = new Course("Calculus");
        alice.enroll(math);

        alice.listCourses();
    }
}