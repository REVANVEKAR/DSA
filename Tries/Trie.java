package Tries;

import genericTrees.TreeNode;

class TrieNode{

    char data;
    boolean isTerminal;
    TrieNode children[];
    int childCount;

    public TrieNode(char data){
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }

}
public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode('\0');
    }

    public void add( String word){
        addHelper(root,word);
    }

    private void addHelper(TrieNode root,String word){
        if (word.length() == 0){
            root.isTerminal = true;
            return;
        }
        int childIndex = word.charAt(0)- 'A';
        TrieNode child = root.children[childIndex];
        if (child == null){
            child = new TrieNode(word.charAt(0)); // if child doesn't exist we enter this shit
            // and create a new node and insert it in its index
            root.children[childIndex] = child;
            root.childCount++;
        }
        addHelper(child,word.substring(1));
    }

    private boolean search(TrieNode root,String word){ // helper
        if (word.length() == 0){
            return root.isTerminal;
        }
        int childIndex = word.charAt(0)-'A';
        TrieNode child = root.children[childIndex];
        if (child == null){
            return false;
        }
        return search(child,word.substring(1));


    }

    public boolean search(String word){
        boolean ans = search(root,word);
        return ans;
    }

    public void remove(String word){
        removeHelper(root,word);
    }

    private void removeHelper(TrieNode root, String word){
        if (word.length()==0){
            root.isTerminal = false;
            return;
        }
        int childIndex = word.charAt(0)-'A';
        TrieNode child = root.children[childIndex];
        if (child==null){
            return;
        }

        removeHelper(child,word.substring(1));
        if (!child.isTerminal && child.childCount==0){
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public int countWordshelp(TrieNode root) {
        int result = 0;
        if (root.isTerminal) {
            result++;
        }

        for (int i = 0; i < 26; i++)
            if (root.children[i] != null )
                result += countWordshelp(root.children[i]);

        return result;

    }

    public int countWords(){
        int i = countWordshelp(root);
        return i;
    }

}