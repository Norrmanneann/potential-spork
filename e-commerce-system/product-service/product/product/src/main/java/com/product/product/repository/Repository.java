package com.product.product.repository;

import com.product.product.entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;

public interface Repository extends MongoRepository<Entity, String> {
    Entity findByName(String name);
}
