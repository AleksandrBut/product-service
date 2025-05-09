package com.microservices.product.model.dto;

import java.math.BigDecimal;

public record ProductDto(
        String id,
        String name,
        String description,
        BigDecimal price
) {
}
