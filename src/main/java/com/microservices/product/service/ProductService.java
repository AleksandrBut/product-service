package com.microservices.product.service;

import com.microservices.product.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    ProductDto getProduct(String id);

    List<ProductDto> getProducts();

    void deleteProduct(String id);
}
