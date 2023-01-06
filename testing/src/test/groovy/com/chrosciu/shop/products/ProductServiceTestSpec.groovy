package com.chrosciu.shop.products

import org.javamoney.moneta.FastMoney
import spock.lang.Specification

class ProductServiceTestSpec extends Specification {
    def VIDEO_PRODUCT = Product.builder()
            .name("Spring masterclass")
            .description("Praktyczny kurs Spring framework")
            .type(ProductType.VIDEO)
            .price(FastMoney.of(1500, "PLN"))
            .build()

    def BOOK_PRODUCT = Product.builder()
            .name("Spring guide")
            .description("Praktyczne cwiczenia do samodzielnego wykonania")
            .type(ProductType.BOOK)
            .price(FastMoney.of(200, "PLN"))
            .build()

    def VIDEO_PRODUCT_ID = 137L

    def productRepository = Mock(ProductRepository)
    def productService = new ProductService(productRepository)

    def "should return product with given id"() {
        given:
        productRepository.findById(VIDEO_PRODUCT_ID) >> Optional.of(VIDEO_PRODUCT)

        when:
        def product = productService.getBy(VIDEO_PRODUCT_ID)

        then:
        product == VIDEO_PRODUCT
    }

    def "should return product with given id with lambda"() {
        given:
        productRepository.findById(VIDEO_PRODUCT_ID) >> {
            long id -> id == VIDEO_PRODUCT_ID ? Optional.of(VIDEO_PRODUCT) : Optional.empty()
        }

        when:
        def product = productService.getBy(VIDEO_PRODUCT_ID)

        then:
        product == VIDEO_PRODUCT
    }

    def "should save product"() {
        when:
        productService.add(VIDEO_PRODUCT)

        then:
        1 * productRepository.save(VIDEO_PRODUCT)
    }

    def "should save product with argument check"() {
        when:
        productService.add(VIDEO_PRODUCT)

        then:
        1 * productRepository.save({it == VIDEO_PRODUCT})
    }
}
