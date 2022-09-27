package Trees;

import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeuse {
    public static void main(String[] args) {

//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//
//        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
//
//        root.left = rootLeft;
//        root.right = rootRight;
//
//        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(5);
//
//        rootLeft.right = twoRight;
//        rootRight.left = threeLeft;

//        BinaryTreeNode<Integer> root = takeTreeInputBetter(true,0,true);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTreesDetailed(root);
//        int n = numNodes(root);
//        System.out.println("num of nodes = " + n);
//        int n = largest(root);
//        int n = numOfLeafNodes(root);
//        System.out.println(n);

//        System.out.println("is Balanced " + isBalanced(root));

//        System.out.println("is balanced " + isBalancedBetter(root).isBalanced);
    }

    public static void printTree(BinaryTreeNode<Integer> root){

        // this works just fine as when the child calls an null node it simply returns
        // and also takes care of the case when you're given a null tree
        if (root == null){
            return;
        }
        System.out.println(root.data);
        // will call left even if its empty but root == null simply returns
        printTree(root.left);
        printTree(root.right);

        // these print functions are good but u cant guess the pattern
        // of the tree u have or u have created

//        option 1;
//        System.out.println(root.data);
//        // this works as a base case for left recursion
//        if (root.left!= null){
//            printTree(root.left);
//        }
//         // this works as a base case for right recursion
//        if (root.right!= null){
//            printTree(root.right);
//        }
    }

    public static void printTreesDetailed(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.print(root.data + ":");
        if (root.left != null){
            System.out.print("L" + root.left.data); // this is just taking care of the root
            // and asking recursion to do the rest of the job
        }
        if (root.right != null){
            System.out.print(", R" + root.right.data);
        }
        // this is just some additional fancy work with the root
        // and the base case in other words
        System.out.println();

        printTreesDetailed(root.left);
        printTreesDetailed(root.right);
    }

    public static BinaryTreeNode<Integer> takeTreeInput(){
        System.out.println("Enter root data");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1){
            return null;
        }// returns if we want to create am empty tree

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        // what happens is until we type in -1 it keeps calling the left
        // then left of left then left of left of left and so on
        // once -1 is entered it starts asking right node as  right is called after
        // left in recursion . it starts returning when -1 is entered
        BinaryTreeNode<Integer> rightChild = takeTreeInput();
        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft){
        if (isRoot) {
            System.out.println("Enter root data");
        }else{
            if (isLeft) {
                System.out.println("enter left child of " + parentData);
            }else {
                System.out.println("enter right child of " + parentData);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1){
            return null;
        }// returns if we want to create am empty tree

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData,true);
        // what happens is until we type in -1 it keeps calling the left
        // then left of left then left of left of left and so on
        // once -1 is entered it starts asking right node as  right is called after
        // left in recursion . it starts returning when -1 is entered
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false,rootData,false);
        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static int numNodes(BinaryTreeNode<Integer> root) {
        if (root == null){
            return 0;
        }

        int leftNodeCount = numNodes(root.left);
        int rightNodeCount = numNodes(root.right);
        return 1 + leftNodeCount + rightNodeCount;

    }

    public static int getSum(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        int count = 0;
        count = count + root.data;
        // will call left even if its empty but root == null simply returns
        int a = getSum(root.left);
        int  b = getSum(root.right);

        return count + a + b;
    }

    public static void postOrder(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static int largest(BinaryTreeNode<Integer> root){
        if (root==null){
            return -1; // or INteger.MIN_VALUE
        }
        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);

        return Math.max(root.data, Math.max(largestLeft,largestRight));
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null){
            return 0;
        }
        int count = 0;
        if (root.data > x){
            count = count + 1;
        }
        int a = countNodesGreaterThanX(root.left,x);
        int b = countNodesGreaterThanX(root.right,x);

        return count + a + b ;
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null){
            return 0;
        }

        int a = height(root.left);
        int b = height(root.right);

        if (a>b){
            return a+1;
        }else{
            return b+1;
        }
    }

    public static int numOfLeafNodes(BinaryTreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int a = numOfLeafNodes(root.left);
        int b = numOfLeafNodes(root.right);

        System.out.print("num of leafs : ");
        return a + b;
    }
    //depth of a node
    public static void printAtDepthK(BinaryTreeNode<Integer> root,int k){
        if (root==null){
            return;
        }
        if (k==0){
            System.out.println(root.data);
            return;
        }
        printAtDepthK(root.left,k-1);
        printAtDepthK(root.right,k-1);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changedepth( root,0);
    }
