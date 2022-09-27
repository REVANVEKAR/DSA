package Recursion;

public class removex {


    public static String removeX(String input){

        if (input.length() == 0){
            return input;
        }
        String smalloutput = removeX(input.substring(1));
        if (input.charAt(0) == 'x'){
            return  smalloutput;
        }else{
            return input.charAt(0) + smalloutput;
        }

    }


}
