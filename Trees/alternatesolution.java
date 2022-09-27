package Trees;


 class Pair {
    int diameter;
    int height;

    public Pair(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}

public class alternatesolution {

    private static Pair diameterHelper(BinaryTreeNode< Integer> root) {
        if (root == null) {
            Pair pair = new Pair(0, 0);
            return pair;
        }
        Pair leftPair = diameterHelper(root.left);
        Pair rightPair = diameterHelper(root.right);
        int leftDiameter = leftPair.diameter;
        int rightDiameter = rightPair.diameter;

        int dist = leftPair.height + rightPair.height + 1;
        int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));
        int height = Math.max(leftPair.height, rightPair.height) + 1;
        return (new Pair(diameter, height));
    }
        private static int diameterOfBinaryTreeCN (BinaryTreeNode< Integer> root) {
            Pair pair = diameterHelper(root);
            return pair.diameter;
        }


}
