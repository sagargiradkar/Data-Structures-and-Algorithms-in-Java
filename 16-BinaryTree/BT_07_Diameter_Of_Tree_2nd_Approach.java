
public class BT_07_Diameter_Of_Tree_2nd_Approach {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(rh, rh) + 1;
        }

        public static int diameter2(Node root) {
            if (root == null) {
                return 0;
            }

            int leftDiam = diameter2(root.left);
            int leftHt = height(root.left);
            int rightDiam = diameter2(root.right);
            int rightHt = height(root.right);

            int selfDiam = leftHt + rightHt + 1;

            return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
        }

        static class Info {

            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            return new Info(diam, ht);
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root of the tree: " + root.data);
        System.out.println("Height of root :: " + tree.height(root));
        System.out.println("Diameter of a tree :: " + tree.diameter(root));
        System.out.println("Diameter of a tree :: " + tree.diameter2(root));

    }
}
