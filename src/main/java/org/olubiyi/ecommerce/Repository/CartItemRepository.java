package org.olubiyi.ecommerce.Repository;

import org.olubiyi.ecommerce.model.CartItem;
import org.olubiyi.ecommerce.model.Product;
import org.olubiyi.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUserAndProduct(User user, Product product);

    void deleteByUserAndProduct(User user, Product product);
}
