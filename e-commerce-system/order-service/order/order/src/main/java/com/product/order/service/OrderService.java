package com.product.order.service;

import com.product.order.ProductFeign.ProductFeign;
import com.product.order.dto.OrderEntity;
import com.product.order.entity.Entity;
import com.product.order.InventoryFeign.InventoryFeign;
import com.product.order.repository.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderService {

    private final Repository repo;
    private final ProductFeign pf;
    private final InventoryFeign inf;

    OrderService(InventoryFeign inf,Repository repo,ProductFeign pf){
        this.inf=inf;
        this.repo=repo;
        this.pf=pf;
    }

    public String placeOrder(OrderEntity re){

        if(inf.getStock(re.skuName(),re.quantity())>=re.quantity()){
            Entity entity = new Entity();
            entity.setQuantity(re.quantity());
            entity.setSkuName(re.skuName());
            repo.save(entity);
            BigDecimal price = pf.getPrice(re.skuName());
            BigDecimal total = price.multiply(BigDecimal.valueOf(re.quantity()));
            inf.updateQuantity(re.skuName(), re.quantity());
            return "Item: "+re.skuName()+"\n"+
                    "Per item cost: "+price+"\n"+
                    "Your total amount is "+ "₹"+total;
        }
        else{
            return "Not Available";
        }
    }
}
