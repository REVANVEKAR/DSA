package Recursionprobs;

public class replacepiii {
    public static void main(String[] args) {
        System.out.println(replacePi("ppipipi"));
    }

    public static String replacePi(String r ){
        if(r.length() == 0){
            return r;
        }
        if (r.charAt(0) == 'p' && r.charAt(1) == 'i'){
            String smallest = replacePi(r.substring(2) );

            return "3.14" + smallest;
        }else{
            String smallest = replacePi(r.substring(1) );
            return r.charAt(0) + smallest;
        }

    }


}
