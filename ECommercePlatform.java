// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double getPrice() {
        return price - calculateDiscount();
    }

    public void displayProductDetails() {
        System.out.println("Product: " + name + ", Final Price: " + getPrice());
    }
}

// Interface for Taxable products
interface Taxable {
    double calculateTax();
}

// Concrete Classes
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }
}

class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }
}

// Main Class to Test
public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Laptop", 60000);
        Product p2 = new Clothing(102, "Shirt", 2000);

        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}
