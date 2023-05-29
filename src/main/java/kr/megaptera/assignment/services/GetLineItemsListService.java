package kr.megaptera.assignment.services;

import java.util.List;
import kr.megaptera.assignment.models.LineItem;
import org.springframework.stereotype.Service;

@Service
public class GetLineItemsListService {

  private final String cartId = "TEST_CART";

  public List<LineItem> getLineItems() {

    return List.of();
  }
}
