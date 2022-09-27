package Tries;

public class TrieUse {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("NOTE");
        t.add("AND");

        System.out.println(t.search("NOTE"));
        t.remove("NOTE");
        System.out.println(t.search("NOTE"));

    }


}
