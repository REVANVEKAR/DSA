package linkedlist1;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Objects;
import java.util.Scanner;

public class linkedListUse {


    static class DoubleNode{
        Node<Integer> head;
        Node<Integer> tail;

        DoubleNode(){

        }

        DoubleNode(Node<Integer> head, Node<Integer> tail){
            this.head = head;
            this.tail = tail;
        }
    }
    // 1)
    public static Node<Integer> createLinkedList(){
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        //easier to dry run on a smaller list done after LL first print method

        //n1, n2, n3, and n4 are four references of four nodes with random address

        n1.next = n2;
//        System.out.println("n1 " + n1 + " data " + n1.data + " next " + n1.next);
        n2.next = n3;
//        System.out.println("n2 " + n2 + " data " + n2.data + " next " + n2.next);
        n3.next = n4;
//        System.out.println("n3 " + n3 + " data " + n3.data + " next " + n3.next);
//        System.out.println("n4 " + n4 + " data " + n4.data + " next " + n4.next);

        // connection making by assigning next value of first node with
        // the address of the second node

        // we should return the first node of the list
        return n1;

    }
    // 2)
    public static void printrecursive(Node<Integer> head){
        if (head == null){
            return;
        }
        System.out.print(head.data + " ");
        printrecursive(head.next);

    }
    // 3)
    public static void printrecursiveulta(Node<Integer> head){
        if (head == null){
            return;
        }

        printrecursiveulta(head.next);
        System.out.print(head.data + " ");


    }
    // 4)
    public static void increment(Node<Integer> head){
        Node<Integer> temp = head;
        while (temp != null) {
            temp.data++;
            temp = temp.next;
        }
        System.out.println();
    }
    // 5)
    public static void print(Node<Integer> head) {
//        System.out.println("print :" + head);
        Node<Integer> temp = head;
        while (temp != null) { //this statement will stand correct till the last node
            System.out.print(temp.data + " ");
            temp = temp.next; // this is something similar to incrementing index number
            // while iterating through an array . just updating the address til its null
        }
        System.out.println();

//        System.out.println(head.next);
//        System.out.println(head.next.data);
//        System.out.println(head.next.next.data);
    }
    // 6)
    public static int length(Node<Integer> head){
        int count = 0;

        Node<Integer> temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }
    // 7)
    public static void printIthNode(Node<Integer> head, int n){
        int count = 0;

        Node<Integer> temp = head;
        while (count != n){
            if (temp == null){
                return;
            }

            else{
                count++;
                temp = temp.next;
            }

        }


        System.out.println(temp.data);

    }
    // 8)
    public static Node<Integer> takeInput(){

        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null , tail = null;
        while(data != -1){
            Node<Integer> currentNode = new Node<>(data);
            if (head == null){
                //make this as head node
                head = currentNode;
                tail = currentNode;
            }else{
//                Node<Integer> tail = head;
//                while(tail.next != null){
//                    tail = tail.next;
//                }
//                // now tail will refer to last node
//                //connect current node after last Node
                tail.next = currentNode;
                tail = tail.next; // or tail = tail.next

            }
            data  = sc.nextInt();
        }
        return head;
    }
    // 9)
    public static Node<Integer> InsertNode(Node<Integer> head, int pos, int elem){

        Node<Integer> nodetobeinserted = new Node<>(elem);

        if (pos == 0){
            nodetobeinserted.next = head; // when inserting at position zero we have to make sure that
//            it will be the new head of the linkefd list
//            head = nodetobeinserted;
            return nodetobeinserted; // returning this to main and not needed to update it again as shown
        }
        else {
            int count = 0;
            Node<Integer> prev = head;
            while (count < pos - 1 && prev != null) {
                count++;
                prev = prev.next;
            }
            if (prev != null) {
                nodetobeinserted.next = prev.next;
                prev.next = nodetobeinserted;
            }
            return head;
        }
    }
    // 10)
    public static Node<Integer> insertnoder(Node<Integer> head, int elem, int pos){

        if (head == null && pos > 0 ){
            return head;
        }
        if (pos == 0){
            Node<Integer> newNode = new Node<>(elem);
            newNode.next = head;
            return newNode;
        } else {
//            Node<Integer> smallhead = insertnoderecursive(head.next , n-1 , data);
//            head.next = smallhead; or
            head.next = insertnoder(head.next, elem , pos-1);
            // collectin the new head is very important here we are conne ting the first part
            // to the recursive part .
            return head;
        }
    }
    // 11)
    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        if (pos == 0 && head != null){
            head = head.next;
            return head;
        }
        else{
            int count = 0;
            Node<Integer> temp = head;
            while (count < pos - 1 && temp!=null){
                count++;
                temp = temp.next;
            }
            if (temp != null ){
                temp.next = temp.next.next;
            }
            return head;
        }
    }
    // 12)
    public static Node<Integer> deletenoder(Node<Integer> head , int pos){
        if (head.next == null && pos > 0 ){
            return head;
        }

        if(pos == 0 ){
            return head.next;
        }
        else{
            head.next = deletenoder(head.next , pos-1);
            return head;
        }
    }
    // 13)
    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {

        if (head ==  null || head.next == null || n == 0 ){
            return head;
        }

        int length = 0;
        Node<Integer> countbaazi = head;
        while(countbaazi.next != null){
            length++;
            countbaazi = countbaazi.next;
        }

        Node<Integer> lasty = head;

        while (lasty.next != null){
            lasty = lasty.next;
        }

        Node<Integer> temp = head;

        int count = 0;
        while(count < length -  n  ){
            count++;
            temp = temp.next;
        }

        Node<Integer> newhead = temp.next;
        lasty.next = head;
        temp.next = null;

        return newhead;
    }
    // 14)
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
    // 15)
    public static Node<Integer> reverseRecBetterTC(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }

        Node<Integer> smallhead  = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return smallhead;

    }
    // 16)
    public static DoubleNode reverseRBetter(Node<Integer> head){
        DoubleNode ans;
        if(head == null || head.next == null){
            ans = new DoubleNode(head,head);
//            ans.head = head; we have created a constructor so we can pass the value there itself
//            ans.tail = head;
            return ans;
        }
        //ths double node will have both head and tail
        DoubleNode smallans  = reverseRBetter(head.next);
        smallans.tail.next = head;
        head.next = null;
        ans = new DoubleNode();
        ans.head = smallans.head;
        ans.tail = head;

        return ans;

    }
    // 17)
    public static Node<Integer> reverseRBetter1(Node<Integer> head){
        DoubleNode ans = reverseRBetter(head);
        return ans.head;
    }
    // 18)
    public static Node<Integer> removeDuplicates(Node<Integer> head) {

        if (head == null){
            return head;
        }

        Node<Integer> temp = head;
        while (temp.next != null){

            if (temp.data.equals(temp.next.data)){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }

        return head;
    }
    // 19)
    public static Node<Integer> reverse_I(Node<Integer> head){
        if (head == null || head.next== null){
            return head;
        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        Node<Integer> next = null;
        while(temp != null){
           next = temp.next;
           temp.next = prev;
           prev = temp;
           temp = next;

        }
        head = prev;
        return head;
    }
    // 20)
    public static Node<Integer> MidPoint(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        if(head == null || head.next == null){
            return head;
        }

        while(fast.next != null && fast.next.next != null){
            // and operator here because if i use or then after checking first condition
            // it will check second too if the first is wrong and will give us a null
            // pointer exception so to stop this shirt circuit we can use and operator
            // so that it doesnt check seconf one too
            slow = slow.next;// so the idea is to have two pointer one moving twice faster than the other one
            fast = fast.next.next; // then when the last one hits the null node the slower one
            // will be in the middle

        }
        return slow;
    }
    // 21)
    public static Node<Integer> MergeTwoLL(Node<Integer> head1 , Node<Integer> head2){
        Node<Integer> t1 = head1;
        Node<Integer> t2 = head2;
        Node<Integer> head = null;
        Node<Integer> tail = null;
        // managing both head and tail helps us to reduce time complexity
        // and also easily make the connections and append the next element
        if (head1 == null){
            return head1;
        }
        if (head2 == null){
            return head2;
        }

        if(t1.data < t2.data){
            head = t1;
            tail = t1;
            t1 = t1.next;
        }
        else{
            head = t2;
            tail = t2;
            t2 = t2.next;
        }

        while(t1 != null && t2 != null){
            if(t1.data<=t2.data){
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }
            else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }

        // one list is done another will be left so add those left elements
        if (t1 != null){
            tail.next  = t1;
        }else{
            tail.next = t2;
        }

        return head;

    }
    // 22)
    public static Node<Integer> MergeSortt( Node<Integer> head){
        if (head == null ){
            return head;
        }
        if(head.next == null){
            return head;
        }
        Node<Integer> midp = MidPoint(head) , h = null , n = null;
        n = MergeSortt(midp.next);
        midp.next = null;
        h = MergeSortt(head);


        MergeTwoLL(h,n);

        return head;
    }
    // 23)
    public static void printReverse(Node<Integer> root) {
        if(root == null ){
            return;
        }
        if(root.next == null){
            System.out.println(root.data);
            return;
        }
        Node<Integer> temp = root;
        Node<Integer> prev = null;
        Node<Integer> next = null;
        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;

        }
        root = prev;
        while(root != null){
            System.out.print(root.data + " ");
            root = root.next;
        }
    }
    // 24)
    public static boolean isPalindrome(Node<Integer> head) {
        //Your code goes here
        Node<Integer> node = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (node!=null)
        {
            arr.add(node.data);
            node=node.next;
        }
        int start=0, end=arr.size()-1;
        while(start<end)
        {
            if (arr.get(start)!=arr.get(end))
            {
                return false;
            }
            else
            {
                start=start+1;
                end=end-1;
            }
        }

        return true;
    }
    // 25)
    public static int findNodeRec(Node<Integer> head , int n ){
        if (head == null ){
            return -1;
        }

        if(head.data == n){
            return 0;
        }
        int count = findNodeRec(head.next, n);
        if (count != -1){
            return 1 + count;
        }else{
            return -1;
        }
    }
    // 26)
    public static Node<Integer> evenAfterOdd(Node<Integer> head) {
        Node<Integer> oddStart = null;
        Node<Integer> oddEnd = null;
        Node<Integer> evenStart = null;
        Node<Integer> evenEnd = null;
        Node<Integer> currentNode = head;
        while(currentNode != null) {
            int element = currentNode.data;

            if(element % 2 == 0) {

                if(evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            } else {
                if(oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            // Move head pointer one step in forward direction
            currentNode = currentNode.next;
        }

        if(oddStart == null || evenStart == null) {
            return oddStart;
        }
        oddEnd.next = evenStart;
        evenEnd.next = null;
        head=oddStart;

        return head;
    }
    // check code for optimised solution
    // 27)
    public static Node<Integer> skipMdeleteNalt(Node<Integer> head, int M, int N) {

        Node<Integer> curr = head , t;
        int count;
        if(M==0){
            return null;
        }
        while (curr!=null) {
            // Skip M nodes
            for (count = 1; count < M && curr != null; count++)
                curr = curr.next;
            // If we reached end of list, then return
            if (curr == null)
                return head;
            // Start from next node and delete N nodes
            t = curr.next;
            for (count = 1; count <= N && t != null; count++) {
                Node<Integer> temp = t;
                t = t.next;
            }
            // Link the previous list with remaining nodes
            curr.next = t;
            // Set current pointer for next iteration
            curr = t;
        }

        return head;

    }
    // check course for better answer!!
    // 28)
    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        Node<Integer> temp=head;
        Node<Integer> temp1=head;
        Node<Integer> tempo=new Node<Integer>(0);
        int beg=0, end=0;

        for(int x=0;x<i;x++)
        {
            temp=temp.next;

        }

        for(int y=0;y<j;y++)
        {
            temp1=temp1.next;

        }

        tempo.data= temp.data;
        temp.data= temp1.data;
        temp1.data=tempo.data;


        return head;
    }
    // check course for better answer!!
    // 29)
    public static Node<Integer> bubbleSort(Node<Integer> head) {
        //Your code goes here if (size > 1) {
        Node<Integer> current = head;
        while (current != null) {

            Node<Integer> second = current.next;
            while (second != null) {

                if (current.data > second.data) {
                    int tmp = current.data;
                    current.data = second.data;
                    second.data = tmp;
                }
                second = second.next;
            }
            current = current.next;
        }
        return head;
    }
    // check course for  better approach
    // 30)
    public static Node<Integer> kReverse(Node<Integer> head, int k)  {
        if (k == 0 || k == 1){
            return head;
        }
        if(head == null)
            return null;
        Node<Integer> current = head;
        Node<Integer> next = null;
        Node<Integer> prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next; // moves the current pointer
            current.next = prev; // reverses the connection and makes it point to the prev node
            prev = current; // moves the prev pointer to next node
            current = next; // moving the current node
            count++; // increasing the count
        }

        if (next != null)
            head.next = kReverse(next, k);

        // prev is now head of input list
        return prev;
    }




    public static void main(String[] args) {

        Node<Integer> head = takeInput(); //createLinkedList();
//        Node<Integer> head2 = takeInput();
        // storing the first node in the variable head

//        increment(head);
//        printrecursiveulta(head);
//        System.out.println(length(head));
//        printIthNode(head,3);

//        InsertNode(head,4,6); we are returning head so we need to update it in the main too
//        and thats why i have to collect it somewhere
//        head = InsertNode(head,4,6);
//        print(head);


//        head = deleteNode(head,0);
//        print(head);
//        Node<Integer> n1 = new Node<>(10);
//        will create a node n1 with data as 10 and address as null
//        System.out.println(n1.data);
//        System.out.println(n1.next);

//        printIthNode(head , 3);

//        head = removeDuplicates(head);
//        print(head);

//        head = reverseRec(head);
//        printrecursive(head);


//        head = MidPoint(head);
//        System.out.println(head.data);

//        Node<Integer> headnew = MergeSortt(head);
//        print(headnew);

//        boolean x = isPalindrome(head);
//        System.out.println(x);
//        int n = findNodeRec(head , 1);
//        System.out.println(n);

//        head = evenAfterOdd(head);
//        print(head);

        head = skipMdeleteNalt(head , 0, 3);
        print(head);

    }

}
