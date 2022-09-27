package stacks;


import linkedlist1.Node;

public class StacksUsingLL<T> {

    private Node<T> head; // can create a stack of int , student names etc we have
    // flexibility to do so in liniked list implementation of stacks
    private int size;


    public StacksUsingLL(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(T elem){
        Node<T> newNode = new Node<>(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T top() throws StackEmptyException {
        if (head == null){
            //throw stack empty exception
            throw new StackEmptyException();
        }
        return head.data;
    }

    public T pop() throws StackEmptyException {
        if (head == null){
            //throw stack empty exception
            throw new StackEmptyException();
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

}
