package com.chrosciu.shop;

public class Main {
    private static ShopApplication shopApplication;

    public static void main(String[] args) {
        shopApplication = new ShopApplication();
        Runtime.getRuntime().addShutdownHook(new Thread(shopApplication::close));
        ShopService shopService = shopApplication.getShopService();
        System.out.println(shopService.getProducts());
    }
}
