
public class BST_07_Mirror_A_BST {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
public static Node createMirror(Node root){
    if(root == null){
        return null;
    }
    Node leftMirror = createMirror(root.left);
    Node rightMirror = createMirror(root.right);

    root.left = rightMirror;
    root.right = leftMirror;
    return root;

}
public static void preorder(Node root){
    if(root == null){
        return;
    }

    System.out.print(root.data+" ");
    preorder(root.left);
    preorder(root.right);
}
    public static void main(String[] args) {
        int values[] = {13, 8, 5, 10, 11, 3, 6, 12};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        createMirror(root);

        preorder(root);
    }
}