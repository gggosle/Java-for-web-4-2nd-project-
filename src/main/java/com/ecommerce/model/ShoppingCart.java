package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    private List<Item> items;
    private String status;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public ShoppingCart(String cartId) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId='" + cartId + '\'' +
                ", items=" + items +
                ", status='" + status + '\'' +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
