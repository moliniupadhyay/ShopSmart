package main;

import dao.ItemDAOImpl;
import model.Item;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        List<Item> orderItems = new ArrayList<>(); // To hold items for the current order

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Remove Item");
            System.out.println("4. List Items");
            System.out.println("5. Create Order");
            System.out.println("6. View Order Details");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter item name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter item price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter item category:");
                    String category = scanner.nextLine();

                    Item newItem = new Item(name, price, category);
                    itemDAO.addItem(newItem);
                    break;

                case 2:
                    System.out.println("Enter item name to update:");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter new price:");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter new category:");
                    String newCategory = scanner.nextLine();

                    Item updatedItem = new Item(updateName, newPrice, newCategory);
                    itemDAO.updateItem(updatedItem);
                    break;

                case 3:
                    System.out.println("Enter item name to remove:");
                    String removeName = scanner.nextLine();
                    itemDAO.removeItem(removeName);
                    break;

                case 4:
                    List<Item> items = itemDAO.listItems();
                    if (items.isEmpty()) {
                        System.out.println("No items found.");
                    } else {
                        System.out.println("Items in inventory:");
                        for (Item item : items) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 5:
                  
                    if (orderItems.isEmpty()) {
                        System.out.println("No items in the order. Add items first.");
                    } else {
                        Order order = new Order("ORD001", orderItems);
                        System.out.println("Order created successfully.");
                    }
                    break;

                case 6:
                 
                    if (orderItems.isEmpty()) {
                        System.out.println("No items in the order.");
                    } else {
                        Order order = new Order("ORD001", orderItems);
                        order.displayOrderDetails();
                    }
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


