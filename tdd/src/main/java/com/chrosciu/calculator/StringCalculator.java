package com.chrosciu.calculator;

public class StringCalculator {
    public static int add(String numbers) {
        String[] numbersArray = numbers.split(",");
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
}
