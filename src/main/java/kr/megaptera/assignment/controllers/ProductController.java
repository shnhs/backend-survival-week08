package kr.megaptera.assignment.controllers;

import java.util.List;
import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.dtos.ProductListDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.services.CreateProductService;
import kr.megaptera.assignment.services.GetProductListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

  private final GetProductListService getProductListService;
  private final CreateProductService createProductService;

  public ProductController(GetProductListService getProductListService,
                           CreateProductService createProductService) {
    this.getProductListService = getProductListService;
    this.createProductService = createProductService;
  }


  @GetMapping
  public ProductListDto getProductList() {
    List<Product> productList = getProductListService.getProductList();

    return new ProductListDto(productList.stream()
                                         .map(this::productToDto)
                                         .toList());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody CreateProductDto createProductDto) {
    createProductService.createProduct(createProductDto);
  }

  private ProductDto productToDto(Product product) {
    return new ProductDto(product.id()
                                 .toString(), product.name(), product.price()
                                                                     .asLong());
  }

}
