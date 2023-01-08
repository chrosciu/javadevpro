package com.chrosciu.shop;

public class Main {
    public static void main(String[] args) {
        try (ShopApplication shopApplication = new ShopApplication()) {
            ShopService shopService = shopApplication.getShopService();
            System.out.println(shopService.getProducts());
        }
    }
}
