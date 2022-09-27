package basics;
import java.util.Objects;
import java.util.Scanner;

public class rockpaperscissors {
    public static void main(String[] args) {
        Scanner game = new Scanner(System.in);
        System.out.print("input your char player 1 : ");
        String player1 = game.next();
        System.out.print("input your char player 2 : ");
        String player2 = game.next();
        String r = "r";
        String p = "p";
        String s = "s";
        if ((Objects.equals(player1, r) && Objects.equals(player2, r)) || (Objects.equals(player1, p) && Objects.equals(player2, p)) || (Objects.equals(player1, s) && Objects.equals(player2, s)) ){
            System.out.println("its a draw");
        }
        else if (Objects.equals(player1, r) && Objects.equals(player2, s)) {
            System.out.println("player 1 wins");
        }
        else if (Objects.equals(player1, s) && Objects.equals(player2, r)) {
            System.out.println("player 2 wins");
        }
        else if (Objects.equals(player1, p) && Objects.equals(player2, s)) {
            System.out.println("player 2 wins");
        }
        else if (Objects.equals(player1, s) && Objects.equals(player2, p)) {
            System.out.println("player 1 wins");
        }
        else if (Objects.equals(player1, r) && Objects.equals(player2, p)) {
            System.out.println("player 2 wins");
        }
        else if (Objects.equals(player1, p) && Objects.equals(player2, r)) {
            System.out.println("player 1 wins");
        }
    }
}
