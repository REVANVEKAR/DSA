package timecomplexassignment;

import java.util.Arrays;

public class sol {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr,2);

        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] a, int s , int e ){

        int temp = 0;


        for (int i = 0; i<=(e-s)/2 ; i++){
            temp = a[s+i];
            a[s+i] = a[e-i];
            a[e-i] = temp;

        }

    }

    public static void rotate(int[] arr, int d) {

        if(arr.length==0){
            return;
        }


        reverse(arr,0, arr.length-1);
        reverse(arr,0, arr.length-1-d);
        reverse(arr, arr.length-d, arr.length-1);



    }

}
