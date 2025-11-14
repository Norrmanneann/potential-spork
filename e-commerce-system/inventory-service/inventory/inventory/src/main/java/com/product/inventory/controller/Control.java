package com.product.inventory.controller;

import com.product.inventory.entity.Entity;
import com.product.inventory.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class Control {

    private final Service service;

    Control(Service service){
        this.service=service;
    }

    @GetMapping("{name}/{quantity}")
    public int getStock(@PathVariable String name , @PathVariable int quantity){
        return service.find(name,quantity);
    }

    @PostMapping("/{name}/{quantity}")
    public String reStock(@PathVariable String name, @PathVariable int quantity){
        return service.save(name,quantity);
    }

    @GetMapping
    public List<Entity> allStocks(){
        return service.findAll();
    }

    @PostMapping("quantity/{name}/{quantity}")
    public String updateQuantity(@PathVariable String name,@PathVariable int quantity){
        return service.saveTheQuantity(name,quantity);
    }
}
