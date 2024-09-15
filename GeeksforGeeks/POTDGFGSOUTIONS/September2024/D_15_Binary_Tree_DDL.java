// Definition of Node class for Binary Tree
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class D_15_Binary_Tree_DDL {
    
    // Head of the doubly linked list
    Node head = null;
    
    // Previous node pointer to keep track of the previous node during inorder traversal
    Node prev = null;

    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root) {
        if (root == null) {
            return null;
        }

        // Recursively convert the left subtree
        bToDLL(root.left);

        // Now convert this node
        if (prev == null) {
            // If this is the first node (leftmost node), it will be the head of the DLL
            head = root;
        } else {
            // Link the previous node with the current node
            root.left = prev;  // left pointer becomes the previous node (prev in DLL)
            prev.right = root; // right pointer of previous node becomes the current node
        }
        // Move the prev pointer to the current node
        prev = root;

        // Recursively convert the right subtree
        bToDLL(root.right);

        // Return the head of the DLL
        return head;
    }

    // Function to print the doubly linked list from left to right
    void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    // Function to print the doubly linked list from right to left
    void printListReverse(Node head) {
        if (head == null) return;

        Node curr = head;
        // Move to the rightmost node
        while (curr.right != null) {
            curr = curr.right;
        }
        
        // Print from right to left
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.left;
        }
        System.out.println();
    }

    // Main method to test the solution
    public static void main(String[] args) {
        D_15_Binary_Tree_DDL tree = new D_15_Binary_Tree_DDL();

        // Creating a binary tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        // Converting the binary tree to DLL
        Node head = tree.bToDLL(root);

        // Printing the doubly linked list from left to right
        System.out.println("DLL from left to right:");
        tree.printList(head);

        // Printing the doubly linked list from right to left
        System.out.println("DLL from right to left:");
        tree.printListReverse(head);
    }
}
