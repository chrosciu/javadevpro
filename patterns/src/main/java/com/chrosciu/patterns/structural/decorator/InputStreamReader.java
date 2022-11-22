package com.chrosciu.patterns.structural.decorator;

import java.io.InputStream;
import java.util.Scanner;

public class InputStreamReader implements Reader {
    private final Scanner scanner;

    public InputStreamReader(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    @Override
    public String getText() {
        return scanner.nextLine();
    }
}
