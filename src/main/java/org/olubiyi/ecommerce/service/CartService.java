package org.olubiyi.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.olubiyi.ecommerce.Repository.CartItemRepository;
import org.olubiyi.ecommerce.Repository.ProductRepository;
import org.olubiyi.ecommerce.Repository.UserRepository;
import org.olubiyi.ecommerce.dtos.CartItemRequest;
import org.olubiyi.ecommerce.model.CartItem;
import org.olubiyi.ecommerce.model.Product;
import org.olubiyi.ecommerce.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;


    public boolean addToCart(String userId, CartItemRequest request) {
        // Look for product

        Optional<Product> productOpt = productRepository.findById(request.getProductId());
        if (productOpt.isEmpty())
            return false;

        Product product = productOpt.get();
        if (product.getStockQuantity() < request.getQuantity())
            return false;

        Optional<User> userOPt = userRepository.findById(Long.valueOf(userId));
        if (userOPt.isEmpty())
            return false;

        User user = userOPt.get();

        CartItem existingCartItem = cartItemRepository.findByUserAndProduct(user, product);
        if (existingCartItem != null){
        // update the quantity
        existingCartItem.setQuantity(existingCartItem.getQuantity() + request.getQuantity());
        existingCartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(existingCartItem.getQuantity())));
        cartItemRepository.save(existingCartItem);

    }else{
            // create new cart item
            CartItem cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())));
            cartItemRepository.save(cartItem);
        }
        return true;
    }

    public boolean deleteItemFromCart(String userId, Long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);

        Optional<User> userOPt = userRepository.findById(Long.valueOf(userId));

        if (productOpt.isPresent() && userOPt.isPresent()) {
            cartItemRepository.deleteByUserAndProduct(userOPt.get(), productOpt.get());
            return true;
        }
        return false;
    }
}
