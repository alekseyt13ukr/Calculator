package com.taran.lesson1;

import com.taran.lesson1.model.ParserReccursion;
import com.taran.lesson1.model.Reader;
import com.taran.lesson1.model.Scan;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scan scan = new Scan();
//        ResultSet resultSet = ResultSet.

        ParserReccursion parser;
        System.out.println("Input word - 'console' for work with console and what you want else for work with dialog window:");


        if (scanner.next().equals("console")) {
            parser = new ParserReccursion(new Reader().readMathString());
            parser.parsString();
            System.out.println("Result = " + parser.getResult());
        } else {
            String mathString = scan.scanMathString();
            parser = new ParserReccursion(mathString);
            parser.parsString();
            JOptionPane.showMessageDialog(null, mathString + " = " + parser.getResult());
        }




    }
}
