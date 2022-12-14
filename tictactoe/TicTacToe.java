package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private Player player1, player2;
    private Board board;
    private int numPlayers;

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();

    }

    public void startGame(){
        Scanner s = new Scanner(System.in);
        // 1) take players input
//        numPlayers++;
        player1 = takePlayerInput(++numPlayers);
        player2 = takePlayerInput(++numPlayers);
        //check if both players have same symbols
        while(player2.getSymbol() == player1.getSymbol()){
            System.out.println("symbol already taken please enter the symbol again");
            player2.setSymbol(s.next().charAt(0));
        }

        // 2) create the board
        board = new Board(player1.getSymbol(), player2.getSymbol());

        // 3) play the game
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while (status == Board.INCOMPLETE || status == Board.INVALIDMOVE){
            // so how this function is working is by using boolean marker to see which
            if (player1Turn){
                System.out.println("player 1 - " + player1.getName() + "'s turn");
                System.out.println("enter x : ");
                int x = s.nextInt();
                System.out.println("enter y : ");
                int y = s.nextInt();
                status = board.move(player1.getSymbol(),x,y);
                //this function returns the status of the game
                // each response is linked to an integer value
                // for ex 1 = player 1 wins , 2 = player 2 wins , 3 = draw
                // 4 = incomplete , 5 = invalid
                // there's no need of using these markers as we have assigned
                // variables the  value in the board class
                if (status == Board.INVALIDMOVE){ // if its invalid then it returns 5
                    System.out.println("invalid move !! Please try again");
                    // if its invalid then we don't change the status of boolean
                    // which gives the player another chance to make his move
                    continue;
                }
//                else{
//                    player1Turn = false;
//                    board.print();
//                }

            }
            else{
                System.out.println("player 2 - " + player2.getName() + "'s turn");
                System.out.println("enter x : ");
                int x = s.nextInt();
                System.out.println("enter y : ");
                int y = s.nextInt();

                status = board.move(player2.getSymbol(),x,y);
                if (status == Board.INVALIDMOVE){
                    System.out.println("invalid move !! Please try again");
                    continue; // added because we commented the else part and
                    // made changes after the loop
                }
//                else{
//                    player1Turn = true;
//                    board.print();
//                } // we can do this or we can just write player1Turn = !player1Turn;
                // at the end of the loop and add continue after the invalid move check

            }
            player1Turn = !player1Turn;
            board.print();

        }

        if (status == Board.PLAYER1WINS){
            System.out.println("Player 1 - " + player1.getName() + " wins !");
        }else if (status == Board.PLAYER2WINS){
            System.out.println("Player 2 - " + player2.getName() + " wins !");
        }else{
            System.out.println("Draw !!");
        }

    }

    private Player takePlayerInput(int num){
        Scanner s = new Scanner(System.in);
        System.out.println("enter player " + num + " name: ");
        String name = s.nextLine();
        System.out.println("enter player " + num + " symbol: ");
        char symbol = s.next().charAt(0);
        Player p = new Player(name,symbol);
        return p;
    }



}
