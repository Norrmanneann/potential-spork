package com.product.inventory.feign;

import com.product.inventory.DTO.RequestProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PRODUCT")
public interface Feign {
    @PostMapping("api/product")
    public boolean postProduct(@RequestBody RequestProduct rp);
}
