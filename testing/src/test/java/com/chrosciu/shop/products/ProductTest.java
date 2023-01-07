package com.chrosciu.shop.products;

import com.chrosciu.shop.products.Product.ProductBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
    @ParameterizedTest(name = "{0} => {1}")
    //@CsvSource(value = {" A good  book :A_good_book", "Book:Book", "N/A:N/A", "NIL:NIL"}, delimiter = ':', nullValues = {"NIL"}, emptyValue = "N/A")
    @MethodSource("nameShouldBeSanitized")
    @DisplayName("Name should be sanitized when using setter")
    public void nameShouldBeSanitizedWhenUsingSetter(String nameToBeSet, String expectedName) {
        //given
        Product product = Product.builder()
                .type(ProductType.BOOK)
                .build();

        //when
        product.setName(nameToBeSet);

        //then
        assertThat(product.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("nameShouldBeSanitized")
    @DisplayName("Name should be sanitized when using builder")
    public void nameShouldBeSanitizedWhenUsingBuilder(String nameToBeSet, String expectedName) {
        //given
        ProductBuilder productBuilder = Product.builder()
                .name(nameToBeSet)
                .type(ProductType.BOOK);

        //when
        Product product = productBuilder.build();

        //then
        assertThat(product.getName()).isEqualTo(expectedName);
    }

    static Stream<Arguments> nameShouldBeSanitized() {
        return Stream.of(
                Arguments.of(" A good  book ", "A_good_book"),
                Arguments.of("Book", "Book"),
                Arguments.of("", ""),
                Arguments.of(null, null)
        );
    }
}
