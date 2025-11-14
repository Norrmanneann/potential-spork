package com.product.inventory.repository;

import com.product.inventory.entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Entity,String> {
//    boolean existsBySkuNameAndQuantityGreaterThan(String skuName,int quantity);
    Entity findBySkuName(String name);
}
