package com.taran.lesson1.model;

import java.util.Scanner;

public class Reader {
    public String readMathString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input math string");
        String mathString = scanner.nextLine();

        return mathString;
    }
}
