package dao;

import model.Item;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public void addItem(Item item) {
        Connection conn = DBUtil.getConnection();
        try {
            String query = "INSERT INTO items (name, price, category) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, item.getItemName());
            stmt.setDouble(2, item.getPrice());
            stmt.setString(3, item.getCategory());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateItem(Item item) {
        Connection conn = DBUtil.getConnection();
        try {
            String query = "UPDATE items SET price = ?, category = ? WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, item.getPrice());
            stmt.setString(2, item.getCategory());
            stmt.setString(3, item.getItemName());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Item updated successfully.");
            } else {
                System.out.println("Item not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void removeItem(String itemName) {
        Connection conn = DBUtil.getConnection();
        try {
            String query = "DELETE FROM items WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, itemName);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Item removed successfully.");
            } else {
                System.out.println("Item not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Item> listItems() {
        List<Item> items = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        try {
            String query = "SELECT * FROM items";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                Item item = new Item(name, price, category);
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return items;
    }
}
