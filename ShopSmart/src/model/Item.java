package model;

import exception.InvalidPriceException;

public class Item {
    private String itemName;
    private double price;
    private String category;

    // Constructor
    public Item(String itemName, double price, String category) {
        if (price <= 0) {
            throw new InvalidPriceException("Price must be greater than zero.");
        }
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    // Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new InvalidPriceException("Price must be greater than zero.");
        }
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item: " + itemName + ", Price: " + price + ", Category: " + category;
    }
}
