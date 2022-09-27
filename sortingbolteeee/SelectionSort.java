package sortingbolteeee;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {5,76,4,3,3,1};
        selection(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void selection(int[] arr){
        for(int i = 0; i < arr.length ; i++){
            //find the max item in the remaining array and swap with correct index
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0 ,last );

            Swap(arr,maxIndex,last);
        }
    }


    private static int getMaxIndex(int[] arr, int start,int end) {
        int max = start;

        for (int i = start ; i <= end; i++){
            if (arr[max] < arr[i]){
                    max = i;
            }
        }
        return max;
    }


    public static void Swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
     }
}
