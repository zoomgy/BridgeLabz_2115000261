import java.util.ArrayList;

public class Hospital {
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}

class Doctor {
    private String name;
    private ArrayList<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this);
        System.out.println(name + " consults " + patient.getName());
    }
}

class Patient {
    private String name;
    private ArrayList<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Doctor drSmith = new Doctor("Dr. Smith");
        Patient alice = new Patient("Alice");

        hospital.addDoctor(drSmith);
        hospital.addPatient(alice);

        drSmith.consult(alice);
    }
}