package dynamicprogramming;

public class minSquares {

    public static void main(String[] args) {

    }

    public static int minSquares(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1;i<=n;i++){

            int minAns = Integer.MAX_VALUE;
            for (int j = 1; j*j <=i;j++){
                int curAns = dp[i-(j*j)];
                if (minAns>curAns){
                    minAns = curAns;
                }
            }
            dp[i] = 1 + minAns;
        }
        return dp[n];
    }

}
