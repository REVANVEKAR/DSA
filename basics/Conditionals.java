package basics;
import java.util.Scanner;

public class Conditionals {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("enter your age : ");
        int age = a.nextInt();
        if(age>18&age<90){
            System.out.println("yes buddy you can drive");
        }
        else {
            System.out.println("fucking dont drive");
        }
    }
}
