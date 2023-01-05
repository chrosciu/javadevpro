package com.chrosciu.calculator;

public class StringCalculator {
    public static int add(String numbers) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(",");
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                returnValue += Integer.parseInt(number);
            }
        }
        return returnValue;
    }
}
