package basics;
import java.util.Scanner;

public class Chap4prac {
    public static void main(String[] args) {
//        question 2
//        Scanner marks = new Scanner(System.in);
//        System.out.print("enter your marks1 : ");
//        int a1 = marks.nextInt();
//
//        System.out.print("enter your marks2 : ");
//        int a2 = marks.nextInt();
//
//        System.out.print("enter your marks3 : ");
//        int a3 = marks.nextInt();
//
//        float sum = (a1+a2+a3)/3.0f;
//        System.out.println("your percentage is : " + sum);
//
//        if (a1>=33 && a2>=33 && a3>=33 && sum>=40){
//            System.out.println("passed be");
//        }
//        else if (a2>=33){
//            System.out.println("passed a2");
//        }
//        else if (a3>=33){
//            System.out.println("passed a3");
//        }
//        else if (sum>=40){
//            System.out.println("pssed the exam");
//        }
//        else {
//            System.out.println("better luck next time");
//        }
//        question 3
        float tax = 0;
        System.out.print("enter income : ");
        Scanner paisebol = new Scanner(System.in);
        float income = paisebol.nextFloat();
        if (income<250000){
            tax = tax + 0.0f ;
            System.out.println(tax);
        }
        else if (income<500000.0f && income>=250000.0f){
            tax = tax + 0.05f * (income-250000);
            System.out.println(tax);
        }
        else if (income<1000000 && income>=50000){
            tax = tax + 0.2f * (income-500000) + 5 * 2500;
            System.out.println(tax);
        }
        else if (income>1000000){
            tax = tax + 0.3f * (income-1000000) + 5 * 2500 + 20 * 5000 ;
            System.out.println(tax);
        }
        else {
            System.out.println("income hi dal loude");
        }

    }
}