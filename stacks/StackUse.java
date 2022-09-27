package stacks;

import java.util.Stack;

public class StackUse {
    public static void main(String[] args) throws StackEmptyException {
//        StackUsingArray stack = new StackUsingArray();
//        StacksUsingLL<Integer> stack = new StacksUsingLL<>();

//        stack.data[1] = 100; no one should be able to fo this hence default keyword
//        wont work
//        stack.push(10);
//        System.out.println(stack.top());
//        stack.pop();
//        stack.size();
//        System.out.println(stack.isEmpty());
        Stack stack = new Stack();

        int arr[] = {5,6,7,1,9};

        for (int i = 0 ; i < arr.length; i++){
            stack.push(arr[i]);
        }
//        stack.push(10);
//        stack.push(20);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
