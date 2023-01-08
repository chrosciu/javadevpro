package com.chrosciu.calculator;

public class StringCalculator {
    public static int add(String numbers) {
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Too many numbers (max 2 allowed");
        }
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                Integer.parseInt(number);
            }
        }
        return 0;
    }
}
