package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart extends BaseEntity {

  @EmbeddedId
  private CartId id;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "cart_id")
  @OrderBy("id")
  private List<LineItem> lineItems;

  public Cart() {
  }

  public Cart(CartId id, List<LineItem> lineItems) {
    this.id = id;
    this.lineItems = lineItems;
  }
}
