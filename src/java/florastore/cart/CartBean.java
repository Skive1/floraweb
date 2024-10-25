/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class CartBean implements Serializable {

    private Map<String, List<CartItem>> items;

    public Map<String, List<CartItem>> getItems() {
        return items;
    }

    public boolean addItemToCart(int productId, int storeId, String storeName, String img, String name, int quantity, double unitPrice, int stockQuantity) {
        boolean result = false;
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        // Khởi tạo items map nếu nó null
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        // Kiểm tra xem storeId đã tồn tại chưa
        List<CartItem> storeItems = items.get(storeName);
        if (storeItems == null) {
            storeItems = new ArrayList<>(); // Tạo mới danh sách sản phẩm cho storeId
            items.put(storeName, storeItems);
        }
        CartItem existingItem = null;
        for (CartItem item : storeItems) {
            if (item.getProductId() == productId) {
                existingItem = item; // Lưu sản phẩm đã tồn tại
                break;
            }
        }
        if (existingItem == null) {
            // Sản phẩm mới, thêm vào danh sách
            CartItem newItem = new CartItem(productId, storeId, storeName, img, name, quantity, unitPrice, stockQuantity);
            storeItems.add(newItem);
            result = true;
        } else {
            if (existingItem.getQuantity() < stockQuantity && (existingItem.getQuantity() + quantity) <= stockQuantity) {
                // Sản phẩm đã tồn tại, tăng số lượng
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
                result = true;
            } else if (existingItem.getQuantity() == stockQuantity) {
                result = false;
            }
        }
        return result;
    }

    public void removeItemFromCart(String storeName, int id) {
        if (this.items == null || !this.items.containsKey(storeName)) {
            return; // If there is no store with that name in the cart, exit.
        }

        List<CartItem> storeItems = items.get(storeName);

        if (storeItems == null) {
            return; // If there are no items for that store, exit.
        }

        CartItem itemToRemove = null;
        // Find the item with the matching name
        for (CartItem item : storeItems) {
            if (item.getProductId() == id) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            storeItems.remove(itemToRemove); // Remove the item from the list
        }

        // If the storeItems list becomes empty after removal, remove the store key from the map
        if (storeItems.isEmpty()) {
            items.remove(storeName);
        }
    }

// Phương thức tính tổng giỏ hàng
    public double calculateTotal() {
        double total = 0.0;
        for (List<CartItem> storeItems : items.values()) {
            for (CartItem item : storeItems) {
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
        for (List<CartItem> storeItems : items.values()) {
            uniqueItemCount += storeItems.size(); // Count the number of unique items
        }

        return uniqueItemCount;
    }
}
