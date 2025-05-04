package com.microservices.product.controller;

import com.microservices.product.model.dto.ProductDto;
import com.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(CREATED)
                .body(productService.createProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
