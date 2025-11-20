package com.ecommerce.model.items;

import com.ecommerce.model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Item2 extends Item {
    public Item2(
            @Value("${item2.id}") String id,
            @Value("${item2.name}") String name,
            @Value("${item2.price}") double price,
            @Value("${item3.description}") String description
    ) {
        super(id, name, price);
        super.setDescription(description);
    }
}