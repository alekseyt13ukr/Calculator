package com.taran.lesson1.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserReccursion {

    private static boolean bracketFlag = true;

    private String result;

    private String mathString;

    public ParserReccursion(String mathString) {
        this.mathString = mathString;
    }

    public void parsString() {

        addBrackets();

        String currentPhrase = "";

        CountNumber countNumber = new CountNumber();
        SearchOpenBrackets searchOpenBrackets = new SearchOpenBrackets(mathString);
        SearchCloseBrackets searchCloseBrackets = new SearchCloseBrackets(mathString);

        if (searchOpenBrackets.getPositionOpenBracket() == -1) {
            result = "Number of open brackets are incorrect";
            return;
        }

        bracketFlag = true;

        if (searchCloseBrackets.getPositionCloseBracket() == -1) {
            result = "Number of close brackets are incorrect";
            return;
        }


        if (bracketFlag) {
            checkNumberBrackets(bracketFlag);
            return;
        }

        char[] mathStringInChar = mathString.toCharArray();
        for (int i = searchOpenBrackets.getPositionOpenBracket(); i <= searchCloseBrackets.getPositionCloseBracket(); i++) {
            currentPhrase += Character.toString(mathStringInChar[i]);
        }

        String resultNumber = countNumber.countPhrase(currentPhrase);
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
                parsString();
            }
        }

        if (result == null) {
            result = "something wrong";
        }
    }

    public void checkNumberBrackets(boolean correctFlag) {
        if (correctFlag) {
            result = "Incorrect number of brackets";
            System.out.println(result);
        }
        return;
    }

    public void addBrackets() {
        Pattern patternWithoutBrackets = Pattern.compile("^\\d+|\\d+$");
        Matcher matcherWithoutBrackets = patternWithoutBrackets.matcher(mathString);
        if (matcherWithoutBrackets.find()) {
            mathString = "(" + mathString + ")";
        }
    }

    public String getResult() {
        return result;
    }

    public static void setBracketFlag(boolean bracketFlag) {
        ParserReccursion.bracketFlag = bracketFlag;
    }

    public String getMathString() {
        return mathString;
    }
}
