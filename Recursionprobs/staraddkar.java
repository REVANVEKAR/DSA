package Recursionprobs;

public class staraddkar {
    public static void main(String[] args) {

        String s = "hello";
        String e = addStars(s);
        System.out.println(e);

    }

    public static String addStars(String s) {
        if(s.length()<=2) {
            if (s.charAt(0)==s.charAt(1)){
                return s.charAt(0) + "*" + s.charAt(1);
            }else{
                return s;
            }
        }
        if(s.charAt(0)==s.charAt(1)) {
            return s.charAt(0) +  "*"  + addStars(s.substring(1));
        }
        else {
            return s.charAt(0) + addStars(s.substring(1));
        }

    }

}
