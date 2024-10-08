package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(Item item) {
        cartItems.add(item);
    }

    public void removeItem(Item item) {
        cartItems.remove(item);
    }

    public void listCartItems() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            cartItems.forEach(System.out::println);
        }
    }

    public void clearCart() {
        cartItems.clear();
        System.out.println("Your cart has been cleared.");
    }
}
