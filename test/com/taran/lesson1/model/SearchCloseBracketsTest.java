package com.taran.lesson1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchCloseBracketsTest {
    SearchCloseBrackets searchCloseBrackets;

    @Before
    public void setUp() {
        searchCloseBrackets = new SearchCloseBrackets("(1+1)");
    }

    @Test
    public void checkCloseBracket() {
        assertEquals(4, searchCloseBrackets.getPositionCloseBracket());
    }

    @Test
    public void checkCorrectNumberBrackets() {
        searchCloseBrackets = new SearchCloseBrackets("(2+1");
        assertEquals(-1, searchCloseBrackets.getPositionCloseBracket());
    }
}
