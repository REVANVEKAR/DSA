package Recursion;

public class CheckArraySort2 {



    public static boolean IsSortedBetter(int[] a, int si){
        if(si == a.length-1) {
            return true;
        }
        if(a[si] > a[si+1]){
            return false;
        }
        boolean SortedOrNot = IsSortedBetter(a,si+1);
        return SortedOrNot;
    }


    public static void main(String[] args) {
        int[] arr = {4,5,1,1,4,5,6,7,8,9};
        System.out.println(IsSortedBetter(arr,4));
    }

}
