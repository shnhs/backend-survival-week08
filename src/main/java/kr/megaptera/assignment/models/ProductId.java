package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ProductId {

    String productId;

    public ProductId(String s) {

    }

    public ProductId() {
    }

    public static ProductId generate() {
        return new ProductId(TsidCreator.getTsid().toString());
    }

    public static ProductId of(String productId) {
        return new ProductId(productId);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductId productId = (ProductId) o;
        return Objects.equals(this.productId, productId.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
