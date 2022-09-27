package basics;

import java.util.Scanner;

public class methods3 {
    public static void main(String[] args) {
        int a = 34;
        int b = 44;

        swap(a,b);
        System.out.println(a + " " + b);

        String name = "revanth anvekar";
        changename(name);
        System.out.println(name);




//
//        // how to swap two numbers
//        int temp = a;
//        a = b;
//        b = temp;
//
//        System.out.println(a + " " + b);


//        Scanner loda = new Scanner(System.in);
//        String name = loda.nextLine();
//
//        String personalised = greetkar(name);
//        System.out.println(personalised);

    }
    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    static void changename(String name){
        name = "rahul rana";

    }




//    static String greetkar(String name) {
//        String message = "hello " + name;
//        return message;
//    }
}
