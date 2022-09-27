package linkedlist1;

import java.util.ArrayList;

public class arrayListDemo {
    public static void main(String[] args) {
       ArrayList<Integer> arr = new ArrayList<>(20);
       //we can also start by giving initial size of the array list
       arr.add(10);
       arr.add(20);
       arr.add(30);
       arr.add(1, 80 );
//       arr.set(0,100); //replaces the element

        for (int i = 0; i<arr.size();i++ ){
            System.out.println(arr.get(i)); //i is the index number
            //we can use that with get function to get elements
        }

        //enhanced or for each looo
        for (int i : arr){
            //for each element i in arr
            System.out.println(i); //here i holds the value
            //of the element of particular index while iteration
        }

//       Integer i = 10;
//       arr.remove(i); can also pass an Integer


//       System.out.println(arr.size());
//       System.out.println(arr.get(2));





    }


}
