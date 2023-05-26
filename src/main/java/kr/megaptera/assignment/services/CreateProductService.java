package kr.megaptera.assignment.services;

import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {

  private ProductRepository productRepository;

  public CreateProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product createProduct(CreateProductDto createProductDto) {
    Product product = Product.create(createProductDto.name(), createProductDto.price());

    productRepository.save(product);

    return product;
  }

}
