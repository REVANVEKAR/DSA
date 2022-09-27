package basics;

import java.util.Scanner;

public class breakandcontinue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fruit = in.next();
//
//        if(fruit.equals("mango")){
//            System.out.println("king of fruit");
//        }
//
//        if (fruit.equals("apple")){
//            System.out.println("a sweet red fruit");
//        }
//
        switch (fruit){
            case "mango" :
                System.out.println("king of fruits");
                break;
            case "apple" :
                System.out.println("a sweet red fruit");
                break;
            case "grapes" :
                System.out.println("small fruit");
                break;
            default:
                System.out.println("enter a valid fruit");
        }

        switch (fruit) {
            case "mango" -> System.out.println("king of fruits");
            case "apple" -> System.out.println("a sweet red fruit");
            case "grapes" -> System.out.println("small fruit");
            default -> System.out.println("enter a valid fruit");
        }

    }
}
