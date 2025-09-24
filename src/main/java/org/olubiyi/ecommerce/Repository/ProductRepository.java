package org.olubiyi.ecommerce.Repository;

import org.olubiyi.ecommerce.dtos.ProductResponse;
import org.olubiyi.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByActiveTrue();
}
