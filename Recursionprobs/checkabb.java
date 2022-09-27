package Recursionprobs;

public class checkabb {
    public static void main(String[] args) {
        String s = "abbabbabb";
        boolean r = checkAB(s);
        System.out.println(r);
    }

    public static boolean checkAB(String input) {
        if(input.length() == 0){
            return true;
        }

        if(input.charAt(0) == 'a'){
            if(input.substring(1).length() > 1 && input.substring(1,3).equals("bb")){
                return checkAB(input.substring(3));
            }else{
                return checkAB(input.substring(1));
            }
        }
        return false;

    }

}
