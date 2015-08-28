package com.taran.lesson1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ParseReccursionTest {

    ParserReccursion parserReccursion;

    @Before
    public void setUp() {
        parserReccursion = new ParserReccursion("1+1");
    }

    @Test
    public void checkAlertWrong() {
        parserReccursion = new ParserReccursion("(1+)");
        parserReccursion.parsString();
        assertEquals("something wrong", parserReccursion.getResult());
    }

    @Test
    public void checkNullResult() {
        parserReccursion = new ParserReccursion("");
        assertNull(parserReccursion.getResult());
    }

    @Test
    public void checkAddBrackets() {
        parserReccursion.addBrackets();
        assertEquals("(1+1)", parserReccursion.getMathString());
    }

    @Test
    public void checkFinishNumber() {
        parserReccursion = new ParserReccursion("2");
        parserReccursion.checkFinishNumber();
        assertNotNull(parserReccursion.getResult());
    }

    @Test
    public void checkFinishNumberWithMinus() {
        parserReccursion = new ParserReccursion("-2");
        parserReccursion.checkFinishNumber();
        assertNotNull(parserReccursion.getResult());
    }
}
