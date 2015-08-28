package com.taran.lesson1.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewMathStringTest {



    @Test
    public void checkDeleteSpace() {
        ViewMathString viewMathString = new ViewMathString("1 + 1");
        String newMathString = viewMathString.changeViewString();
        assertEquals("1+1", newMathString);
        assertNotNull(viewMathString);
    }
}
