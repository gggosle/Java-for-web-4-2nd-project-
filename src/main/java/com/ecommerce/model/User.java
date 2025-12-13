package com.ecommerce.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class User {
    private String userId;
    private String username;
    @Value("${user.email}")
    private String email;
    private ShoppingCart shoppingCart;

    public User(@Value("${user.id}") String userId, @Value("${user.username}") String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(@Value("${user.id:USER001}") String userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(@Value("${user.username:john_doe}") String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@Value("${user.email:john.doe@example.com}") String email) {
        this.email = email;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Autowired
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


    @PostConstruct
    public void init() {
        System.out.println("User bean is initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("User bean is destroyed");
    }
}
