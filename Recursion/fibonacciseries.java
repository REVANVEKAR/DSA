package Recursion;

public class fibonacciseries {


    public static int FibSer(int n){
        if(n==1 || n ==2){
            return 1;
        }
        int fib_n_1 = FibSer(n-1);
        int fib_n_2 = FibSer(n-2);
        int output = fib_n_1 + fib_n_2;
        return output;
    }

    public static void main(String[] args) {
        System.out.println(FibSer(7));
    }

}
