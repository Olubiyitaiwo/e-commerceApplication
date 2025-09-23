package org.olubiyi.ecommerce.Repository;

import org.olubiyi.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
