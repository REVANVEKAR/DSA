package basics;

import java.util.Arrays;

public class varargs {
    public static void main(String[] args) {
        fun(2, 3, 4, 5, 6);
        multiple(2,3,"rev","nice","god");

    }

    static void multiple(int a, int b, String ...v){
        System.out.println();
    }

    static void fun(int ...v) {
        System.out.println(Arrays.toString(v));
    }
}
