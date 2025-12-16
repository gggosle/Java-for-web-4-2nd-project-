package com.ecommerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {
    @Value("${cart.id}")
    private String cartId;
    private List<Item> items;
    @Value("${cart.status}")
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

    public void setCartId(@Value("${cart.id:CART001}") String cartId) {
        this.cartId = cartId;
    }

    public List<Item> getItems() {
        return items;
    }

    @Autowired
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(@Value("${cart.status:Active}") String status) {
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
