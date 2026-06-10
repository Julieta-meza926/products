package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/me")
    public String me(Authentication authentication) {

        return "Usuario autenticado: "
                + authentication.getName();
    }

    @GetMapping
    public List<Product> getProducts() {

        return productService.getAll();
    }

    @PostMapping
    public Product createProduct(
            @RequestBody Product product
    ) {

        return productService.save(product);
    }

    @GetMapping("/public")
    public String publicEndpoint() {

        return "Endpoint publico";
    }
}