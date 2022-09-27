package linkedlist1;

import java.util.LinkedList;

public class CollectionsLinkedLIst {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>(); //this is a doubly linked list
        list.add(10);
        list.add(20);
        list.add(30); // 10->20->30
        list.add(1, 100); // 10->100->20->30
        list.addFirst(80); // 80->10->100->20->30
        list.set(0,60); //60->10->100->20->30
        list.remove(); // by default will removes the first node

        System.out.println(list.get(1));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
