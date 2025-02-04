class Product {
    private static double discount = 10.0; // in percentage
    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }
}

public class ShoppingCartManagementSystem {
    public static void main(String[] args) {
        Product prod1 = new Product("P123", "Laptop", 1200.0, 2);
        prod1.displayProductDetails();
        Product.updateDiscount(15.0);
        prod1.displayProductDetails();
    }
}
