package model;

import java.util.List;

public class Order {
    private String orderID;
    private List<Item> itemList;
    private double totalPrice;

    public Order(String orderID, List<Item> itemList) {
        this.orderID = orderID;
        this.itemList = itemList;
        this.totalPrice = calculateTotalPrice();
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
        this.totalPrice = calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calculateTotalPrice() {
        return itemList.stream().mapToDouble(Item::getPrice).sum();
    }
    

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Items in the order:");
        for (Item item : itemList) {
            System.out.println(item);
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}
