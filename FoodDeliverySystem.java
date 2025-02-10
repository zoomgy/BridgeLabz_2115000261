abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();
}

// VegItem subclass
class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

// Main Class to Test
public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem food = new VegItem("Paneer Tikka", 200, 2);
        System.out.println("Total Price: " + food.calculateTotalPrice());
    }
}
