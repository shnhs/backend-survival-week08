package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.UpdateCartDto;
import kr.megaptera.assignment.services.AddCartItemService;
import kr.megaptera.assignment.services.DeleteCartItemService;
import kr.megaptera.assignment.services.GetCartService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private GetCartService getCartService;
    private AddCartItemService addCartItemService;
    private DeleteCartItemService deleteCartItemService;

    public CartController(GetCartService getCartService, AddCartItemService addCartItemService,
        DeleteCartItemService deleteCartItemService) {
        this.getCartService = getCartService;
        this.addCartItemService = addCartItemService;
        this.deleteCartItemService = deleteCartItemService;
    }

    // 장바구니 정보 불러오기
    @GetMapping()
    public CartDto getCartInfo(@RequestParam String cartId) {
        return getCartService.getById(cartId);
    }

    // 장바구니에 물건 추가
    @PostMapping
    public void addCartItem(@RequestParam String cartId,
        @RequestBody UpdateCartDto updateCartDto) {
        addCartItemService.addItem(cartId, updateCartDto);
    }

    // 장바구니에서 물건 제거
    @DeleteMapping
    public void deleteCartItem(@RequestParam String cartId,
        @RequestBody UpdateCartDto updateCartDto) {
        deleteCartItemService.deleteItem(cartId, updateCartDto);
    }


}
