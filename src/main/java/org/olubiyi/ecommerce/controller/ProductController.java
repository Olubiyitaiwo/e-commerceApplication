package org.olubiyi.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.olubiyi.ecommerce.dtos.ProductRequest;
import org.olubiyi.ecommerce.dtos.ProductResponse;
import org.olubiyi.ecommerce.model.Product;
import org.olubiyi.ecommerce.service.ProductServive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Api/products")
public class ProductController {

    private final ProductServive productServive;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<ProductResponse>(productServive.createProduct(productRequest),
                HttpStatus.CREATED);

    }
}
