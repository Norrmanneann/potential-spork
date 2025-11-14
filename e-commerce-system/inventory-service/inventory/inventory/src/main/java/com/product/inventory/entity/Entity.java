package com.product.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entity {

    @Id
    private String id;
    private String skuName;
    private int quantity;
}
