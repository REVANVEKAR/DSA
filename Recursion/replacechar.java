package Recursion;

public class replacechar {



    public static void main(String[] args) {

        System.out.println(replacechar("soduighsodgh",'o','r'));

    }


    public static String replacechar(String input, char c1, char c2){
        if (input.length() == 0){
            return input;
        }

        String smalloutput = replacechar(input.substring(1),c1,c2);
        if(input.charAt(0) == c1){
            return c2 + smalloutput;
        }else{
            return input.charAt(0) + smalloutput;
        }
    }




}
