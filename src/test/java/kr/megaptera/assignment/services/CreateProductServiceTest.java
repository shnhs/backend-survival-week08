package kr.megaptera.assignment.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateProductServiceTest {

  private CreateProductService createProductService;
  private ProductRepository productRepository;

  @BeforeEach
  void setUp() {
    productRepository = mock(ProductRepository.class);
    createProductService = new CreateProductService(productRepository);
  }

  @Test
  void createProduct() {

    CreateProductDto createProductDto = new CreateProductDto("뭔가 물건", 100L);
    Product product = createProductService.createProduct(createProductDto);

    assertThat(product.name()).isEqualTo("뭔가 물건");
    assertThat(product.price()
                      .asLong()).isEqualTo(100L);

    verify(productRepository).save(product);
  }

}