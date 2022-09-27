package searchalgo;

public class binarysearchquestions {

    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};


        int ans = ceiling(arr,14);
        System.out.println(ans);


        int ans2 = floor(arr,14);
        System.out.println(ans2);

        char[] a = {'a','b','c','d','e','f','g'};
        char kya = nextGreatestLetter(a,'d');
        System.out.println(kya);

    }

    //smallest greatest number or equal to target
    static int ceiling(int[] arr,int target){
        if (target>arr[arr.length-1]){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;


        while(start<=end){
            int mid = start + (end - start)/2;
            if(target<arr[mid]){
                end = mid - 1;
            }else if(target>arr[mid]){
                start = mid +1;
            }else{
                return mid;
            }
        }
        return start ;

    }


    //greatest smaller number or equal to target
    static int floor(int[] arr,int target){


        int start = 0;
        int end = arr.length-1;


        while(start<=end){
            int mid = start + (end - start)/2;
            if(target<arr[mid]){
                end = mid - 1;
            }else if(target>arr[mid]){
                start = mid +1;
            }else{
                return mid;
            }
        }
        return end ;

    }


    static char nextGreatestLetter(char[] letters , char target){
//        if (target>=letters[letters.length-1]){
//            return letters[0];
//        }

        int start = 0;
        int end = letters.length-1;


        while(start<=end){
            int mid = start + (end - start)/2;
            if(target<letters[mid]){
                end = mid - 1;
            }else {
                start = mid +1;
            }
        }
        return letters[start % letters.length] ;
    }





}
