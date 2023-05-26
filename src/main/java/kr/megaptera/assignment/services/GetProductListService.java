package kr.megaptera.assignment.services;

import java.util.List;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProductListService {

  private final ProductRepository productRepository;

  public GetProductListService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getProductList() {
    return productRepository.findAll();
  }

}
