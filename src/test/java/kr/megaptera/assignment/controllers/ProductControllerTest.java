package kr.megaptera.assignment.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import kr.megaptera.assignment.models.Money;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.services.GetProductListService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetProductListService getProductListService;

  @Test
  @DisplayName("GET /products")
  void getProductsList()
      throws Exception {

    Product product = new Product(new ProductId(), "굉장 물건", new Money(100_100L));
    given(getProductListService.getProductList()).willReturn(List.of(product));

    mockMvc.perform(get("/products"))
           .andExpect(status().isOk())
           .andExpect(content().string(containsString("물건")));
  }

  @Test
  @DisplayName("POST /products")
  void createProduct()
      throws Exception {
    String json = """
        {
          "name" : "덜 멋진 무언가",
          "price" : 50000
        }
        """;
    mockMvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON)
                                     .content(json))
           .andExpect(status().isCreated());
  }
}