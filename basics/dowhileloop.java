package basics;

import java.util.Scanner;

public class dowhileloop {
    public static void main(String[] args) {
        // do while loop
        /*
           do {
              body
           }while(condition);

         */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int m = 1;
        do {
            System.out.println(m);
            m++;
        }while (m<=n);
    }
}
