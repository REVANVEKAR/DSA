package basics;
import java.util.Scanner;

public class practiceeeeeee2of4 {
    public static void main(String[] args) {
//        question 4
        Scanner url = new Scanner(System.in);
        System.out.print("enter url type : ");
        String a = url.nextLine();
//        System.out.print("enter day number : ");
//        int day = weekno.nextInt();
//        if (n<=4 && day==1+(7*(n-1))){
//            System.out.println("monday");
//        }
//        else if (n<=4 && day==2+(7*(n-1))) {
//            System.out.println("tuesday");
//        }
//        else if (n<=4 && day==3+(7*(n-1))) {
//            System.out.println("wednesday");
//        }
//        else if (n<=3 && day==4+(7*(n-1))) {
//            System.out.println("thursday");
//        }
//        else if (n<=3 && day==5+(7*(n-1))) {
//            System.out.println("friday");
//        }
//        else if (n<=3 && day==6+(7*(n-1))) {
//            System.out.println("saturday");
//        }
//        else if (n<=3 && day==7+(7*(n-1))) {
//            System.out.println("sunday");
//        }
//        else {
//            System.out.println("maa chuda");
//        }

//        System.out.println(day<=7);
//        switch (day){
//
//            case 1 -> System.out.println("monday");
//            case 2 -> System.out.println("tuesday");
//            case 3 -> System.out.println("wednesday");
//            case 4 -> System.out.println("thursday");
//            case 5 -> System.out.println("friday");
//            case 6 -> System.out.println("saturday");
//            case 7 -> System.out.println("sunday");
//        }
        // leap year wala question
//        if (n%4==0) {
//            System.out.println("leap year he bhai");
//        }
//        else {
//            System.out.println("nhi he be leap year");
//        }
//        url question
        if (a.endsWith(".org")){
            System.out.println("organizational website");
        }
        else if (a.endsWith(".com")){
            System.out.println("commercial website");
        }
        else if (a.endsWith(".in")) {
            System.out.println("indian website");
        }
        else{
            System.out.println("f");
        }
    }
}
