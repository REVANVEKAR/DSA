package test1;

import java.util.Arrays;

public class maxprofit {

    public static void main(String[] args) {
        int arr[] = { 22, 87, 9, 50, 56, 43 };
        System.out.print(
                maximumProfit(arr));
    }

//    public static int maximumProfit(int budget[]) {
//        int ans = Integer.MIN_VALUE;
//
//        int price = 0;
//
//        int n = budget.length;
//        for (int i = 0; i<n ; i++){
//            int count = 0;
//
//            for (int j = 0; j < n ; j++){
//                if(budget[i] <= budget[j]){
//                    count++;
//                }
//            }
//
//            if (ans < count * budget[i]){
//                price = budget[i];
//                ans = count * budget[i];
//            }
//        }
//
//        int x = price;
//
//        int people = 0;
//        for (int i = 0; i < n ; i++){
//            if (budget[i]>=x){
//                people++;
//            }
//        }
//
//        return people*price;
//
//    }


    public static int maximumProfit(int budget[])
    {
        // Stores the maximum profit
        int ans = Integer.MIN_VALUE;

        // Stores the price of the item
        int price = 0;

        // Sort the array
        Arrays.sort(budget);

        int N = budget.length;

        // Traverse the array
        for (int i = 0; i < N; i++) {

            // Count of buyers with
            // budget >= arr[i]
            int count = (N - i);

            // Update the maximum profit
            if (ans < count * budget[i]) {
                price = budget[i];
                ans = count * budget[i];
            }
        }

        // Return the maximum possible
        // price
        int x = price;

        int people = 0;
        for (int i = 0; i < N ; i++){
            if (budget[i]>=x){
                people++;
            }
        }

        return people*price;
    }

}
