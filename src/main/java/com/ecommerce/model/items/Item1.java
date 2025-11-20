package com.ecommerce.model.items;

import com.ecommerce.model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Item1 extends Item {
    public Item1(
            @Value("${item1.id}") String id,
            @Value("${item1.name}") String name,
            @Value("${item1.price}") double price,
            @Value("${item1.description}") String description
    ) {
        super(id, name, price);
        super.setDescription(description);
    }
}