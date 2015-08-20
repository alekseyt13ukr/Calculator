package com.taran.leason1;

import com.taran.leason1.model.Parser;
import com.taran.leason1.model.Reader;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parsString(new Reader().readMathString());


    }
}
