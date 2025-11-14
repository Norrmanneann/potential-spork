package com.product.order.ProductFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient("PRODUCT")
public interface ProductFeign {

    @GetMapping("api/product/{name}")
    public BigDecimal getPrice(@PathVariable String name);
}
