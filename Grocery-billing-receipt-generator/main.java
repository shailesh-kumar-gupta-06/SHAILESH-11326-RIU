import java.util.*;

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        if (price < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Invalid price or quantity!");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Calculate total for this item
    public double getTotal() {
        return price * quantity;
    }
}

class Bill {
    private List<Item> items;
    private static final double TAX_RATE = 0.05; // 5% tax

    public Bill() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateSubtotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append("\n------ Grocery Bill ------\n");
        receipt.append(String.format("%-10s %-10s %-10s %-10s\n", "Item", "Price", "Qty", "Total"));

        for (Item item : items) {
            receipt.append(String.format("%-10s %-10.2f %-10d %-10.2f\n",
                    item.getName(),
                    item.getPrice(),
                    item.getQuantity(),
                    item.getTotal()));
        }

        double subtotal = calculateSubtotal();
        double tax = calculateTax();
        double grandTotal = subtotal + tax;

        receipt.append("\nSubtotal: ").append(String.format("%.2f", subtotal));
        receipt.append("\nTax (5%): ").append(String.format("%.2f", tax));
        receipt.append("\nGrand Total: ").append(String.format("%.2f", grandTotal));
        receipt.append("\n---------------------------\n");

        return receipt.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bill bill = new Bill();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for item " + (i + 1));

            System.out.print("Item name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            try {
                Item item = new Item(name, price, quantity);
                bill.addItem(item);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

        System.out.println(bill.generateReceipt());

        sc.close();
    }
}
