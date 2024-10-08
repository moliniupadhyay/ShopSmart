package dao;

import model.Item;
import java.util.List;

public interface ItemDAO {
    void addItem(Item item);
    void updateItem(Item item);
    void removeItem(String itemName);
    List<Item> listItems();
}

