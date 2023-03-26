package kr.megaptera.assignment.services;

import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.exceptions.CartNotFound;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.repositories.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCartService {

    private CartRepository cartRepository;

    public GetCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDto getById(String cartId) {
        Cart cart = cartRepository.findById(CartId.of(cartId)).orElseThrow(CartNotFound::new);

        return cart.toDto();
    }

}
