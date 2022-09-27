package BST;

import Trees.BinaryTreeNode;
import linkedlist1.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class bstuse {

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        boolean r = searchInBST(root,a);
        boolean s = searchInBST(root,b);
        if (!r && !s){
            return -1;
        }
        if (!s){
            return a;
        }
        if (!r){
            return b;
        }
        if (a==b){
            return a;
        }
        BinaryTreeNode<Integer> alele = getlcahelper(root, a, b);
        return alele.data;
    }

    public static BinaryTreeNode<Integer> getlcahelper(BinaryTreeNode<Integer> root ,int a, int b){
        if (root == null){
            return null;
        }
        if (root.data > a && root.data > b){
            return getlcahelper(root.left,a,b);
        }
        if (root.data<a&& root.data<b){
            return getlcahelper(root.right,a,b);
        }
        return root;
    }

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null){
            return false;
        }
        if (root.data == k){
            return true;
        }

        if (k < root.data){
            return searchInBST(root.left, k);
        }

        return searchInBST(root.right,k);
    }

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
        if(root == null){
            return;
        }

        if (root.data<k1){
            elementsInRangeK1K2(root.right,k1,k2);
        }
        else if (root.data>k2){
            elementsInRangeK1K2(root.left,k1,k2);
        }
        else{
            elementsInRangeK1K2(root.left,k1,k2);
            System.out.println(root.data);
            elementsInRangeK1K2(root.right,k1,k2);
        }
    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {

        if (root==null){
            return true;
        }
        if (root.left != null && root.left.data > root.data){
            return false;
        }
        if (root.right != null && root.right.data < root.data){
            return false;
        }
        if (!isBST(root.left) || !isBST(root.right)) {
            return false;
        }
        return true;
    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        BinaryTreeNode<Integer> root = SortedArrayToBSTHelper(arr,0 , n-1);
        return root;
    }

    public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr , int si , int ei){
        if (si>ei){
            return null;
        }

        int mi = (si+(ei-si)/2) ;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mi]);

        root.left = SortedArrayToBSTHelper(arr,si,mi-1);
        root.right = SortedArrayToBSTHelper(arr,mi+1, ei );

        return root;
    }

    public static boolean isBSTBet(BinaryTreeNode<Integer> root){
        if (root == null){
            return true;
        }
        int leftMax = largest(root.left);
        if (leftMax>= root.data){
            return false;
        }
        int rightMin = minimum(root.right);
        if (rightMin< root.data){
            return false;
        }

        boolean isLeftBst = isBSTBet(root.left);
        boolean isRightBst = isBSTBet(root.right);

        return isLeftBst && isRightBst;
    }

    private static int largest(BinaryTreeNode<Integer> root) {
        if (root==null){
            return -1; // or INteger.MIN_VALUE
        }
        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);

        return Math.max(root.data, Math.max(largestLeft,largestRight));
    }

    public static int minimum(BinaryTreeNode<Integer> root){
        if (root == null ){
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        return Math.min(root.data, Math.min(leftMin,rightMin));

    }

    public static IsBSTReturn isBSTBet2(BinaryTreeNode<Integer> root){
        if(root == null){
            IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
            return ans;
        }
        IsBSTReturn LeftAns = isBSTBet2(root.left);
        IsBSTReturn RightAns = isBSTBet2(root.right);

        int min = Math.min(root.data, Math.min(LeftAns.min,RightAns.min));
        int max = Math.max(root.data, Math.max(LeftAns.max,RightAns.max));

        boolean isBST = true;

        if (LeftAns.max>= root.data){
            isBST = false;
        }
        if (RightAns.max< root.data){
            isBST = false;
        }
        if (!LeftAns.isBST){
            isBST = false;
        }
        if (!RightAns.isBST){
            isBST = false;
        }

        IsBSTReturn ans = new IsBSTReturn(min, max , isBST);
        return ans;
    }

    public static boolean isBST3(BinaryTreeNode<Integer> root, int minRange, int maxRange){
        if (root == null){
            return true;
        }

        if (root.data <minRange || root.data>maxRange){
            return false;
        }

        boolean isLeftWithRange = isBST3(root.left,minRange, root.data-1);
        boolean isRightWithRange = isBST3(root.left, root.data, maxRange);

        return isLeftWithRange&&isRightWithRange;
    }

    static Node<Integer> head=null;
    static Node<Integer> tail=null; // initializing these variable outisde the function to
    // make sure that their values dont keep on changing

    public static Node<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

        if(root==null){
            return null;
        }
        Node<Integer> node = new Node<>(root.data);
        Node<Integer> left = constructLinkedList(root.left);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=tail.next;

        }
        Node<Integer> right = constructLinkedList(root.right);

        return head;
    }

    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root , int x){
        if (root == null){
            return null;
        }
        if (root.data == x){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput = nodeToRootPath(root.left,x);
        if (leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> RightOutput = nodeToRootPath(root.left,x);
        if (RightOutput != null){
            RightOutput.add(root.data);
            return RightOutput;
        }
        return null;
    }

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
        if (root==null){
            return null;
        }
        if (root.data == data){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        if (root.data>data){
            ArrayList<Integer> leftOutput = getPath(root.left,data);
            if (leftOutput != null){
                leftOutput.add(root.data);
                return leftOutput;
            }
        }
        else {
            ArrayList<Integer> RightOutput = getPath(root.left,data);
            if (RightOutput != null){
                RightOutput.add(root.data);
                return RightOutput;
            }

        }
        return null;
    }

    static int sum = 0;
    static BinaryTreeNode<Integer> root;

    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }
        replaceWithLargerNodesSum(root.right);
        sum = sum + root.data;
        root.data = sum;
        replaceWithLargerNodesSum(root.left);
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        // Write your code here
        if (root==null)
            return;
        else
        {
            ArrayList<Integer> arr = convertToArray(root);
            Collections.sort(arr);
            //for (int i=0;i<arr.size();i++)
            //{
            //    System.out.print (arr.get(i)+" ");
            //}
            //System.out.println();
            printPairSum(arr,s);
        }

    }


    /*
    try to solve this on your own tomorrow
    and dry run it
     */
    /*
    Given a binary search tree and an integer S, find pair of nodes in the BST which
    sum to S. You can use extra space of the order of O(log n).
     */
    private static ArrayList<Integer> convertToArray(BinaryTreeNode<Integer> root) {
        if (root==null)
        {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            return arr;
        }


        ArrayList<Integer> currArr = new ArrayList<Integer>();
        ArrayList<Integer> leftArr = convertToArray(root.left);
        if (!leftArr.isEmpty())
        {
            currArr.addAll(leftArr);
        }

        currArr.add(root.data);

        ArrayList<Integer> rightArr = convertToArray(root.right);
        if (!rightArr.isEmpty())
        {
            currArr.addAll(rightArr);
        }
        return currArr;
    }
    private static void printPairSum(ArrayList<Integer> arr, int s) {
        int i=0,j=arr.size()-1;
        while(i<j)
        {
            int val1=arr.get(i);
            int val2=arr.get(j);
            if (val1+val2>s)
            {
                j=j-1;
            }
            else if(val1+val2<s)
            {
                i=i+1;
            }
            else
            {
                System.out.println(val1+" "+val2);
                i=i+1;
                j=j-1;
            }

        }
    }

    /*
    Given a Binary tree, find the largest BST subtree. That is, you need to find the
     BST with maximum height in the given binary tree. You have to return the height
     of largest BST
     */
    static class helper{
        boolean isBST;
        int min;
        int max;
        int height;

        helper(){
            isBST = true;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            height = 0;
        }
    }
    private static helper help(BinaryTreeNode<Integer> root) {

        if(root == null) {
            helper output = new helper();

            output.isBST = false;
            output.min = Integer.MAX_VALUE;
            output.max = Integer.MIN_VALUE;
            output.height = 0;

            return output;
        }

        if(root.left == null && root.right == null) {
            helper output = new helper();

            output.isBST = true;
            output.min = root.data;
            output.max = root.data;
            output.height = 1;

            // System.out.println("Root = " + root.data + " isBST = "+output.isBST + " height = " + output.height + " minimum = " + output.min + " max = " + output.max);

            return output;
        }


        helper leftoutput = new helper();
        if(root.left != null)
            leftoutput = help(root.left);

        helper rightoutput = new helper();
        if(root.right != null)
            rightoutput = help(root.right);

        boolean isBST = false;
        int min;
        int max;
        int height;

        if(leftoutput.isBST && rightoutput.isBST && leftoutput.max < root.data && rightoutput.min >= root.data) {

            isBST = true;
            min = Math.min(root.data, Math.min(leftoutput.min, rightoutput.min));
            max = Math.max(root.data, Math.max(leftoutput.max, rightoutput.max));
            height = Math.max(leftoutput.height, rightoutput.height) + 1;

            helper output = new helper();
            output.min = min;
            output.max = max;
            output.isBST = isBST;
            output.height = height;

//			System.out.println("Root = " + root.data + " isBST = "+output.isBST + " height = " + output.height + " minimum = " + output.min + " max = " + output.max);

            return output;
        }

        min = Math.min(leftoutput.min, Math.min(root.data, rightoutput.min));
        max = Math.max(root.data, Math.max(leftoutput.max, rightoutput.max));

        height = Math.max(leftoutput.height, rightoutput.height);

        helper output = new helper();

        output.min = min;
        output.max = max;
        output.isBST = isBST;
        output.height = height;

//		System.out.println("Root = " + root.data + " isBST = "+output.isBST + " height = " + output.height + " minimum = " + output.min + " max = " + output.max);

        return output;
    }
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        // Write your code here

        if(root == null)
            return 0;

        helper output = help(root);

        return output.height;
    }

    /*
    Given a binary tree, write code to create a separate linked list for each level.
     You need to return the array which contains head of each level linked list.
     */
    private static ArrayList<Node<Integer>> arr = new ArrayList<Node<Integer>>();
    public static ArrayList<Node<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        // Write your code here
        if (root==null) {
            return null;
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
        nodesToPrint.add(root);
        nodesToPrint.add(null);
        Node<Integer> head = null,tail=null;
        //arr.add(head);
        while(!nodesToPrint.isEmpty())
        {
            BinaryTreeNode<Integer> front=nodesToPrint.poll();
            if (front==null)
            {
                if (nodesToPrint.isEmpty())
                    break;
                else
                {
                    //System.out.println();
                    nodesToPrint.add(null);
                    tail.next=null;
                    tail=tail.next;
                    head=null;

                }

            }
            else
            {
                if (head==null)
                {
                    head = new Node<Integer>(front.data);
                    tail=head;
                    arr.add(head);
                }
                else
                {
                    tail.next=new Node<Integer>(front.data);
                    tail=tail.next;
                }
                //System.out.print(front.data+" ");
                if (front.left!=null)
                    nodesToPrint.add(front.left);
                if (front.right!=null)
                    nodesToPrint.add(front.right);
            }
        }
        return arr;
    }


}
