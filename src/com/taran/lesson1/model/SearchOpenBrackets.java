package com.taran.lesson1.model;

public class SearchOpenBrackets {

    private String result;
    private String mathString;
    private boolean isHaveBracket = false;

    public SearchOpenBrackets(String mathString) {
        this.mathString = mathString;
    }

    public int getPositionOpenBracket() {
        char[] mathStringInChar = mathString.toCharArray();
        int positionOpenBracket = 0;
        ParserReccursion parserReccursion = new ParserReccursion(mathString);

        for (int i = 0; i < mathStringInChar.length; i++) {
            if (mathStringInChar[i] == '(') {
                positionOpenBracket = i;
                parserReccursion.setBracketFlag(false);
                isHaveBracket = true;
                if (mathStringInChar[i + 1] == ')') {
                    System.out.println("Empty brackets");
                    result = "Empty brackets";
                    break;
                }
            }
        }
        if (isHaveBracket) {
            return positionOpenBracket;
        } else {
            return -1;
        }
    }

    public String getResult() {
        return result;
    }
}
