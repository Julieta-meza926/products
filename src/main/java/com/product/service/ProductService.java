package com.product.service;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getAll() {

        return repository.findAll();
    }

    public Product save(Product product) {

        return repository.save(product);
    }

    public void delete(String id) {

        repository.deleteById(id);
    }
}
