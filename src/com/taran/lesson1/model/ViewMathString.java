package com.taran.lesson1.model;

import java.util.ArrayList;
import java.util.List;

public class ViewMathString {

    private String mathString;

    public ViewMathString(String mathString) {
        this.mathString = mathString;
    }

    public String changeViewString() {
        String newMathString;
        char[] mathStringInChar = mathString.toCharArray();
        List<Character> newStringInChar = new ArrayList<>();

        for (char symbolString: mathStringInChar) {
            if (symbolString != ' ') {
                newStringInChar.add(symbolString);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character symbol: newStringInChar) {
            stringBuilder.append(symbol);
        }


        return stringBuilder.toString();
    }
}
