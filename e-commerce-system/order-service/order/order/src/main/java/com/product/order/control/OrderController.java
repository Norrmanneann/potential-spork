package com.product.order.control;

import com.product.order.dto.OrderEntity;
import com.product.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService os;

    OrderController(OrderService os){
        this.os=os;
    }

    @PostMapping
    public String placeOrder(@RequestBody OrderEntity orderEntity){
        return os.placeOrder(orderEntity);
    }
}
