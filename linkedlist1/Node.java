package linkedlist1;

public class Node<T> {

    public T data; // node's value part
    public Node<T> next; //address of the next node

    public Node(T data){
        this.data = data;
//        next = null; not required as default value will be null
//        (default value of any reference in an object is null)
    }

}
