package kr.megaptera.assignment.dtos;

import java.util.List;

public class CartDto {

    String cartId;

    int totalPrice;

    List<CartItemDto> itemList;

    public CartDto() {
    }

    public CartDto(String cartId, int totalPrice, List<CartItemDto> itemList) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
        this.itemList = itemList;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<CartItemDto> itemList) {
        this.itemList = itemList;
    }
}
