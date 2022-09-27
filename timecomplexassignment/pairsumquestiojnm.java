package timecomplexassignment;

import java.util.Arrays;

public  class pairsumquestiojnm {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        int n = pairSum(arr,3);
        System.out.println(n);
    }
    public static int pairSum(int[] arr, int num){

        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int counter=0;
        while(i<j)
        {
            if(arr[i]+arr[j]==num)
            {
                if (arr[i] == arr[j]) {
                    int count = j - i + 1;
                    int n = count - 1;
                    int totalCount = ((n) * (n+1)) / 2;
                    while ( totalCount > 0) {
                        ++counter;
                        totalCount--;
                    }
                    i=j;
                } else {
                    int countStart = 0;
                    int countEnd = 0;
                    int temp = arr[i];
                    int start = i;
                    while (arr[start] == temp && start < j) {
                        start++;
                        countStart++;
                    }
                    temp = arr[j];
                    int end = j;

                    while (arr[end] == temp  && end > i) {
                        end--;
                        countEnd++;
                    }
                    int totalTimes = countStart * countEnd;

                    i = start;
                    j = end;
                    while (totalTimes > 0) {
                        ++counter;
                        totalTimes--;
                    }
                }
            } else if (arr[i] + arr[j] < num) {
                i++;
            } else
                j--;


        }
        return counter;
    }

 }
