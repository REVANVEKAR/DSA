package searchalgo;

public class linearprobs2 {
    public static void main(String[] args) {

        int[][] a = {
                {2,3,4},
                {5,1,2},
                {4,9}
        };

        System.out.println(wealthiest(a));
    }

    static int wealthiest(int[][] accounts){

        int max = 0;
        for (int i = 0; i < accounts.length ; i++){
            int sum = 0;
            //when we start a new column, take a new sum for that
            for (int j = 0;j < accounts[i].length ; j++){
                sum += accounts[i][j];
            }
            //when i come out this loop
            //we have sum of accounts of person
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }



}
