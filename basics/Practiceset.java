package basics;
import java.util.Scanner;

public class Practiceset {
    public static void main(String[] args) {
      //  System.out.print("type your name here : ");
      //  Scanner input = new Scanner(System.in);
       // String Name = input.nextLine();
        //  System.out.println("hello " + Name + " have a good day " );
        Scanner input = new Scanner(System.in);
        System.out.print("enter the distance in kilometres : ");
        float kms = input.nextFloat();
        float miles = kms * 0.621371f;
        System.out.println("distance in miles is : " + miles );
    }
}
