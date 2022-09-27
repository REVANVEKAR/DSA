package searchalgo;

import java.util.Arrays;

public class seachin2darray {


    public static void main(String[] args) {
        int[][] arr = {
                {23,4,1},
                {18,12,3,9},
                {78,99,34,56,},
                {18,12}
        };
        int target = 56;
        int[] ans = search(arr,target); //format of return value
        // {row,col}
        System.out.println(Arrays.toString(ans));
        System.out.println(max(arr));
    }


    public static int[] search(int[][] arr,int target){
        for(int row = 0; row < arr.length ; row++){
            for (int j = 0; j < arr[row].length ; j++ ){
                 if(arr[row][j] == target ){
                     return new int[]{row ,j};
                 }
            }
        }
        return new int[]{-1 , -1};
    }


    public static int max(int[][] arr){
        int max = arr[0][0];
        for(int row = 0; row < arr.length ; row++){
            for (int j = 0; j < arr[row].length ; j++ ){
                if(arr[row][j] > max ){
                    max = arr[row][j];
                }
            }
        }
        return max;
    }



}
