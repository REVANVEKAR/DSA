package priorotyQueue;

import java.util.ArrayList;

public class maxpriority {
    /*
     * Time complexity:
     * O(log(N)) [for insert and removeMax functions]
     * O(1) [for all other functions]
     * Space complexity : O(1) [for all functions]
     *
     * where N is the size of the Priority Queue
     */
    private ArrayList<Integer> heap;

    public  maxpriority() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int getSize() {
        return heap.size();
    }

    int getMax() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMax(){
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int ans = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int index = 0;
        int maxIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < heap.size()) {

            if (heap.get(leftChildIndex) > heap.get(maxIndex)) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }
            if (maxIndex == index) {
                break;
            } else {
                int temp = heap.get(index);
                heap.set(index, heap.get(maxIndex));
                heap.set(maxIndex, temp);
                index = maxIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }
        return ans;

    }
}