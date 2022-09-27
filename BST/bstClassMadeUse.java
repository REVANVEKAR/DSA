package BST;

public class bstClassMadeUse {
    public static void main(String[] args) {
        BST b = new BST();
        b.insert(5);
        b.insert(2);
        b.insert(7);
        b.insert(1);
        b.insert(3);
        b.insert(6);
        b.insert(8);

        b.printTree();

        System.out.println(b.isPresent(5));
        b.delete(5);
        System.out.println(b.isPresent(5));

        b.printTree();


    }

}
