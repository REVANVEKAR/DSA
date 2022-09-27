package Recursion3;

public class minArray {

    public static void main(String[] args) {

        int a[] = {3,4,5,2,1,7,8};
//        findMin1(a);
        printmin2(a,0,Integer.MAX_VALUE);
    }

    public static int findMin(int[] input, int startIndex){
        if (startIndex == input.length){
            return Integer.MAX_VALUE;
        }
        int minSmallArray = findMin(input, startIndex+1);
        if (input[startIndex] < minSmallArray){
            return input[startIndex];
        }else{
            return minSmallArray;
        }
    }
    public static void findMin1(int[] input){
        int min = findMin(input,0);
        System.out.println(min);
    }

    public static void printmin2(int[] a, int startIndex, int minsofar){
        if (startIndex == a.length){
            System.out.println(minsofar);
            return;
        }
        int newMinimum = minsofar;
        if (a[startIndex] < minsofar){
            newMinimum = a[startIndex];
        }
        printmin2(a, startIndex+1, newMinimum);

    }

}
