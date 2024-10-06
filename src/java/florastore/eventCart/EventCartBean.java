/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.eventCart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class EventCartBean implements Serializable {

    private Map<String, List<EventCartItem>> items;

    public Map<String, List<EventCartItem>> getItems() {
        return items;
    }

    public void addItemToCart(int epId, int eventId, String eventName, String img, String epName, int quantity, double unitPrice, int stockQuantity) {
        if (epName == null || epName.trim().isEmpty()) {
            return;
        }

        // Khởi tạo items map nếu nó null
        if (this.items == null) {
            this.items = new HashMap<>();
        }

        // Kiểm tra xem eventId đã tồn tại chưa
        List<EventCartItem> eventItems = items.get(eventName);
        if (eventItems == null) {
            eventItems = new ArrayList<>(); // Tạo mới danh sách sản phẩm cho eventId
            items.put(eventName, eventItems);
        }

        EventCartItem existingItem = null;
        for (EventCartItem item : eventItems) {
            if (item.getEpName().equals(epName)) {
                existingItem = item; // Lưu sản phẩm đã tồn tại
                break;
            }
        }
        if (existingItem == null) {
            // Sản phẩm mới, thêm vào danh sách
            EventCartItem newItem = new EventCartItem(epId, eventId, eventName, epName, img, quantity, unitPrice, stockQuantity);
            eventItems.add(newItem);
        } else {
            // Sản phẩm đã tồn tại, tăng số lượng
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        }
    }

    public void removeItemFromCart(String eventName, String epName) {
        if (this.items == null || !this.items.containsKey(eventName)) {
            return; // If there is no event with that name in the cart, exit.
        }

        List<EventCartItem> eventItems = items.get(eventName);

        if (eventItems == null) {
            return; // If there are no items for that store, exit.
        }

        EventCartItem itemToRemove = null;
        // Find the item with the matching name
        for (EventCartItem item : eventItems) {
            if (item.getEpName().equals(epName)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            eventItems.remove(itemToRemove); // Remove the item from the list
        }

        // If the storeItems list becomes empty after removal, remove the store key from the map
        if (eventItems.isEmpty()) {
            items.remove(eventName);
        }
    }

    // Phương thức tính tổng giỏ hàng
    public double calculateTotal() {
        double total = 0.0;
        for (List<EventCartItem> eventItems : items.values()) {
            for (EventCartItem item : eventItems) {
                total += item.getUnitPrice() * item.getQuantity();
            }
        }
        return total;
    }

    public int getUniqueItemCount() {
        if (items == null) {
            return 0; // If there are no items, return 0
        }

        int uniqueItemCount = 0;

        // Loop through each store's item list
        for (List<EventCartItem> eventItems : items.values()) {
            uniqueItemCount += eventItems.size(); // Count the number of unique items
        }

        return uniqueItemCount;
    }
}
