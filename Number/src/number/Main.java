/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number;

import java.util.Scanner;

/**
 *
 * @author Lisa
 */
public class Main {

    private Scanner s = new Scanner(System.in, "windows-1252");

    public static void main(String[] args) {
        Main main = new Main();
        int calculator = main.chooseCalculator();
        int operation = main.chooseOperation();
        Number[] n = main.setNumbers();
        Number x = n[0];
        Number y = n[1];

    }

    private int chooseCalculator() {
        int auswahl;
        System.out.println("1 - Relational calculator");
        System.out.println("2 - Vector calculator");
        System.out.println("3 - Complex calculator");
        System.out.println("4 - Exit prigram");

        auswahl = Integer.parseInt(s.nextLine());
        while (auswahl < 1 || auswahl > 4) {
            try {
                auswahl = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Fehler - Sie haben keine Zahl eingegeben");
            }
            if (auswahl < 1 || auswahl > 4) {
                System.out.println("bitte geben Sie eine Zahl zwischen 1 und 4 ein");
            }
        }
        return auswahl;
    }

    private int chooseOperation() {
        int auswahl;
        System.out.println("1 - add");
        System.out.println("2 - subtraction");
        System.out.println("3 - mutliply");
        System.out.println("4 - divide");
        System.out.println("5 - enter numbers again");

        auswahl = Integer.parseInt(s.nextLine());
        while (auswahl < 1 || auswahl > 5) {
            try {
                auswahl = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Fehler - Sie haben keine Zahl eingegeben");
            }
            if (auswahl < 1 || auswahl > 5) {
                System.out.println("bitte geben Sie eine Zahl zwischen 1 und 5 ein");
            }
        }
        return auswahl;
    }

    private Number[] setNumbers() {
        Number x = new Number();
        Number y = new Number();
        int a;
        int b;
        System.out.println("Enter number x a>");
        a = Integer.parseInt(s.nextLine());
        System.out.println("Enter number x b>");
        b = Integer.parseInt(s.nextLine());
        x.setA(a);
        x.setB(b);
        System.out.println("Enter number y a>");
        a = Integer.parseInt(s.nextLine());
        System.out.println("Enter number y b>");
        b = Integer.parseInt(s.nextLine());
        y.setA(a);
        y.setB(b);
        Number[] arr = {x, y};
        return arr;

    }

}
