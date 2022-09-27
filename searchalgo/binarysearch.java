package searchalgo;

public class binarysearch {


    public static void main(String[] args) {
        int[] arr = {-14,-12,-4,0,2,3,4,5,6,7,8,9};
        int ans = binarySearch(arr,7);
        System.out.println(ans);
    }
    //return the index
    //retrun -1 if it doesn't exist
    static int binarySearch(int[] arr , int target){
        int start =  0;
        int end = arr.length - 1;

        while(start <= end){
            //find the middle element
            //int mid = (start+end)/2;
            //theres a problem , might be possible that start + end
            //can exceed the int value range, we can use

            //better way to find miD
            int mid = start + (end-start)/2;
            if (target<arr[mid]){
                end = mid-1;
            }else if (target > arr[mid]){
                start = mid + 1;
            }else{
                // ans found
                return mid;
            }
        }
        return -1;
    }

}
