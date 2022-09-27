package genericTrees;

import Queues.QueueEmptyException;
import Queues.QueueFullException;
import Queues.QueueUsingLL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeNodeTest {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

//        printTree(root);
//        printTreebetter(root);
        System.out.println(numOfNodes(root));
    }

    public static void printTree(TreeNode<Integer> root){
        if (root == null){
            return;
        }// not the base case but the special case
        // its interesting to note down that there is no visible base case
        // thats because the loop works as the base case if there are no elemnts in the
        // arraylist it wont run
        System.out.print(root.data+ " ");
        for (int i=0;i<root.children.size();i++){
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }

    public static void printTreebetter(TreeNode<Integer> root){
        if (root == null){
            return;
        }

        System.out.print(root.data+ ": ");
        for (int i = 0; i < root.children.size(); i++){
            System.out.print(root.children.get(i).data+ " ");
        }
        System.out.println();
        for (int i=0;i<root.children.size();i++){
            TreeNode<Integer> child = root.children.get(i);
            printTreebetter(child);
        }
    }

    // implement take input recursive and take input level wise before starting
    // new topics tomorrow

    public static int numOfNodes(TreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        int count = 1;
        for (int i=0;i<root.children.size();i++){
            int childcount = numOfNodes(root.children.get(i));
            count += childcount;
        }
        return count;
    }

    public static int sumOfAllNode(TreeNode<Integer> root){

        if (root == null){
            return 0;
        }
        int count = root.data;
        for (int i = 0; i < root.children.size(); i++){
            int chilsum = sumOfAllNode(root.children.get(i));
            count += chilsum;
        }
        return count;
    }

    public static TreeNode<Integer> takeInput() throws QueueEmptyException {
        Scanner sc = new Scanner(System.in);
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        System.out.println("enter the root data");
        int rootData = sc.nextInt();
        if (rootData==-1){
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()){
            TreeNode<Integer> front = pendingNodes.dequeue();
            System.out.println("enter the number of children for" + front.data);
            int numChi = sc.nextInt(); //  num of children
            for (int i = 0 ; i<numChi;i++){
                System.out.println("enter the " + i +"th child data for :" +front.data );
                int childData = sc.nextInt(); // taking user input again
                TreeNode<Integer> childNode = new TreeNode<>(childData);
                // creating the node
                front.children.add(childNode);
                // making the connections
                pendingNodes.enqueue(childNode);
                //adding them to the queue
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */

        if(root == null){
            return;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);


        while(!q.isEmpty()){

            TreeNode<Integer> front = q.remove();

            if(front != null){
                System.out.print(front.data+" ");

                for(int i = 0; i < front.children.size(); i++){
                    q.add(front.children.get(i));
                }

            }

            else{
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }


        }

    }

    public static int numNodeGreater(TreeNode<Integer> root,int x){

        if (root == null){
            return 0;
        }

        int count = 0;

        // If current root is greater
        // than x increment count
        if (root.data > x){
            count++;
        }

        // Recursively calling for every
        // child of current root
        for(int i = 0; i < root.children.size(); i++)
        {
            count += numNodeGreater(root.children.get(i), x);
        }

        // Return the count
        return count;

    }

    public static int getHeight(TreeNode<Integer> root){
        int max = 0;
        for (TreeNode<Integer> childNode : root.children){
            int height = getHeight(childNode);
            if (height > max ){
                max = height;
            }
        }
        return max + 1;
    }

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if(root.data == x){
            return true;
        }
        for(TreeNode<Integer> childNode : root.children){
            boolean ans = checkIfContainsX(childNode,x);
            if(ans){
                return true;
            }
        }
        return false;
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root){
        helper(root,0);
    }
    private static void helper(TreeNode<Integer> root,int count){
        root.data = count;
        for(int i = 0; i < root.children.size();i++){
            helper(root.children.get(i),count+ 1);
        }
    }

    public static int countLeafNodes(TreeNode<Integer> root){
        // Write your code here
        int leaf = 0;

        if (root == null )
        {
            return 0;
        }

        if (root.children.size() == 0)
        {
            return 1;
        }

        for (TreeNode<Integer> child : root.children)
        {
            leaf += countLeafNodes(child);
        }

        return leaf ;
    }

    public static boolean checkIdeentical(TreeNode<Integer> root1, TreeNode<Integer> root2 ){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.children.size() != root2.children.size()){
            return false;
        }
        for (int i = 0; i < root1.children.size(); i++){
            if (!checkIdeentical(root1.children.get(i),root2.children.get(i))){
                return false;
            }
        }
        return true;
    }

    /*
    solve this tomorrow and dry run it
     */

    static int maxsum;
    static TreeNode<Integer> resNode;

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        int maxsum = 0;

        maxSumUtil(root);


        return resNode;
    }
    public static void maxSumUtil(TreeNode<Integer> root){

        if (root == null)
            return;


        int currsum = root.data;


        int count = root.children.size();

        for (int i = 0; i < count; i++)
        {
            currsum += root.children.get(i).data;
            maxSumUtil(root.children.get(i));
        }

        if (currsum > maxsum)
        {


            resNode = root;
            maxsum = currsum;
        }
        return;
    }

    static TreeNode<Integer> res;

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){


        res = null;


        nextLargerElementUtil(root, n);

        return res;

    }
    static void nextLargerElementUtil(TreeNode<Integer> root, int x) {
        if (root == null)
            return;


        if (root.data > x)
            if ((res == null || (res).data > root.data))
                res = root;

        // Number of children of root
        int numChildren = root.children.size();

        // Recur calling for every child
        for (int i = 0; i < numChildren; i++)
            nextLargerElementUtil(root.children.get(i), x);

        return;
    }

    public static void change(TreeNode<Integer> root, int m ){
        if(root==null){
            return;
        }
        if(root.data==m){
            root.data = Integer.MIN_VALUE;
        }
        for(TreeNode<Integer> child: root.children){
            change(child, m );
        }
        return;
    }
    public static TreeNode<Integer> Largest(TreeNode<Integer> root){
        if(root==null){
            return root;
        }
        TreeNode<Integer> maxnode = root;

        for(int i =0; i<root.children. size(); i++){
            TreeNode<Integer> node =  Largest(root.children.get(i));
            if(node.data>maxnode.data){
                maxnode  =node;

            }
        }
        return maxnode;
    }
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer>root){
        TreeNode<Integer> largest = Largest( root);
        int data = largest.data;
        change(root, data);
        return Largest( root);
    }

    public static void printPostOrder(TreeNode<Integer> root){
        /* Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        if (root == null){
            return;
        }// not the base case but the special case
        // its interesting to note down that there is no visible base case
        // thats because the loop works as the base case if there are no elemnts in the
        // arraylist it wont run

        for (int i=0;i<root.children.size();i++){
            TreeNode<Integer> child = root.children.get(i);
            printPostOrder(child);
        }
        System.out.print(root.data+ " ");
    }

}
