public class BinaryTreeBi {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        public Node buildTree(int[] nodes) {
            return buildTreeHelper(nodes, new int[]{0});
        }

        private Node buildTreeHelper(int[] nodes, int[] index) {
            if (index[0] >= nodes.length || nodes[index[0]] == -1) {
                index[0]++; // move index forward
                return null;
            }

            Node newNode = new Node(nodes[index[0]]);
            index[0]++;
            newNode.left = buildTreeHelper(nodes, index);
            newNode.right = buildTreeHelper(nodes, index);

            return newNode;
        }
        public static void preorder(Node root)
        {
            if(root == null)
            {
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root of the tree: " + root.data);
        System.out.print("Tree preordre of the tree: " );
        tree.preorder(root);
    }
}
