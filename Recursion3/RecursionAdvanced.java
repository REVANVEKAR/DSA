package Recursion3;

import java.util.Scanner;

public class RecursionAdvanced {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        String string = sc.next();
//        String[] output = Subsequence(string);
        int numberwaa = sc.nextInt();
        String[] output = keypad(numberwaa);
        for (String outstring: output){
            System.out.print(outstring+ " ");
        }



    }

    public static String[] Subsequence(String input){
        if(input.length() == 0){ // base case
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smalloutput = Subsequence(input.substring(1));
        String[] output = new String[smalloutput.length*2];
        for(int s = 0; s<smalloutput.length;s++){
            output[s] = smalloutput[s];
        }

        for(int s = 0; s<smalloutput.length;s++){
            output[smalloutput.length+s] = input.charAt(0) + smalloutput[s];
        }

        return output;
    }

    public static String[] keypad(int n){
        if(n == 0){ // base case
            String[] output = new String[1];
            output[0] = "";
            return output;
        }

        String[] smalloutput = keypad(n/10);
        int lastdigit = n%10;
        String lastDigitsoutput = getOptions(lastdigit);
        String[] output = new String[smalloutput.length* lastDigitsoutput.length()];
        int k = 0;
        for(int i = 0; i < smalloutput.length ;  i++){
            for (int j = 0; j < lastDigitsoutput.length(); j++){
                output[k] = smalloutput[i] + lastDigitsoutput.charAt(j);
                k++;
            }
        }
        return output;
    }

    public static String getOptions(int digit){
        if (digit == 2){
            return "abc";
        }
        if (digit == 3){
            return "def";
        }
        if (digit == 4){
            return "ghi";
        }
        if (digit == 5){
            return "jkl";
        }
        if (digit == 6){
            return "mno";
        }
        if (digit == 7){
            return "pqrs";
        }
        if (digit==8){
            return "tuv";
        }
        if (digit == 9){
            return "wxyz";
        }
        return "";
    }
}
