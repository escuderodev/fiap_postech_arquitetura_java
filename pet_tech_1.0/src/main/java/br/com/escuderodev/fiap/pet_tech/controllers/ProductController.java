package br.com.escuderodev.fiap.pet_tech.controllers;

import br.com.escuderodev.fiap.pet_tech.models.Product;
import br.com.escuderodev.fiap.pet_tech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Collection<Product>> findAll() {
        var products = service.findAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable UUID id) {
        var product = service.findProductById(id);
        return ResponseEntity.ok(product);
    }



}
