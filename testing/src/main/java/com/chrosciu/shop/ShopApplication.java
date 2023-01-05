package com.chrosciu.shop;

import com.chrosciu.shop.payments.ConsoleEventPublisher;
import com.chrosciu.shop.payments.MapPaymentRepository;
import com.chrosciu.shop.payments.PaymentIdGenerator;
import com.chrosciu.shop.payments.PaymentRepository;
import com.chrosciu.shop.payments.PaymentService;
import com.chrosciu.shop.payments.UuidPaymentIdGenerator;
import com.chrosciu.shop.products.MapProductRepository;
import com.chrosciu.shop.products.ProductRepository;
import com.chrosciu.shop.products.ProductService;
import lombok.Getter;

public class ShopApplication {
    @Getter
    private ShopService shopService;

    public ShopApplication() {
        ProductRepository productRepository = new MapProductRepository();
        ProductService productService = new ProductService(productRepository);
        PaymentIdGenerator paymentIdGenerator = new UuidPaymentIdGenerator();
        PaymentRepository paymentRepository = new MapPaymentRepository();
        ConsoleEventPublisher eventPublisher = new ConsoleEventPublisher();
        PaymentService paymentService = new PaymentService(paymentIdGenerator, paymentRepository, eventPublisher);
        shopService = new ShopService(paymentService, productService);
        ShopRunner shopRunner = new ShopRunner(shopService);
        shopRunner.run();
    }
}
