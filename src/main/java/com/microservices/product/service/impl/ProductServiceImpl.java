package com.microservices.product.service.impl;

import com.microservices.product.model.mapper.ProductMapper;
import com.microservices.product.model.dto.ProductDto;
import com.microservices.product.repository.ProductRepository;
import com.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return save(productDto);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return save(productDto);
    }

    @Override
    public ProductDto getProduct(String id) {
        return productMapper.toDto(
                productRepository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    public List<ProductDto> getProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    private ProductDto save(ProductDto productDto) {
        return productMapper.toDto(
                productRepository.save(
                        productMapper.toModel(productDto)
                )
        );
    }
}
