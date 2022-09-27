package basics;

public class methods2 {
    public static void main(String[] args) {
        String message = greet();
        System.out.println(message);

        int abc = sum2(2 ,4);
        System.out.println(abc);

    }


    // pass the value of numbers when you are calling the method in main()

    static int sum2(int a, int b) {
        int sum2 = a + b;
        return sum2;
    }


     //return the value
     static String greet() {
        String greeting = "how are you";
        return greeting;

    }

}
