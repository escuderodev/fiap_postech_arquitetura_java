package br.com.escuderodev.fiap.pet_tech.service;

import br.com.escuderodev.fiap.pet_tech.controller.exception.NotFoundExceptionController;
import br.com.escuderodev.fiap.pet_tech.dto.ProductDTO;
import br.com.escuderodev.fiap.pet_tech.entities.Product;
import br.com.escuderodev.fiap.pet_tech.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Collection<ProductDTO> findAllProduct() {
        var product = productRepository.findAll();
        return product.stream().map(this::toProductDTO).collect(Collectors.toList());
    }

    public ProductDTO findProductById(UUID id) {
        var product = productRepository.findById(id).orElseThrow(() -> new NotFoundExceptionController("Produto não encontrado!"));
        return toProductDTO(product);
    }

    public ProductDTO save(ProductDTO productDTO) {
        var product = toProduct(productDTO);
        product = productRepository.save(product);
        return toProductDTO(product);
    }

    public ProductDTO update(UUID id, ProductDTO productDTO) {

        try {
            Product productSearch = productRepository.getReferenceById(id);
            productSearch.setNameProduct(productDTO.nameProduct());
            productSearch.setDescription(productDTO.description());
            productSearch.setUrlImage(productDTO.urlImage());
            productSearch.setValor(productDTO.valor());
            productSearch = productRepository.save(productSearch);

            return toProductDTO(productSearch);
        } catch (EntityNotFoundException e) {
            throw new NotFoundExceptionController("Produto não encontrado!");
        }
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    private ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getIdproduct(),
                product.getNameProduct(),
                product.getDescription(),
                product.getValor(),
                product.getUrlImage()
        );
    }

    private Product toProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.idproduct(),
                productDTO.nameProduct(),
                productDTO.description(),
                productDTO.valor(),
                productDTO.urlImage()
        );
    }

}
