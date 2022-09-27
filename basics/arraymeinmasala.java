package basics;

public class arraymeinmasala {
    public static void main(String[] args) {
        int [] marks = {98, 45, 79, 99, 80};
//        System.out.println(marks.length);
//        displaying the array ina simple way
//        System.out.println(marks[0]);
//        System.out.println(marks[1]);
//        System.out.println(marks[2]);
//        System.out.println(marks[3]);
//        System.out.println(marks[4]);
//         its easy to do this when we have fewer elements but what if there were 500 elements

////        printing using for loop
//        for (int i= 0 ; i< marks.length ; i++){
//            System.out.println(marks[i]);
//        }
////        in reverse order
//
//        for (int i= marks.length-1 ; i>=0 ; i--){
//            System.out.println(marks[i]);
       // }
//         printing using for each loop


          for (int element: marks){
              System.out.println(element);
          }

    }
}
