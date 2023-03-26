package kr.megaptera.assignment.services;

import kr.megaptera.assignment.dtos.UpdateCartDto;
import kr.megaptera.assignment.exceptions.CartNotFound;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class AddCartItemService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public AddCartItemService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


    public void addItem(String cartId, UpdateCartDto updateCartDto) {
        Cart cart = cartRepository.findById(CartId.of(cartId)).orElseThrow(CartNotFound::new);

        Product product = productRepository.findById(ProductId.of(updateCartDto.getProductId()))
                                           .orElseThrow(
                                               ProductNotFound::new);

        cart.addItem(product, updateCartDto.getQuantity());
    }
}
