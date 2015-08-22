package com.taran.leason1.model;

import javax.script.ScriptException;

public class ParserReccursion {

    boolean correctFlag = true;

    public void parsString(String mathString) {
        int positionOpenBracket = 0;
        int positionCloseBracket = 0;
        String currentPhrase = "";
        char[] mathStringInChar = mathString.toCharArray();
        for (int i = 0; i < mathStringInChar.length; i++) {
            if (mathStringInChar[i] == '(') {
                positionOpenBracket = i;
                if (mathStringInChar[i + 1] == ')') {
                    System.out.println("Incorrect phrase, stupid bastorses");
                    return;
                }
            }
        }
        System.out.println("position open bracket: " + positionOpenBracket);

        for (int i = positionOpenBracket; i < mathStringInChar.length; i++) {
            if (mathStringInChar[i] == ')') {
                positionCloseBracket = i;
                correctFlag = false;
                break;
            }
        }

        if (correctFlag) {
            System.out.println("Incorrect phrase, stupid bastorses");
            return;
        }

        System.out.println("Position close bracket: " + positionCloseBracket);

        for (int i = positionOpenBracket; i <= positionCloseBracket; i++) {
            currentPhrase += Character.toString(mathStringInChar[i]);
        }

        Number number = new Number();
        try {
            mathString = mathString.replace(currentPhrase, number.countPhrase(currentPhrase));
            System.out.println("newString: " + mathString);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        //recursion
        mathStringInChar = mathString.toCharArray();
        for (int i = 0; i < mathStringInChar.length; i++) {
            if (mathStringInChar[i] == '+' || mathStringInChar[i] == '-') {
                parsString(mathString);
            }
        }
    }
}
