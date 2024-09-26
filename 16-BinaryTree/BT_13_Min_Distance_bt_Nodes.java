
public class BT_13_Min_Distance_bt_Nodes {

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

    public static Node lca2(Node root, int n1, int n2) {
        // Base case: if root is null or matches n1 or n2, return root
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively search in left and right subtrees
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // If both leftLca and rightLca are non-null, root is the LCA
        if (leftLca != null && rightLca != null) {
            return root;
        }

        // Otherwise, return the non-null node (either leftLca or rightLca)
        return (leftLca != null) ? leftLca : rightLca;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
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
        int n1 = 4, n2 = 6;
        System.out.println("Lowest Common Ancestors :: " + lca2(root, n1, n2).data);
        System.out.println("Min Distance :: " + minDist(root, n1, n2));
    }
}
