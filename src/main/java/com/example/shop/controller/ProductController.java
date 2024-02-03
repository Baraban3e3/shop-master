package com.example.shop.controller;

import com.example.shop.DTO.ProductDTO;
import com.example.shop.model.Product;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return mapProductsToDTOs(products);
    }

    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        return mapProductToDTO(product);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDTO productDTO) {
        Product product = mapDTOToProduct(productDTO);
        productService.createProduct(product);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable Long productId, @RequestBody ProductDTO updatedProductDTO) {
        Product existingProduct = productService.getProductById(productId);
        if (existingProduct != null) {
            Product updatedProduct = mapDTOToProduct(updatedProductDTO);
            productService.updateProduct(productId, updatedProduct);
        }
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    private List<ProductDTO> mapProductsToDTOs(List<Product> products) {
        return products.stream()
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO mapProductToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        return productDTO;
    }

    private Product mapDTOToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        return product;
    }
}
