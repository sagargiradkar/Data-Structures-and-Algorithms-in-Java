public class D_06_Root_Leaf {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static int help(Node root, int num) {
        if (root == null) {
            return 0;
        }

        // Combine current node's data with the accumulated number
        num = num * 10 + root.data;

        // If leaf node, return the complete number
        if (root.left == null && root.right == null) {
            return num;
        }

        // Recursively calculate sums for left and right subtrees
        // (avoid unnecessary variable declaration)
        return help(root.left, num) + help(root.right, num);
    }

    public static int treePathsSum(Node root) {
        // Reset the initial number to 0 before starting the calculation
        return help(root, 0);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int sum = treePathsSum(root);
        System.out.println("Sum of all root-to-leaf path numbers: " + sum);
    }
}