package Queues;

import stacks.StackEmptyException;

public class QueueUsingArray {

    private int data[];
    private int front; // index of the element at the start of the queue
    private int rear; // index of the element at the end of the queue
    private int size;


    public QueueUsingArray() {
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int elem) {
        if (size == data.length) {
//            throw new QueueFullException();
            doubleCapacity();
        }
        if (size == 0) {
            front++;
        }

//        rear++;
//        if(rear == data.length){
//            rear = 0;
//        }
        rear = (rear + 1) % data.length; // better way of writing
        data[rear] = elem;
        size++;
    }

    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public int dequeue() throws StackEmptyException {
        if (size == 0) {
            throw new StackEmptyException();
        }
        int temp = data[front];
//        front++;
//        if (front == data.length){
//            front = 0;
//        }
        front = (front + 1) % data.length;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * temp.length];
        int index = 0;
        for (int i = front; i < data.length; i++) {
            data[index++] = temp[i];
        }
        for (int i = 0; i < front - 1; i++) {
            data[index++] = temp[i];
        }
        front = 0;
        rear = temp.length - 1;
    }


}
