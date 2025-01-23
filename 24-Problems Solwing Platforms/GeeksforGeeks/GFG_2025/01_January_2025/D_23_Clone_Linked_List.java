class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

public class D_23_Clone_Linked_List {
    public static void main(String[] args) {
        // Creating a sample linked list
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.next = third;

        head.random = third; // 1 -> 3
        second.random = head; // 2 -> 1
        third.random = second; // 3 -> 2

        Solution solution = new Solution();
        Node clonedHead = solution.cloneLinkedList(head);

        // Printing the original and cloned linked list
        System.out.println("Original Linked List:");
        printList(head);

        System.out.println("\nCloned Linked List:");
        printList(clonedHead);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Node data: " + current.data);
            if (current.random != null) {
                System.out.print(", Random points to: " + current.random.data);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            current = current.next;
        }
    }
}

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes
        Node current = head;
        while (current != null) {
            Node clone = new Node(current.data);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        // Step 2: Set random pointers for cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next; // Move to the next original node
        }

        // Step 3: Separate the original and cloned lists
        Node original = head;
        Node cloneHead = head.next;
        Node cloneCurrent = cloneHead;

        while (original != null) {
            original.next = original.next.next;
            if (cloneCurrent.next != null) {
                cloneCurrent.next = cloneCurrent.next.next;
            }
            original = original.next;
            cloneCurrent = cloneCurrent.next;
        }

        return cloneHead;
    }
}
