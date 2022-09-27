package Recursion;

public class CheckIfArraySorted {

    public static boolean IsSorted(int[] a){
        if(a.length == 1){//base case
            return true;
        }
        if(a[0] > a[1]){
            return false;
        }
        int smallarray[] = new int[a.length-1];
        for (int i =1;i<a.length;i++){
            smallarray[i-1] = a[i];
        }
        boolean isSmallArraySorted = IsSorted(smallarray);
        return isSmallArraySorted;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7};
//        if(IsSorted(arr) == true){
//        System.out.println("sorted he bhai");
//        }
//        else{
//            System.out.println("thoda sorting karle");
//        }

        System.out.println(IsSorted(arr));
    }
}
