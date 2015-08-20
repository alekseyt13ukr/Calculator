package com.taran.leason1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    String sign = null;

    public List<Integer> separateNumber(String partOfMathString) {
        List<String> numbersString = new ArrayList<>();
        Pattern patternNumber = Pattern.compile("(\\d+)");
        Matcher matcherNumber = patternNumber.matcher(partOfMathString);
        while (matcherNumber.find()) {
            numbersString.add(matcherNumber.group());
        }
        List<Integer> numbersInt = new ArrayList<>();
        for (String number: numbersString) {
            numbersInt.add(Integer.parseInt(number));
        }
        System.out.println(numbersInt);
        return numbersInt;
    }

    public void separateSign(String partOfMathString) {
        Pattern patternSign = Pattern.compile("\\+|\\-");
        Matcher matcherSign = patternSign.matcher(partOfMathString);

        while (matcherSign.find()) {
            sign = matcherSign.group();
        }
    }

    public void parsString(String mathString) {
        Pattern pattern = Pattern.compile("(\\(.*?\\))");
        Matcher matcher = pattern.matcher(mathString);

        List<String> groupsMathString = new ArrayList<>();
        while (matcher.find()) {
            groupsMathString.add(matcher.group());
        }

        for (String partOfMathString: groupsMathString) {
            separateSign(partOfMathString);

            Plus plus = new Plus();
            Minus minus = new Minus();

            if (sign.equals("+")) {
                int i = 0;
                mathString = mathString.replace(partOfMathString, String.valueOf(plus.plus
                        (separateNumber(partOfMathString).get(i), separateNumber(partOfMathString).get(++i))));
            } else if (sign.equals("-")) {
                int i = 0;
                mathString = mathString.replace(partOfMathString, String.valueOf(minus.minus
                        (separateNumber(partOfMathString).get(i), separateNumber(partOfMathString).get(++i))));
            }

            System.out.println(mathString);
        }
    }
}
