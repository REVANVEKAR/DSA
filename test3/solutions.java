package test3;

import Trees.BinaryTreeNode;
import genericTrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class solutions {

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        // Write your code here
        int x = p;
        int y = q;
        if(root.data == x || root.data == y) return false;
        boolean xFound = false, yFound = false;

        Queue<BinaryTreeNode<Integer>> z = new LinkedList<>();
        z.offer(root);

        while(!z.isEmpty()) {
            int size = z.size();
            for(int i = 0; i<size; i++){
                BinaryTreeNode<Integer> cur = z.poll();
                //check if siblings
                if(cur.left != null && cur.right != null) {
                    if((cur.left.data == x && cur.right.data == y) || (cur.left.data == y && cur.right.data == x)){
                        return false;
                    }
                }
                if(cur.left != null){
                    xFound = xFound || cur.left.data == x;
                    yFound = yFound || cur.left.data == y;
                    z.offer(cur.left);
                }
                if(cur.right != null){
                    xFound = xFound || cur.right.data == x;
                    yFound = yFound || cur.right.data == y;
                    z.offer(cur.right);
                }
            }
            //if both found on same level, return true otherwise if only one found on this level return false
            if(xFound && yFound) {
                return true;
            }
            else if(xFound || yFound) {
                return false;
            }
        }

        //neither found
        return false;

    }

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
        // Write your code here
        if(root == null)
        {
            ArrayList<Integer> output = new ArrayList<>();
            return output;
        }

        // Recursive call on root.right
        ArrayList<Integer> right = longestRootToLeafPath(root.right);

        // Recursive call on root.left
        ArrayList<Integer> left = longestRootToLeafPath(root.left);

        // Compare the size of the two ArrayList
        // and insert current node accordingly
        if(right.size() < left.size())
        {
            left.add(root.data);
        }
        else
        {
            right.add(root.data);
        }

        // Return the appropriate ArrayList
        return (left.size() >
                right.size() ? left :right);

    }

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {

        if(root==null){ return null;}// if root is null return null
        if(root.children.size()==0){// if root itself is leaf return null
            return null;}
        // if root.children is a leaf node
        // then delete it from children vector
        for (int i = 0; i < root.children.size(); i++) {

            TreeNode<Integer> child= root.children.get(i);

            // if it is  a leaf
            if (child.children.size() == 0) {

                // shifting the vector to left
                // after the point i
                for (int j = i; j < root.children.size() - 1; j++)
                    root.children.set(j, root.children.get(j + 1));

                // delete the last element
                root.children.remove(root.children.size()-1);

                i--;
            }
        }

        // Remove all leaf node
        // of children of root
        for (int i = 0;
             i < root.children.size();
             i++) {

            // call function for root.children
            root.children.set(i,removeLeafNodes(root.children.get(i)));
        }
        return root;

    }

}
