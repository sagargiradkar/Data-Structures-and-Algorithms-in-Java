public class BT_03_Height_of_Tree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int []nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static int height(Node root) {
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(rh, rh) + 1;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root of the tree: " + root.data);
        System.out.println("Height of root :: "+tree.height(root));
    }
}
