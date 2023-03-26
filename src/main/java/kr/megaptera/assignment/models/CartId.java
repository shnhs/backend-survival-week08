package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CartId {

    String cartId;

    public CartId(String cartId) {
        this.cartId = cartId;
    }

    public CartId() {
    }

    public static CartId generate() {
        return new CartId(TsidCreator.getTsid().toString());
    }

    public static CartId of(String value) {
        return new CartId(value);
    }

    @Override
    public String toString() {
        return cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartId cartId = (CartId) o;
        return Objects.equals(this.cartId, cartId.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }
}
