package hasmap;

import java.util.*;

public class inbuilthashmap {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        // insert

        map.put("abc", 1);
        map.put("def", 3);

        //size
        map.put("abc", 4); // size wont change just the value does
        System.out.println(map.size());

        if (map.containsKey("abc")) {
            System.out.println("map has abc");
        }
        if (map.containsKey("abc1")) {
            System.out.println("map has abc1");
        }

        // get value

        int v = map.get("abc");
        System.out.println(v);

//        int v1 = map.get("abc1"); this returns null
//        System.out.println(v1); // this gives a null pointer exception
        // for ex if Integer i = null; as Integer is a wrapper class , its pointing to null
        // when we try to do int v1 = i then we are trying to access the value of null hence the
        // exception

        // so we dont use get directly instead
        int v1 = 0;
        if (map.containsKey("abc1")) {
            v1 = map.get("abc1");
        } // this wont throw null pointer because the line wont be executed


        // remove

//        map.remove("abc");
        if (map.containsKey("abc")) {
            System.out.println("map has abc");
        }

        map.remove("abc1"); // if it does not find abc1 then it wont do anything


        // iterate over hash map
        Set<String> keys = map.keySet(); // all the keys will be given in a set
        for (String s : keys) {
            System.out.println(s); // prints all the keys
        }


        // remove duplicates from an array
        int[] arr = {1, 3, 2, 2, 3, 1, 6, 2, 5};
        ArrayList<Integer> output = removeDuplicates(arr);
        System.out.println(output);


    }


    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                continue;
            }
            output.add(arr[i]);
            map.put(arr[i], true);
        }
        return output;
    }


    /*
    You are given an array of integers that contain numbers in random order.
     Write a program to find and return the number which occurs the maximum
     times in the given input.
     */
    public static int maxFrequencyNumber(int[] arr) {

        if(arr.length == 0) {
            return -1;
        }
        int maxFreq = 0;
        int number = -1;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i],map.get(arr[i])+1);
            }
            else {
                map.put(arr[i], 1);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])>maxFreq)
            {
                maxFreq=map.get(arr[i]);
                number=arr[i];
            }
        }
        return number;

    }


    /*
    You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M,
    respectively. You need to print their intersection; An intersection for this
     problem can be defined when both the arrays/lists contain a particular value
     or to put it in other words, when there is a common value that exists in both
     the arrays/lists.
     */
    public static void printIntersection(int[] arr1,int[] arr2) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< arr1.length;i++){
           if (map.containsKey(arr1[i])){
               int value = map.get(arr1[i]);
               map.put(arr1[i],value+1);
           }else{
               map.put(arr1[i],1);
           }
        }

        for (int i =0; i< arr2.length;i++){
            if (map.containsKey(arr2[i])){
                int freq = map.get(arr2[i]);
                if (freq>0){
                    System.out.println(arr2[i]);
                    map.put(arr2[i],freq-1 );
                }
            }
        }

    }


    /*
    Given a random integer array A of size N. Find and print the count of pair of
    elements in the array which sum up to 0.
     */

    public static int PairSum(int[] arr, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int paircount = 0;
        for(int i :arr){
            if(map.containsKey(i)){
                if(map.containsKey(-i)){
                    paircount += map.get(-i);
                }
                map.put(i, map.get(i)+1);

            }else{
                if(map.containsKey(-i)){
                    paircount += map.get(-i);
                }
                map.put(i, 1);
            }
        }
        return paircount;
    }
    //solve this again
    public static int PairSum2(int[] arr, int size) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int finalCount = 0;
        for (int i =0; i < size;i++){
            int key = arr[i];
            if (map.containsKey(key)){
                int value = map.get(key);
                map.put(key , value+1);
            }
            else{
                map.put(key , 1);
            }
        }

        for (int i = 0; i <size; i++){
            int key = arr[i];
            if (map.containsKey(-key) && map.get(key)!=0){
                int times;
                if (key==(-key)){
                    int occurences = map.get(key);
                    times = (occurences * ( occurences - 1))/2;
                    finalCount = finalCount+times;
                    map.put(key,0);
                    continue;
                }
                times = map.get(key) * map.get(-key);
                finalCount = finalCount+times;
                map.put(key,0);
                map.put(-key,0);
            }
        }

        return finalCount;

    }

//    public static String uniqueChar(String str){
//
//        char arr[] = new char[str.length()];
//       for (int i = 0 ; i < str.length() ; i++){
//           arr[i] = str.charAt(i);
//       }
//       return removeDuplicatee(arr);
//
//    }
//
//    public static String removeDuplicatee(char str[]) {
//        // Used as index in the modified string
//        int index = 0;
//
//        // Traverse through all characters
//        for (int i = 0; i < str.length; i++)
//        {
//
//            // Check if str[i] is present before it
//            int j;
//            for (j = 0; j < i; j++)
//            {
//                if (str[i] == str[j])
//                {
//                    break;
//                }
//            }
//
//            // If not present, then add it to
//            // result.
//            if (j == i)
//            {
//                str[index++] = str[i];
//            }
//        }
//        return String.valueOf(Arrays.copyOf(str, index));
//    } //

    // this is my answer

    // this is coding ninjas answer

    public static String uniqueChar(String str){
        if (str.length()==0){
            return "";
        }
        String ans = "";
        HashMap<Character,Boolean> hm = new HashMap<>();
        for (int currIndex = 0; currIndex<str.length();currIndex++){
            char currChar = str.charAt(currIndex);
            if (!hm.containsKey(currIndex)){
                hm.put(currChar, true);
                ans += currChar;
            }
        }
        return ans;
    }




}