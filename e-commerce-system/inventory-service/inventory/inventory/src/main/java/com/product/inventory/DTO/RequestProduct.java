package com.product.inventory.DTO;

import java.math.BigDecimal;


public class RequestProduct{
    String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    BigDecimal price = BigDecimal.ZERO;
}
