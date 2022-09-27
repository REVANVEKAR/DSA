package BST;

import Trees.BinaryTreeNode;

public class bstImplementr {

    private static BinaryTreeNode<Integer> root;

    public static void insert(int data) {
        //Implement the insert() function
        root=insert(data,root);
    }

    public static BinaryTreeNode<Integer> insert(int data,BinaryTreeNode<Integer> root){
        if(root==null){
            BinaryTreeNode<Integer> node=new BinaryTreeNode<>(data);
            return node;
        }
        if(root.data<data){
            root.right =insert(data,root.right);
        }else{
            root.left=insert(data,root.left);
        }
        return root;
    }

    public void remove(int data) {
        //Implement the remove() function
        root=remove(data,root);
    }

    public static BinaryTreeNode<Integer> remove(int data,BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }
        if(root.data<data){
            root.right=remove(data,root.right);
        }else if(root.data>data){
            root.left=remove(data,root.left);
        }else{
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left!=null && root.right!=null){

                root.data=minimum(root.right);
                root.right=remove(root.data,root.right);
            }
        }
        return root;
    }

    public static int minimum(BinaryTreeNode<Integer> root){
        int minv=root.data;
        while(root.left!=null){
            minv =root.left.data;
            root=root.left;
        }
        return minv;
    }

    public static void printTree(){
        printHelper(root);
        return;
    }

    private static void printHelper(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return ;
        String s=root.data+":";
        //System.out.print(root.data+":");
        if(root.left!=null)
            s=s+"L:"+root.left.data+",";
        //System.out.print("L:"+root.left.data+",");
        if(root.right!=null){
            s=s+"R:"+root.right.data;
            //System.out.print("R:"+root.right.data);
        }
        System.out.println(s);
        //System.out.println();
        printHelper(root.left);
        printHelper(root.right);
        //return;
    }

    public boolean search(int data) {
        //Implement the search() function
        return hasDatahelper(data,root);
    }

    public static boolean hasDatahelper(int data,BinaryTreeNode<Integer> root){
        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }else if(root.data<data){
            return hasDatahelper(data,root.right);
        }else{
            return hasDatahelper(data,root.left);
        }
    }
}
