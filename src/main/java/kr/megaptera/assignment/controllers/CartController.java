package kr.megaptera.assignment.controllers;

import java.util.List;
import kr.megaptera.assignment.dtos.LineItemDto;
import kr.megaptera.assignment.dtos.LineItemsListDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart-line-items")
@CrossOrigin
public class CartController {

  @GetMapping
  public LineItemsListDto getCartItemList() {
    LineItemDto lineItemDto = new LineItemDto("test", "멋진 물건",
                                              2L, 10000L, 5000L);
    return new LineItemsListDto(List.of(lineItemDto));
  }

}
