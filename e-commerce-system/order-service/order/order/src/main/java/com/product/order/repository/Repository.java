package com.product.order.repository;

import com.product.order.entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Entity, String> {
}
