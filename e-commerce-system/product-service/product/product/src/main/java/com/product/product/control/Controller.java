package com.product.product.control;

import com.product.product.dto.RequestProduct;
import com.product.product.entity.Entity;
import com.product.product.service.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class Controller {

    private final Service service;

    Controller(Service service){
        this.service=service;
    }

    @GetMapping
    public List<Entity> getProduct(){
        return service.getProduct();
    }

    @PostMapping
    public boolean postProduct(@RequestBody RequestProduct rp){
        return service.saveProduct(rp);
    }

    @GetMapping("/{name}")
    public BigDecimal getPrice(@PathVariable String name){return service.getPrice(name);
    }

    @PostMapping("{name}/{price}")
    public String setPrice(@PathVariable String name, @PathVariable BigDecimal price){
        return service.setThePrice(name,price);
    }
}
