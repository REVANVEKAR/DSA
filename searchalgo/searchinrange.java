package searchalgo;

public class searchinrange {
    public static void main(String[] args) {
        int[] nums = {23,45,56,1,2,8,19,-3,-11};
        int target = 8;
        int start = 1;
        int end = 5;
        System.out.println(searchinrangee(nums,start,end,target));

    }
    static int searchinrangee(int[] arr,int start ,int end, int target){
        if(arr.length == 0){
            return -1;
        }


        for(int i = start;i <= end;i++){
            if (arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
