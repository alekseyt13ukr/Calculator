package com.taran.lesson1.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CountNumberTest {

    CountNumber countNumber;

    @Before
    public void setUp() {
        countNumber = new CountNumber();
    }

    @Test
    public void countPhraseTest() {
        String actualResult = "10";

        assertEquals(actualResult, countNumber.countPhrase("5+5"));
    }

    @Test
    public void countPhraseFailTest() {
        String actualResult = "5";
        CountNumber countNumber = new CountNumber();
        assertFalse(actualResult.equals(countNumber.countPhrase("5+5")));
    }

    @Test
    public void countPhraseNotNullTest() {
        assertNotNull(countNumber.countPhrase("1+1"));
    }
}
