package searchalgo;

public class minnum {
    public static void main(String[] args) {
        int[] nums = {23,45,56,1,2,8,19,-3,-11};

        System.out.println(minnum(nums));
    }

    static int minnum(int[] arr) {
        int min = arr[0];
        for (int i = 0; i< arr.length;i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
