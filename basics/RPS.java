package basics;
import java.util.Scanner;
import java.util.Random;

public class RPS {
    public static void main(String[] args) {
        Random rng = new Random();
        Scanner input = new Scanner(System.in);

        System.out.println("rock=0");
        System.out.println("paper=1");
        System.out.println("scissor=2");

        System.out.print("enter your move rock=0/paper=1/scissor=2 : ");
        int q = input.nextInt();
        System.out.println(q);

        int computerkaint = rng.nextInt(3);
        System.out.println(computerkaint);

        if ( (q==0 && computerkaint==0) || (q==1 && computerkaint==1) || (q==2 && computerkaint==2) ){
            System.out.println("its a draw");
        }
        else if ((q==0 && computerkaint==2) || (q==1 && computerkaint==0) || (q==2 && computerkaint==1)){
            System.out.println("you won");
        }
        else {
            System.out.println("comp won");
        }
    }
}
