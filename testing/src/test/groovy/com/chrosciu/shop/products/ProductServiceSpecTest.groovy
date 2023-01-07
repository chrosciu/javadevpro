package com.chrosciu.shop.products

import spock.lang.Specification

class ProductServiceSpecTest extends Specification {
    def VIDEO_PRODUCT = Product.builder()
            .name("Spring masterclass")
            .description("Praktyczny kurs Spring framework")
            .type(ProductType.VIDEO)
            .build()

    def BOOK_PRODUCT = Product.builder()
            .name("Spring guide")
            .description("Praktyczne cwiczenia do samodzielnego wykonania")
            .type(ProductType.BOOK)
            .build()

    def VIDEO_PRODUCT_ID = 137L
    def BOOK_PRODUCT_ID = 262L

    def productRepository = Mock(ProductRepository)
    def productValidator = Mock(ProductValidator)
    def productService = new ProductService(productRepository, productValidator)

    def "should return product with given id"() {
        given:
        productRepository.findById(VIDEO_PRODUCT_ID) >> Optional.of(VIDEO_PRODUCT)

        when:
        def product = productService.getBy(VIDEO_PRODUCT_ID)

        then:
        product == VIDEO_PRODUCT
    }

}
