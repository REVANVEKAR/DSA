package basics;
import java.util.Scanner;

public class methods {

    public static void main(String[] args) {
        sum();

    }

    //return_type_name () {jgf

    static void sum() {
        Scanner loda = new Scanner(System.in);

        System.out.print("enter the number of times u want to sum 2 nums : ");
        int n = loda.nextInt();

        for (int j = 0; j <= n; j++) {


            System.out.print("enter num 1 : ");
            int num1 = loda.nextInt();
            System.out.print("enter num 2 : ");
            int num2 = loda.nextInt();

            int sum = num1 + num2;
            System.out.println("the sum is " + sum);


        }
    }
}
