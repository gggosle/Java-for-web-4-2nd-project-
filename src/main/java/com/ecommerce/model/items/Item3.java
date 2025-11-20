package com.ecommerce.model.items;

import com.ecommerce.model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Item3 extends Item {
    public Item3(
            @Value("${item3.id}") String id,
            @Value("${item3.name}") String name,
            @Value("${item3.price}") double price,
            @Value("${item3.description}") String description
    ) {
        super(id, name, price);
        super.setDescription(description);
    }
}