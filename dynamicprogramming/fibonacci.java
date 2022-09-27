package dynamicprogramming;

import java.util.Scanner;

public class fibonacci {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] dp = new int[n+1]; // memoization ( recursion + storing )
//        for (int i = 0 ; i < n+1 ; i++){
//            dp[i] = -1;
//        }
//        int ans = fibb(n,dp);
//        System.out.println(ans);

        long s = staircase(4);
        System.out.println(s);

    }


    public static int fibb(int n ,int[] dp){
        if (n==0 || n==1){
            return n;
        }
        int ans1,ans2;

        if (dp[n-1] == -1 ){
            ans1 = fibb(n-1,dp);
            dp[n-1] = ans1;
        }else{
            ans1 = dp[n-1];
        }
        if (dp[n-2] == -1 ){
            ans2 = fibb(n-2,dp);
            dp[n-2] = ans2;
        }else{
            ans2 = dp[n-2];
        }

        int myAns = ans1 + ans2;
        return myAns;
    }

    public static int fibbI(int n){
        if (n==0 || n==1){
            return n;
        }
        // fill the first two index in storing as the base case
        // for ex 0 and 1 in 0 and 1st index
        // then start filling them in ascending order of index
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        // n should be greater than or equal to 2
        for (int i = 2; i <=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static long staircase(int n) {
        if (n==0){
            return 1;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        long one , two , three;
        long[] dp = new long[n+1];
        for (int i = 0; i <=n ; i++){
            dp[i] = -1;
        }

        if (dp[n-1] == -1){
            one = staircase(n-1);
            dp[n-1] = one;
        }else{
            one = dp[n-1];
        }

        if (dp[n-2] == -1){
            two = staircase(n-2);
            dp[n-2] = two;
        }else{
            two = dp[n-2];
        }

        if (dp[n-3] == -1){
            three = staircase(n-3);
            dp[n-3] = three;
        }else{
            three = dp[n-3];
        }
        return one+three+two;
    }

    public static long staircasee(int n){
        if (n==0||n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];

    }

    public static int countMinStepsToOne(int n) {
        if (n==1){
            return 0;
        }
        int x=Integer.MAX_VALUE;
        int y=Integer.MAX_VALUE;
        int z=Integer.MAX_VALUE;
        y = countMinStepsToOne(n-1);
        if (n%2==0){
            z = countMinStepsToOne(n/2);
        }
        if (n%3==0){
            x = countMinStepsToOne(n/3);
        }
        y = countMinStepsToOne(n-1);
        return 1 + Math.min(y,Math.min(z,x)) ;
    }

}
