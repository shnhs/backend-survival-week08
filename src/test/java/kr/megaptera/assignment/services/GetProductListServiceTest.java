package kr.megaptera.assignment.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetProductListServiceTest {

  private GetProductListService getProductListService;

  private ProductRepository productRepository;

  @BeforeEach
  void setUp() {
    productRepository = mock(ProductRepository.class);
    getProductListService = new GetProductListService(productRepository);
  }

  @Test
  void getProductList() {
    getProductListService.getProductList();

    verify(productRepository).findAll();
  }

}