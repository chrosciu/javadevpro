package com.chrosciu.shop.products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ProductTest {
    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource
    @DisplayName("Name should be sanitized")
    public void nameShouldBeSanitized(String name, String expected) {
        //given
        Product.ProductBuilder productBuilder = Product.builder()
                .name(name)
                .type(ProductType.BOOK);

        //when
        Product product = productBuilder.build();

        //then
        assertThat(product.getName()).isEqualTo(expected);
    }

    static Stream<Arguments> nameShouldBeSanitized() {
        return Stream.of(
                arguments("A good  book", "A_good_book"),
                arguments("Book", "Book"),
                arguments("", ""),
                arguments(null, null)
        );
    }

    @Test
    @DisplayName("Null type should not be allowed")
    public void nullTypeShouldNotBeAllowed() {
        //given
        Product.ProductBuilder productBuilder = Product.builder()
                .name(" A good  book ");

        //when / then
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(productBuilder::build);
    }
}
