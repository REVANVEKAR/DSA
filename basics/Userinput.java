package basics;
import java.util.Scanner;

public class Userinput {
    public static void main(String[] args) {
        System.out.println("taking user input !!");
        Scanner kuchbhi = new Scanner(System.in);
         System.out.println("enter number");
         int a = kuchbhi.nextInt();
         System.out.println("enter number 2");
         int b = kuchbhi.nextInt();
         System.out.println("enter number 3");
         int c = kuchbhi.nextInt();
         int sum = a+b+c;
         System.out.print("the sum is : ");
         System.out.println(sum);
         boolean b1 = kuchbhi.hasNextInt();
         System.out.println(b1);
        String mkc = kuchbhi.nextLine();
        System.out.println(mkc);
    }
}
