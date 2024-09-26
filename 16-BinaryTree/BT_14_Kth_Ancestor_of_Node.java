
public class BT_14_Kth_Ancestor_of_Node {

    public static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static int kAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        // If node n is not found in either subtree, return -1
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // max gives the correct distance from the node found in either subtree
        int maxDist = Math.max(leftDist, rightDist);

        // If the current node is the kth ancestor, print and return success
        if (maxDist + 1 == k) {
            System.out.println("Kth Ancestor is: " + root.data);
        }

        // Return the distance of this node from n
        return maxDist + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println();
        System.out.print("Tree inorder of the tree: ");
        inorder(root);
        System.out.println();

        int n = 5, k = 2;
        int result = kAncestor(root, n, k);

        // If result is less than k, it means there is no kth ancestor
        if (result < k) {
            System.out.println("No " + k + "th ancestor found for node " + n);
        }
    }
}
