package com.taran.leason1;

import com.taran.leason1.model.ParserReccursion;
import com.taran.leason1.model.Reader;
import com.taran.leason1.model.Scan;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ParserReccursion parser = new ParserReccursion();
        System.out.println("Input word - 'console' for work with console and what you want else for work with dialog window:");


        if (scanner.next().equals("console")) {
            parser.parsString(new Reader().readMathString());
            System.out.println("Result = " + parser.getResult());
        } else {
            parser.parsString(new Scan().scanMathString());
            JOptionPane.showMessageDialog(null, parser.getResult());
        }




    }
}
