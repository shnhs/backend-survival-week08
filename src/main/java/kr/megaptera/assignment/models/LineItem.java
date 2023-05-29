package kr.megaptera.assignment.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "line_items")
public class LineItem extends BaseEntity {

  @EmbeddedId
  private LineItemId id;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "product_id"))
  private ProductId productId;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "quantity")
  private Long quantity;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "unit_price"))
  private Money unitPrice;

  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "total_price"))
  private Money totalPrice;

  public LineItem() {
  }

  public LineItem(LineItemId id, ProductId productId, String productName, Long quantity,
                  Money unitPrice, Money totalPrice) {
    this.id = id;
    this.productId = productId;
    this.productName = productName;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
    this.totalPrice = totalPrice;
  }
}
