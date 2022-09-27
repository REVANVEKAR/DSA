package searchalgo;

public class linearproblems {


    public static void main(String[] args) {

        int[] arr = {23, 34, 5, 67, 7, 8777, 9};
//        System.out.println(findnumbers(arr));
        System.out.println(digits2(394739));


    }

    static int digits2(int num){
        if(num < 0 ){
            num = num * -1;
        }
        return (int)(Math.log10(num) + 1 );
    }







    public static int findnumbers(int[] nums){
        int count = 0;
        for (int num : nums) {
            if(even(num)){
                count++;
            }
        }
        return count;

    }

    //function to check whether a number contains even digits or not
    static boolean even(int num){
        int numberofdigits = digits(num);
        if (numberofdigits % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    static int digits(int num){
        int count = 0;
        if(num < 0 ){
            num = num * -1;
        }
        while( num>0 ) {
            count++;
            num = num/10;
        }

        return count;
    }

}
