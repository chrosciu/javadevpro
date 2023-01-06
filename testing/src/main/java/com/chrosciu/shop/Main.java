package com.chrosciu.shop;

public class Main {
    private static ShopApplication shopApplication;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(Main::terminate));
        shopApplication = new ShopApplication();
        ShopService shopService = shopApplication.getShopService();
        System.out.println(shopService.getProducts());
    }

    private static void terminate() {
        shopApplication.close();
    }
}
