import java.util.*;
public class RestaurantManagementSystem {
    static class MenuItem {
        String name;
        double price;
        boolean available;

        MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
            this.available = true;
        }

        public String toString() {
            return name + " - rs " + price + (available ? " (Available)" : " (Not Available)");
        }
    }

    static class Inventory {
        Map<String, Integer> stock = new HashMap<>();

        void addStock(String item, int quantity) {
            stock.put(item, stock.getOrDefault(item, 0) + quantity);
        }

        boolean useStock(String item, int quantity) {
            int current = stock.getOrDefault(item, 0);
            if (current >= quantity) {
                stock.put(item, current - quantity);
                return true;
            }
            return false;
        }

        void displayStock() {
            System.out.println("\n--- Inventory Status ---");
            for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    static class Order {
        static int counter = 1;
        int orderId;
        List<MenuItem> items = new ArrayList<>();
        double total = 0.0;

        Order() {
            this.orderId = counter++;
        }

        void addItem(MenuItem item) {
            if (item.available) {
                items.add(item);
                total += item.price;
            } else {
                System.out.println("Item " + item.name + " is not available.");
            }
        }

        void printReceipt() {
            System.out.println("\n--- Order Receipt ---");
            System.out.println("Order ID: " + orderId);
            for (MenuItem item : items) {
                System.out.println("- " + item.name + ": rs " + item.price);
            }
            System.out.printf("Total: rs%.2f\n", total);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menu = new ArrayList<>();
        Inventory inventory = new Inventory();

        String[] itemNames = {"Chicken Wings", "Chilli Chicken", "Butter Naan", "Roti",
                              "Butter Chicken", "Kadai Chicken Curry", "Chicken Biryani",
                              "MLA Special Chicken Biryani", "Soft Drinks", "Ice cream"};
        double[] prices = {200, 175, 25, 25, 250, 250, 200, 300, 25, 40};
        int[] initialStock = {10, 10, 15, 15, 5, 5, 15, 10, 20, 30};

        for (int i = 0; i < itemNames.length; i++) {
            menu.add(new MenuItem(itemNames[i], prices[i]));
            inventory.addStock(itemNames[i], initialStock[i]);
        }

        System.out.println("WELCOME TO MLA RESTAURANT...!");

        while (true) {
            System.out.println("\nLogin as:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int roleChoice = scanner.nextInt();

            if (roleChoice == 1) {
                boolean adminExit = false;
                while (!adminExit) {
                    System.out.println("\n--- Admin Panel ---");
                    System.out.println("1. View Inventory");
                    System.out.println("2. Add Stock");
                    System.out.println("3. Set Item Availability");
                    System.out.println("4. View Menu");
                    System.out.println("5. Logout");
                    System.out.print("Choose option: ");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (adminChoice) {
                        case 1:
                            inventory.displayStock();
                            break;
                        case 2:
                            System.out.print("Enter item name: ");
                            String itemToAdd = scanner.nextLine();
                            System.out.print("Enter quantity to add: ");
                            int qty = scanner.nextInt();
                            inventory.addStock(itemToAdd, qty);
                            System.out.println("Stock updated.");
                            break;
                        case 3:
                            System.out.print("Enter item name to update availability: ");
                            String itemName = scanner.nextLine();
                            MenuItem item = null;
                            for (MenuItem m : menu) {
                                if (m.name.equalsIgnoreCase(itemName)) {
                                    item = m;
                                    break;
                                }
                            }
                            if (item != null) {
                                System.out.print("Set as available? (yes/no): ");
                                String avail = scanner.nextLine();
                                item.available = avail.equalsIgnoreCase("yes");
                                System.out.println("Availability updated.");
                            } else {
                                System.out.println("Item not found.");
                            }
                            break;
                        case 4:
                            System.out.println("\n--- Menu ---");
                            for (MenuItem m : menu) {
                                System.out.println(m);
                            }
                            break;
                        case 5:
                            adminExit = true;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }

            } else if (roleChoice == 2) {
                
                boolean exit = false;
                while (!exit) {
                    Order order = new Order();
                    while (true) {
                        System.out.println("\nMenu:");
                        for (int i = 0; i < menu.size(); i++) {
                            System.out.println((i + 1) + ". " + menu.get(i));
                        }
                        System.out.print("Select item number to order (0 to finish): ");
                        int choice = scanner.nextInt();
                        if (choice == 0) break;
                        if (choice > 0 && choice <= menu.size()) {
                            MenuItem selected = menu.get(choice - 1);
                            if (inventory.useStock(selected.name, 1)) {
                                order.addItem(selected);
                                System.out.println(selected.name + " added to your order.");
                            } else {
                                System.out.println("Sorry, " + selected.name + " is out of stock.");
                            }
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }

                    if (!order.items.isEmpty()) {
                        order.printReceipt();
                    } else {
                        System.out.println("No items were ordered.");
                    }

                    inventory.displayStock();

                    System.out.print("\nWould you like to place another order? (yes/no): ");
                    String again = scanner.next().toLowerCase();
                    if (!again.equals("yes")) {
                        exit = true;
                    }
                }

            } else if (roleChoice == 3) {
                System.out.println("Thank you! Visit again.");
                break;
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }
}