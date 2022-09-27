package Recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(BinSearchRecur(arr,0,8,6));

    }






    public static int BinSearchRecur(int[] a, int si , int ei , int x){
        if ( si > ei ){
            return -1;
        }
        int midIndex = (si + ei)/2;
        if(a[midIndex] == x){
            return midIndex;
        }
        else if(a[midIndex] < x){
            return BinSearchRecur(a , midIndex+1 , ei , x);
        }else{
            return BinSearchRecur(a , si , midIndex-1 , x);
        }
    }




}
