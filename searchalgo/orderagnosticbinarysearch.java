package searchalgo;

import java.util.Scanner;

public class orderagnosticbinarysearch {


    public static void main(String[] args) {


        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


        int ans1 = OABinarySearch(arr, 3);
        System.out.println(ans1);

        int ans2 = OABinarySearch(arr2, 3);

        System.out.println(ans2);


    }




    static int OABinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //find whether ascending or descending
        boolean isAsc = arr[start] < arr[end];


        while (start <= end) {
            //find the middle element
            //int mid = (start+end)/2;
            //theres a problem , might be possible that start + end
            //can exceed the int value range, we can use

            //better way to find miD
            int mid = start + (end - start) / 2;

//            if (arr[mid] == target) {
//                return mid;
//            }

            if(isAsc){
                if(target < arr[mid]){
                    end = mid -1;
                }else if(target > arr[mid]){
                    start = mid + 1;
                }
            }
            else{
                if(target < arr[mid]){
                    start = mid + 1;
                }else if(target > arr[mid]){
                    end = mid -1;
                }
            }


        }
        return -1;
    }

}




