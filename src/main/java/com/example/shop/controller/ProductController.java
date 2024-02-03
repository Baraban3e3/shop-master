package com.example.shop.controller;

import com.example.shop.domein.DTO.ProductDTO;
import com.example.shop.domein.model.Product;
import com.example.shop.domein.model.User;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper mapper;

    @PostMapping
    public void addProduct(@RequestBody ProductDTO productDTO) {
        Product product = mapper.mapDTOToProduct(productDTO);
        productService.createProduct(product);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products.stream()
                .map(mapper::mapProductToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        return mapper.mapProductToDTO(product);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable Long productId, @RequestBody ProductDTO updatedProductDTO) {
        Product existingProduct = productService.getProductById(productId);
        if (existingProduct != null) {
            Product updatedProduct = mapper.mapDTOToProduct(updatedProductDTO);
            productService.updateProduct(productId, updatedProduct);
        }
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @PostMapping("{productId}/order")
    public void orderProduct(@PathVariable Long productId, @RequestParam int quantity, @AuthenticationPrincipal User user) {
        productService.orderProduct(productId, quantity, user);
    }
}
