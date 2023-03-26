package kr.megaptera.assignment.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Optional;
import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.repositories.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetCartServiceTest {

    private CartRepository cartRepository;

    private GetCartService getCartService;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        getCartService = new GetCartService(cartRepository);
    }

    @Test
    @DisplayName("장바구니 정보 조회 테스트")
    void getCartInfo() {
        // Given : 장바구니 정보 조회
        CartId cartId = new CartId("ID0701");

        given(cartRepository.findById(cartId)).willReturn(Optional.of(new Cart(cartId)));

        // When : 서비스 메서드 조회
        CartDto cartDto = getCartService.getById(cartId.toString());

        // Then : 아이디 확인 및 아이템 확인
        assertThat(cartDto.getCartId()).isEqualTo("ID0701");
        assertThat(cartDto.getItemList()).hasSize(0);
    }

}