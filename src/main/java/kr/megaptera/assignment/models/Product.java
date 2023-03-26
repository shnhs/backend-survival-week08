package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Embedded
    @Column(name = "product_id")
    ProductId productId;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    int price;

    public Product() {
    }

    public Product(ProductId productId, String name, int price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price) {
    }

    public ProductId productId() {
        return productId;
    }

    public String name() {
        return name;
    }

    public int price() {
        return price;
    }
}
