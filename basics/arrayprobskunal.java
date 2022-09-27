package basics;

import java.util.Arrays;
import java.util.Scanner;

public class arrayprobskunal {

    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 54, 67};
//        swap(arr, 1 , 3);
//

//        System.out.println(Arrays.toString(arr));

        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int index1 ,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
//        System.out.println(max(arr));
//        System.out.println(maxy(arr,1,3));

    }


    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while (start< end){
            //swap function
            swap(arr,start, end);
            start++;
            end--;
        }


    }

//    static int maxy(int[] arr, int start, int end){
//        int max = arr[0];
//        for (int i = start; i <= end; i++){
//            if (arr[i] > max) {
//                max = arr[i];
//            }
//        }
//        return max;
//    }
//
//    //array is not value
//    static int max(int[] arr){
//        int max = arr[0];
//        for (int i = 0; i < arr.length; i++){
//            if (arr[i] > max) {
//                max = arr[i];
//            }
//        }
//        return max;
//    }




}
