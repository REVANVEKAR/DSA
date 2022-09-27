package basics;

import java.util.Arrays;
import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {
        // syntax
        // datatype[] variable_name = new datatype[size];
        //store 5 roll numbers
//        int[] rnos = new int[5];
        //or directly
//        int[] rnos2 = {23, 24, 12, 34, 45};

       // int[] ros; // declaration of array .
                   // ros is getting defined in the stack
     //   ros = new int[5]; // initialisation :
         // actually here object is being created is being in the memory (heap)
        Scanner in = new Scanner(System.in);
//
//       int[] arr = new int[5];
//        arr[0] = 23;
//        arr[1] = 3;
//        arr[2] = 2;
//        arr[3] = 231;
//        arr[4] = 2321;
//        // [23,3,2,231,2321]
//        System.out.println(arr[3]);

        //input using for loops
//        for(int i = 0; i < arr.length ; i++){
//            arr[i] = in.nextInt();
//        }
//        for(int i = 0; i < arr.length ; i++) {
//            System.out.print(arr[i] + " ");
//        }

        String[] str = new String[4];
        for (int i = 0;i< str.length;i++){
            str[i] = in.nextLine();
        }

        System.out.println(Arrays.toString(str));

        str[0] = "revu";

        System.out.println(Arrays.toString(str));

    }
}
