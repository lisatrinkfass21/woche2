/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbertester;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lisa
 */
public class NumberTester {

    public interface NumberTest {

        boolean testNumber(int number);
    }

    private NumberTest palindromeTester;
    private NumberTest primeTester;
    private NumberTest oddEvenTester;
    private String filePfad;

    public static void main(String[] args) {
        NumberTester nt = new NumberTester("zahlen.txt");
        nt.testFile();

    }

    public NumberTester(String fileName) {
        this.filePfad = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddEvenTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        String[] zeile = new String[2];
        int zahl1 = 0;
        int zahl2 = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePfad));
            int anzahlZeilen = Integer.parseInt(br.readLine());
            for (int i = 0; i < anzahlZeilen; i++) {
                zeile = br.readLine().split(" ");
                zahl1 = Integer.parseInt(zeile[0]);
                zahl2 = Integer.parseInt(zeile[2]);

                switch (zahl1) {
                    case 1:
                        setOddEvenTester((n) -> n % 2 == 0);
                        if (oddEvenTester.testNumber(zahl2)) {
                            System.out.println("EVEN");
                        } else {
                            System.out.println("ODD");
                        }
                        break;

                    case 2:
                        setPrimeTester((p) -> this.isPrime(p));
                        if (this.primeTester.testNumber(zahl2)) {
                            System.out.println("PRIME");
                        } else {
                            System.out.println("NO PRIME");
                        }
                        break;
                    case 3:
                        if (this.palindromeTester.testNumber(zahl2)) {
                            System.out.println("PALINDROME");
                        } else {
                            System.out.println(" NO PALINDROME");
                        }
                        break;

                    default:
                        System.out.println("ungültiges File");
                }

            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean isPrime(int p) {
        if (p <= 2) {
            return (p == 2);
        }
        for (int i = 2; i * i <= p; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }
}
