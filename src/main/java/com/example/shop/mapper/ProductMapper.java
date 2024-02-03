package com.example.shop.mapper;

import com.example.shop.domein.DTO.ProductDTO;
import com.example.shop.domein.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductMapper {

    private final ModelMapper mapper;

    public Product mapDTOToProduct(ProductDTO productDTO){
        return mapper.map(productDTO, Product.class);
    }
    public ProductDTO mapProductToDTO(Product product){
        return mapper.map(product, ProductDTO.class);
    }
}
