package basics;
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner marksinput = new Scanner(System.in);
        System.out.println("enter your maths marks : ");
        float A = marksinput.nextFloat();
        System.out.println("enter your science marks : ");
        float B = marksinput.nextFloat();
        System.out.println("enter your hindi marks : ");
        float C = marksinput.nextFloat();
        System.out.println("enter your history marks : ");
        float D = marksinput.nextFloat();
        System.out.println("enter your english marks : ");
        float E = marksinput.nextFloat();
        System.out.print("your percentage is : ");
        float percentage = ( A + B + C + D + E) / 5;
        System.out.println(percentage);

    }
}
