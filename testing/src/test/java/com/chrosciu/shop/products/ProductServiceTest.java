package com.chrosciu.shop.products;

import org.assertj.core.api.Assertions;
import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);
        when(productRepository.findById(VIDEO_PRODUCT_ID)).thenReturn(Optional.of(VIDEO_PRODUCT));

        //when
        Product product = productService.getBy(VIDEO_PRODUCT_ID);

        //then
        assertThat(product).isEqualTo(VIDEO_PRODUCT);
    }

    @Test
    public void shouldReturnProductWithGivenIdWithLambda() {
        //given
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);
        doAnswer(invocation -> {
            long id = invocation.getArgument(0, Long.class);
            return id == VIDEO_PRODUCT_ID ? Optional.of(VIDEO_PRODUCT) : Optional.empty();
        }).when(productRepository).findById(anyLong());

        //when
        Product product = productService.getBy(VIDEO_PRODUCT_ID);

        //then
        assertThat(product).isEqualTo(VIDEO_PRODUCT);
    }

    @Test
    public void shouldSaveProduct() {
        //given
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);

        //when
        productService.add(VIDEO_PRODUCT);

        //then
        Mockito.verify(productRepository).save(VIDEO_PRODUCT);
        Mockito.verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void shouldSaveProductWithCaptor() {
        //given
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);

        //when
        productService.add(VIDEO_PRODUCT);

        //then
        Mockito.verify(productRepository).save(captor.capture());
        Assertions.assertThat(captor.getValue()).isEqualTo(VIDEO_PRODUCT);
    }


}
