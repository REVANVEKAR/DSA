package stacks;

import java.util.Stack;

public class StackCollections {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        int arr[] = {5, 6, 7, 1, 9};

        for (int elem : arr){
            stack.push(elem);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

//        stack.push(10);
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());
    }
}
