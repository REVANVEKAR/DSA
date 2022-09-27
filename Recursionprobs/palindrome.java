package Recursionprobs;

public class palindrome {

    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(isStringPalindrome(s));
    }

    public static boolean isStringPalindromee(String input,int s,int e){
        // Write your code here

        if (s >= e){
            return true;
        }
        if (input.charAt(s)!=input.charAt(e)){
            return false;
        }

        return isStringPalindromee(input,s+1,e-1);

    }

    public static boolean isStringPalindrome(String input) {
        return isStringPalindromee(input,0,input.length()-1);

    }






}

