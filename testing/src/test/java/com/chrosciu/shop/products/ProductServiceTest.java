package com.chrosciu.shop.products;

import org.assertj.core.api.Assertions;
import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void shouldReturnProductWithGivenId() {
        //given
        when(productRepository.findById(VIDEO_PRODUCT_ID)).thenReturn(Optional.of(VIDEO_PRODUCT));

        //when
        Product product = productService.getBy(VIDEO_PRODUCT_ID);

        //then
        assertThat(product).isEqualTo(VIDEO_PRODUCT);
    }

    @Test
    public void shouldReturnProductWithGivenIdWithLambda() {
        //given
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
        //when
        productService.add(VIDEO_PRODUCT);

        //then
        Mockito.verify(productRepository).save(VIDEO_PRODUCT);
        Mockito.verifyNoMoreInteractions(productRepository);
    }

    @Test
    public void shouldSaveProductWithCaptor() {
        //given
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);

        //when
        productService.add(VIDEO_PRODUCT);

        //then
        Mockito.verify(productRepository).save(captor.capture());
        Assertions.assertThat(captor.getValue()).isEqualTo(VIDEO_PRODUCT);
    }


}
