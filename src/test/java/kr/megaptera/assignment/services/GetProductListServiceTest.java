package kr.megaptera.assignment.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import kr.megaptera.assignment.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetProductListServiceTest {

  private GetProductListService getProductListService;

  @BeforeEach
  void setUp() {
    getProductListService = new GetProductListService();
  }

  @Test
  void getProductList() {
    List<Product> productList = getProductListService.getProductList();

    assertThat(productList).hasSize(1);
  }

}