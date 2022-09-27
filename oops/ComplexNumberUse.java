package oops;

import java.util.Scanner;

public class ComplexNumberUse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int real1 = s.nextInt();
        int imaginary1 = s.nextInt();

        int real2 = s.nextInt();
        int imaginary2 = s.nextInt();

        ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
        ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

        int choice = s.nextInt();

        if(choice == 1) {
            // Add
            c1.plus(c2);
            c1.print();
        }
        else if(choice == 2) {
            // Multiply
            c1.multiply(c2);
            c1.print();
        }
        else {
            return;
        }
    }
}
