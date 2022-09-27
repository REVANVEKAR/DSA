package Recursion;

import java.util.Scanner;

public class problems {

//    public static int power(int x, int n){
//        if (n == 0){
//            return 1;
//        }
//        int smallinput = power(x , n-1);
//        int output = x * smallinput;
//        return output;
//    }
//    public static int count(int n){
//        if(n==0){
//            return 0;
//        }
//        int smallint = count(n / 10);
//        return smallint + 1;
//
//    }
//
//    public static int sum(int input[]){
//
//        if (input.length == 0){
//            return 0;
//        }
//        if(input.length == 1){
//            return input[0];
//        }
//
//        int smallarray[] = new int[input.length-1];
//        for (int i =1;i<input.length;i++){
//            smallarray[i-1] = input[i];
//        }
//        int v = input[0] + sum(smallarray);
//        return v;
//    }


    public static boolean checkNumber(int input[], int x){
        if (input.length == 0) {
            return false;
        }
        if (input[0] == x){
            return true;
        }
        int smallarray[] = new int[input.length-1];
        for (int i =1;i<input.length;i++) {
            smallarray[i - 1] = input[i];
        }
        return checkNumber(smallarray,x);
    }






    public static void main(String[] args) {
//        System.out.println(power(3,4));
//        System.out.println(count(5655743));

        int[] arr = {2,3,5,6,7,8,4};
//        System.out.println(sum(arr));
        System.out.println(checkNumber(arr,3));
    }
}
