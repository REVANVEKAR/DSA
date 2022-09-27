package basics;

import java.util.Scanner;

public class questionsssss {
    public static void main(String[] args) {
        Scanner is = new Scanner(System.in);
 //       int n = is.nextInt();
//
//        boolean ans = isprime(n);
//        System.out.println(ans);
   //     System.out.println(armstrong());

        for (int i = 100 ; i < 1000 ; i++){
            if (armstrong(i)){
                System.out.println(i + " ");
            }
        }

    }
    // print all the 3 digits armstrong number

    static boolean armstrong(int n) {
        int original = n;
        int sum = 0;

        while(n>0){
            int rem = n%10;
            n = n/10;
            sum = sum + rem*rem*rem;
        }

        return sum == original;
    }



//    static boolean isprime(int n) {
//        if (n <= 1){
//            return false;
//        }
//        int c = 2;
//        while(c * c <= n ) {
//            if (n % c == 0) {
//                return false;
//            }
//            c++;
//        }
//        return c * c > n;
//    }

}
