package Queues;

import stacks.StackEmptyException;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueUse {
    public static void main(String[] args)  {

//        QueueUsingArray queue = new QueueUsingArray();
//        int arr[] = {10,20,30,40};
//        for (int elem : arr){
//            queue.enqueue(elem);
//        }
//
//        while (! queue.isEmpty()){
//            try {
//                System.out.println(queue.dequeue());
//            } catch (StackEmptyException e) {
//                // will never reach here while condition
//            }
//        }

        // queue is an interface while linked list and stacks were classes so its quite different


//        Queue<Integer> queue ; // cant create an object as its an interface
        Queue<Integer> queue = new LinkedList<>();
        // use linkedlist class because it has implementation of the queue interface
        queue.add(10);
        queue.add(20);
        System.out.println(queue.size());
        System.out.println(queue.peek());

    }

    public static void reverseQueue(Queue<Integer> input) {

        if (input.isEmpty()){
            return;
        }
        // Dequeue current item (from front)
        int data = input.peek();
        input.remove();

        // Reverse remaining queue
        reverseQueue(input);

        // Enqueue current item (to rear)
        input.add(data);

    }

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {

        Queue<Integer> temp = new LinkedList<>();
        int length = input.size();
        int count = 0;
        while(count<k){
            int data = input.peek();
            input.remove();
            temp.add(data);
            count++;
        }

        reverseQueue(temp);

        for (int i = 0 ; i < length-k; i++){
            int maaka = input.peek();
            input.remove();
            temp.add(maaka);
        }

        return temp;
    }


}
