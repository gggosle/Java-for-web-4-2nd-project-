package com.ecommerce.model;

/**
 * User class - Level 1 (outermost bean)
 * Contains ShoppingCart bean (Level 2)
 * Demonstrates both constructor and setter-based dependency injection
 */
public class User {
    private String userId;
    private String username;
    private String email;
    private ShoppingCart shoppingCart;

    // Default constructor
    public User() {
    }

    // Constructor for constructor-based DI
    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
