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
        ComplexCalculator cc = new ComplexCalculator();
        RationalCalculator rc = new RationalCalculator();
        VectorCalculator vc = new VectorCalculator();

        Number[] n;
        Number x;
        Number y;
        int calculator;
        int operation;
        do {
            calculator = main.chooseCalculator();
            switch (calculator) {
                case 1:
                    n = main.setNumbers();
                    x = n[0];
                    y = n[1];
                    operation = main.chooseOperation();
                    main.ausGabeErgebnis(main.doSwitch(operation, rc, x, y));
                    break;
                case 2:
                    n = main.setNumbers();
                    x = n[0];
                    y = n[1];
                    operation = main.chooseOperation();
                    main.ausGabeErgebnis(main.doSwitch(operation, vc, x, y));
                    break;
                case 3:
                    n = main.setNumbers();
                    x = n[0];
                    y = n[1];
                    operation = main.chooseOperation();
                    main.ausGabeErgebnis(main.doSwitch(operation, cc, x, y));
                    break;
                default:
                    System.out.println("ungültige Zahl");
            }
        } while (calculator != 4);

    }

    private void ausGabeErgebnis(Number erg) {
        System.out.println("Solution:");
        System.out.println("a = " + erg.getA());
        System.out.println("b = " + erg.getB());
    }

    private Number doSwitch(int operation, AbstractCalculator calc, Number a, Number b) {
        Number erg = new Number();
        switch (operation) {
            case 1:
                erg = calc.add(a, b);
                break;
            case 2:
                erg = calc.subtract(a, b);
                break;
            case 3:
                erg = calc.multiply(a, b);
                break;
            case 4:
                erg = calc.divide(a, b);
                break;

            default:
                System.out.println("ungültige Zahl");
        }
        return erg;
    }

    private int chooseCalculator() {
        int auswahl;
        System.out.println("Choose Calculator:");
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
        System.out.println("Choose Calculator:");
        System.out.println("1 - add");
        System.out.println("2 - subtraction");
        System.out.println("3 - mutliply");
        System.out.println("4 - divide");

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
