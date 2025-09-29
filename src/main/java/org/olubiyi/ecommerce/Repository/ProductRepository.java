package org.olubiyi.ecommerce.Repository;

import org.olubiyi.ecommerce.dtos.ProductResponse;
import org.olubiyi.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByActiveTrue();

    @Query("SELECT p FROM products p WHERE p.active = true AND p.stockQuantity > 0 AND lower(p.name) LIKE lower(CONCAT('%', :keyword, '%')) ")
    List<Product> searchProducts(@Param("keyword") String keyword);
}
