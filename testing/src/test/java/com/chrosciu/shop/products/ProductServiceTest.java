package com.chrosciu.shop.products;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {
    private static final Product VIDEO_PRODUCT = Product.builder()
            .name("Spring masterclass")
            .description("Praktyczny kurs Spring framework")
            .type(ProductType.VIDEO)
            .price(FastMoney.of(1500, "PLN"))
            .build();

    private static final Product BOOK_PRODUCT = Product.builder()
            .name("Spring guide")
            .description("Praktyczne ćwiczenia do samodzielnego wykonania")
            .type(ProductType.BOOK)
            .price(FastMoney.of(200, "PLN"))
            .build();

    private static final long VIDEO_PRODUCT_ID = 137L;

    @Test
    public void shouldReturnProductWithGivenId() {
        //given
        Map<Long, Product> productMap = Map.of(VIDEO_PRODUCT_ID, VIDEO_PRODUCT);
        MapProductRepository productRepository = new MapProductRepository(productMap);
        ProductService productService = new ProductService(productRepository);

        //when
        Product product = productService.getBy(VIDEO_PRODUCT_ID);

        //then
        assertThat(product).isEqualTo(VIDEO_PRODUCT);
    }

    @Test
    public void shouldThrowExceptionIfProductWithGivenIdIsNotFound() {
        //TODO
    }

    @Test
    public void shouldSaveProduct() {
        //TODO
    }

    @Test
    public void shouldReturnAllProducts() {
        //TODO
    }
}
