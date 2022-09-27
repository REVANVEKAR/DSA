package basics;

import java.util.Scanner;

public class loopquestions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.print("enter num 1 : ");
//        int a = in.nextInt();
//        System.out.print("enter num 2 : ");
//        int b = in.nextInt();
//        System.out.print("enter num 3 : ");
//        int c = in.nextInt();

//        if (a>b && a>c){
//            System.out.println(a);
//        }
//        else if (b>a && b>c){
//            System.out.println(b);
//        }
//        else if (c>a && c>b){
//            System.out.println(c);
//        }


//        int max = a;
//        if (b>max){
//            b = max;
//        }
//        else{
//            a = max;
//        }
//        if (c>max){
//            c=max;
//        }
//        else {
//            b=max;
//        }
//        System.out.println(max);


//        int max = a;
//        if (b>max){
//           max = b;
//        }
//        if (c>max){
//            max = c;
//        }
//
//        System.out.print("teh answer is : ");
//        System.out.println(max);

//        String z = "****";
//        int n = 4;
//        System.out.println(z.substring(n));
//        for(int num = 0; num<=4; num++){
//            String z = "****";
//            System.out.println(z.substring(num));
//        }
//        String z = "****";
//        int n = 0;
//        while(n>4){
//            String z = "****";
//            System.out.println(z.substring(n));
//            n++;
//        }
        //practice 1
//        int n = 4;
//        for (int i=n; i>0; i--){
//            for (int j=0; j<i; j++){
//                System.out.print("*");
//            }
//            System.out.print("\n");
//        }

        // practice 2
//        int sum = 0;
//        System.out.print("enter number : ");
//        int n = in.nextInt();
//        for (int i=0; i<n ; i++){
//            sum = sum + (2*i);
//        }
//        System.out.print("sum of even no : ");
//        System.out.println(sum);
        // practice 3
//        System.out.print("enter number : ");
//        int m = in.nextInt();
//        for (int n =1; n<11; n++){
//            int z = m*n;
//            System.out.println(z);
//        }
//        // practice 4
//        System.out.print("enter number : ");
//        int m = in.nextInt();
//        for (int n =10; n>0; n--){
//            int z = m*n;
//            System.out.printf("%d X %d = %d\n", m , n, m*n);
//        }
             // practice 5
//        int n = 5;
//        int i = 1;
//        int fact = 1;
//        while (i<=n){
//            fact *= i;
//            i++;
//        }
//        System.out.printf("%d * %d * %d * %d * 1 = %d ",n , n-1 , n-2 , n-3 ,fact);

        int sum = 0;
        int n = 8;
        for (int i = 1; i<11 ; i++){
            int table = n*i;
            sum +=  table;
        }
        System.out.println(sum);


    }
}
