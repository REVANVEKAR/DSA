package searchalgo;

public class linearsearch {
    public static void main(String[] args) {
        int[] nums = {23,45,56,1,2,8,19,-3,-11};
        int target = 9867;
        int answer  = linearsearch(nums , target);
        System.out.println(answer);
    }

    //search in the array: return the index if item found
    //otherwise if item not found return -1
    static int linearsearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        for (int index = 0; index < arr.length; index++) {
            //check for every element at every index if the target is present
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        //ths line will execute if none of the return statements above have executed
        //hence the target not found
        return -1;

    }

}
