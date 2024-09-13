public class D_13_Mirror_Tree {

    public static void main(String[] args) {
        // Sample binary tree (modify as needed)
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Solution solution = new Solution();
        solution.mirror(root);

        // In-order traversal to print the mirrored tree (optional)
        System.out.print("Mirrored Tree: ");
        inOrder(root);
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static class Solution {
        // Function to convert a binary tree into its mirror tree.
        void mirror(Node node) {
            if (node == null) {
                return;
            }

            // Swap left and right subtrees
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Recursively mirror left and right subtrees
            mirror(node.left);
            mirror(node.right);
        }
    }
}