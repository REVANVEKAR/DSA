package Recursionprobs;

public class multiplic {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int s = multiplyTwoIntegers(n,m);
        System.out.println(s);
    }

    public static int multiplyTwoIntegers(int m, int n){

        if(n==0){
            return 0;
        }

        int small1 = m + multiplyTwoIntegers(m,n-1);



        return small1 ;

    }


}
