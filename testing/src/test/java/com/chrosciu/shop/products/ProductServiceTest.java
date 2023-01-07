package com.chrosciu.shop.products;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;
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
            .description("Praktyczne cwiczenia do samodzielnego wykonania")
            .type(ProductType.BOOK)
            .price(FastMoney.of(200, "PLN"))
            .build();

    private static final long VIDEO_PRODUCT_ID = 137L;
    private static final long BOOK_PRODUCT_ID = 262L;

    private ProductRepository productRepository;
    private ProductValidator productValidator;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productValidator = Mockito.mock(ProductValidator.class);
        productService = new ProductService(productRepository, productValidator);
    }

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
    public void shouldThrowExceptionIfProductWithGivenIdIsNotFound() {
        //TODO
    }


    @Test
    public void shouldReturnAllProducts() {
        //TODO
    }

    @Test
    public void shouldSaveProduct() {
        //given
        //when(productRepository.save(VIDEO_PRODUCT)).thenReturn(VIDEO_PRODUCT);
        doAnswer(invocationOnMock -> {
            Product product = invocationOnMock.getArgument(0, Product.class);
            product.setId(212L);
            return product;
        }).when(productRepository).save(VIDEO_PRODUCT);

        //when
        Product addedProduct = productService.add(VIDEO_PRODUCT);

        //then
        //assertThat(addedProduct).isEqualTo(VIDEO_PRODUCT);
        assertThat(addedProduct.getId()).isEqualTo(212L);
    }

    @Test
    public void shouldValidateProductOnSave() {
        //given

        //when
        productService.add(VIDEO_PRODUCT);

        //then
        Mockito.verify(productValidator).validate(VIDEO_PRODUCT);
    }
}
