package kr.megaptera.assignment.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

  @EmbeddedId
  private ProductId id;

  @Column(name = "name")
  private String name;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "price"))
  private Money price;

  public Product() {
  }

  public Product(ProductId id, String name, Money price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public static Product create(String name, Long price) {
    return new Product(ProductId.generate(), name, new Money(price));
  }

  public ProductId id() {
    return id;
  }

  public String name() {
    return name;
  }

  public Money price() {
    return price;
  }
}
