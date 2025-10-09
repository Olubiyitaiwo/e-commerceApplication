package org.olubiyi.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.olubiyi.ecommerce.dtos.OrderResponse;
import org.olubiyi.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestHeader("X-User-ID") String userId){
        OrderResponse order = orderService.createOrder(UserId);
        return new ResponseEntity<OrderResponse>(order, HttpStatus.CREATED);
    }
}
