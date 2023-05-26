package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class ProductId extends EntityId {
  @Column(name = "id")
  private String value;

  public ProductId() {
  }

  public ProductId(String value) {
    super(value);
  }
}
