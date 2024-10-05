/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package florastore.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HaiQuan
 */
public class CartBean implements Serializable {

    private Map<String, CartItem> items;

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void addItemToCart(String img, String name, int quantity, double unitPrice, int stockQuantity) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        // Initialize items map if it's null
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        CartItem item = items.get(name);
        if (item == null) {
            // New item, set default quantity to 1 and initialize stock quantity
            item = new CartItem(img, name, quantity, unitPrice, stockQuantity);
        } else {
            // Existing item, increment quantity
            item.setQuantity(item.getQuantity() + 1);
        }
        // Update the items map
        this.items.put(name, item);
    }
    
    

    public void removeItemFromCart(String item) {
        if (item == null) {
            return;
        }
        if (item.trim().isEmpty()) {
            return;
        }
        //1.check existed items
        if (this.items == null) {
            return;
        }
        //2.check existed item
        if (this.items.containsKey(item)) {
            //3.remove item from items
            this.items.remove(item);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : items.values()) {
            total += item.getUnitPrice() * item.getQuantity();
        }
        return total;
    }
}
