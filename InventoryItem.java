package Java;
import java.util.ArrayList;
import java.util.Scanner;

class InventoryItem {
    private final String id;
    private final String name;
    private int quantity;
    private final int reorderLevel;

    public InventoryItem(String id, String name, int quantity, int reorderLevel) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getReorderLevel() { return reorderLevel; }

    public void addStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        quantity += amount;
    }

    public boolean removeStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (amount > quantity) {
            return false;
        }
        quantity -= amount;
        return true;
    }

    public boolean needsReorder() {
        return quantity <= reorderLevel;
    }

    @Override
    public String toString() {
        String status = needsReorder() ? "REORDER" : "IN STOCK";
        return String.format("%-8s %-18s %8d %12d %-10s",
                id, name, quantity, reorderLevel, status);
    }
}

class WarehouseInventorySystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<InventoryItem> inventory = new ArrayList<>();

    public static void main(String[] args) {
        inventory.add(new InventoryItem("WH101", "Rice Bags", 18, 20));
        inventory.add(new InventoryItem("WH102", "Cooking Oil", 42, 15));
        inventory.add(new InventoryItem("WH103", "Sugar Bags", 9, 12));
        inventory.add(new InventoryItem("WH104", "Wheat Flour", 30, 10));

        int choice;
        do {
            System.out.println("\\n=== WAREHOUSE INVENTORY SYSTEM ===");
            System.out.println("1. Display inventory");
            System.out.println("2. Add stock");
            System.out.println("3. Remove stock");
            System.out.println("4. Reorder report");
            System.out.println("5. Exit");
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1 -> displayInventory();
                case 2 -> updateStock(true);
                case 3 -> updateStock(false);
                case 4 -> generateReorderReport();
                case 5 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice. Select 1 to 5.");
            }
        } while (choice != 5);
        sc.close();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static InventoryItem findItem(String id) {
        for (InventoryItem item : inventory) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    private static void displayInventory() {
        System.out.printf("%-8s %-18s %8s %12s %-10s%n",
                "ID", "Item", "Quantity", "Reorder", "Status");
        for (InventoryItem item : inventory) {
            System.out.println(item);
        }
    }

    private static void updateStock(boolean adding) {
        System.out.print("Enter item ID: ");
        String id = sc.nextLine().trim();
        InventoryItem item = findItem(id);

        if (item == null) {
            System.out.println("Item ID not found.");
            return;
        }

        int amount = readInt("Enter quantity: ");
        try {
            if (adding) {
                item.addStock(amount);
                System.out.println("Stock added successfully.");
            } else if (item.removeStock(amount)) {
                System.out.println("Stock removed successfully.");
            } else {
                System.out.println("Insufficient stock. Quantity was not changed.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid quantity: " + e.getMessage());
        }

        if (item.needsReorder()) {
            System.out.println("LOW-STOCK ALERT: " + item.getName()
                    + " is at or below its reorder level.");
        }
    }

    private static void generateReorderReport() {
        int count = 0;
        System.out.println("\\n=== ITEMS TO REORDER ===");
        for (InventoryItem item : inventory) {
            if (item.needsReorder()) {
                System.out.println(item);
                count++;
            }
        }
        System.out.println("Items requiring reorder: " + count);
        if (count == 0) {
            System.out.println("No items currently require reorder.");
        }
    }
}
