package stacks;

public class StackUsingArray {

    private int data[];
    private int topIndex; // index of the top most element of the stack

    public StackUsingArray(){
        data = new int[5];
        topIndex = -1;
    }

    public StackUsingArray(int size){
        data = new int[size];
        topIndex = -1;
    }

    //O(1)
    public int size(){ // to get the size
        return topIndex+1;
    }

    //O(1)
    public boolean isEmpty(){ // to chec whether a given stack id empty or not
//        if (TopIndex == -1){
//            return false;
//        }else{
//            return true;
//        }
        return topIndex == -1;
    }

    //O(1)
    public void push(int elem)  { // to add elements
        // if stack is full ill throw a stack full exception
        if (topIndex == data.length-1){
          doubleCapacity();
        }
//        topIndex++;
        data[++topIndex] = elem;
    }

    private void doubleCapacity(){
//        System.out.println("double");
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i < temp.length;i++){
            data[i] = temp[i];
        }
    }


    // O(1)
    public int pop() throws StackEmptyException { // to remove th top element
        if (topIndex == -1){
            // throw stack empty exception
            throw new StackEmptyException();
        }
        int temp = data[topIndex];
        topIndex--;
        return temp;
    }

//    O(1)
    public int top() throws StackEmptyException{ // to see the top element
        if (topIndex == -1){
            // throw stack empty exception
            throw new StackEmptyException();
        }
        return data[topIndex];
    }


}
