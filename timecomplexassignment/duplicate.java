package timecomplexassignment;

public class duplicate {
    public static void main(String[] args) {

        int[] a = {0,1,2,3,4,5,6,7,8,8,9};
        int s = findDuplicate(a);
        System.out.println(s);
    }

    public static int findDuplicate(int[] arr) {

        int n = arr.length-2;
        int sum2 = n*( n+1)/2;
        int sum = 0;
        for (int i = 0; i< arr.length ; i++){
            sum = sum + arr[i];
        }
        return sum - sum2;
    }






}
