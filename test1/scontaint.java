package test1;

public class scontaint {

    public static boolean checkSequence(String a, String b) {
            //if length of the b = 0
            //then we return true
            if(b.length()==0)
                return true;

            //if length of a = 0
            //that means b is not present in
            //a so we return false
            if(a.length() == 0)
                return false;

            if(a.charAt(0) == b.charAt(0))
                return checkSequence(a.substring(1), b.substring(1));
            else
                return checkSequence(a.substring(1), b);
        }

    }


