package Recursion;

public class problem {


    //first index of a no. using long method
//    public static int firstIndex(int[] input, int x) {
//       if (input.length == 0){
//           return -1;
//       }
//       if (input[0] == x){
//           return 0;
//       }
//        int smallarray[] = new int[input.length-1];
//        for (int i =1;i<input.length;i++) {
//            smallarray[i - 1] = input[i];
//        }
//        int fi = firstIndex(smallarray, x);
//        if(fi == -1){
//            return -1;
//        }
//        else{
//            return fi+1;
//        }
//    }

    //better Method
    public static int firstindexbetter(int a[],int x,int si){
        if (a.length == si){
            return -1;
        }
        if (a[si] == x){
            return si;
        }
        int k = firstindexbetter(a, x, si+1);
        return k;
    }

    //last index of occurence
//    public static int lastIndex(int[] input, int x) {
//       if (input.length == 0){
//           return -1;
//       }
//       if (input[input.length-1] == x){
//           return input.length-1;
//       }
//        int smallarray[] = new int[input.length-1];
//        for (int i = 0;i<smallarray.length;i++) {
//            smallarray[i] = input[i];
//        }
//        int k = lastIndex(smallarray, x);
//        if(k == -1){
//            return -1;
//        }
//        else{
//            return k;
//        }
//    }


//    public static int lasstindex(int[] a, int x){
//        if(a.length == 0){
//            return -1;
//        }
//        int smallarray[] = new int[a.length-1];
//        for (int i = 1;i<smallarray.length;i++) {
//            smallarray[i - 1] = a[i];
//        }
//        int k = lasstindex(smallarray,x);
//            if(k != -1){
//                return k + 1;
//            }
//            else {
//                if(a[0] == x){
//                    return 0;
//                }
//                else{
//                    return -1;
//                }
//            }
//        }


    public static int lastindexbet(int[] a, int x, int si){
        if(si==a.length){
            return -1;
        }
        int k = lastindexbet(a, x, si+1);
        if(k!= -1){
            return k;
        }
        else{
            if (a[si] == x ){
                return si;
            }
            else{
                return -1;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {3,7,5,9,7,65,5};
//        System.out.println(firstindexbetter(arr,7,));
//        System.out.println(lastIndex(arr,7));
        System.out.println(lastindexbet(arr,7,0));
    }
}
