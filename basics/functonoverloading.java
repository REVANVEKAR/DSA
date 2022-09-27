package basics;

import java.util.Arrays;

public class functonoverloading {
    public static void main(String[] args) {

        fun(67);
        fun("rev");
        demo(2,3,4,5,6,7);
        demo("rev","king","jod");
       // demo(); ambiguity

    }
    static void fun(int a){ // function overloading
                            // functions with same name but different arguments
        System.out.println("first one");
        System.out.println(a);


    }
// function overloading decides which program to run in compile time
    static void fun(String name){
        System.out.println("second one");
        System.out.println(name);

    }
    static void demo(int ...v){
        System.out.println(Arrays.toString(v));
    }

    static void demo(String ...v){
        System.out.println(Arrays.toString(v));
    }



}
