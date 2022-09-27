package Recursion2;

import java.util.Arrays;

public class MergeSort {



    public static void main(String[] args) {

        int[] arr = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void mergeSort(int[] input ){

        if (input.length <= 1){
            return;
        }

        //creating two smaller arrays
        int[] b = new int[input.length/2];
        int[] c = new int[input.length - b.length];

        for(int i =0; i < input.length/2; i++){
            b[i] = input[i]; // copying elements to the first subarray
        }

        for(int i = input.length/2; i < input.length ;i++){
            c[i-input.length/2] = input[i]; // copy the elements to the second subarray
        }

        mergeSort(b);
        mergeSort(c);

        merge(b, c, input);

    }

    public static void merge(int[] s1, int[] s2, int[] d){

        //compare the smallest of 2 sub arrays to get the smallest of the larger array
        int i = 0;
        int j = 0; // initialising the index number of both subarrays to compare
        int k = 0; // index of destination array
        while(i < s1.length && j < s2.length){
            if (s1[i]<=s2[j]){
               d[k] = s1[i];
               i++;
               k++;
            }
            else{
                d[k] = s2[j];
                j++;
                k++;
            }
        }
        if(i<s1.length){
            while(i<s1.length){
                d[k] = s1[i];
                i++;
                k++;
            }
        }
        if(j<s2.length){
            while(j<s1.length){
                d[k] = s2[j];
                j++;
                k++;
            }
        }


    }





}
