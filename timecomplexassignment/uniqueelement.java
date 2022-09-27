package timecomplexassignment;

public class uniqueelement {
    public static void main(String[] args) {
        int[] a = {1, 4, 1, 3, 2, 4, 2};
        int m = findUnique(a);
        System.out.println(m);
    }
    public static int findUnique(int[] arr) {

        int a = 0;
        for (int i = 0; i < arr.length ; i++){
            a = a ^ arr[i];
        }
        return a;
    }

}



