package com.microservices.product.model.mapper;

import com.microservices.product.model.Product;
import com.microservices.product.model.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toModel(ProductDto productDto);

    List<ProductDto> toDtoList(List<Product> products);

    List<Product> toModelList(List<ProductDto> productDtos);
}
