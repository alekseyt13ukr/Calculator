package com.taran.leason1;

import com.taran.leason1.model.ParserReccursion;
import com.taran.leason1.model.Reader;

public class Main {

    public static void main(String[] args) {
        ParserReccursion parser = new ParserReccursion();
        parser.parsString(new Reader().readMathString());


    }
}
