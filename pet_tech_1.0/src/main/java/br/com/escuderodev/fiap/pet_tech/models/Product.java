package br.com.escuderodev.fiap.pet_tech.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idproduct;
    private String nameProduct;
    private String Description;
    private BigDecimal valor;
    private String urlImage;

    public Product() {
    }

    public Product(String nameProduct, String description, BigDecimal valor, String urlImage) {
        this.nameProduct = nameProduct;
        Description = description;
        this.valor = valor;
        this.urlImage = urlImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idproduct, product.idproduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idproduct=" + idproduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", Description='" + Description + '\'' +
                ", valor=" + valor +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
