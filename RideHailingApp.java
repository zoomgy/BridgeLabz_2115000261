// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per km: " + ratePerKm);
    }
}

// Interface for GPS
interface GPS {
    void getCurrentLocation();

    void updateLocation(String location);
}

// Car subclass
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 15; // Rs 15 per km
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Current Location: " + location);
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
        System.out.println("Updated Location: " + location);
    }
}

// Bike subclass
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 8; // Rs 8 per km
    }
}

// Auto subclass
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 10; // Rs 10 per km
    }
}

// Main Class to Test
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle v1 = new Car("C101", "John", 15);
        Vehicle v2 = new Bike("B202", "Mike", 8);
        Vehicle v3 = new Auto("A303", "Sam", 10);

        System.out.println("Fare for Car: " + v1.calculateFare(10));
        System.out.println("Fare for Bike: " + v2.calculateFare(10));
        System.out.println("Fare for Auto: " + v3.calculateFare(10));

        // Testing GPS for Car
        Car car = (Car) v1;
        car.updateLocation("Downtown");
        car.getCurrentLocation();
    }
}
