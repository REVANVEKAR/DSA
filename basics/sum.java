package basics;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int x = 0;
        while (x<3){
            int rate = (int) (0.1*amount);
            amount= amount-rate;
            if(x==2){
                System.out.println(amount);
            }
            x++;

        }



    }
}

