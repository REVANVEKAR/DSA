package basics;

import java.util.Arrays;

public class passinginfunctionn {
    public static void main(String[] args) {
        int[] nums = {3,4,5,12};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void change(int[] lund){
        lund[0] = 99;
    }

}