// this is the helper function to achieve the answer we can just simply add one more
//  variable which increases why recursing
    public static void changedepth(BinaryTreeNode<Integer> root, int level) {
        // Base Case
        if (root == null)
            return;

        // Replace data with current depth
        root.data = level;

        changedepth(root.left, level+1);
        changedepth(root.right, level+1);
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null)
            return false;

        if (root.data == x)
            return true;

        // then recur on left subtree /
        boolean res1 = isNodePresent(root.left, x);

        // node found, no need to look further
        if(res1) return true;

        // node is not found in left,
        // so recur on right subtree /
        boolean res2 = isNodePresent(root.right, x);

        return res2;
    }

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        // If this is an internal node, recur for left
        // and right subtrees
        if (root.left != null && root.right != null)
        {
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
        }

        // If left child is NULL and right
        // is not, print right child
        // and recur for right child
        else if (root.right != null)
        {
            System.out.print(root.right.data + " ");
            printNodesWithoutSibling(root.right);
        }

        // If right child is NULL and left
        // is not, print left child
        // and recur for left child
        else if (root.left != null)
        {
            System.out.print( root.left.data + " ");
            printNodesWithoutSibling(root.left);
        }
    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }
        if (root.left == null && root.right== null){
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

    public static BinaryTreeNode<Integer> mirror(BinaryTreeNode<Integer> root){
        //Your code goes here
        if (root == null)
            return root;

        /* do the subtrees */
        BinaryTreeNode<Integer> left = mirror(root.left);
        BinaryTreeNode<Integer> right = mirror(root.right);

        /* swap the left and right pointers */
        root.left = right;
        root.right = left;

        return root;
    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        root = mirror(root);
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root){
        if (root == null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight-rightHeight) > 1){
            return false;
        }
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        return isLeftBalanced && isRightBalanced;
    }

    public static balancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if (root == null){
            int height = 0;
            boolean isBal = true;
            balancedTreeReturn ans = new balancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }

        balancedTreeReturn leftOutput = isBalancedBetter(root.left);
        balancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        if (Math.abs(leftOutput.height - rightOutput.height)>1){
            isBal = false;
        }

        if (!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }

        balancedTreeReturn ans = new balancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }
    // diameter is the distance between two farthest nodes in a tree
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        A a = new A();
        int h = heightforD(root , a);
        return a.ans;
    }

    public static class A{
        int ans = Integer.MIN_VALUE;
    }

    public static int heightforD(BinaryTreeNode<Integer> root, A a){

        if (root == null){
            return 0;
        }
        int left_height = heightforD(root.left,a);
        int right_height = heightforD(root.right,a);

        a.ans = Math.max(a.ans,1 + left_height + right_height);

        return 1 + Math.max(left_height, right_height);
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("enter root data");
        int rootData = s.nextInt();

        if (rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("enter left child of " + front.data);
            int left = s.nextInt();
            if (left != -1){
                BinaryTreeNode<Integer> leftchild = new BinaryTreeNode<Integer>(left);
                front.left = leftchild;
                pendingChildren.add(leftchild);
            }

            System.out.println("enter right child of " + front.data);
            int right = s.nextInt();
            if (right != -1){
                BinaryTreeNode<Integer> rightchild = new BinaryTreeNode<Integer>(right);
                front.right = rightchild;
                pendingChildren.add(rightchild);
            }

        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root==null)
            return ;
        Queue<BinaryTreeNode<Integer>> q1=new LinkedList<BinaryTreeNode<Integer>>();
        Queue<BinaryTreeNode<Integer>> q2=new LinkedList<BinaryTreeNode<Integer>>();
        q1.add(root);
        while(!q1.isEmpty()){
            String ans="";
            BinaryTreeNode<Integer> front=q1.remove();
            ans+=front.data;
            if(front.left!=null)
            {
                ans+=":L:"+front.left.data+",";
                q2.add(front.left);
            }
            else{
                ans+=":L:"+"-1"+",";
            }
            if(front.right!=null){
                ans+="R:"+front.right.data;
                q2.add(front.right);
            }
            else{
                ans+="R:"+"-1";
            }
            if(q1.isEmpty()){
                q1=q2;
                q2=new LinkedList<BinaryTreeNode<Integer>>();
            }
            System.out.println(ans);
        }
    }

    // coding ninjas answer
    // helper function for the main function
    public static BinaryTreeNode<Integer> buildreeFronPreHelper(int[] pre , int[] in
            , int siPre,int eiPre, int siIn, int eiIn){
        if (siPre>eiPre){
            return null;
        }
        int rootdata = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);

        int rootIndex = -1;
        for (int i = siIn; i<= eiIn; i++){
            if (in[i] == rootdata){
                rootIndex = i;
                break;
            }
        }

        int siPreLeft = siPre+1;
        int siInLeft = siIn;
        int eiInLeft = rootdata-1;
        int siInRight= rootIndex + 1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;

        int leftSubTreeLength = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSubTreeLength - 1;
        int siPreRight = eiPreRight + 1;

        BinaryTreeNode<Integer> left = buildreeFronPreHelper(pre,in,siPreLeft,eiPreLeft,siInLeft,eiInLeft);
        BinaryTreeNode<Integer> right = buildreeFronPreHelper(pre,in,siPreRight,eiPreRight,siInRight,eiInRight);
        root.left = left;
        root.right = right;

        return root;
    }
    public static BinaryTreeNode<Integer> buildtreefromPreIn(int[] pre, int[] in){
        BinaryTreeNode<Integer> root = buildreeFronPreHelper(pre, in ,0 , pre.length,0, in.length );
        return  root;
    }

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        BinaryTreeNode<Integer> temp = root.left;
        BinaryTreeNode<Integer> rootcopy = new BinaryTreeNode<>(root.data);
