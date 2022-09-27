package Recursion3;

public class recursiveadv_2 {

    public static void main(String[] args) {

    }

    public static int factorialHelper(int input){
        if (input == 0){
            return 1;
        }
        return input* factorialHelper(input - 1);
    }

    public static void factorial1(int input){
        int out = factorialHelper(input);
        System.out.println(out);
    }

    public static void factorial2(int input, int answer){
        if (input == 0){
            System.out.println(answer);
            return;
        }
        answer = answer * input;
        factorial2(input - 1, answer);
    }



}
