package br.com.escuderodev.fiap.pet_tech.services;

import br.com.escuderodev.fiap.pet_tech.controllers.NotFoundExceptionController;
import br.com.escuderodev.fiap.pet_tech.models.Product;
import br.com.escuderodev.fiap.pet_tech.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Collection<Product> findAllProduct() {
        var product = productRepository.findAll();
        return product;
    }

    public Product findProductById(UUID id) {
        var product = productRepository.findById(id).orElseThrow(() -> new NotFoundExceptionController("Produto não encontrado!"));
        return product;
    }

    public Product save(Product product) {
        product = productRepository.save(product);
        return product;
    }

    public Product update(UUID id, Product product) {

        try {
            Product productSearch = productRepository.getReferenceById(id);
            productSearch.setNameProduct(product.getNameProduct());
            productSearch.setDescription(product.getDescription());
            productSearch.setUrlImage(product.getUrlImage());
            productSearch.setValor(product.getValor());
            productSearch = productRepository.save(productSearch);

            return productSearch;
        }
        catch (EntityNotFoundException e) {
            throw new NotFoundExceptionController("Produto não encontrado!");
        }
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}
