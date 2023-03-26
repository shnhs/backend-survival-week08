package kr.megaptera.assignment.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTest {


    @Test
    @DisplayName("장바구니 생성 테스트")
    void createTest() {
        // 장바구니 생성
        Cart cart = new Cart();

        assertThat(cart.cartItems()).hasSize(0);
    }

    @Test
    @DisplayName("아이템 추가 테스트")
    void addItem() {
        CartId cartId = new CartId("ID0701");
        Cart cart = new Cart(cartId);

        Product product = new Product("연어", 10000);
        Product otherProduct = new Product("고등어", 5000);

        cart.addItem(product, 1);

        assertThat(cart.cartItems).hasSize(1);
        assertThat(cart.cartItems).containsKey(product);

        cart.addItem(otherProduct, 2);
        assertThat(cart.cartItems).hasSize(2);
    }

    @Test
    @DisplayName("이미 있는 아이템 추가 테스트")
    void addExistedItem() {
        CartId cartId = new CartId("ID0701");
        Cart cart = new Cart(cartId);

        Product product = new Product("연어", 10000);

        cart.addItem(product, 1);
        assertThat(cart.cartItems).hasSize(1);

        cart.addItem(product, 2);
        assertThat(cart.cartItems).hasSize(1);
        assertThat(cart.cartItems.get(product)).isEqualTo(3);
    }

    @Test
    @DisplayName("물건 제거 테스트")
    void removeItem() {
        CartId cartId = new CartId("ID0701");
        Cart cart = new Cart(cartId);

        Product product = new Product("연어", 10000);

        cart.addItem(product, 1);
        assertThat(cart.cartItems).hasSize(1);

        cart.removeItem(product, 1);
        assertThat(cart.cartItems).hasSize(0);
    }

}
