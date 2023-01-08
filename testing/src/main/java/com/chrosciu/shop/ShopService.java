package com.chrosciu.shop;

import com.chrosciu.shop.payments.Payment;
import com.chrosciu.shop.payments.PaymentRequest;
import com.chrosciu.shop.payments.PaymentService;
import com.chrosciu.shop.products.Product;
import com.chrosciu.shop.products.ProductService;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;

import javax.money.Monetary;
import java.util.List;

@RequiredArgsConstructor
public class ShopService {
    private final ProductService productService;
    private final PaymentService paymentService;

    public List<Product> getProducts() {
        return productService.getAll();
    }

    public Product addProduct(Product product) {
        return productService.add(product);
    }

    public Payment createPayment(long... productIds) {
        FastMoney totalPrice = FastMoney.zero(Monetary.getCurrency("PLN"));
        for (long productId: productIds) {
            Product product = productService.getBy(productId);
            totalPrice = totalPrice.add(product.getPrice());
        }
        PaymentRequest paymentRequest = new PaymentRequest(totalPrice);
        return paymentService.process(paymentRequest);
    }
}
