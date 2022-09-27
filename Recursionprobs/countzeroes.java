package Recursionprobs;

public class countzeroes {
    public static void main(String[] args) {
        int m = 10;
        int s = countZerosRec(m);
        System.out.println(s);
    }

    public static int countZerosRec(int input) {


        if (input/10 == 0){
            if (input == 0){
                return 1;
            }else{
                return 0;
            }
        }
        else {
            int d = input % 10;
            if (d == 0) {
                return countZerosRec(input / 10) + 1;
            } else {
                countZerosRec(input / 10);
            }
        }
        return countZerosRec(input/10);
    }


}