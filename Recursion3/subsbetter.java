package Recursion3;

public class subsbetter {

    public static void main(String[] args) {

    }



    public static void keypadCombi(int input , String stringsofar){
        if (input == 0){
            System.out.println(stringsofar);
            return;
        }
        int lastdigit = input%10;
        int smallinput = input/10;
        String optionshLastDigit = getOptions(lastdigit);
        for (int i = 0; i < optionshLastDigit.length();i++){
            keypadCombi(smallinput , optionshLastDigit.charAt(i)+stringsofar);
        }
    }

    private static String getOptions(int digit) {
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
