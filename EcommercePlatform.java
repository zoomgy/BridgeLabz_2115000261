import java.util.ArrayList;
import java.util.List;

// Product Class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Order Class
class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products Ordered:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
        }
        System.out.println("Total Amount: $" + calculateTotal());
    }
}

// Customer Class
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showOrders() {
        System.out.println("Customer: " + name);
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

// Main Class
public class EcommercePlatform {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");

        Order order1 = new Order(101);
        order1.addProduct(new Product("Laptop", 800));
        order1.addProduct(new Product("Phone", 500));

        customer.placeOrder(order1);
        customer.showOrders();
    }
}
