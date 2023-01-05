package com.chrosciu.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int add(String numbers) {
        String delimiters = "[,\n]";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimitersStartIndex = numbers.indexOf("//") + 2;
            int delimitersEndIndex = numbers.indexOf("\n");
            delimiters = numbers.substring(delimitersStartIndex, delimitersEndIndex);
            numbersWithoutDelimiter = numbers.substring(delimitersEndIndex + 1);
        }
        return add(numbersWithoutDelimiter, delimiters);
    }

    private static int add(String numbers, String delimiters) {
        int returnValue = 0;
        String delimitersRegex = "[" + delimiters + "]";
        String[] numbersArray = numbers.split(delimitersRegex);
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                } else if (numberInt <= 1000) {
                    returnValue += numberInt;
                }
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
        }
        return returnValue;
    }
}
