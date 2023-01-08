package com.chrosciu.calculator;

public class StringCalculator {
    public static int add(String numbers) {
        String[] numbersArray = numbers.split(",");
        validateNumbersCount(numbersArray);
        return getSum(numbersArray);
    }

    private static int getSum(String[] numbersArray) {
        int sum = 0;
        for (String number : numbersArray) {
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }

    private static void validateNumbersCount(String[] numbersArray) {
        if (numbersArray.length > 2) {
            throw new RuntimeException("Too many numbers (max 2 allowed");
        }
    }
}
