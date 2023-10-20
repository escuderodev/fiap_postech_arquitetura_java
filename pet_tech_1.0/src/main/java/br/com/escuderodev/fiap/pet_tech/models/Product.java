package br.com.escuderodev.fiap.pet_tech.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

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

    public UUID getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(UUID idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
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
