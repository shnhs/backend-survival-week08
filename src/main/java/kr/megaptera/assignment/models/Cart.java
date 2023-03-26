package kr.megaptera.assignment.models;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;


@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Embedded
    @Column(name = "cart_id")
    CartId cartId;

    @ElementCollection
    @CollectionTable(name = "cart_items", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    HashMap<Product, Integer> cartItems = new HashMap<>();


    public Cart() {
        this.cartId = CartId.generate();
    }

    public Cart(CartId cartId) {
        this.cartId = cartId;
    }

    public Cart(CartId cartId, HashMap<Product, Integer> cartItems) {
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public CartId cartId() {
        return cartId;
    }

    public HashMap<Product, Integer> cartItems() {
        return cartItems;
    }

    public void addItem(Product product, int addQuantity) {
        if (this.cartItems.containsKey(product)) {
            Integer before = this.cartItems().get(product);
            this.cartItems.replace(product, before + addQuantity);
        } else {
            this.cartItems.put(product, addQuantity);
        }
    }

    public void removeItem(Product product, int deleteQuantity) {
        if (this.cartItems().containsKey(product)) {
            Integer before = this.cartItems().get(product);
            if (before < deleteQuantity) {
                // 장바구니에 있는 양보다 더 크면 에러발생
                throw new RuntimeException();
            }
            if (before == deleteQuantity) {
                // 있는 양을 모두 제거하면 물건을 목록에서 제거
                this.cartItems().remove(product);
            }
            this.cartItems().replace(product, before - deleteQuantity);
        } else {
            throw new ProductNotFound();
        }
    }

    private int getTotalPrice() {
        Set<Product> keySet = this.cartItems().keySet();

        int totalPrice = 0;
        for (Product product : keySet) {
            Integer quantity = cartItems().get(product);
            int price = product.price();
            totalPrice = totalPrice + price * quantity;
        }
        return totalPrice;
    }

    public CartDto toDto() {
        Set<Product> keySet = this.cartItems().keySet();

        List<CartItemDto> itemList = new ArrayList<>();
        for (Product product : keySet) {
            itemList.add(new CartItemDto(product.name(), this.cartItems().get(product)));
        }

        return new CartDto(this.cartId().toString(), this.getTotalPrice(), itemList);
    }
}
