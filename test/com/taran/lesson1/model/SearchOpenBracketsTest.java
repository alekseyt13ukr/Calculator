package com.taran.lesson1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SearchOpenBracketsTest {

    SearchOpenBrackets searchOpenBrackets;

    @Before
    public void setUp() {
        String mathString = "(1+(1+1))";
        searchOpenBrackets = new SearchOpenBrackets(mathString);
    }

    @Test
    public void checkOpenBracket() {
        assertEquals(3, searchOpenBrackets.getPositionOpenBracket());
    }

    @Test
    public void checkAnotherOpenBracket() {
        assertNotEquals(0, searchOpenBrackets.getPositionOpenBracket());
    }

    @Test
    public void checkEmptyBrackets() {
        String emptyBrackets = "()";
        searchOpenBrackets = new SearchOpenBrackets(emptyBrackets);
        searchOpenBrackets.getPositionOpenBracket();
        assertEquals("Empty brackets", searchOpenBrackets.getResult());
    }

    @Test
    public void checkCorrectNumberBrackets() {
        searchOpenBrackets = new SearchOpenBrackets("1+2)");
        assertEquals(-1, searchOpenBrackets.getPositionOpenBracket());
    }

}
