package com.product.product.service;

import com.product.product.dto.RequestProduct;
import com.product.product.entity.Entity;
//import com.product.product.feign.Feign;
import com.product.product.repository.Repository;

import java.math.BigDecimal;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repo;
//    private final Feign feign;

    Service(Repository repo){
        this.repo=repo;
//        this.feign=feign;
    }

    public boolean saveProduct(RequestProduct rp){
        int quantity=0;
        Entity ent = Entity.builder()
                .name(rp.name())
                .price(rp.price())
                .build();
        repo.save(ent);
        return true;
    }

    public List<Entity> getProduct(){
        return repo.findAll();
    }

    public BigDecimal getPrice(String name){
        return repo.findByName(name).getPrice();
    }

    public String setThePrice(String name,BigDecimal price){
        if(repo.findByName(name)!=null){
            Entity ent = repo.findByName(name);
            ent.setPrice(price);
            repo.save(ent);
            return "The Price is Set";
        }
        else{
            return "Product does not exist";
        }
    }
}
