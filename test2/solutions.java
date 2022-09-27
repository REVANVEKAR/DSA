package test2;

import linkedlist1.Node;

public class solutions {

    public static Node<Integer> nextLargeNumberhelp(Node<Integer> head) {
        head = reverseRec(head);
        int carry = 1,num;
        Node<Integer> ptr = head, prev = null;
        while(ptr != null){
            num = ((ptr.data)+carry)%10;
            carry = ((ptr.data)+carry)/10;
            ptr.data = num;
            prev = ptr;
            ptr = ptr.next;
        }
        if (carry==1){
            Node<Integer> tail = new Node<>(carry);
            prev.next = tail;
        }
        return reverseRec(head);
    }


    public static Node<Integer> reverseRec(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }

        Node<Integer> smallhead  = reverseRec(head.next);
        Node<Integer> tail = smallhead;
        while(tail.next != null ){
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return smallhead;

    }

    public static void deleteAlternateNodes(Node<Integer> head) {
        if (head == null)
            return;

        Node<Integer> node = head;

        while (node != null && node.next != null) {
            /* Change next link of next node */
            node.next = node.next.next;

            /*Update ref node to new alternate node */
            node = node.next;
        }
    }


}


