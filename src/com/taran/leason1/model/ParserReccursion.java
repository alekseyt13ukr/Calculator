package com.taran.leason1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserReccursion {

    private static boolean bracketFlag = true;

    private String result;

    public void parsString(String mathString) {

        int positionOpenBracket = 0;
        int positionCloseBracket = 0;
        String currentPhrase = "";

        Number number = new Number();

        char[] mathStringInChar = mathString.toCharArray();
        for (int i = 0; i < mathStringInChar.length; i++) {
            if (mathStringInChar[i] == '(') {
                positionOpenBracket = i;
                bracketFlag = false;
                if (mathStringInChar[i + 1] == ')') {
                    System.out.println("Empty brackets");
                }
            }
        }

        bracketFlag = true;
        for (int i = positionOpenBracket; i < mathStringInChar.length; i++) {
            if (mathStringInChar[i] == ')') {
                positionCloseBracket = i;
                bracketFlag = false;
                break;
            }
        }
        if (bracketFlag) {
            checkNumberBrackets(bracketFlag);
            return;
        }


        for (int i = positionOpenBracket; i <= positionCloseBracket; i++) {
            currentPhrase += Character.toString(mathStringInChar[i]);
        }

        String resultNumber = number.countPhrase(currentPhrase);
        mathString = mathString.replace(currentPhrase, resultNumber);

        //recursion
        mathStringInChar = mathString.toCharArray();

        Pattern pattern = Pattern.compile("^\\-?\\d+$");
        Matcher matcher = pattern.matcher(mathString);
        if (matcher.find()) {
            result = mathString;
            return;
        }

        for (int k = 0; k < mathStringInChar.length; k++) {
            if (mathStringInChar[k] == '+' || mathStringInChar[k] == '-') {
                parsString(mathString);
            }
        }
    }

    public void checkNumberBrackets(boolean correctFlag) {
        if (correctFlag) {
            System.out.println("Incorrect number of brackets");
        }
        return;
    }

    public String getResult() {
        return result;
    }
}
