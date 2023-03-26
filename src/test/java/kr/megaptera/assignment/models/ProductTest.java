package kr.megaptera.assignment.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void createTest() {
        Product newProduct = new Product("연어", 10000);

        assertThat(newProduct.name.equals("연어"));
        assertThat(newProduct.price == 10000);
    }

}
