package com.product.inventory.service;

import com.product.inventory.DTO.RequestProduct;
import com.product.inventory.entity.Entity;
import com.product.inventory.feign.Feign;
import com.product.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Feign feign;

    private final InventoryRepository ir;

    Service(InventoryRepository ir){
        this.ir=ir;
    }

    public int find(String skuName , int quantity){
        return ir.findBySkuName(skuName).getQuantity();
    }

    public String  save(String name, int quantity){

        if(ir.findBySkuName(name)!=null){
            Entity ent = ir.findBySkuName(name);
            ent.setQuantity(ent.getQuantity()+quantity);
            ir.save(ent);
            return "updated";
        }
        else{
            RequestProduct requestProduct = new RequestProduct();
            requestProduct.setName(name);
            feign.postProduct(requestProduct);
            Entity ent = new Entity();
            ent.setSkuName(name);
            ent.setQuantity(quantity);
            ir.save(ent);
            return "Saved";
        }
    }

    public List<Entity> findAll(){
        return ir.findAll();
    }

    public String saveTheQuantity(String name,int quantity){
        if(ir.findBySkuName(name)!=null){
            Entity ent = ir.findBySkuName(name);
            ent.setQuantity(ent.getQuantity()-quantity);
            ir.save(ent);
            return "Done";
        }
        else{
            return "Item not found";
        }
    }
}
