package com.chrosciu.calculator;

public class StringCalculator {
    public static int add(String numbers) {
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        } else {
            for (String number : numbersArray) {
                Integer.parseInt(number);
            }
        }
        return 0;
    }
}