//        root.left = rootcopy;
//        rootcopy.left = temp;

        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);

        root.left = rootcopy;
        rootcopy.left = temp;

    }

    public static void printLevelWiseLine(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while(true){

            int nodeCount = q.size();
            if (nodeCount == 0){
                break;
            }
            while(nodeCount > 0){
                BinaryTreeNode<Integer> node = q.peek();
                System.out.println(node.data + " ");
                q.remove();
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!= null){
                    q.add(node.right);
                }
                nodeCount--;
            }
            System.out.println();

        }



    }

    public static Pairr<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        if (root == null){
            Pairr<Integer,Integer> sc = new Pairr<>(Integer.MAX_VALUE ,Integer.MIN_VALUE);
            return sc;
        }
        Pairr<Integer, Integer> leftka;
        Pairr<Integer, Integer> rightka;
        leftka = getMinAndMax(root.left);
        rightka = getMinAndMax(root.right);

        int min=Math.min(root.data,Math.min(rightka.minimum,leftka.minimum));
        int max=Math.max(root.data,Math.max(rightka.maximum,leftka.maximum));
        Pairr<Integer , Integer> ans = new Pairr<>(min , max);

        return ans;
    }

    public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node , int x){
        if(node == null){
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
            return newRoot;
        }
        if (x >= node.data){
            node.right = insert(node.right,x);
        }else{
            node.left = insert(node.left,x);
        }

        return node;

    }
/*
For a given postorder and inorder traversal of a Binary Tree of type integer stored
in an array/list, create the binary tree using the given two arrays/lists. You just
need to construct the tree and return the root
 */
    private static BinaryTreeNode<Integer> buildTreehelper(int[] in, int[] post, int inS, int inE, int postS, int postE) {
        if (inS>inE){
            return null;
        }
        int rootData = post[postE];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int rootIndex = -1;
        for(int i = inS; i <= inE; i++){
            if(in[i] == rootData){
                rootIndex = i;
                break;
            }
        }

        if (rootIndex==-1){
            return null;
        }

        int leftinS = inS;
        int leftinE = rootIndex - 1;
        int rightinS = rootIndex + 1;
        int rightinE = inE;
        int leftpostS = postS;
        int leftpostE = leftinE - leftinE + leftpostS;
        int rightpostS = leftpostS + 1;
        int rightpostE = postE - 1;

        root.left = buildTreehelper(in,post,leftinS,leftinE,leftpostS,leftpostE);
        root.right = buildTreehelper(in,post,rightinS,rightinE,rightpostS,rightpostE);

        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        //Your code goes here
        return buildTreehelper(inOrder,postOrder,0,inOrder.length - 1, 0, postOrder.length - 1);
    }

/*
You are given a Binary Tree of type integer, a target node, and an integer value K.
Print the data of all nodes that have a distance K from the target node.
 The order in which they would be printed will not matter
 */
//
    public static void printNodeKdown(BinaryTreeNode<Integer> root, int k) {
        if (root== null || k<0){
            return ;
        }
        if (k == 0){
            System.out.println(root.data);
            return;
        }
        printNodeKdown(root.left,k-1);
        printNodeKdown(root.right,k-1);
    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        printNodeK(root,node,k);
        return;
    }

    public static int printNodeK(BinaryTreeNode<Integer> root, int node, int k) {
        if(root == null) {
            return -1;
        }
        if(root.data == node) {
            printNodeKdown(root, k);
            return 0;
        }
        int leftDown = printNodeK(root.left, node, k);
        if(leftDown != -1) {
            if(leftDown + 1 == k) {
                System.out.println(root.data);

            }
            else {
                printNodeKdown(root.right, k - leftDown - 2);
        //this funstion is used for finding k
            }
            return 1 + leftDown;
        }

        int rightDown = printNodeK(root.right, node, k);
        if(rightDown != -1) {
            if(rightDown + 1 == k) {
                System.out.println(root.data);
            }
            else {
                printNodeKdown(root.left , k - rightDown - 2);
                //why we go left here from the root
            }
            return 1 + rightDown;
        }

        return -1;
    }

 /*
 For a given Binary Tree of type integer and a number K, print out all root-to-leaf
  paths where the sum of all the node data along the path is equal to K.
  */
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
     //Your code goes here
     rootToLeafPathsSumToK(root, k, "");
 }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String arr) {

        if (root == null) {
            return;
        }

        int rootData = root.data;
        arr += rootData + " ";

        // root is leaf and root data is k
        if (k == root.data && root.left == null && root.right == null) {
            System.out.println(arr);
            return;
        }

        rootToLeafPathsSumToK(root.left, k - (root.data), arr);
        rootToLeafPathsSumToK(root.right, k - (root.data), arr);

    }


}






class Pairr<T, U> { //this class is for the min and max question
    T minimum;
    U maximum;

    public Pairr(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}