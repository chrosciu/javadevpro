package com.chrosciu.shop.products;

import org.assertj.core.api.Assertions;
import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class ProductServiceTest {
    private static final Product VIDEO_PRODUCT = Product.builder()
            .name("Spring masterclass")
            .description("Praktyczny kurs Spring framework")
            .type(ProductType.VIDEO)
            .price(FastMoney.of(1500, "PLN"))
            .build();

    private static final Product BOOK_PRODUCT = Product.builder()
            .name("Spring guide")
            .description("Praktyczne cwiczenia do samodzielnego wykonania")
            .type(ProductType.BOOK)
            .price(FastMoney.of(200, "PLN"))
            .build();

    private static final long VIDEO_PRODUCT_ID = 137L;
    private static final long BOOK_PRODUCT_ID = 262L;

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    public void shouldReturnProductWithGivenId() {
        //given
        Mockito.when(productRepository.findById(VIDEO_PRODUCT_ID)).thenReturn(Optional.of(VIDEO_PRODUCT));

        //when
        Product product = productService.getBy(VIDEO_PRODUCT_ID);

        //then
        Assertions.assertThat(product).isEqualTo(VIDEO_PRODUCT);
    }

    @Test
    public void shouldThrowExceptionIfProductWithGivenIdIsNotFound() {
        //TODO
    }


    @Test
    public void shouldReturnAllProducts() {
        //TODO
    }

    @Test
    public void shouldSaveProduct() {
        //TODO
    }
}
