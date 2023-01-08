package com.chrosciu.shop;

import com.chrosciu.shop.payments.ConsoleEventPublisher;
import com.chrosciu.shop.payments.InMemoryPaymentRepository;
import com.chrosciu.shop.payments.PaymentIdGenerator;
import com.chrosciu.shop.payments.PaymentRepository;
import com.chrosciu.shop.payments.PaymentService;
import com.chrosciu.shop.payments.UuidPaymentIdGenerator;
import com.chrosciu.shop.products.DummyProductValidator;
import com.chrosciu.shop.products.InMemoryProductRepository;
import com.chrosciu.shop.products.ProductRepository;
import com.chrosciu.shop.products.ProductService;
import com.chrosciu.shop.products.ProductValidator;
import lombok.Getter;

public class ShopApplication implements AutoCloseable {
    @Getter
    private final ShopService shopService;
    private final ShopWebServer shopWebServer;

    public ShopApplication() {
        System.out.println("Starting application");
        ProductRepository productRepository = new InMemoryProductRepository();
        ProductValidator productValidator = new DummyProductValidator();
        ProductService productService = new ProductService(productRepository, productValidator);
        PaymentIdGenerator paymentIdGenerator = new UuidPaymentIdGenerator();
        PaymentRepository paymentRepository = new InMemoryPaymentRepository();
        ConsoleEventPublisher eventPublisher = new ConsoleEventPublisher();
        PaymentService paymentService = new PaymentService(paymentIdGenerator, paymentRepository, eventPublisher);
        shopService = new ShopService(productService, paymentService);
        ShopRunner shopRunner = new ShopRunner(shopService);
        shopRunner.run();
        shopWebServer = new ShopWebServer();
        System.out.println("Application started");
    }

    @Override
    public void close() {
        System.out.println("Closing application");
        shopWebServer.close();
        System.out.println("Application closed");
    }
}
