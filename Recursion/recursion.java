package Recursion;

public class recursion {

    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        int smallOutput = fact(n-1);
        int output = n * smallOutput;
        return output;
    }

    public static int sumn(int n){
        if(n == 0){
            return 0;// we can make it return 1 but if we input 0 then it will
            // take -1 and so on and give stackoverflow error
        }
        int smallnextinput = sumn(n-1);
        int output = n + smallnextinput;
        return output;
    }



    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(sumn(6));
    }
}
