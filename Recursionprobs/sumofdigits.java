package Recursionprobs;

public class sumofdigits {

    public static void main(String[] args) {
        int n = 345;
        int s = sumOfDigitss(n);
        System.out.println(s);
    }


    public static int sumOfDigitss(int input){
        if(input==0){
            return 0;
        }

        int smallinput = input%10 + sumOfDigitss(input/10);
        return smallinput;

    }

}
