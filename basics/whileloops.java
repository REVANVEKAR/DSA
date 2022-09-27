package basics;

import java.util.Scanner;

public class whileloops {
    public static void main(String[] args) {
//        while loop syntax
        /*
            syntax:
            initialisation
                  while(conditon) {
                  body
                  increment/decrement
                  }
         */
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();

        int num = 0;
        while(num<=3){
            String z = "****";
            System.out.println(z.substring(num));
            num++;
        }
    }
}
