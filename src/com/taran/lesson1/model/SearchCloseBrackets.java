package com.taran.lesson1.model;

public class SearchCloseBrackets {

    private String mathString;
    private boolean isHaveBracket = false;

    public SearchCloseBrackets(String mathString) {
        this.mathString = mathString;
    }

    public int getPositionCloseBracket() {
        char[] mathStringInChar = mathString.toCharArray();
        SearchOpenBrackets searchOpenBrackets = new SearchOpenBrackets(mathString);
        ParserReccursion parserReccursion = new ParserReccursion(mathString);

        int positionCloseBracket = 0;
        for (int i = searchOpenBrackets.getPositionOpenBracket(); i < mathStringInChar.length; i++) {
            if (mathStringInChar[i] == ')') {
                positionCloseBracket = i;
                isHaveBracket = true;
                parserReccursion.setBracketFlag(false);
                break;
            }
        }
        if (isHaveBracket) {
            return positionCloseBracket;
        } else {
            return -1;
        }
    }
}
