// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

// Interface for Medical Records
interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private String medicalHistory;

    public InPatient(int patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + medicalHistory);
    }
}

// OutPatient subclass
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

// Main Class to Test
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient p1 = new InPatient(101, "Alice", 45, 2000, 5);
        Patient p2 = new OutPatient(102, "Bob", 30, 500);

        p1.getPatientDetails();
        System.out.println("Bill: " + p1.calculateBill());

        p2.getPatientDetails();
        System.out.println("Bill: " + p2.calculateBill());
    }
}
