package kr.megaptera.assignment.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
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

class DeleteCartItemServiceTest {

    private CartRepository cartRepository;

    private ProductRepository productRepository;

    private DeleteCartItemService deleteCartItemService;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        productRepository = mock(ProductRepository.class);
        deleteCartItemService = new DeleteCartItemService(cartRepository, productRepository);
    }

    @Test
    @DisplayName("장바구니 물건 삭제 테스트")
    void deleteTest() {
        // Given 메서드와 엔티티 스터빙
        CartId cartId = new CartId("ID0701");

        ProductId productId = new ProductId("P0701");
        Product product = new Product(productId, "연어", 10000);

        Cart cart = new Cart(cartId, new HashMap<>() {{
            put(product, 3);
        }});

        given(cartRepository.findById(cartId)).willReturn(
            Optional.of(cart));
        given(productRepository.findById(productId)).willReturn(Optional.of(product));

        // When 서비스 호출
        UpdateCartDto updateCartDto = new UpdateCartDto(productId.toString(), 2);
        deleteCartItemService.deleteItem(cartId.toString(), updateCartDto);

        // Then 목록에서 제거된거 확인
        assertThat(cart.cartItems()).hasSize(1);
        assertThat(cart.cartItems()).containsKey(product);
        assertThat(cart.cartItems().get(product)).isEqualTo(1);
    }

}