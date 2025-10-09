package org.olubiyi.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.olubiyi.ecommerce.Repository.UserRepository;
import org.olubiyi.ecommerce.dtos.OrderResponse;
import org.olubiyi.ecommerce.model.CartItem;
import org.olubiyi.ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CartService cartService;
    private final UserRepository userRepository;

    public Optional<OrderResponse> createOrder(String userId) {
        //validate for cart items
        List<CartItem> cartItems = cartService.getCart(userId);
        if(cartItems.isEmpty()){
            return Optional.empty();
        }
        //validate for user
        Optional<User> userOptional = userRepository.findById(Long.valueOf(userId));
        if (userOptional.isEmpty()) {
            return Optional.empty();

        }
        User user = userOptional.get();
        //Calculate tottal price
        BigDecimal totalPrice = cartItems.stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //Create order

        //Clear the cart
    }
}
