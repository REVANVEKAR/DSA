package Recursionprobs;

public class Stairs {
    public static void main(String[] args) {

        int n = 4;
        int m = staircase(n);
        System.out.println(m);
    }
    public static int staircase(int n){
        if (n == 0 ){
            return 1;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        int x = staircase(n-1);
        int y = staircase(n-2);
        int z = staircase(n-3);

        return x+y+z;
    }
}
