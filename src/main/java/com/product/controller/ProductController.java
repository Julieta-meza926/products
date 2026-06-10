package com.product.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/me")
    public String me(Authentication authentication) {

        return "Usuario autenticado: "
                + authentication.getName();
    }

    @GetMapping("/public")
    public String publicEndpoint() {

        return "Endpoint publico";
    }

    @GetMapping("/private")
    public String privateEndpoint() {

        return "Endpoint privado";
    }
}
