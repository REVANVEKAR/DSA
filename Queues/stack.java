package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class stack {

    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
    static int curr_size;


    public stack() {
        curr_size = 0;
    }



    public int getSize() {
        //Implement the getSize() function
        return curr_size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return curr_size == 0;
    }

    public void push(int element) {
        //Implement the push(element) function
        curr_size++;

        // Push x first in empty q2
        q2.add(element);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public int pop() {
        //Implement the pop() function
        if (q1.isEmpty()){
            return -1;
        }
        int temp = q1.peek();
        q1.remove();
        curr_size--;
        return temp;
    }

    public int top() {
        //Implement the top() function
        if (q1.isEmpty()){
            return -1;
        }
        return q1.peek();
    }

}
