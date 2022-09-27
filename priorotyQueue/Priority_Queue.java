package priorotyQueue;


import java.util.ArrayList;

public class Priority_Queue<T> {

    private ArrayList<Element<T>> heap;

    public Priority_Queue(){
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        Element<T> e = new Element<>(value , priority);
        heap.add(e); // added at the last to follow the complete binary tree property
        int childIndex = heap.size()-1; // as discussed parent node is always at i-1/2 th node;
        int parentIndex = (childIndex-1)/2;

        while (childIndex>0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else{
                return;
            }
        }
    }

    public T getMin() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return heap.get(0).value;
    }

    public T removeMin() throws PriorityQueueException{
        if (isEmpty()){
            throw new PriorityQueueException();
        }

        // here we are storing thr element to be removed and then insert yhr first element
        // at last
        Element<T> removed = heap.get(0);
        T ans = removed.value;

        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;

        while (leftChildIndex<heap.size()) {
            int minIndex = parentIndex;
            if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex< heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = rightChildIndex;
            }

            if (minIndex == parentIndex){
                break;
            }
            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
        }
        return ans;
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        if (size()==0){
            return true;
        }
        return false;
    }

//    int removeMin()throws PriorityQueueException  {
//        if (isEmpty()) {
//            // Throw an exception
//            throw new PriorityQueueException();
//        }
//        int ans=heap.get(0);
//        heap.set(0,heap.get(heap.size()-1));
//        heap.remove(heap.size()-1);
//        int parent=0;
//        int leftchild=(2*parent)+1;
//        int rightchild=(2*parent)+2;
//        while(leftchild<heap.size()){
//
//            int min=parent;
//            if(heap.get(leftchild)<heap.get(min)){
//                min=leftchild;
//            }
//            if(rightchild<heap.size() && heap.get(rightchild)<heap.get(min)){
//                min=rightchild;
//            }
//            if(min==parent){
//                break;
//            }
//            int temp = heap.get(min);
//            heap.set(min, heap.get(parent));
//            heap.set(parent, temp);
//            parent=min;
//            leftchild=(2*parent)+1;
//            rightchild=(2*parent)+2;
//        }
//        return ans;
//        // Complete this function
//        // Throw the exception PriorityQueueException if queue is empty
//    }




}
