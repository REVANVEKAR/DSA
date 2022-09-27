package Recursion;

public class pruintfirstn {
    public static void print1ton(int n){
        if(n == 0 ){
            return;
        }
//        System.out.println(n);
        print1ton(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        print1ton(10);
    }
}
