
public class BST_02_Search_BST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return  root;
        }

        if(root.data > val){
           root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root)
    {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return  true;
        }

        if(root.data > key){
            return search(root.left, key);
        }

        else{
            return search(root.right, key);
        }
    }
    public static void main(String[] args) {
        int values[] = { 6,5, 1, 3, 4, 2, 7 };
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();

        if(search(root, 1)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }
}
