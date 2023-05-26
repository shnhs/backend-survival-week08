package kr.megaptera.assignment.services;

import java.util.List;
import kr.megaptera.assignment.models.Money;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.stereotype.Service;

@Service
public class GetProductListService {

  public List<Product> getProductList() {
    // TODO: 현재 작업중
    new Product(new ProductId(), "멋진물건", new Money(100_000L));
    return List.of();
  }

}
