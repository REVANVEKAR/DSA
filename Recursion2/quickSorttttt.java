package Recursion2;

import java.util.Arrays;

 public class quickSorttttt {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] a, int s , int e){
        if(s >=e){
            return ; //base case
        }
        int pivotIndex = partition(a,s,e);
        quickSort(a,s,pivotIndex-1); //calling quicksort on the first part
        quickSort(a,pivotIndex+1,e); //calling quicksort on second part

    }

    public static int partition(int[] a, int si, int ei){
        int pivotElement = a[si];
        int smallerNumberCount = 0;
        for (int i = si + 1; i <= ei ; i++){
            if(a[i]<pivotElement){
                smallerNumberCount++; //finding the number of smaller elements
                //than the pivot number
            }
        }

        int temp = a[si + smallerNumberCount]; //changing the position of pivot element
        a[si + smallerNumberCount] = a[si];
        a[si] = temp;

        //moving smaller numbers to left and bigger numbers to right
        int i = si;
        int j = ei;
        while(i < j){
            if (a[i] < pivotElement){
                i++;
            }else if (a[j] >= pivotElement ){
                j--;
            }else{ // it runs when both the above conditions fail
                //making it suitable for our case to swap
                int tempp = a[i];
                a[i] = a[j];
                a[j] = tempp;
                i++;
                j--;
            }
        }
        return si + smallerNumberCount;
    }



}
