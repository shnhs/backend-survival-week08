package kr.megaptera.assignment.controllers;

import java.util.List;
import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.dtos.ProductListDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

  @GetMapping
  public ProductListDto getProductList() {
    ProductDto productDto = new ProductDto("test_id", "굉장 물건", 100_000L);
    return new ProductListDto(List.of(productDto));
  }

}
