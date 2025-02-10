abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

// Interface for Insurable vehicles
interface Insurable {
    double calculateInsurance();
}

// Car subclass
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 1000;
    }

    @Override
    public double calculateInsurance() {
        return 5000;
    }
}

// Main Class to Test
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("KA01AB1234", 1000);
        System.out.println("Rental Cost: " + car.calculateRentalCost(5));
    }
}
