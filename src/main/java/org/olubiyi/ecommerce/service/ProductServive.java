package org.olubiyi.ecommerce.service;

import lombok.AllArgsConstructor;
import org.olubiyi.ecommerce.Repository.ProductRepository;
import org.olubiyi.ecommerce.dtos.ProductRequest;
import org.olubiyi.ecommerce.dtos.ProductResponse;
import org.olubiyi.ecommerce.model.Product;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ProductServive {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        updateProductFromRequest(product, productRequest);
        productRepository.save(product);
        Product savedProduct = productRepository.save(product);
        return mapToProductResponse(savedProduct);
    }

    private void updateProductFromRequest(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
    }
}
