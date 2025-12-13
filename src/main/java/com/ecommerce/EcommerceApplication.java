package com.ecommerce;

import com.ecommerce.model.User;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.model.Item;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("Spring XML DI Demo - E-commerce Application");
        System.out.println("=================================================\n");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        User user = (User) context.getBean("user");

        System.out.println("Demonstrating 3 Levels of Nested Dependency Injection:\n");
        
        System.out.println("LEVEL 1: User Bean");
        System.out.println("-------------------");
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println();

        ShoppingCart cart = user.getShoppingCart();
        System.out.println("LEVEL 2: ShoppingCart Bean (nested in User)");
        System.out.println("--------------------------------------------");
        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Cart Status: " + cart.getStatus());
        System.out.println("Number of Items: " + cart.getItems().size());
        System.out.println("Total Cart Value: $" + String.format("%.2f", cart.getTotalPrice()));
        System.out.println();

        System.out.println("LEVEL 3: Item Beans (nested in ShoppingCart)");
        System.out.println("---------------------------------------------");
        int itemNumber = 1;
        for (Item item : cart.getItems()) {
            System.out.println("Item " + itemNumber + ":");
            System.out.println("  ID: " + item.getItemId());
            System.out.println("  Name: " + item.getName());
            System.out.println("  Price: $" + String.format("%.2f", item.getPrice()));
            System.out.println("  Description: " + item.getDescription());
            System.out.println();
            itemNumber++;
        }

        System.out.println("=================================================");
        System.out.println("Dependency Injection Summary:");
        System.out.println("=================================================");
        System.out.println("✓ Constructor DI: User (userId, username)");
        System.out.println("✓ Setter DI: User (email, shoppingCart)");
        System.out.println("✓ Constructor DI: ShoppingCart (cartId)");
        System.out.println("✓ Setter DI: ShoppingCart (items, status)");
        System.out.println("✓ Constructor DI: Item (itemId, name, price)");
        System.out.println("✓ Setter DI: Item (description)");
        System.out.println("✓ Property File Injection: All values from application.properties");
        System.out.println("=================================================");

        context.close();
    }
}
