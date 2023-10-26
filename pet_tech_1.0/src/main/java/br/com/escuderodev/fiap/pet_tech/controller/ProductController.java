package br.com.escuderodev.fiap.pet_tech.controller;

import br.com.escuderodev.fiap.pet_tech.dto.ProductDTO;
import br.com.escuderodev.fiap.pet_tech.entities.Product;
import br.com.escuderodev.fiap.pet_tech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Collection<ProductDTO>> findAll() {
        var products = service.findAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
        var product = service.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        var saveProduct = service.save(productDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(saveProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {
        productDTO = service.update(id, productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
