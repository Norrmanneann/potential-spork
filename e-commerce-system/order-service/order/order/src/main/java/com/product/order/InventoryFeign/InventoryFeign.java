package com.product.order.InventoryFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("INVENTORY")
public interface InventoryFeign {

    @GetMapping("/api/inventory/{name}/{quantity}")
    int getStock(@PathVariable String name , @PathVariable int quantity);

    @PostMapping("api/inventory/quantity/{name}/{quantity}")
    public String updateQuantity(@PathVariable("name") String name,@PathVariable("quantity") int quantity);
}
