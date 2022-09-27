package BST;

import Trees.BinaryTreeNode;
public class BST {

    private BinaryTreeNode<Integer> root;
    private int size;

    private boolean isPresentHelper(BinaryTreeNode<Integer> node, int x){
        if (node == null){
            return false;
        }
        if (node.data == x){
            return true;
        }
        if (x <node.data){
            return isPresentHelper(node.left,x);
        }
        else{
            return isPresentHelper(node.right,x);
        }
    }

    public boolean isPresent(int x){
        return isPresentHelper(root,x);
    }

    private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node , int x){
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

    public void insert(int x){
        root = insert(root,x);
        size++;
    }

    private static BSTDeleteReturn deleteHelper(BinaryTreeNode<Integer> root , int x){
        if (root == null){
            return new BSTDeleteReturn(null,false);
        }
        // created a class which return two data types the root and the boolean whether the
        // data is deleted or not
        if (root.data<x){
            // if root.data is less than x then we call recursion on right
            BSTDeleteReturn outputRight = deleteHelper(root.right,x);
            root.right = outputRight.root;
            outputRight.root = root; // just saving space by creatign less number of objects
            return outputRight; // returning the root;
        }
        if (root.data>x){
            // vice versa
            BSTDeleteReturn outputLeft = deleteHelper(root.left,x);
            root.right = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }
        if (root.left==null &&root.right == null){ // no child
            return new BSTDeleteReturn(null,true);
        }
        if (root.left != null && root.right == null){ // only left child
            return new BSTDeleteReturn(root.left,true);
        }
        if (root.left == null && root.right != null){ // omly right child
            return new BSTDeleteReturn(root.right,true);
        }

        int rightMin  = minimum(root.right);
        root.data = rightMin;
        BSTDeleteReturn OutputRight = deleteHelper(root.right, rightMin);
        // we do this to eliminate the rightmin data which is present on more time
        root.right = OutputRight.root;
        // make connections
        return new BSTDeleteReturn(root,true);
    }

    private static int minimum(BinaryTreeNode<Integer> root){
        if (root==null){
            return Integer.MAX_VALUE;
        }
        int minLeft = minimum(root.left);
        int minRight = minimum(root.right);

        return Math.max(root.data, Math.min(minLeft,minRight));
    }

    public boolean delete(int x){
        BSTDeleteReturn output = deleteHelper(root,x);
        root = output.root;
        if (output.deleted){
            size--;
        }
        return output.deleted;
    }

    public int size(){
        return size;
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> node){
        if (node == null){
            return;
        }
        System.out.print(node.data + ":");
        if (node.left != null){
            System.out.print("L" + node.left.data); // this is just taking care of the root
            // and asking recursion to do the rest of the job
        }
        if (node.right != null){
            System.out.print(", R" + node.right.data);
        }
        // this is just some additional fancy work with the root
        // and the base case in other words
        System.out.println();

        printTreeHelper(node.left);
        printTreeHelper(node.right);
    }

    public void printTree(){
        printTreeHelper(root);
    }


}
