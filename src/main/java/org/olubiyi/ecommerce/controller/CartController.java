package org.olubiyi.ecommerce.controller;


import lombok.RequiredArgsConstructor;
import org.olubiyi.ecommerce.dtos.CartItemRequest;
import org.olubiyi.ecommerce.model.CartItem;
import org.olubiyi.ecommerce.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<String> addCartItem(
            @RequestHeader("X-User-ID") String userId,
            @RequestBody CartItemRequest request) {
        if(!cartService.addToCart(userId, request)){
            return ResponseEntity.badRequest().body("Product not found or Product out of stock or User not found");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
