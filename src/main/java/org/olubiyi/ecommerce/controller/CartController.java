package org.olubiyi.ecommerce.controller;


import org.olubiyi.ecommerce.model.CartItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @PostMapping
    public ResponseEntity<void> addCartItem(
            @RequestHeader("X-User-ID") String userId,
            @RequestBody CartItemRequest request) {
        CartService.addToCart(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
