package kr.megaptera.assignment.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Optional;
import kr.megaptera.assignment.dtos.UpdateCartDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddCartItemServiceTest {

    private CartRepository cartRepository;

    private ProductRepository productRepository;

    private AddCartItemService addCartItemService;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        productRepository = mock(ProductRepository.class);
        addCartItemService = new AddCartItemService(cartRepository, productRepository);
    }

    @Test
    @DisplayName("장바구니에 물건 담기 테스트 - 초기 담기")
    void addItem() {
        // Given 장바구니 조회
        CartId cartId = new CartId("ID0701");
        Cart cart = new Cart(cartId);

        ProductId productId = new ProductId("P0701");
        Product product = new Product(productId, "연어", 10000);

        given(cartRepository.findById(cartId)).willReturn(Optional.of(cart));
        given(productRepository.findById(productId)).willReturn(Optional.of(product));

        // When 조회된 장바구니에 물건 추가
        UpdateCartDto updateCartDto = new UpdateCartDto(productId.toString(), 3);
        addCartItemService.addItem(cartId.toString(), updateCartDto);

        // Then 추가된 물건 확인
        assertThat(cart.cartItems()).hasSize(1);
        assertThat(cart.cartItems()).containsKey(product);
        assertThat(cart.cartItems().get(product)).isEqualTo(3);
    }

    @Test
    @DisplayName("장바구니에 물건 담기 테스트 - 추가 담기")
    void addExistedItem() {
        // Given 장바구니 조회
        CartId cartId = new CartId("ID0701");
        Cart cart = new Cart(cartId);

        ProductId productId = new ProductId("P0701");
        Product product = new Product(productId, "연어", 10000);

        given(cartRepository.findById(cartId)).willReturn(Optional.of(cart));
        given(productRepository.findById(productId)).willReturn(Optional.of(product));

        // When 조회된 장바구니에 물건 추가 + 추가된 물건 추가시 수량만 변동
        UpdateCartDto updateCartDto = new UpdateCartDto(productId.toString(), 3);
        addCartItemService.addItem(cartId.toString(), updateCartDto);

        UpdateCartDto updateCartDto2 = new UpdateCartDto(productId.toString(), 5);
        addCartItemService.addItem(cartId.toString(), updateCartDto2);

        // Then 수량 확인 및 목록 사이즈 확인
        assertThat(cart.cartItems()).hasSize(1);
        assertThat(cart.cartItems().get(product)).isEqualTo(8);
    }
}