package com.chrosciu.shop;

import com.chrosciu.shop.products.Product;
import com.chrosciu.shop.products.ProductType;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;

@RequiredArgsConstructor
public class ShopRunner {
    private final ShopService shopService;

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


    public void run() {
        shopService.addProduct(VIDEO_PRODUCT);
        shopService.addProduct(BOOK_PRODUCT);

        shopService.createPayment(VIDEO_PRODUCT.getId(), BOOK_PRODUCT.getId());
    }
}
