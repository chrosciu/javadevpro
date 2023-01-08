package com.chrosciu.calculator;

public class StringCalculator {
    public static int add(String numbers) {
        String[] numbersArray = numbers.split(",");
        validateNumbersCount(numbersArray);
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                Integer.parseInt(number);
            }
        }
        return 0;
    }

    private static void validateNumbersCount(String[] numbersArray) {
        if (numbersArray.length > 2) {
            throw new RuntimeException("Too many numbers (max 2 allowed");
        }
    }
}
